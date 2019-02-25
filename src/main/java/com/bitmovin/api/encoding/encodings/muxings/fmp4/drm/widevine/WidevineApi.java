package com.bitmovin.api.encoding.encodings.muxings.fmp4.drm.widevine;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.muxings.fmp4.drm.widevine.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WidevineApi
{
    private final WidevineClient apiClient;
    public CustomdataApi customdata;

    public WidevineApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public WidevineApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public WidevineApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(WidevineClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Add Widevine DRM to fMP4
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the fMP4 muxing. (required)
    * @param widevineDrm TODO Add Description (optional)
    * @return WidevineDrm
    * @throws BitmovinException if fails to make API call
    */
    public WidevineDrm create(String encodingId, String muxingId, WidevineDrm widevineDrm) throws BitmovinException
    {
        return this.apiClient.create(encodingId, muxingId, widevineDrm);
    }

    /**
    * Delete Widevine DRM from fMP4
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the fMP4 muxing (required)
    * @param drmId Id of the widevine drm. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String encodingId, String muxingId, String drmId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, muxingId, drmId);
    }

    /**
    * Widevine DRM Details of fMP4
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the fMP4 muxing. (required)
    * @param drmId Id of the widevine drm. (required)
    * @return WidevineDrm
    * @throws BitmovinException if fails to make API call
    */
    public WidevineDrm get(String encodingId, String muxingId, String drmId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, muxingId, drmId);
    }
    /**
    * List Widevine DRMs of fMP4
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the fmp4 fragment. (required)
    * @return List&lt;WidevineDrm&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<WidevineDrm> list(String encodingId, String muxingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, muxingId, new HashMap<String, Object>());
    }

    /**
    * List Widevine DRMs of fMP4
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the fmp4 fragment. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;WidevineDrm&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<WidevineDrm> list(String encodingId, String muxingId, WidevineDrmsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, muxingId, queryParams);
    }
}
