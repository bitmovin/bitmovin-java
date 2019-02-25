package com.bitmovin.api.encoding.configurations.video.h264;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.configurations.video.h264.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class H264Api
{
    private final H264Client apiClient;
    public CustomdataApi customdata;

    public H264Api(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public H264Api(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public H264Api(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(H264Client.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create H264/AVC Codec Configuration
    * 
    * @param h264VideoConfiguration  (optional)
    * @return H264VideoConfiguration
    * @throws BitmovinException if fails to make API call
    */
    public H264VideoConfiguration create(H264VideoConfiguration h264VideoConfiguration) throws BitmovinException
    {
        return this.apiClient.create(h264VideoConfiguration);
    }

    /**
    * Delete H264/AVC Codec Configuration
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
    * H264/AVC Codec Configuration Details
    * 
    * @param configurationId Id of the codec configuration (required)
    * @return H264VideoConfiguration
    * @throws BitmovinException if fails to make API call
    */
    public H264VideoConfiguration get(String configurationId) throws BitmovinException
    {
        return this.apiClient.get(configurationId);
    }
    /**
    * List H264/AVC Codec Configurations
    * 
    * @return List&lt;H264VideoConfiguration&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<H264VideoConfiguration> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List H264/AVC Codec Configurations
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;H264VideoConfiguration&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<H264VideoConfiguration> list(H264VideoConfigurationsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
