package com.bitmovin.api.resource;

import com.bitmovin.api.RestClient;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class EncodingStatisticsResource<T>
{

    protected Map<String, String> headers;
    protected String url;
    protected Class<T> type;

    public EncodingStatisticsResource(Map<String, String> headers, String url, Class<T> type)
    {
        this.headers = headers;
        this.url = url;
        this.type = type;
    }

    public T getEncodingStatistics(String encodingId) throws BitmovinApiException, UnirestException, IOException, URISyntaxException
    {
        String url = this.url.replace("{encoding_id}", encodingId);
        return RestClient.get(url, headers, type);
    }
}