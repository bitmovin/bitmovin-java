package com.bitmovin.api.encoding.filters.audioVolume;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.filters.audioVolume.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AudioVolumeApi
{
    private final AudioVolumeClient apiClient;
    public CustomdataApi customdata;

    public AudioVolumeApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public AudioVolumeApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public AudioVolumeApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(AudioVolumeClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create Audio Volume Filter
    * 
    * @param audioVolumeFilter  (optional)
    * @return AudioVolumeFilter
    * @throws BitmovinException if fails to make API call
    */
    public AudioVolumeFilter create(AudioVolumeFilter audioVolumeFilter) throws BitmovinException
    {
        return this.apiClient.create(audioVolumeFilter);
    }

    /**
    * Delete Audio Volume Filter
    * 
    * @param filterId Id of the Audio volume configuration. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String filterId) throws BitmovinException
    {
        return this.apiClient.delete(filterId);
    }

    /**
    * Audio Volume Filter Details
    * 
    * @param filterId Id of the audio volume configuration. (required)
    * @return AudioVolumeFilter
    * @throws BitmovinException if fails to make API call
    */
    public AudioVolumeFilter get(String filterId) throws BitmovinException
    {
        return this.apiClient.get(filterId);
    }
    /**
    * List Audio Volume Filters
    * 
    * @return List&lt;AudioVolumeFilter&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<AudioVolumeFilter> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List Audio Volume Filters
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;AudioVolumeFilter&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<AudioVolumeFilter> list(AudioVolumeFiltersListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
