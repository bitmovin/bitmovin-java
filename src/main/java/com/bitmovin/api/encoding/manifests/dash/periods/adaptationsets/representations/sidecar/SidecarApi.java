package com.bitmovin.api.encoding.manifests.dash.periods.adaptationsets.representations.sidecar;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SidecarApi
{
    private final SidecarClient apiClient;

    public SidecarApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public SidecarApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public SidecarApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(SidecarClient.class);

    }


    /**
    * Add Sidecar Representation
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @param dashSidecarRepresentation The sidecar representation to be added to the adaptation set (optional)
    * @return DashSidecarRepresentation
    * @throws BitmovinException if fails to make API call
    */
    public DashSidecarRepresentation create(String manifestId, String periodId, String adaptationsetId, DashSidecarRepresentation dashSidecarRepresentation) throws BitmovinException
    {
        return this.apiClient.create(manifestId, periodId, adaptationsetId, dashSidecarRepresentation);
    }

    /**
    * Delete Sidecar Representation
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @param representationId Id of the Sidecar representation to be deleted (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String manifestId, String periodId, String adaptationsetId, String representationId) throws BitmovinException
    {
        return this.apiClient.delete(manifestId, periodId, adaptationsetId, representationId);
    }

    /**
    * Sidecar Representation Details
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @param representationId Id of the representation (required)
    * @return DashSidecarRepresentation
    * @throws BitmovinException if fails to make API call
    */
    public DashSidecarRepresentation get(String manifestId, String periodId, String adaptationsetId, String representationId) throws BitmovinException
    {
        return this.apiClient.get(manifestId, periodId, adaptationsetId, representationId);
    }
    /**
    * List all Sidecar Representations
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @return List&lt;DashSidecarRepresentation&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<DashSidecarRepresentation> list(String manifestId, String periodId, String adaptationsetId) throws BitmovinException
    {
        return this.apiClient.list(manifestId, periodId, adaptationsetId, new HashMap<String, Object>());
    }

    /**
    * List all Sidecar Representations
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;DashSidecarRepresentation&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<DashSidecarRepresentation> list(String manifestId, String periodId, String adaptationsetId, DashSidecarRepresentationsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(manifestId, periodId, adaptationsetId, queryParams);
    }
}
