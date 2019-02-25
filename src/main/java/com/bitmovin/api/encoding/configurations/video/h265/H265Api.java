package com.bitmovin.api.encoding.configurations.video.h265;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.configurations.video.h265.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class H265Api
{
    private final H265Client apiClient;
    public CustomdataApi customdata;

    public H265Api(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public H265Api(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public H265Api(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(H265Client.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create H265/HEVC Codec Configuration
    * 
    * @param h265VideoConfiguration  (optional)
    * @return H265VideoConfiguration
    * @throws BitmovinException if fails to make API call
    */
    public H265VideoConfiguration create(H265VideoConfiguration h265VideoConfiguration) throws BitmovinException
    {
        return this.apiClient.create(h265VideoConfiguration);
    }

    /**
    * Delete H265/HEVC Codec Configuration
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
    * H265/HEVC Codec Configuration Details
    * 
    * @param configurationId Id of the codec configuration (required)
    * @return H265VideoConfiguration
    * @throws BitmovinException if fails to make API call
    */
    public H265VideoConfiguration get(String configurationId) throws BitmovinException
    {
        return this.apiClient.get(configurationId);
    }
    /**
    * List H265/HEVC Codec Configurations
    * 
    * @return List&lt;H265VideoConfiguration&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<H265VideoConfiguration> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List H265/HEVC Codec Configurations
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;H265VideoConfiguration&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<H265VideoConfiguration> list(H265VideoConfigurationsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
