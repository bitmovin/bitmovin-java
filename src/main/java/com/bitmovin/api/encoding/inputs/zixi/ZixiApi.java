package com.bitmovin.api.encoding.inputs.zixi;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.inputs.zixi.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZixiApi
{
    private final ZixiClient apiClient;
    public CustomdataApi customdata;

    public ZixiApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public ZixiApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public ZixiApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(ZixiClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create Zixi input
    * 
    * @param zixiInput The ZixiInput to be created (optional)
    * @return ZixiInput
    * @throws BitmovinException if fails to make API call
    */
    public ZixiInput create(ZixiInput zixiInput) throws BitmovinException
    {
        return this.apiClient.create(zixiInput);
    }

    /**
    * Delete Zixi input
    * 
    * @param inputId Id of the input (required)
    * @return ZixiInput
    * @throws BitmovinException if fails to make API call
    */
    public ZixiInput delete(String inputId) throws BitmovinException
    {
        return this.apiClient.delete(inputId);
    }

    /**
    * Zixi Input Details
    * 
    * @param inputId Id of the input (required)
    * @return ZixiInput
    * @throws BitmovinException if fails to make API call
    */
    public ZixiInput get(String inputId) throws BitmovinException
    {
        return this.apiClient.get(inputId);
    }
    /**
    * List Zixi inputs
    * 
    * @return List&lt;ZixiInput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<ZixiInput> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List Zixi inputs
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;ZixiInput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<ZixiInput> list(ZixiInputsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
