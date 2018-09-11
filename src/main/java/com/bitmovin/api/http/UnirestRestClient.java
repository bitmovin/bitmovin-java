package com.bitmovin.api.http;

import com.bitmovin.api.http.exceptions.RestClientException;
import com.bitmovin.api.http.utils.RequestLogger;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
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
    private boolean debug = false;
    private boolean retry = false;

    public UnirestRestClient(final ObjectMapper objectMapper, boolean debug, boolean retry)
    {
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        this.objectMapper = objectMapper;
    }

    @Override
    public String getAsString(String uri, Map<String, String> headers)
            throws RestClientException
    {
        if (this.debug)
        {
            RequestLogger.logRequest("GET", uri, headers);
        }
        try
        {
            HttpResponse<String> response = Unirest.get(uri)
                    .headers(headers)
                    .asString();
            this.checkResponse(response);
            return response.getBody();
        }
        catch (UnirestException e)
        {
            String errorMsg = String
                    .format("Got UnirestException in getAsString from GET request to url %s", uri);
            throw new RestClientException(errorMsg, e);
        }
    }

    @Override
    public <T> T getAsObject(String uri, Map<String, String> headers, Class<T> responseClass)
            throws RestClientException
    {
        String stringResponse = getAsString(uri, headers);
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
    public String postAsString(String uri, Map<String, String> headers, Object object) throws RestClientException
    {
        if (this.debug)
        {
            RequestLogger.logRequest("POST", uri, object, headers);
        }
        try
        {
            HttpResponse<String> response = Unirest.post(uri)
                    .headers(headers)
                    .body(object)
                    .asString();
            this.checkResponse(response);
            return response.getBody();
        }
        catch (UnirestException e)
        {
            String errorMsg = String
                    .format("Got UnirestException in postAsString from POST request to url %s", uri);
            throw new RestClientException(errorMsg, e);
        }
    }

    @Override
    public <T> T postAsObject(String uri, Map<String, String> headers, Object object, Class<T> responseClass) throws RestClientException
    {
        String stringResponse = this.postAsString(uri, headers, object);
        try
        {
            return this.objectMapper.readValue(stringResponse, responseClass);
        }
        catch (IOException e)
        {
            throw new RestClientException("Error de-serializing the respose", e);
        }
    }

    @Override
    public String patchAsString(String uri, Map<String, String> headers, Object object) throws RestClientException
    {
        if (this.debug)
        {
            RequestLogger.logRequest("PATCH", uri, headers);
        }
        try
        {
            HttpResponse<String> response = Unirest.patch(uri)
                    .headers(headers)
                    .body(object)
                    .asString();
            this.checkResponse(response);
            return response.getBody();
        }
        catch (UnirestException e)
        {
            String errorMsg = String
                    .format("Got UnirestException in postAsString from POST request to url %s", uri);
            throw new RestClientException(errorMsg, e);
        }
    }

    @Override
    public <T> T patchAsObject(String uri, Map<String, String> headers, Object object, Class<T> responseClass) throws RestClientException
    {
        String stringResponse = patchAsString(uri, headers, object);
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
    public <T> T delete(String uri, Map<String, String> headers, Class<T> responseClass) throws RestClientException
    {
        try
        {
            RequestLogger.logRequest("DELETE", uri, headers);
            HttpResponse<String> response = Unirest.delete(uri)
                    .headers(headers)
                    .asString();
            this.checkResponse(response);
            return this.objectMapper.readValue(response.getBody(), responseClass);
        }
        catch (UnirestException e)
        {
            String errorMsg = String
                    .format("Got UnirestException in delete from DELETE request to url %s", uri);
            throw new RestClientException(errorMsg, e);
        }
        catch (IOException e)
        {
            throw new RestClientException("Error de-serializing th response", e);
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

}
