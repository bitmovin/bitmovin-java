package com.bitmovin.api.http;

import com.bitmovin.api.http.exceptions.RestClientException;
import com.bitmovin.api.http.utils.RequestLogger;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mashape.unirest.http.HttpMethod;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class UnirestRestClient implements IRestClient
{
    private final ObjectMapper objectMapper;
    private boolean debug;
    private boolean retry;
    private int maxRetries = 10;
    private long msToWaitForRetrying = 2000;

    public UnirestRestClient(final ObjectMapper objectMapper, boolean debug, boolean retry)
    {
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        this.objectMapper = objectMapper;
        this.debug = debug;
        this.retry = retry;
    }

    private String performRequestWithRetries(String uri, Map<String, String> headers, HttpMethod httpMethod) throws RestClientException
    {
        return performRequestWithRetries(uri, headers, httpMethod, null);
    }

    private String performRequestWithRetries(String uri, Map<String, String> headers, HttpMethod httpMethod, Object body) throws RestClientException
    {
        int retryNumber = 0;
        RestClientException thrownException;
        do
        {
            try
            {
                return this.performRequest(uri, headers, httpMethod, body);
            }
            catch (RestClientException e)
            {
                if (e.getStatusCode() >= 500 && e.getStatusCode() < 600)
                {
                    try
                    {
                        thrownException = e;
                        Thread.sleep(this.msToWaitForRetrying);
                        retryNumber++;
                        continue;
                    }
                    catch (InterruptedException ie)
                    {
                        throw e;
                    }
                }
                throw e;
            }
        } while (retryNumber < this.maxRetries);
        throw new RestClientException(
                String.format(
                        "Got 5xx server error responses while performing '%s' to url '%s' after %d retries",
                        httpMethod.toString(),
                        uri,
                        retryNumber
                ),
                thrownException.getStatusCode(),
                thrownException.getRawBody()
        );
    }

    private String performRequest(String uri, Map<String, String> headers, HttpMethod httpMethod) throws RestClientException
    {
        return this.performRequest(uri, headers, httpMethod, null);
    }

    private String performRequest(String uri, Map<String, String> headers, HttpMethod httpMethod, Object body)
            throws RestClientException
    {
        if (this.debug)
        {
            RequestLogger.logRequest(httpMethod.toString(), uri, headers);
        }
        try
        {
            HttpResponse<String> response;
            switch (httpMethod) {
                case GET:
                    response = Unirest.get(uri)
                            .headers(headers)
                            .asString();
                    break;
                case POST:
                    response = Unirest.post(uri)
                            .headers(headers)
                            .body(body)
                            .asString();
                    break;
                case PATCH:
                    response = Unirest.patch(uri)
                            .headers(headers)
                            .body(body)
                            .asString();
                    break;
                case DELETE:
                    response = Unirest.delete(uri)
                            .headers(headers)
                            .asString();
                    break;
                default:
                    throw new RestClientException(
                            String.format("Http method '%s' is not supported", httpMethod.toString())
                    );

            }

            this.checkResponse(response);
            return response.getBody();
        }
        catch (UnirestException e)
        {
            String errorMsg = String.format(
                    "Got UnirestException while performing '%s' request to url '%s'",
                    uri,
                    httpMethod.toString()
            );
            throw new RestClientException(errorMsg, e);
        }
    }

    @Override
    public <T> T getAsObject(String uri, Map<String, String> headers, Class<T> responseClass)
            throws RestClientException
    {
        String stringResponse = this.retry ? this.performRequestWithRetries(uri, headers, HttpMethod.GET) : this.performRequest(uri, headers, HttpMethod.GET);
        try
        {
            return this.objectMapper.readValue(stringResponse, responseClass);
        }
        catch (IOException e)
        {
            throw new RestClientException("Error de-serializing response", e);
        }

    }

    @Override
    public <T> T postAsObject(String uri, Map<String, String> headers, Object object, Class<T> responseClass) throws RestClientException
    {
        String stringResponse = this.retry ? this.performRequestWithRetries(uri, headers, HttpMethod.POST, object) : this.performRequest(uri, headers, HttpMethod.POST, object);
        try
        {
            return this.objectMapper.readValue(stringResponse, responseClass);
        }
        catch (IOException e)
        {
            throw new RestClientException("Error de-serializing the response", e);
        }
    }

    @Override
    public <T> T patchAsObject(String uri, Map<String, String> headers, Object object, Class<T> responseClass) throws RestClientException
    {
        String stringResponse = this.retry ? this.performRequestWithRetries(uri, headers, HttpMethod.PATCH, object) : this.performRequest(uri, headers, HttpMethod.PATCH, object);
        try
        {
            return this.objectMapper.readValue(stringResponse, responseClass);
        }
        catch (IOException e)
        {
            throw new RestClientException("Error de-serializing the response", e);
        }
    }

    @Override
    public <T> T deleteAsObject(String uri, Map<String, String> headers, Class<T> responseClass) throws RestClientException
    {
        String stringResponse = this.retry ? this.performRequestWithRetries(uri, headers, HttpMethod.DELETE) : this.performRequest(uri, headers, HttpMethod.DELETE);
        try
        {
            return this.objectMapper.readValue(stringResponse, responseClass);
        }
        catch (IOException e)
        {
            throw new RestClientException("Error de-serializing the response", e);
        }
    }

    @Override
    public void getIgnoreResponse(String uri, Map<String, String> headers) throws RestClientException
    {
        if (this.retry)
        {
            this.performRequestWithRetries(uri, headers, HttpMethod.GET);
        }
        else
        {
            this.performRequest(uri, headers, HttpMethod.GET);
        }
    }

    @Override
    public void postIgnoreResponse(String uri, Map<String, String> headers, Object body) throws RestClientException
    {
        if (this.retry)
        {
            this.performRequestWithRetries(uri, headers, HttpMethod.POST);
        }
        else
        {
            this.performRequest(uri, headers, HttpMethod.POST);
        }
    }

    @Override
    public void deleteIgnoreResponse(String uri, Map<String, String> headers) throws RestClientException
    {
        if (this.retry)
        {
            this.performRequestWithRetries(uri, headers, HttpMethod.DELETE);
        }
        else
        {
            this.performRequest(uri, headers, HttpMethod.DELETE);
        }
    }

    private void checkResponse(HttpResponse response) throws RestClientException
    {
        if (response.getStatus() < 200 || response.getStatus() >= 300)
        {
            try
            {
                String rawBody = IOUtils.toString(response.getRawBody(), StandardCharsets.UTF_8);
                throw new RestClientException(
                        "Error response from REST call",
                        response.getStatus(),
                        rawBody
                );
            }
            catch (IOException e)
            {
                throw new RestClientException(
                        "Error response from REST call",
                        response.getStatus(),
                        "<NOT PARSABLE>"
                );
            }
        }
    }

    public boolean isRetry()
    {
        return retry;
    }

    public void setRetry(boolean retry)
    {
        this.retry = retry;
    }

    public int getMaxRetries()
    {
        return maxRetries;
    }

    public void setMaxRetries(int maxRetries)
    {
        this.maxRetries = maxRetries;
    }

    public long getMsToWaitForRetrying()
    {
        return msToWaitForRetrying;
    }

    public void setMsToWaitForRetrying(long msToWaitForRetrying)
    {
        this.msToWaitForRetrying = msToWaitForRetrying;
    }
}
