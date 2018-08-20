package com.bitmovin.api.http;

import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.rest.ResponseEnvelope;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.InputStream;
import java.net.URI;
import java.util.List;
import java.util.Map;

/**
 * Created by
 * David Moser [david.moser@bitmovin.com]
 * on 7/13/16
 */
public class JsonRestClient
{
    private int maxRetries = 10;
    private int msToWaitForRetrying = 2000;
    private boolean retryOnError = false;
    private boolean debug;

    public JsonRestClient(boolean isDebug, boolean isRetry)
    {
        this.debug = isDebug;
        this.retryOnError = isRetry;
    }

    private void logHttpRequest(HttpRequest request)
    {
        if (!this.debug)
            return;
        System.out.println("");
        System.out.println("--- Sending Request ---");
        System.out.println("URL: " + request.getUrl());
        System.out.println("Method: " + request.getHttpMethod().toString());

        System.out.println("Headers: ");
        Map<String, List<String>> requestHeaders = request.getHeaders();
        for (String key : requestHeaders.keySet())
        {
            List<String> values = requestHeaders.get(key);
            for (String value : values)
            {
                System.out.println(key + " : " + value);
            }
        }

        try
        {
            InputStream in = request.getBody().getEntity().getContent();
            String body = IOUtils.toString(in, "UTF-8");
            in.close();
            System.out.println("Body: " + body);
        }
        catch (Exception ex)
        {
            System.out.println("Body: <EMPTY>");
        }
    }

    private void logHttpResponse(HttpResponse response)
    {
        if (!this.debug)
            return;
        System.out.println("--- Retrieved Response ---");
        System.out.println("Status: " + response.getStatus());
        System.out.println("Status Test: " + response.getStatusText());

        try
        {
            Object object = response.getBody();
            System.out.println("Body: " + new ObjectMapper().writeValueAsString(object));
        }
        catch (Exception ex)
        {
            System.out.println("Body: <EMPTY>");
        }
        System.out.println("--- End of Request ---");
    }

    private void checkOrThrowError(HttpResponse response) throws BitmovinApiException
    {
        if (response.getStatus() >= 200 && response.getStatus() < 300)
            return;
        if (response.getBody() instanceof ResponseEnvelope)
        {
            ResponseEnvelope responseEnvelope = (ResponseEnvelope) response.getBody();
            try
            {
                ObjectMapper mapper = new ObjectMapper();
                mapper.enable(SerializationFeature.INDENT_OUTPUT);
                System.out.println("Error Response: " + mapper.writeValueAsString(responseEnvelope));
            }
            catch (Exception ignore)
            {
            }
            throw new BitmovinApiException(response.getStatus(), responseEnvelope);
        }
        throw new BitmovinApiException(response.getStatus());
    }

    public <T> T post(URI resource, Map<String, String> headers, Object content, Class<T> classOfT) throws UnirestException, BitmovinApiException
    {
        HttpRequest request = Unirest.post(resource.toString())
                                     .headers(headers)
                                     .body(content)
                                     .getHttpRequest();
        this.logHttpRequest(request);
        HttpResponse<T> response =  executeHttpRequest(request, classOfT);
        this.logHttpResponse(response);
        this.checkOrThrowError(response);
        return response.getBody();
    }

    public <T> T get(URI resource, Map<String, String> headers, Class<T> classOfT) throws UnirestException, BitmovinApiException
    {
        HttpRequest request = Unirest.get(resource.toString())
                                     .headers(headers);
        this.logHttpRequest(request);
        HttpResponse<T> response = executeHttpRequest(request, classOfT);
        this.logHttpResponse(response);
        this.checkOrThrowError(response);
        return response.getBody();
    }

    public <T> T delete(URI resource, Map<String, String> headers, Class<T> classOfT) throws UnirestException, BitmovinApiException
    {
        HttpRequest request = Unirest.delete(resource.toString())
                                     .headers(headers)
                                     .getHttpRequest();
        this.logHttpRequest(request);
        HttpResponse<T> response = executeHttpRequest(request, classOfT);
        this.logHttpResponse(response);
        this.checkOrThrowError(response);
        return response.getBody();
    }

