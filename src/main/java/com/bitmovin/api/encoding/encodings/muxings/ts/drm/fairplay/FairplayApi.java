package com.bitmovin.api.encoding.encodings.muxings.ts.drm.fairplay;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.muxings.ts.drm.fairplay.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FairplayApi
{
    private final FairplayClient apiClient;
    public CustomdataApi customdata;

    public FairplayApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public FairplayApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public FairplayApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(FairplayClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Add FairPlay DRM to TS Segment
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the TS muxing. (required)
    * @param fairPlayDrm  (optional)
    * @return FairPlayDrm
    * @throws BitmovinException if fails to make API call
    */
    public FairPlayDrm create(String encodingId, String muxingId, FairPlayDrm fairPlayDrm) throws BitmovinException
    {
        return this.apiClient.create(encodingId, muxingId, fairPlayDrm);
    }

    /**
    * Delete FairPlay DRM from TS Segment
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the transport streams segment. (required)
    * @param drmId Id of the FairPlay DRM configuration. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String encodingId, String muxingId, String drmId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, muxingId, drmId);
    }

    /**
    * FairPlay DRM Details of TS Segment
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the transport streams segment. (required)
    * @param drmId Id of the FairPlay DRM configuration. (required)
    * @return FairPlayDrm
    * @throws BitmovinException if fails to make API call
    */
    public FairPlayDrm get(String encodingId, String muxingId, String drmId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, muxingId, drmId);
    }
    /**
    * List FairPlay DRMs of TS Segment
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the transport streams segment. (required)
    * @return List&lt;FairPlayDrm&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<FairPlayDrm> list(String encodingId, String muxingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, muxingId, new HashMap<String, Object>());
    }

    /**
    * List FairPlay DRMs of TS Segment
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the transport streams segment. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;FairPlayDrm&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<FairPlayDrm> list(String encodingId, String muxingId, FairPlayDrmsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, muxingId, queryParams);
    }
}
