package com.bitmovin.api.encoding.manifests.dash.periods;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.manifests.dash.periods.customXmlElements.CustomXmlElementsApi;
import com.bitmovin.api.encoding.manifests.dash.periods.adaptationsets.AdaptationsetsApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PeriodsApi
{
    private final PeriodsClient apiClient;
    public CustomXmlElementsApi customXmlElements;
    public AdaptationsetsApi adaptationsets;

    public PeriodsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public PeriodsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public PeriodsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(PeriodsClient.class);

        customXmlElements = new CustomXmlElementsApi(clientFactory);
        adaptationsets = new AdaptationsetsApi(clientFactory);
    }


    /**
    * Add Period
    * 
    * @param manifestId Id of the manifest (required)
    * @param period The Period to be added to the manifest (optional)
    * @return Period
    * @throws BitmovinException if fails to make API call
    */
    public Period create(String manifestId, Period period) throws BitmovinException
    {
        return this.apiClient.create(manifestId, period);
    }

    /**
    * Delete Period
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period to be deleted (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String manifestId, String periodId) throws BitmovinException
    {
        return this.apiClient.delete(manifestId, periodId);
    }

    /**
    * Period Details
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @return Period
    * @throws BitmovinException if fails to make API call
    */
    public Period get(String manifestId, String periodId) throws BitmovinException
    {
        return this.apiClient.get(manifestId, periodId);
    }
    /**
    * List all Periods
    * 
    * @param manifestId Id of the manifest (required)
    * @return List&lt;Period&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Period> list(String manifestId) throws BitmovinException
    {
        return this.apiClient.list(manifestId, new HashMap<String, Object>());
    }

    /**
    * List all Periods
    * 
    * @param manifestId Id of the manifest (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;Period&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Period> list(String manifestId, PeriodsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(manifestId, queryParams);
    }
}
