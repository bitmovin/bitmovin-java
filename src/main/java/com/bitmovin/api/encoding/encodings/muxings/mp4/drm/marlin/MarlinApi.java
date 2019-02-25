package com.bitmovin.api.encoding.encodings.muxings.mp4.drm.marlin;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.muxings.mp4.drm.marlin.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarlinApi
{
    private final MarlinClient apiClient;
    public CustomdataApi customdata;

    public MarlinApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public MarlinApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public MarlinApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(MarlinClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Add Marlin DRM to MP4
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the MP4 muxing. (required)
    * @param marlinDrm  (optional)
    * @return MarlinDrm
    * @throws BitmovinException if fails to make API call
    */
    public MarlinDrm create(String encodingId, String muxingId, MarlinDrm marlinDrm) throws BitmovinException
    {
        return this.apiClient.create(encodingId, muxingId, marlinDrm);
    }

    /**
    * Delete Marlin DRM from MP4
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the mp4. (required)
    * @param drmId Id of the Marlin DRM configuration. (required)
    * @return MarlinDrm
    * @throws BitmovinException if fails to make API call
    */
    public MarlinDrm delete(String encodingId, String muxingId, String drmId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, muxingId, drmId);
    }

    /**
    * Marlin DRM Details of MP4
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the mp4. (required)
    * @param drmId Id of the Marlin DRM configuration. (required)
    * @return MarlinDrm
    * @throws BitmovinException if fails to make API call
    */
    public MarlinDrm get(String encodingId, String muxingId, String drmId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, muxingId, drmId);
    }
    /**
    * List Marlin DRMs of MP4
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the mp4. (required)
    * @return List&lt;MarlinDrm&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<MarlinDrm> list(String encodingId, String muxingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, muxingId, new HashMap<String, Object>());
    }

    /**
    * List Marlin DRMs of MP4
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the mp4. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;MarlinDrm&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<MarlinDrm> list(String encodingId, String muxingId, MarlinDrmsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, muxingId, queryParams);
    }
}
