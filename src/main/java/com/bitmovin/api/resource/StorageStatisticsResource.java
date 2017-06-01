package com.bitmovin.api.resource;

import com.bitmovin.api.RestClient;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.storage.OverallStatistics;
import com.bitmovin.api.storage.PathRequest;
import com.bitmovin.api.http.RestException;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 13.09.16.
 */
public class StorageStatisticsResource
{

    protected Map<String, String> headers;
    protected String url;

    public StorageStatisticsResource(Map<String, String> headers, String url)
    {
        this.headers = headers;
        this.url = url;
    }

    public OverallStatistics getStatistics(PathRequest pathRequest) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        return RestClient.get(this.url, this.headers, OverallStatistics.class);
    }
}
