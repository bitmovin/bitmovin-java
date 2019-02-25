package com.bitmovin.api.encoding.inputs.https;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.inputs.https.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpsApi
{
    private final HttpsClient apiClient;
    public CustomdataApi customdata;

    public HttpsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public HttpsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public HttpsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(HttpsClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create HTTPS Input
    * 
    * @param httpsInput The Https input to be created (optional)
    * @return HttpsInput
    * @throws BitmovinException if fails to make API call
    */
    public HttpsInput create(HttpsInput httpsInput) throws BitmovinException
    {
        return this.apiClient.create(httpsInput);
    }

    /**
    * Delete HTTPS Input
    * 
    * @param inputId Id of the input (required)
    * @return HttpsInput
    * @throws BitmovinException if fails to make API call
    */
    public HttpsInput delete(String inputId) throws BitmovinException
    {
        return this.apiClient.delete(inputId);
    }

    /**
    * HTTPS Input Details
    * 
    * @param inputId Id of the input (required)
    * @return HttpsInput
    * @throws BitmovinException if fails to make API call
    */
    public HttpsInput get(String inputId) throws BitmovinException
    {
        return this.apiClient.get(inputId);
    }
    /**
    * List HTTPS Inputs
    * 
    * @return List&lt;HttpsInput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<HttpsInput> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List HTTPS Inputs
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;HttpsInput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<HttpsInput> list(HttpsInputsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
