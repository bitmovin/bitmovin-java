package com.bitmovin.api.encoding.manifests.hls.streams;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.manifests.hls.streams.customTag.CustomTagApi;
import com.bitmovin.api.encoding.manifests.hls.streams.iframe.IframeApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamsApi
{
    private final StreamsClient apiClient;
    public CustomTagApi customTag;
    public IframeApi iframe;

    public StreamsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public StreamsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public StreamsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(StreamsClient.class);

        customTag = new CustomTagApi(clientFactory);
        iframe = new IframeApi(clientFactory);
    }


    /**
    * Add Variant Stream
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @param streamInfo  (optional)
    * @return StreamInfo
    * @throws BitmovinException if fails to make API call
    */
    public StreamInfo create(String manifestId, StreamInfo streamInfo) throws BitmovinException
    {
        return this.apiClient.create(manifestId, streamInfo);
    }

    /**
    * Delete Variant Stream
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @param streamId Id of the variant stream. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String manifestId, String streamId) throws BitmovinException
    {
        return this.apiClient.delete(manifestId, streamId);
    }

    /**
    * Variant Stream Details
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @param streamId Id of the variant stream. (required)
    * @return StreamInfo
    * @throws BitmovinException if fails to make API call
    */
    public StreamInfo get(String manifestId, String streamId) throws BitmovinException
    {
        return this.apiClient.get(manifestId, streamId);
    }
    /**
    * List all Variant Streams
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @return List&lt;StreamInfo&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<StreamInfo> list(String manifestId) throws BitmovinException
    {
        return this.apiClient.list(manifestId, new HashMap<String, Object>());
    }

    /**
    * List all Variant Streams
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;StreamInfo&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<StreamInfo> list(String manifestId, StreamInfosListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(manifestId, queryParams);
    }
}
