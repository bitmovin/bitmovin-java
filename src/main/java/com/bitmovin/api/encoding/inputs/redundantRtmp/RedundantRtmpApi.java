package com.bitmovin.api.encoding.inputs.redundantRtmp;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RedundantRtmpApi
{
    private final RedundantRtmpClient apiClient;

    public RedundantRtmpApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public RedundantRtmpApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public RedundantRtmpApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(RedundantRtmpClient.class);

    }


    /**
    * Create Redundant RTMP Input
    * 
    * @param redundantRtmpInput The Redundant RTMP input to be created (optional)
    * @return RedundantRtmpInput
    * @throws BitmovinException if fails to make API call
    */
    public RedundantRtmpInput create(RedundantRtmpInput redundantRtmpInput) throws BitmovinException
    {
        return this.apiClient.create(redundantRtmpInput);
    }

    /**
    * Delete Redundant RTMP Input
    * 
    * @param inputId Id of the input (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String inputId) throws BitmovinException
    {
        return this.apiClient.delete(inputId);
    }

    /**
    * Redundant RTMP Input Details
    * 
    * @param inputId Id of the input (required)
    * @return RedundantRtmpInput
    * @throws BitmovinException if fails to make API call
    */
    public RedundantRtmpInput get(String inputId) throws BitmovinException
    {
        return this.apiClient.get(inputId);
    }
    /**
    * List Redundant RTMP Inputs
    * 
    * @return List&lt;RedundantRtmpInput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<RedundantRtmpInput> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List Redundant RTMP Inputs
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;RedundantRtmpInput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<RedundantRtmpInput> list(RedundantRtmpInputsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
