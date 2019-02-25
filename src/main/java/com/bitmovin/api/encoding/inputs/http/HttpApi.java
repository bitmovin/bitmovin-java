package com.bitmovin.api.encoding.inputs.http;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.inputs.http.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpApi
{
    private final HttpClient apiClient;
    public CustomdataApi customdata;

    public HttpApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public HttpApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public HttpApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(HttpClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create HTTP Input
    * 
    * @param httpInput The HTTP input to be created (optional)
    * @return HttpInput
    * @throws BitmovinException if fails to make API call
    */
    public HttpInput create(HttpInput httpInput) throws BitmovinException
    {
        return this.apiClient.create(httpInput);
    }

    /**
    * Delete HTTP Input
    * 
    * @param inputId Id of the input (required)
    * @return HttpInput
    * @throws BitmovinException if fails to make API call
    */
    public HttpInput delete(String inputId) throws BitmovinException
    {
        return this.apiClient.delete(inputId);
    }

    /**
    * HTTP Input Details
    * 
    * @param inputId Id of the input (required)
    * @return HttpInput
    * @throws BitmovinException if fails to make API call
    */
    public HttpInput get(String inputId) throws BitmovinException
    {
        return this.apiClient.get(inputId);
    }
    /**
    * List HTTP Inputs
    * 
    * @return List&lt;HttpInput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<HttpInput> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List HTTP Inputs
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;HttpInput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<HttpInput> list(HttpInputsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
