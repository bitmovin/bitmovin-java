package com.bitmovin.api.http;

import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.rest.ResponseEnvelope;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.net.URI;
import java.util.Map;

/**
 * Created by
 * David Moser [david.moser@bitmovin.com]
 * on 7/13/16
 */
public class JsonRestClient
{

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
        HttpResponse<T> response = Unirest.post(resource.toString())
                                          .headers(headers)
                                          .body(content)
                                          .asObject(classOfT);
        this.checkOrThrowError(response);
        return response.getBody();
    }

    public <T> T get(URI resource, Map<String, String> headers, Class<T> classOfT) throws UnirestException, BitmovinApiException
    {
        HttpResponse<T> response = Unirest.get(resource.toString())
                                          .headers(headers)
                                          .asObject(classOfT);
        this.checkOrThrowError(response);
        return response.getBody();
    }

    public <T> T delete(URI resource, Map<String, String> headers, Class<T> classOfT) throws UnirestException, BitmovinApiException
    {
        HttpResponse<T> response = Unirest.delete(resource.toString())
                                          .headers(headers)
                                          .asObject(classOfT);
        this.checkOrThrowError(response);
        return response.getBody();
    }

    public void post(URI resource, Map<String, String> headers, Object content) throws IOException, RestException, UnirestException, BitmovinApiException
    {
        HttpResponse<ResponseEnvelope> response = Unirest.post(resource.toString())
                                                         .headers(headers)
                                                         .body(content)
                                                         .asObject(ResponseEnvelope.class);
        this.checkOrThrowError(response);
    }

    public void get(URI resource, Map<String, String> headers) throws IOException, RestException, UnirestException, BitmovinApiException
    {
        HttpResponse<ResponseEnvelope> response = Unirest.get(resource.toString())
                                                         .headers(headers)
                                                         .asObject(ResponseEnvelope.class);
        this.checkOrThrowError(response);
    }

    public <T> T patch(URI resource, Map<String, String> headers, Object content, Class<T> classOfT) throws UnirestException, BitmovinApiException
    {
        HttpResponse<T> response = Unirest.patch(resource.toString())
                                          .headers(headers)
                                          .asObject(classOfT);
        this.checkOrThrowError(response);
        return response.getBody();
    }

    public void delete(URI resource, Map<String, String> headers) throws IOException, RestException, UnirestException, BitmovinApiException
    {
        HttpResponse<ResponseEnvelope> response = Unirest.delete(resource.toString())
                                                         .headers(headers)
                                                         .asObject(ResponseEnvelope.class);
        this.checkOrThrowError(response);
    }

    public void delete(URI resource, Map<String, String> headers, Object content) throws IOException, RestException, UnirestException, BitmovinApiException
    {
        if (content == null)
        {
            this.delete(resource, headers);
            return;
        }
        HttpResponse<ResponseEnvelope> response = Unirest.delete(resource.toString())
                                                         .headers(headers)
                                                         .body(content)
                                                         .asObject(ResponseEnvelope.class);
        this.checkOrThrowError(response);
    }

}
