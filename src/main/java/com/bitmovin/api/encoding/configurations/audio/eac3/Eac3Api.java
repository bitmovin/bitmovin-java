package com.bitmovin.api.encoding.configurations.audio.eac3;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.configurations.audio.eac3.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Eac3Api
{
    private final Eac3Client apiClient;
    public CustomdataApi customdata;

    public Eac3Api(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public Eac3Api(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public Eac3Api(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(Eac3Client.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create E-AC3 Codec Configuration
    * 
    * @param eac3AudioConfiguration  (optional)
    * @return Eac3AudioConfiguration
    * @throws BitmovinException if fails to make API call
    */
    public Eac3AudioConfiguration create(Eac3AudioConfiguration eac3AudioConfiguration) throws BitmovinException
    {
        return this.apiClient.create(eac3AudioConfiguration);
    }

    /**
    * Delete E-AC3 Codec Configuration
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
    * E-AC3 Codec Configuration Details
    * 
    * @param configurationId Id of the codec configuration (required)
    * @return Eac3AudioConfiguration
    * @throws BitmovinException if fails to make API call
    */
    public Eac3AudioConfiguration get(String configurationId) throws BitmovinException
    {
        return this.apiClient.get(configurationId);
    }
    /**
    * List E-AC3 Configurations
    * 
    * @return List&lt;Eac3AudioConfiguration&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Eac3AudioConfiguration> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List E-AC3 Configurations
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;Eac3AudioConfiguration&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Eac3AudioConfiguration> list(Eac3AudioConfigurationsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
