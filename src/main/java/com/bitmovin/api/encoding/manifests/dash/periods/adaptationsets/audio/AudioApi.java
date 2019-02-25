package com.bitmovin.api.encoding.manifests.dash.periods.adaptationsets.audio;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AudioApi
{
    private final AudioClient apiClient;

    public AudioApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public AudioApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public AudioApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(AudioClient.class);

    }


    /**
    * Add Audio AdaptationSet
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param audioAdaptationSet The audio adaptation set to be added to the period (optional)
    * @return AudioAdaptationSet
    * @throws BitmovinException if fails to make API call
    */
    public AudioAdaptationSet create(String manifestId, String periodId, AudioAdaptationSet audioAdaptationSet) throws BitmovinException
    {
        return this.apiClient.create(manifestId, periodId, audioAdaptationSet);
    }

    /**
    * Delete Audio AdaptationSet
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the audio adaptation set to be deleted (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String manifestId, String periodId, String adaptationsetId) throws BitmovinException
    {
        return this.apiClient.delete(manifestId, periodId, adaptationsetId);
    }

    /**
    * Audio AdaptationSet Details
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the audio adaptation set (required)
    * @return AudioAdaptationSet
    * @throws BitmovinException if fails to make API call
    */
    public AudioAdaptationSet get(String manifestId, String periodId, String adaptationsetId) throws BitmovinException
    {
        return this.apiClient.get(manifestId, periodId, adaptationsetId);
    }
    /**
    * List all Audio AdaptationSets
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @return List&lt;AudioAdaptationSet&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<AudioAdaptationSet> list(String manifestId, String periodId) throws BitmovinException
    {
        return this.apiClient.list(manifestId, periodId, new HashMap<String, Object>());
    }

    /**
    * List all Audio AdaptationSets
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;AudioAdaptationSet&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<AudioAdaptationSet> list(String manifestId, String periodId, AudioAdaptationSetsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(manifestId, periodId, queryParams);
    }
}
