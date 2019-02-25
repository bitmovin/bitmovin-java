package com.bitmovin.api.encoding.inputs.udp;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UdpApi
{
    private final UdpClient apiClient;

    public UdpApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public UdpApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public UdpApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(UdpClient.class);

    }


    /**
    * UDP Input Details
    * 
    * @param inputId Id of the input (required)
    * @return UdpInput
    * @throws BitmovinException if fails to make API call
    */
    public UdpInput get(String inputId) throws BitmovinException
    {
        return this.apiClient.get(inputId);
    }
    /**
    * List UDP inputs
    * 
    * @return List&lt;UdpInput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<UdpInput> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List UDP inputs
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;UdpInput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<UdpInput> list(UdpInputsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
