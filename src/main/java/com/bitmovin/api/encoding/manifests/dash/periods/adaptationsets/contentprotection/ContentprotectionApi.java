package com.bitmovin.api.encoding.manifests.dash.periods.adaptationsets.contentprotection;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContentprotectionApi
{
    private final ContentprotectionClient apiClient;

    public ContentprotectionApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public ContentprotectionApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public ContentprotectionApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(ContentprotectionClient.class);

    }


    /**
    * Add Content Protection to AdaptationSet
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @param contentProtection The content protection to be added to the adaptation set (optional)
    * @return ContentProtection
    * @throws BitmovinException if fails to make API call
    */
    public ContentProtection create(String manifestId, String periodId, String adaptationsetId, ContentProtection contentProtection) throws BitmovinException
    {
        return this.apiClient.create(manifestId, periodId, adaptationsetId, contentProtection);
    }

    /**
    * Delete AdaptationSet Content Protection
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @param contentprotectionId Id of the adaptation set content protection to be deleted (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String manifestId, String periodId, String adaptationsetId, String contentprotectionId) throws BitmovinException
    {
        return this.apiClient.delete(manifestId, periodId, adaptationsetId, contentprotectionId);
    }

    /**
    * AdaptationSet Content Protection Details
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @param contentprotectionId Id of the adaptation set content protection (required)
    * @return ContentProtection
    * @throws BitmovinException if fails to make API call
    */
    public ContentProtection get(String manifestId, String periodId, String adaptationsetId, String contentprotectionId) throws BitmovinException
    {
        return this.apiClient.get(manifestId, periodId, adaptationsetId, contentprotectionId);
    }
    /**
    * List all AdaptationSet Content Protections
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @return List&lt;ContentProtection&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<ContentProtection> list(String manifestId, String periodId, String adaptationsetId) throws BitmovinException
    {
        return this.apiClient.list(manifestId, periodId, adaptationsetId, new HashMap<String, Object>());
    }

    /**
    * List all AdaptationSet Content Protections
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;ContentProtection&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<ContentProtection> list(String manifestId, String periodId, String adaptationsetId, ContentProtectionsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(manifestId, periodId, adaptationsetId, queryParams);
    }
}
