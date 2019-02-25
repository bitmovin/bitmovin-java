package com.bitmovin.api.encoding.manifests.hls.streams.customTag;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomTagApi
{
    private final CustomTagClient apiClient;

    public CustomTagApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public CustomTagApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public CustomTagApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(CustomTagClient.class);

    }


    /**
    * Add Custom Tag to Variant Stream
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @param streamId Id of the variant stream. (required)
    * @param customTag  (optional)
    * @return CustomTag
    * @throws BitmovinException if fails to make API call
    */
    public CustomTag create(String manifestId, String streamId, CustomTag customTag) throws BitmovinException
    {
        return this.apiClient.create(manifestId, streamId, customTag);
    }

    /**
    * Delete Custom Tag
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @param streamId Id of the variant stream. (required)
    * @param customTagId Id of the custom tag. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String manifestId, String streamId, String customTagId) throws BitmovinException
    {
        return this.apiClient.delete(manifestId, streamId, customTagId);
    }

    /**
    * Custom Tag Details
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @param streamId Id of the variant stream. (required)
    * @param customTagId Id of the custom tag. (required)
    * @return CustomTag
    * @throws BitmovinException if fails to make API call
    */
    public CustomTag get(String manifestId, String streamId, String customTagId) throws BitmovinException
    {
        return this.apiClient.get(manifestId, streamId, customTagId);
    }
    /**
    * List all Custom Tags of a Variant Stream
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @param streamId Id of the variant stream. (required)
    * @return List&lt;CustomTag&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<CustomTag> list(String manifestId, String streamId) throws BitmovinException
    {
        return this.apiClient.list(manifestId, streamId, new HashMap<String, Object>());
    }

    /**
    * List all Custom Tags of a Variant Stream
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @param streamId Id of the variant stream. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;CustomTag&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<CustomTag> list(String manifestId, String streamId, CustomTagsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(manifestId, streamId, queryParams);
    }
}
