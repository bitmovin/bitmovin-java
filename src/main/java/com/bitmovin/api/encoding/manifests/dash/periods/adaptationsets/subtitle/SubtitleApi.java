package com.bitmovin.api.encoding.manifests.dash.periods.adaptationsets.subtitle;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubtitleApi
{
    private final SubtitleClient apiClient;

    public SubtitleApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public SubtitleApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public SubtitleApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(SubtitleClient.class);

    }


    /**
    * Add Subtitle AdaptationSet
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param subtitleAdaptationSet The subtitle adaptation set to be added to the period (optional)
    * @return SubtitleAdaptationSet
    * @throws BitmovinException if fails to make API call
    */
    public SubtitleAdaptationSet create(String manifestId, String periodId, SubtitleAdaptationSet subtitleAdaptationSet) throws BitmovinException
    {
        return this.apiClient.create(manifestId, periodId, subtitleAdaptationSet);
    }

    /**
    * Delete Subtitle AdaptationSet
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the subtitle adaptation set to be deleted (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String manifestId, String periodId, String adaptationsetId) throws BitmovinException
    {
        return this.apiClient.delete(manifestId, periodId, adaptationsetId);
    }

    /**
    * Subtitle AdaptationSet Details
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the subtitle adaptation set (required)
    * @return SubtitleAdaptationSet
    * @throws BitmovinException if fails to make API call
    */
    public SubtitleAdaptationSet get(String manifestId, String periodId, String adaptationsetId) throws BitmovinException
    {
        return this.apiClient.get(manifestId, periodId, adaptationsetId);
    }
    /**
    * List all Subtitle AdaptationSets
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @return List&lt;SubtitleAdaptationSet&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<SubtitleAdaptationSet> list(String manifestId, String periodId) throws BitmovinException
    {
        return this.apiClient.list(manifestId, periodId, new HashMap<String, Object>());
    }

    /**
    * List all Subtitle AdaptationSets
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;SubtitleAdaptationSet&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<SubtitleAdaptationSet> list(String manifestId, String periodId, SubtitleAdaptationSetsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(manifestId, periodId, queryParams);
    }
}
