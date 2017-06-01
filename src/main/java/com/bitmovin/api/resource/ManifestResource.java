package com.bitmovin.api.resource;

import com.bitmovin.api.AbstractApiResponse;
import com.bitmovin.api.RestClient;
import com.bitmovin.api.encoding.manifest.ManifestCreationProcessResponse;
import com.bitmovin.api.enums.Status;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.http.RestException;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * Created by rkersche on 9/5/16.
 */
public class ManifestResource<T extends AbstractApiResponse> extends AbstractResource<T>
{

    private String status;
    private String start;

    public ManifestResource(Map<String, String> headers, String url, Class<T> type)
    {
        super(headers, url, type);
    }

    public ManifestResource(Map<String, String> headers, String url, Class<T> type, String status, String start)
    {
        super(headers, url, type);
        this.status = status;
        this.start = start;
    }

    public ManifestCreationProcessResponse startGeneration(T manifest) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = this.start.replace("{manifestId}", manifest.getId());
        return RestClient.postDetail(newUrl, this.headers, manifest, ManifestCreationProcessResponse.class);
    }

    public Status getGenerationStatus(T manifest) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = this.status.replace("{manifestId}", manifest.getId());
        Map resultMap = RestClient.getDetailsFromResponse(newUrl, this.headers, Map.class);
        return Status.valueOf(resultMap.get("status").toString());
    }
}
