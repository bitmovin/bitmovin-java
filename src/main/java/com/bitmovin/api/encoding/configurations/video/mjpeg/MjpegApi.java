package com.bitmovin.api.encoding.configurations.video.mjpeg;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.configurations.video.mjpeg.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MjpegApi
{
    private final MjpegClient apiClient;
    public CustomdataApi customdata;

    public MjpegApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public MjpegApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public MjpegApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(MjpegClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create MJPEG Codec Configuration
    * 
    * @param mjpegVideoConfiguration  (optional)
    * @return MjpegVideoConfiguration
    * @throws BitmovinException if fails to make API call
    */
    public MjpegVideoConfiguration create(MjpegVideoConfiguration mjpegVideoConfiguration) throws BitmovinException
    {
        return this.apiClient.create(mjpegVideoConfiguration);
    }

    /**
    * Delete MJPEG Codec Configuration
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
    * MJPEG Codec Configuration Details
    * 
    * @param configurationId Id of the codec configuration (required)
    * @return MjpegVideoConfiguration
    * @throws BitmovinException if fails to make API call
    */
    public MjpegVideoConfiguration get(String configurationId) throws BitmovinException
    {
        return this.apiClient.get(configurationId);
    }
    /**
    * List MJPEG Configurations
    * 
    * @return List&lt;MjpegVideoConfiguration&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<MjpegVideoConfiguration> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List MJPEG Configurations
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;MjpegVideoConfiguration&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<MjpegVideoConfiguration> list(MjpegVideoConfigurationsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
