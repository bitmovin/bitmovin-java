package com.bitmovin.api.encoding.inputs.rtmp;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RtmpApi
{
    private final RtmpClient apiClient;

    public RtmpApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public RtmpApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public RtmpApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(RtmpClient.class);

    }


    /**
    * RTMP Input Details
    * 
    * @param inputId Id of the input (required)
    * @return RtmpInput
    * @throws BitmovinException if fails to make API call
    */
    public RtmpInput get(String inputId) throws BitmovinException
    {
        return this.apiClient.get(inputId);
    }
    /**
    * List RTMP Inputs
    * 
    * @return List&lt;RtmpInput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<RtmpInput> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List RTMP Inputs
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;RtmpInput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<RtmpInput> list(RtmpInputsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
