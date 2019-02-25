package com.bitmovin.api.encoding.manifests.dash.periods.adaptationsets.representations.fmp4.drm;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.manifests.dash.periods.adaptationsets.representations.fmp4.drm.contentprotection.ContentprotectionApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DrmApi
{
    private final DrmClient apiClient;
    public ContentprotectionApi contentprotection;

    public DrmApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public DrmApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public DrmApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(DrmClient.class);

        contentprotection = new ContentprotectionApi(clientFactory);
    }


    /**
    * Add DRM fMP4 Representation
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @param dashFmp4DrmRepresentation The DRM fMP4 representation to be added to the adaptation set (optional)
    * @return DashFmp4DrmRepresentation
    * @throws BitmovinException if fails to make API call
    */
    public DashFmp4DrmRepresentation create(String manifestId, String periodId, String adaptationsetId, DashFmp4DrmRepresentation dashFmp4DrmRepresentation) throws BitmovinException
    {
        return this.apiClient.create(manifestId, periodId, adaptationsetId, dashFmp4DrmRepresentation);
    }

    /**
    * Delete DRM fMP4 Representation
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @param representationId Id of the DRM fMP4 representation to be deleted (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String manifestId, String periodId, String adaptationsetId, String representationId) throws BitmovinException
    {
        return this.apiClient.delete(manifestId, periodId, adaptationsetId, representationId);
    }

    /**
    * DRM fMP4 Representation Details
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @param representationId Id of the representation (required)
    * @return DashFmp4DrmRepresentation
    * @throws BitmovinException if fails to make API call
    */
    public DashFmp4DrmRepresentation get(String manifestId, String periodId, String adaptationsetId, String representationId) throws BitmovinException
    {
        return this.apiClient.get(manifestId, periodId, adaptationsetId, representationId);
    }
    /**
    * List all DRM fMP4 Representations
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @return List&lt;DashFmp4DrmRepresentation&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<DashFmp4DrmRepresentation> list(String manifestId, String periodId, String adaptationsetId) throws BitmovinException
    {
        return this.apiClient.list(manifestId, periodId, adaptationsetId, new HashMap<String, Object>());
    }

    /**
    * List all DRM fMP4 Representations
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;DashFmp4DrmRepresentation&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<DashFmp4DrmRepresentation> list(String manifestId, String periodId, String adaptationsetId, DashFmp4DrmRepresentationsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(manifestId, periodId, adaptationsetId, queryParams);
    }
}
