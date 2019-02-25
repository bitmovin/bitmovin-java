package com.bitmovin.api.encoding.manifests.hls;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.manifests.hls.customdata.CustomdataApi;
import com.bitmovin.api.encoding.manifests.hls.streams.StreamsApi;
import com.bitmovin.api.encoding.manifests.hls.media.MediaApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HlsApi
{
    private final HlsClient apiClient;
    public CustomdataApi customdata;
    public StreamsApi streams;
    public MediaApi media;

    public HlsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public HlsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public HlsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(HlsClient.class);

        customdata = new CustomdataApi(clientFactory);
        streams = new StreamsApi(clientFactory);
        media = new MediaApi(clientFactory);
    }


    /**
    * Create HLS Manifest
    * 
    * @param hlsManifest  (optional)
    * @return HlsManifest
    * @throws BitmovinException if fails to make API call
    */
    public HlsManifest create(HlsManifest hlsManifest) throws BitmovinException
    {
        return this.apiClient.create(hlsManifest);
    }

    /**
    * Delete HLS Manifest
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String manifestId) throws BitmovinException
    {
        return this.apiClient.delete(manifestId);
    }

    /**
    * HLS Manifest Details
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @return HlsManifest
    * @throws BitmovinException if fails to make API call
    */
    public HlsManifest get(String manifestId) throws BitmovinException
    {
        return this.apiClient.get(manifestId);
    }
    /**
    * List HLS Manifests
    * 
    * @return List&lt;HlsManifest&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<HlsManifest> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List HLS Manifests
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;HlsManifest&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<HlsManifest> list(HlsManifestsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }

    /**
    * Start HLS Manifest Creation
    * 
    * @param manifestId Id of the HLS manifest. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse start(String manifestId) throws BitmovinException
    {
        return this.apiClient.start(manifestId);
    }

    /**
    * HLS Manifest Creation Status
    * 
    * @param manifestId Id of the HLS manifest. (required)
    * @return Task
    * @throws BitmovinException if fails to make API call
    */
    public Task status(String manifestId) throws BitmovinException
    {
        return this.apiClient.status(manifestId);
    }

    /**
    * Stop HLS Manifest Creation
    * 
    * @param manifestId Id of the HLS manifest. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse stop(String manifestId) throws BitmovinException
    {
        return this.apiClient.stop(manifestId);
    }
}
