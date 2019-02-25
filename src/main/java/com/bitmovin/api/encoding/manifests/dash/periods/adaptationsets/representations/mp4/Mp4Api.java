package com.bitmovin.api.encoding.manifests.dash.periods.adaptationsets.representations.mp4;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.manifests.dash.periods.adaptationsets.representations.mp4.drm.DrmApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mp4Api
{
    private final Mp4Client apiClient;
    public DrmApi drm;

    public Mp4Api(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public Mp4Api(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public Mp4Api(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(Mp4Client.class);

        drm = new DrmApi(clientFactory);
    }


    /**
    * Add MP4 Representation
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @param dashMp4Representation The MP4 representation to be added to the adaptation set (optional)
    * @return DashMp4Representation
    * @throws BitmovinException if fails to make API call
    */
    public DashMp4Representation create(String manifestId, String periodId, String adaptationsetId, DashMp4Representation dashMp4Representation) throws BitmovinException
    {
        return this.apiClient.create(manifestId, periodId, adaptationsetId, dashMp4Representation);
    }

    /**
    * Delete MP4 Representation
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @param representationId Id of the MP4 representation to be deleted (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String manifestId, String periodId, String adaptationsetId, String representationId) throws BitmovinException
    {
        return this.apiClient.delete(manifestId, periodId, adaptationsetId, representationId);
    }

    /**
    * MP4 Representation Details
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @param representationId Id of the representation (required)
    * @return DashMp4Representation
    * @throws BitmovinException if fails to make API call
    */
    public DashMp4Representation get(String manifestId, String periodId, String adaptationsetId, String representationId) throws BitmovinException
    {
        return this.apiClient.get(manifestId, periodId, adaptationsetId, representationId);
    }
    /**
    * List all MP4 Representations
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @return List&lt;DashMp4Representation&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<DashMp4Representation> list(String manifestId, String periodId, String adaptationsetId) throws BitmovinException
    {
        return this.apiClient.list(manifestId, periodId, adaptationsetId, new HashMap<String, Object>());
    }

    /**
    * List all MP4 Representations
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the adaptation set (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;DashMp4Representation&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<DashMp4Representation> list(String manifestId, String periodId, String adaptationsetId, DashMp4RepresentationsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(manifestId, periodId, adaptationsetId, queryParams);
    }
}
