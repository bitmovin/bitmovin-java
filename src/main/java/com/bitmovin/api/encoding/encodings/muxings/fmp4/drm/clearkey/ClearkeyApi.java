package com.bitmovin.api.encoding.encodings.muxings.fmp4.drm.clearkey;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.muxings.fmp4.drm.clearkey.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClearkeyApi
{
    private final ClearkeyClient apiClient;
    public CustomdataApi customdata;

    public ClearkeyApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public ClearkeyApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public ClearkeyApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(ClearkeyClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Add ClearKey DRM to fMP4
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the fMP4 muxing. (required)
    * @param clearKeyDrm  (optional)
    * @return ClearKeyDrm
    * @throws BitmovinException if fails to make API call
    */
    public ClearKeyDrm create(String encodingId, String muxingId, ClearKeyDrm clearKeyDrm) throws BitmovinException
    {
        return this.apiClient.create(encodingId, muxingId, clearKeyDrm);
    }

    /**
    * Delete ClearKey DRM from fMP4
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the fragmented mp4. (required)
    * @param drmId Id of the ClearKey DRM configuration. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String encodingId, String muxingId, String drmId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, muxingId, drmId);
    }

    /**
    * ClearKey DRM Details of fMP4
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the fragmented mp4. (required)
    * @param drmId Id of the ClearKey DRM configuration. (required)
    * @return ClearKeyDrm
    * @throws BitmovinException if fails to make API call
    */
    public ClearKeyDrm get(String encodingId, String muxingId, String drmId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, muxingId, drmId);
    }
    /**
    * List ClearKey DRMs of fMP4
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the fragmented mp4. (required)
    * @return List&lt;ClearKeyDrm&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<ClearKeyDrm> list(String encodingId, String muxingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, muxingId, new HashMap<String, Object>());
    }

    /**
    * List ClearKey DRMs of fMP4
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the fragmented mp4. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;ClearKeyDrm&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<ClearKeyDrm> list(String encodingId, String muxingId, ClearKeyDrmsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, muxingId, queryParams);
    }
}
