package com.bitmovin.api.encoding.encodings.keyframes;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyframesApi
{
    private final KeyframesClient apiClient;

    public KeyframesApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public KeyframesApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public KeyframesApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(KeyframesClient.class);

    }


    /**
    * Create Keyframes
    * 
    * @param encodingId Id of the encoding. (required)
    * @param keyframe  (optional)
    * @return Keyframe
    * @throws BitmovinException if fails to make API call
    */
    public Keyframe create(String encodingId, Keyframe keyframe) throws BitmovinException
    {
        return this.apiClient.create(encodingId, keyframe);
    }

    /**
    * Delete Keyframe
    * 
    * @param encodingId Id of the encoding. (required)
    * @param keyframeId Id of the keyframe. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String encodingId, String keyframeId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, keyframeId);
    }

    /**
    * Keyframe Details
    * 
    * @param encodingId Id of the encoding. (required)
    * @param keyframeId Id of the keyframe. (required)
    * @return Keyframe
    * @throws BitmovinException if fails to make API call
    */
    public Keyframe get(String encodingId, String keyframeId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, keyframeId);
    }
    /**
    * List all Keyframes
    * 
    * @param encodingId Id of the encoding. (required)
    * @return List&lt;Keyframe&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Keyframe> list(String encodingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, new HashMap<String, Object>());
    }

    /**
    * List all Keyframes
    * 
    * @param encodingId Id of the encoding. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;Keyframe&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Keyframe> list(String encodingId, KeyframesListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, queryParams);
    }
}
