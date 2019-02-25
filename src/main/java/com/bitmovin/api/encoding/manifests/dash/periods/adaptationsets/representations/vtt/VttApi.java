package com.bitmovin.api.encoding.manifests.dash.periods.adaptationsets.representations.vtt;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VttApi
{
    private final VttClient apiClient;

    public VttApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public VttApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public VttApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(VttClient.class);

    }


    /**
    * Add VTT Representation
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @param dashVttRepresentation The VTT representation to be added to the adaptation set (optional)
    * @return DashVttRepresentation
    * @throws BitmovinException if fails to make API call
    */
    public DashVttRepresentation create(String manifestId, String periodId, String adaptationsetId, DashVttRepresentation dashVttRepresentation) throws BitmovinException
    {
        return this.apiClient.create(manifestId, periodId, adaptationsetId, dashVttRepresentation);
    }

    /**
    * Delete VTT Representation
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @param representationId Id of the VTT representation to be deleted (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String manifestId, String periodId, String adaptationsetId, String representationId) throws BitmovinException
    {
        return this.apiClient.delete(manifestId, periodId, adaptationsetId, representationId);
    }

    /**
    * VTT Representation Details
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @param representationId Id of the VTT representation (required)
    * @return DashVttRepresentation
    * @throws BitmovinException if fails to make API call
    */
    public DashVttRepresentation get(String manifestId, String periodId, String adaptationsetId, String representationId) throws BitmovinException
    {
        return this.apiClient.get(manifestId, periodId, adaptationsetId, representationId);
    }
    /**
    * List all VTT Representations
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @return List&lt;DashVttRepresentation&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<DashVttRepresentation> list(String manifestId, String periodId, String adaptationsetId) throws BitmovinException
    {
        return this.apiClient.list(manifestId, periodId, adaptationsetId, new HashMap<String, Object>());
    }

    /**
    * List all VTT Representations
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;DashVttRepresentation&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<DashVttRepresentation> list(String manifestId, String periodId, String adaptationsetId, DashVttRepresentationsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(manifestId, periodId, adaptationsetId, queryParams);
    }
}