    public void post(URI resource, Map<String, String> headers, Object content) throws UnirestException, BitmovinApiException
    {
        HttpRequest request = Unirest.post(resource.toString())
                                     .headers(headers)
                                     .body(content)
                                     .getHttpRequest();
        this.logHttpRequest(request);
        HttpResponse<ResponseEnvelope> response =  executeHttpRequest(request, ResponseEnvelope.class);
        this.logHttpResponse(response);
        this.checkOrThrowError(response);
    }

    public void get(URI resource, Map<String, String> headers) throws UnirestException, BitmovinApiException
    {
        HttpRequest request = Unirest.get(resource.toString())
                                     .headers(headers)
                                     .getHttpRequest()
                ;
        this.logHttpRequest(request);
        HttpResponse<ResponseEnvelope> response =  executeHttpRequest(request, ResponseEnvelope.class);
        this.logHttpResponse(response);
        this.checkOrThrowError(response);
    }

    public <T> T patch(URI resource, Map<String, String> headers, Object content, Class<T> classOfT) throws UnirestException, BitmovinApiException
    {
        HttpRequest request = Unirest.patch(resource.toString())
                                     .headers(headers)
                                     .getHttpRequest();
        this.logHttpRequest(request);
        HttpResponse<T> response =  executeHttpRequest(request, classOfT);
        this.logHttpResponse(response);
        this.checkOrThrowError(response);
        return response.getBody();
    }

    public void delete(URI resource, Map<String, String> headers) throws UnirestException, BitmovinApiException
    {
        HttpRequest request = Unirest.delete(resource.toString())
                                     .headers(headers)
                                     .getHttpRequest();
        this.logHttpRequest(request);
        HttpResponse<ResponseEnvelope> response =  executeHttpRequest(request, ResponseEnvelope.class);
        this.logHttpResponse(response);
        this.checkOrThrowError(response);
    }

    public void delete(URI resource, Map<String, String> headers, Object content) throws UnirestException, BitmovinApiException
    {
        if (content == null)
        {
            this.delete(resource, headers);
            return;
        }
        HttpRequest request = Unirest.delete(resource.toString())
                                     .headers(headers)
                                     .body(content)
                                     .getHttpRequest();
        this.logHttpRequest(request);
        HttpResponse<ResponseEnvelope> response = executeHttpRequest(request, ResponseEnvelope.class);
        this.logHttpResponse(response);
        this.checkOrThrowError(response);
    }

    public void setMaxRetries(int maxRetries)
    {
        this.maxRetries = maxRetries;
    }

    public void setMsToWaitForRetrying(int msToWaitForRetrying)
    {
        this.msToWaitForRetrying = msToWaitForRetrying;
    }

    public void setRetryOnError(boolean retryOnError)
    {
        this.retryOnError = retryOnError;
    }

    public void setDebug(boolean debug)
    {
        this.debug = debug;
    }

    private <T> HttpResponse<T> executeHttpRequest(HttpRequest httpRequest, Class<T> responseClass) throws UnirestException
    {
        if (this.retryOnError && this.maxRetries > 0 && this.msToWaitForRetrying > 0)
        {
            return this.executeHttpRequestWithRetries(httpRequest, responseClass);
        }
        else
        {
            return httpRequest.asObject(responseClass);
        }
    }

    private <T> HttpResponse<T> executeHttpRequestWithRetries(HttpRequest httpRequest, Class<T> responseClass) throws UnirestException
    {
        for (int i = 1; i <= this.maxRetries; i++)
        {
            try
            {
                return httpRequest.asObject(responseClass);
            }
            catch (UnirestException e)
            {
                if (this.debug)
                {
                    System.out.println(
                            String.format("Exception occurred (Retry %d from %d)...: %s", i, this.maxRetries, ExceptionUtils.getStackTrace(e))
                    );
                }
                try
                {
                    Thread.sleep(this.msToWaitForRetrying);
                }
                catch (InterruptedException interruptedException)
                {
                    if (this.debug)
                    {
                        System.out.println(
                                String.format("Got InterruptedException (Retry %d from %d): %s", i, this.maxRetries, ExceptionUtils.getStackTrace(interruptedException))
                        );
                    }
                }
            }
        }
        throw new UnirestException(
                String.format("Couldn't successfully perform HttpRequest after %d retries", this.maxRetries)
        );
    }

}
