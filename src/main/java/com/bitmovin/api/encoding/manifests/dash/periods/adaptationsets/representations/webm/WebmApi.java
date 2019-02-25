package com.bitmovin.api.encoding.manifests.dash.periods.adaptationsets.representations.webm;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.manifests.dash.periods.adaptationsets.representations.webm.contentprotection.ContentprotectionApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebmApi
{
    private final WebmClient apiClient;
    public ContentprotectionApi contentprotection;

    public WebmApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public WebmApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public WebmApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(WebmClient.class);

        contentprotection = new ContentprotectionApi(clientFactory);
    }


    /**
    * Add WebM Representation
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @param dashWebmRepresentation The WebM representation to be added to the adaptation set (optional)
    * @return DashWebmRepresentation
    * @throws BitmovinException if fails to make API call
    */
    public DashWebmRepresentation create(String manifestId, String periodId, String adaptationsetId, DashWebmRepresentation dashWebmRepresentation) throws BitmovinException
    {
        return this.apiClient.create(manifestId, periodId, adaptationsetId, dashWebmRepresentation);
    }

    /**
    * Delete WebM Representation
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @param representationId Id of the WebM representation to be deleted (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String manifestId, String periodId, String adaptationsetId, String representationId) throws BitmovinException
    {
        return this.apiClient.delete(manifestId, periodId, adaptationsetId, representationId);
    }

    /**
    * WebM Representation Details
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @param representationId Id of the representation (required)
    * @return DashWebmRepresentation
    * @throws BitmovinException if fails to make API call
    */
    public DashWebmRepresentation get(String manifestId, String periodId, String adaptationsetId, String representationId) throws BitmovinException
    {
        return this.apiClient.get(manifestId, periodId, adaptationsetId, representationId);
    }
    /**
    * List all WebM Representations
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @return List&lt;DashWebmRepresentation&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<DashWebmRepresentation> list(String manifestId, String periodId, String adaptationsetId) throws BitmovinException
    {
        return this.apiClient.list(manifestId, periodId, adaptationsetId, new HashMap<String, Object>());
    }

    /**
    * List all WebM Representations
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;DashWebmRepresentation&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<DashWebmRepresentation> list(String manifestId, String periodId, String adaptationsetId, DashWebmRepresentationsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(manifestId, periodId, adaptationsetId, queryParams);
    }
}
