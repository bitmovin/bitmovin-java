package com.bitmovin.api.encoding.manifests.dash.periods.adaptationsets.representations.webm.contentprotection;

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
    * Add Content Protection to WebM Representation
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @param representationId Id of the representation (required)
    * @param contentProtection The content protection to be added to the WebM representation (optional)
    * @return ContentProtection
    * @throws BitmovinException if fails to make API call
    */
    public ContentProtection create(String manifestId, String periodId, String adaptationsetId, String representationId, ContentProtection contentProtection) throws BitmovinException
    {
        return this.apiClient.create(manifestId, periodId, adaptationsetId, representationId, contentProtection);
    }

    /**
    * Delete WebM Representation Content Protection
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @param representationId Id of the representation (required)
    * @param contentprotectionId Id of the DRM WebM content protection to be deleted (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String manifestId, String periodId, String adaptationsetId, String representationId, String contentprotectionId) throws BitmovinException
    {
        return this.apiClient.delete(manifestId, periodId, adaptationsetId, representationId, contentprotectionId);
    }

    /**
    * WebM Representation Content Protection Details
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @param representationId Id of the representation (required)
    * @param contentprotectionId Id of the DRM WebM content protection (required)
    * @return ContentProtection
    * @throws BitmovinException if fails to make API call
    */
    public ContentProtection get(String manifestId, String periodId, String adaptationsetId, String representationId, String contentprotectionId) throws BitmovinException
    {
        return this.apiClient.get(manifestId, periodId, adaptationsetId, representationId, contentprotectionId);
    }
    /**
    * List all WebM Representation Content Protections
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @param representationId Id of the representation (required)
    * @return List&lt;ContentProtection&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<ContentProtection> list(String manifestId, String periodId, String adaptationsetId, String representationId) throws BitmovinException
    {
        return this.apiClient.list(manifestId, periodId, adaptationsetId, representationId, new HashMap<String, Object>());
    }

    /**
    * List all WebM Representation Content Protections
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @param representationId Id of the representation (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;ContentProtection&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<ContentProtection> list(String manifestId, String periodId, String adaptationsetId, String representationId, ContentProtectionsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(manifestId, periodId, adaptationsetId, representationId, queryParams);
    }
}
