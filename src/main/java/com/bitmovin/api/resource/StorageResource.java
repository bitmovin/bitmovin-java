package com.bitmovin.api.resource;

import com.bitmovin.api.RestClient;
import com.bitmovin.api.constants.ApiUrls;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.storage.PathRequest;
import com.bitmovin.api.storage.StoragePaginationResponse;
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
public class StorageResource
{

    protected Map<String, String> headers;
    protected String url;

    public StorageResource(Map<String, String> headers, String url)
    {
        this.headers = headers;
        this.url = url;
    }

    public StoragePaginationResponse getEntries(PathRequest pathRequest) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        return RestClient.postDetail(this.url, this.headers, pathRequest, StoragePaginationResponse.class);
    }

    public StoragePaginationResponse getEntries(PathRequest pathRequest, Integer offset, Integer limit) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String limitOffsetString = "";
        if(offset != null || limit != null)
            limitOffsetString = "?";
        if(offset != null)
            limitOffsetString += "offset=" + offset + "&";
        if(limit != null)
            limitOffsetString += "limit=" + limit;

        return RestClient.postDetail(this.url + limitOffsetString, this.headers, pathRequest, StoragePaginationResponse.class);
    }

    public void deleteEntries(PathRequest pathRequest) throws BitmovinApiException, URISyntaxException, IOException, RestException, UnirestException
    {
        RestClient.delete(ApiUrls.storageUrl, this.headers, pathRequest);
    }

}
