package com.bitmovin.api.resource;

import com.bitmovin.api.RestClient;
import com.bitmovin.api.constants.ApiUrls;
import com.bitmovin.api.encoding.manifest.smooth.SmoothStreamingContentProtection;
import com.bitmovin.api.encoding.manifest.smooth.SmoothStreamingManifest;
import com.bitmovin.api.encoding.manifest.smooth.SmoothStreamingRepresentation;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.http.RestException;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * Created by atrattnig on 11/16/16.
 */
public class ManifestSmoothResource extends ManifestResource<SmoothStreamingManifest>
{
    public ManifestSmoothResource(Map<String, String> headers, String url, Class<SmoothStreamingManifest> type, String status, String start)
    {
        super(headers, url, type, status, start);
    }

    public SmoothStreamingRepresentation addRepresentation(SmoothStreamingManifest smoothManifest,
                                                           SmoothStreamingRepresentation smoothStreamingRepresentation)
            throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.manifestSmoothRepresentation.replace("{manifestId}", smoothManifest.getId());
        return RestClient.postDetail(newUrl, this.headers, smoothStreamingRepresentation, SmoothStreamingRepresentation.class);
    }

    public SmoothStreamingContentProtection addContentProtection(SmoothStreamingManifest smoothManifest,
                                                              SmoothStreamingContentProtection smoothStreamingContentProtection)
            throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.manifestSmoothContentProtection.replace("{manifestId}", smoothManifest.getId());
        return RestClient.postDetail(newUrl, this.headers, smoothStreamingContentProtection, SmoothStreamingContentProtection.class);
    }
}
