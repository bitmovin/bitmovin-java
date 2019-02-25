package com.bitmovin.api.encoding.manifests.dash.periods.adaptationsets.custom;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomApi
{
    private final CustomClient apiClient;

    public CustomApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public CustomApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public CustomApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(CustomClient.class);

    }


    /**
    * Add Custom AdaptationSet
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationSet The custom adaptation set to be added to the period (optional)
    * @return AdaptationSet
    * @throws BitmovinException if fails to make API call
    */
    public AdaptationSet create(String manifestId, String periodId, AdaptationSet adaptationSet) throws BitmovinException
    {
        return this.apiClient.create(manifestId, periodId, adaptationSet);
    }

    /**
    * Delete Custom AdaptationSet
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the custom adaptation set to be deleted (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String manifestId, String periodId, String adaptationsetId) throws BitmovinException
    {
        return this.apiClient.delete(manifestId, periodId, adaptationsetId);
    }

    /**
    * Custom AdaptationSet Details
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the custom adaptation set (required)
    * @return AdaptationSet
    * @throws BitmovinException if fails to make API call
    */
    public AdaptationSet get(String manifestId, String periodId, String adaptationsetId) throws BitmovinException
    {
        return this.apiClient.get(manifestId, periodId, adaptationsetId);
    }
    /**
    * List all Custom AdaptationSets
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @return List&lt;AdaptationSet&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<AdaptationSet> list(String manifestId, String periodId) throws BitmovinException
    {
        return this.apiClient.list(manifestId, periodId, new HashMap<String, Object>());
    }

    /**
    * List all Custom AdaptationSets
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;AdaptationSet&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<AdaptationSet> list(String manifestId, String periodId, AdaptationSetsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(manifestId, periodId, queryParams);
    }
}
