package com.bitmovin.api.http;

import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.rest.ResponseEnvelope;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
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

    private boolean debug;

    public JsonRestClient(boolean isDebug)
    {
        this.debug = isDebug;
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
        HttpResponse<T> response =  request.asObject(classOfT);
        this.logHttpResponse(response);
        this.checkOrThrowError(response);
        return response.getBody();
    }

    public <T> T get(URI resource, Map<String, String> headers, Class<T> classOfT) throws UnirestException, BitmovinApiException
    {
        HttpRequest request = Unirest.get(resource.toString())
                                     .headers(headers);
        this.logHttpRequest(request);
        HttpResponse<T> response = request.asObject(classOfT);
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
        HttpResponse<T> response = request.asObject(classOfT);
        this.logHttpResponse(response);
        this.checkOrThrowError(response);
        return response.getBody();
    }

    public void post(URI resource, Map<String, String> headers, Object content) throws IOException, RestException, UnirestException, BitmovinApiException
    {
        HttpRequest request = Unirest.post(resource.toString())
                                     .headers(headers)
                                     .body(content)
                                     .getHttpRequest();
        this.logHttpRequest(request);
        HttpResponse<ResponseEnvelope> response =  request.asObject(ResponseEnvelope.class);
        this.logHttpResponse(response);
        this.checkOrThrowError(response);
    }

    public void get(URI resource, Map<String, String> headers) throws IOException, RestException, UnirestException, BitmovinApiException
    {
        HttpRequest request = Unirest.get(resource.toString())
                                     .headers(headers)
                                     .getHttpRequest()
                ;
        this.logHttpRequest(request);
        HttpResponse<ResponseEnvelope> response =  request.asObject(ResponseEnvelope.class);
        this.logHttpResponse(response);
        this.checkOrThrowError(response);
    }

    public <T> T patch(URI resource, Map<String, String> headers, Object content, Class<T> classOfT) throws UnirestException, BitmovinApiException
    {
        HttpRequest request = Unirest.patch(resource.toString())
                                     .headers(headers)
                                     .getHttpRequest();
        this.logHttpRequest(request);
        HttpResponse<T> response =  request.asObject(classOfT);
        this.logHttpResponse(response);
        this.checkOrThrowError(response);
        return response.getBody();
    }

    public void delete(URI resource, Map<String, String> headers) throws IOException, RestException, UnirestException, BitmovinApiException
    {
        HttpRequest request = Unirest.delete(resource.toString())
                                     .headers(headers)
                                     .getHttpRequest();
        this.logHttpRequest(request);
        HttpResponse<ResponseEnvelope> response =  request.asObject(ResponseEnvelope.class);
        this.logHttpResponse(response);
        this.checkOrThrowError(response);
    }

    public void delete(URI resource, Map<String, String> headers, Object content) throws IOException, RestException, UnirestException, BitmovinApiException
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
        HttpResponse<ResponseEnvelope> response =  request.asObject(ResponseEnvelope.class);
        this.logHttpResponse(response);
        this.checkOrThrowError(response);
    }

}
