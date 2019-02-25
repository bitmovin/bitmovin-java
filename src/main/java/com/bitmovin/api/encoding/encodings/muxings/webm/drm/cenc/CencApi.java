package com.bitmovin.api.encoding.encodings.muxings.webm.drm.cenc;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.muxings.webm.drm.cenc.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CencApi
{
    private final CencClient apiClient;
    public CustomdataApi customdata;

    public CencApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public CencApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public CencApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(CencClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Add CENC DRM to WebM
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the WebM muxing. (required)
    * @param cencDrm The CencDrm to be created (optional)
    * @return CencDrm
    * @throws BitmovinException if fails to make API call
    */
    public CencDrm create(String encodingId, String muxingId, CencDrm cencDrm) throws BitmovinException
    {
        return this.apiClient.create(encodingId, muxingId, cencDrm);
    }

    /**
    * Delete CENC DRM from WebM
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the WebM muxing (required)
    * @param drmId Id of the cenc drm. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String encodingId, String muxingId, String drmId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, muxingId, drmId);
    }

    /**
    * CENC DRM Details of WebM
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the WebM muxing. (required)
    * @param drmId Id of the cenc drm. (required)
    * @return CencDrm
    * @throws BitmovinException if fails to make API call
    */
    public CencDrm get(String encodingId, String muxingId, String drmId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, muxingId, drmId);
    }
    /**
    * List CENC DRMs of WebM
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the WebM muxing. (required)
    * @return List&lt;CencDrm&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<CencDrm> list(String encodingId, String muxingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, muxingId, new HashMap<String, Object>());
    }

    /**
    * List CENC DRMs of WebM
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the WebM muxing. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;CencDrm&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<CencDrm> list(String encodingId, String muxingId, CencDrmsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, muxingId, queryParams);
    }
}
