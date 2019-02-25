package com.bitmovin.api.encoding.manifests.smooth;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.manifests.smooth.customdata.CustomdataApi;
import com.bitmovin.api.encoding.manifests.smooth.representations.RepresentationsApi;
import com.bitmovin.api.encoding.manifests.smooth.contentprotection.ContentprotectionApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmoothApi
{
    private final SmoothClient apiClient;
    public CustomdataApi customdata;
    public RepresentationsApi representations;
    public ContentprotectionApi contentprotection;

    public SmoothApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public SmoothApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public SmoothApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(SmoothClient.class);

        customdata = new CustomdataApi(clientFactory);
        representations = new RepresentationsApi(clientFactory);
        contentprotection = new ContentprotectionApi(clientFactory);
    }


    /**
    * Create Smooth Streaming Manifest
    * 
    * @param smoothStreamingManifest  (optional)
    * @return SmoothStreamingManifest
    * @throws BitmovinException if fails to make API call
    */
    public SmoothStreamingManifest create(SmoothStreamingManifest smoothStreamingManifest) throws BitmovinException
    {
        return this.apiClient.create(smoothStreamingManifest);
    }

    /**
    * Delete Smooth Streaming Manifest
    * 
    * @param manifestId Id of the Smooth Streaming manifest. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String manifestId) throws BitmovinException
    {
        return this.apiClient.delete(manifestId);
    }

    /**
    * Smooth Streaming Manifest Details
    * 
    * @param manifestId Id of the Smooth Streaming manifest. (required)
    * @return SmoothStreamingManifest
    * @throws BitmovinException if fails to make API call
    */
    public SmoothStreamingManifest get(String manifestId) throws BitmovinException
    {
        return this.apiClient.get(manifestId);
    }
    /**
    * List Smooth Streaming Manifests
    * 
    * @return List&lt;SmoothStreamingManifest&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<SmoothStreamingManifest> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List Smooth Streaming Manifests
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;SmoothStreamingManifest&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<SmoothStreamingManifest> list(SmoothStreamingManifestsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }

    /**
    * Start Smooth Streaming Manifest Creation
    * 
    * @param manifestId Id of the Smooth Streaming manifest. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse start(String manifestId) throws BitmovinException
    {
        return this.apiClient.start(manifestId);
    }

    /**
    * Smooth Streaming Manifest Creation Status
    * 
    * @param manifestId Id of the Smooth Streaming manifest. (required)
    * @return Task
    * @throws BitmovinException if fails to make API call
    */
    public Task status(String manifestId) throws BitmovinException
    {
        return this.apiClient.status(manifestId);
    }

    /**
    * Stop Smooth Streaming Manifest Creation
    * 
    * @param manifestId Id of the Smooth Streaming manifest. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse stop(String manifestId) throws BitmovinException
    {
        return this.apiClient.stop(manifestId);
    }
}
