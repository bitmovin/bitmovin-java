package com.bitmovin.api.encoding.configurations.audio.mp2;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.configurations.audio.mp2.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mp2Api
{
    private final Mp2Client apiClient;
    public CustomdataApi customdata;

    public Mp2Api(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public Mp2Api(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public Mp2Api(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(Mp2Client.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create MP2 Codec Configuration
    * 
    * @param mp2AudioConfiguration  (optional)
    * @return Mp2AudioConfiguration
    * @throws BitmovinException if fails to make API call
    */
    public Mp2AudioConfiguration create(Mp2AudioConfiguration mp2AudioConfiguration) throws BitmovinException
    {
        return this.apiClient.create(mp2AudioConfiguration);
    }

    /**
    * Delete MP2 Codec Configuration
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
    * MP2 Codec Configuration Details
    * 
    * @param configurationId Id of the codec configuration (required)
    * @return Mp2AudioConfiguration
    * @throws BitmovinException if fails to make API call
    */
    public Mp2AudioConfiguration get(String configurationId) throws BitmovinException
    {
        return this.apiClient.get(configurationId);
    }
}
