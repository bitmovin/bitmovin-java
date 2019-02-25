package com.bitmovin.api.encoding.manifests.hls.media.customTag;

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
    * Add Custom Tag to Audio Media
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @param mediaId Id of the audio media. (required)
    * @param customTag  (optional)
    * @return CustomTag
    * @throws BitmovinException if fails to make API call
    */
    public CustomTag create(String manifestId, String mediaId, CustomTag customTag) throws BitmovinException
    {
        return this.apiClient.create(manifestId, mediaId, customTag);
    }

    /**
    * Delete Custom Tag
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @param mediaId Id of the audio media. (required)
    * @param customTagId Id of the custom tag. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String manifestId, String mediaId, String customTagId) throws BitmovinException
    {
        return this.apiClient.delete(manifestId, mediaId, customTagId);
    }

    /**
    * Custom Tag Details
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @param mediaId Id of the audio media (required)
    * @param customTagId Id of the custom tag. (required)
    * @return CustomTag
    * @throws BitmovinException if fails to make API call
    */
    public CustomTag get(String manifestId, String mediaId, String customTagId) throws BitmovinException
    {
        return this.apiClient.get(manifestId, mediaId, customTagId);
    }
    /**
    * List all Custom Tags of a Audio media
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @param mediaId Id of the audio media. (required)
    * @return List&lt;CustomTag&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<CustomTag> list(String manifestId, String mediaId) throws BitmovinException
    {
        return this.apiClient.list(manifestId, mediaId, new HashMap<String, Object>());
    }

    /**
    * List all Custom Tags of a Audio media
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @param mediaId Id of the audio media. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;CustomTag&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<CustomTag> list(String manifestId, String mediaId, CustomTagsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(manifestId, mediaId, queryParams);
    }
}
