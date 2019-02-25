package com.bitmovin.api.encoding.manifests.dash.periods.adaptationsets.representations.fmp4;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.manifests.dash.periods.adaptationsets.representations.fmp4.drm.DrmApi;
import com.bitmovin.api.encoding.manifests.dash.periods.adaptationsets.representations.fmp4.contentprotection.ContentprotectionApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fmp4Api
{
    private final Fmp4Client apiClient;
    public DrmApi drm;
    public ContentprotectionApi contentprotection;

    public Fmp4Api(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public Fmp4Api(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public Fmp4Api(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(Fmp4Client.class);

        drm = new DrmApi(clientFactory);
        contentprotection = new ContentprotectionApi(clientFactory);
    }


    /**
    * Add fMP4 Representation
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @param dashFmp4Representation The fMP4 representation to be added to the adaptation set (optional)
    * @return DashFmp4Representation
    * @throws BitmovinException if fails to make API call
    */
    public DashFmp4Representation create(String manifestId, String periodId, String adaptationsetId, DashFmp4Representation dashFmp4Representation) throws BitmovinException
    {
        return this.apiClient.create(manifestId, periodId, adaptationsetId, dashFmp4Representation);
    }

    /**
    * Delete fMP4 Representation
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @param representationId Id of the fMP4 representation to be deleted (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String manifestId, String periodId, String adaptationsetId, String representationId) throws BitmovinException
    {
        return this.apiClient.delete(manifestId, periodId, adaptationsetId, representationId);
    }

    /**
    * fMP4 Representation Details
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @param representationId Id of the representation (required)
    * @return DashFmp4Representation
    * @throws BitmovinException if fails to make API call
    */
    public DashFmp4Representation get(String manifestId, String periodId, String adaptationsetId, String representationId) throws BitmovinException
    {
        return this.apiClient.get(manifestId, periodId, adaptationsetId, representationId);
    }
    /**
    * List all fMP4 Representations
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @return List&lt;DashFmp4Representation&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<DashFmp4Representation> list(String manifestId, String periodId, String adaptationsetId) throws BitmovinException
    {
        return this.apiClient.list(manifestId, periodId, adaptationsetId, new HashMap<String, Object>());
    }

    /**
    * List all fMP4 Representations
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;DashFmp4Representation&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<DashFmp4Representation> list(String manifestId, String periodId, String adaptationsetId, DashFmp4RepresentationsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(manifestId, periodId, adaptationsetId, queryParams);
    }
}
