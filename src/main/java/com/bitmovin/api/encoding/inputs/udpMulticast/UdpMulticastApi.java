package com.bitmovin.api.encoding.inputs.udpMulticast;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.inputs.udpMulticast.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UdpMulticastApi
{
    private final UdpMulticastClient apiClient;
    public CustomdataApi customdata;

    public UdpMulticastApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public UdpMulticastApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public UdpMulticastApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(UdpMulticastClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create UDP multicast input
    * 
    * @param udpMulticastInput The UdpMulticastInput to be created (optional)
    * @return UdpMulticastInput
    * @throws BitmovinException if fails to make API call
    */
    public UdpMulticastInput create(UdpMulticastInput udpMulticastInput) throws BitmovinException
    {
        return this.apiClient.create(udpMulticastInput);
    }

    /**
    * Delete UDP multicast input
    * 
    * @param inputId Id of the input (required)
    * @return UdpMulticastInput
    * @throws BitmovinException if fails to make API call
    */
    public UdpMulticastInput delete(String inputId) throws BitmovinException
    {
        return this.apiClient.delete(inputId);
    }

    /**
    * UDP multicast Input Details
    * 
    * @param inputId Id of the input (required)
    * @return UdpMulticastInput
    * @throws BitmovinException if fails to make API call
    */
    public UdpMulticastInput get(String inputId) throws BitmovinException
    {
        return this.apiClient.get(inputId);
    }
    /**
    * List UDP multicast inputs
    * 
    * @return List&lt;UdpMulticastInput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<UdpMulticastInput> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List UDP multicast inputs
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;UdpMulticastInput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<UdpMulticastInput> list(UdpMulticastInputsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
