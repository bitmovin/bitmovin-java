package com.bitmovin.api.encoding.inputs.tcp;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TcpApi
{
    private final TcpClient apiClient;

    public TcpApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public TcpApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public TcpApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(TcpClient.class);

    }


    /**
    * TCP Input Details
    * 
    * @param inputId Id of the input (required)
    * @return TcpInput
    * @throws BitmovinException if fails to make API call
    */
    public TcpInput get(String inputId) throws BitmovinException
    {
        return this.apiClient.get(inputId);
    }
    /**
    * List TCP inputs
    * 
    * @return List&lt;TcpInput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<TcpInput> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List TCP inputs
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;TcpInput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<TcpInput> list(TcpInputsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
