package com.bitmovin.api.encoding.manifests.dash.periods.adaptationsets.representations.mp4.drm;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DrmApi
{
    private final DrmClient apiClient;

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

    }


    /**
    * Add DRM MP4 Representation
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @param dashMp4DrmRepresentation The DRM MP4 representation to be added to the adaptation set (optional)
    * @return DashMp4DrmRepresentation
    * @throws BitmovinException if fails to make API call
    */
    public DashMp4DrmRepresentation create(String manifestId, String periodId, String adaptationsetId, DashMp4DrmRepresentation dashMp4DrmRepresentation) throws BitmovinException
    {
        return this.apiClient.create(manifestId, periodId, adaptationsetId, dashMp4DrmRepresentation);
    }

    /**
    * Delete DRM MP4 Representation
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @param representationId Id of the DRM MP4 representation to be deleted (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String manifestId, String periodId, String adaptationsetId, String representationId) throws BitmovinException
    {
        return this.apiClient.delete(manifestId, periodId, adaptationsetId, representationId);
    }

    /**
    * DRM MP4 Representation Details
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @param representationId Id of the representation (required)
    * @return DashMp4DrmRepresentation
    * @throws BitmovinException if fails to make API call
    */
    public DashMp4DrmRepresentation get(String manifestId, String periodId, String adaptationsetId, String representationId) throws BitmovinException
    {
        return this.apiClient.get(manifestId, periodId, adaptationsetId, representationId);
    }
    /**
    * List all DRM MP4 Representations
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @return List&lt;DashMp4DrmRepresentation&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<DashMp4DrmRepresentation> list(String manifestId, String periodId, String adaptationsetId) throws BitmovinException
    {
        return this.apiClient.list(manifestId, periodId, adaptationsetId, new HashMap<String, Object>());
    }

    /**
    * List all DRM MP4 Representations
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;DashMp4DrmRepresentation&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<DashMp4DrmRepresentation> list(String manifestId, String periodId, String adaptationsetId, DashMp4DrmRepresentationsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(manifestId, periodId, adaptationsetId, queryParams);
    }
}
