package com.bitmovin.api.resource;

import com.bitmovin.api.RestClient;
import com.bitmovin.api.encoding.statistics.LiveInputEvent;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class LiveEncodingEventsResource
{
    protected Map<String, String> headers;
    protected String url;

    public LiveEncodingEventsResource(Map<String, String> headers, String url)
    {
        this.headers = headers;
        this.url = url;
    }

    public List<LiveInputEvent> getEvents(String encodingId) throws BitmovinApiException, UnirestException, IOException, URISyntaxException
    {
        String url = this.url.replace("{encoding_id}", encodingId);
        return RestClient.getItems(url, headers, LiveInputEvent.class);
    }

    public List<LiveInputEvent> getEvents(String encodingId, int offset, int limit) throws BitmovinApiException, UnirestException, IOException, URISyntaxException
    {
        String url = this.url.replace("{encoding_id}", encodingId);
        String limitUrl = url + "?offset=" + String.valueOf(offset) + "&limit=" + String.valueOf(limit);
        return RestClient.getItems(limitUrl, headers, LiveInputEvent.class);
    }
}
