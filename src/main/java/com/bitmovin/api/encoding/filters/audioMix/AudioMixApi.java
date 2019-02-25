package com.bitmovin.api.encoding.filters.audioMix;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.filters.audioMix.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AudioMixApi
{
    private final AudioMixClient apiClient;
    public CustomdataApi customdata;

    public AudioMixApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public AudioMixApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public AudioMixApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(AudioMixClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create Audio Mix Filter
    * 
    * @param audioMixFilter  (optional)
    * @return AudioMixFilter
    * @throws BitmovinException if fails to make API call
    */
    public AudioMixFilter create(AudioMixFilter audioMixFilter) throws BitmovinException
    {
        return this.apiClient.create(audioMixFilter);
    }

    /**
    * Delete Audio Mix Filter
    * 
    * @param filterId Id of the Audio Mix configuration. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String filterId) throws BitmovinException
    {
        return this.apiClient.delete(filterId);
    }

    /**
    * Audio Mix Filter Details
    * 
    * @param filterId Id of the Audio Mix configuration. (required)
    * @return AudioMixFilter
    * @throws BitmovinException if fails to make API call
    */
    public AudioMixFilter get(String filterId) throws BitmovinException
    {
        return this.apiClient.get(filterId);
    }
    /**
    * List Audio Mix Filters
    * 
    * @return List&lt;AudioMixFilter&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<AudioMixFilter> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List Audio Mix Filters
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;AudioMixFilter&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<AudioMixFilter> list(AudioMixFiltersListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
