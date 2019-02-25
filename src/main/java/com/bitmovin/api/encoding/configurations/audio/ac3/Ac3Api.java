package com.bitmovin.api.encoding.configurations.audio.ac3;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.configurations.audio.ac3.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ac3Api
{
    private final Ac3Client apiClient;
    public CustomdataApi customdata;

    public Ac3Api(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public Ac3Api(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public Ac3Api(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(Ac3Client.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create AC3 Codec Configuration
    * 
    * @param ac3AudioConfiguration  (optional)
    * @return Ac3AudioConfiguration
    * @throws BitmovinException if fails to make API call
    */
    public Ac3AudioConfiguration create(Ac3AudioConfiguration ac3AudioConfiguration) throws BitmovinException
    {
        return this.apiClient.create(ac3AudioConfiguration);
    }

    /**
    * Delete AC3 Codec Configuration
    * 
    * @param configurationId Id of the codec configuration (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String configurationId) throws BitmovinException
    {
        return this.apiClient.delete(configurationId);
    }

    /**
    * AC3 Codec Configuration Details
    * 
    * @param configurationId Id of the codec configuration (required)
    * @return Ac3AudioConfiguration
    * @throws BitmovinException if fails to make API call
    */
    public Ac3AudioConfiguration get(String configurationId) throws BitmovinException
    {
        return this.apiClient.get(configurationId);
    }
    /**
    * List AC3 Configurations
    * 
    * @return List&lt;Ac3AudioConfiguration&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Ac3AudioConfiguration> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List AC3 Configurations
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;Ac3AudioConfiguration&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Ac3AudioConfiguration> list(Ac3AudioConfigurationsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
