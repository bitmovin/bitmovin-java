package com.bitmovin.api.encoding.encodings.muxings.fmp4;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.muxings.fmp4.customdata.CustomdataApi;
import com.bitmovin.api.encoding.encodings.muxings.fmp4.drm.DrmApi;
import com.bitmovin.api.encoding.encodings.muxings.fmp4.captions.CaptionsApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fmp4Api
{
    private final Fmp4Client apiClient;
    public CustomdataApi customdata;
    public DrmApi drm;
    public CaptionsApi captions;

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

        customdata = new CustomdataApi(clientFactory);
        drm = new DrmApi(clientFactory);
        captions = new CaptionsApi(clientFactory);
    }


    /**
    * Add fMP4 Segment Muxing
    * 
    * @param encodingId Id of the encoding. (required)
    * @param fmp4Muxing  (optional)
    * @return Fmp4Muxing
    * @throws BitmovinException if fails to make API call
    */
    public Fmp4Muxing create(String encodingId, Fmp4Muxing fmp4Muxing) throws BitmovinException
    {
        return this.apiClient.create(encodingId, fmp4Muxing);
    }

    /**
    * Delete fMP4 Muxing
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the fMP4 muxing (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String encodingId, String muxingId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, muxingId);
    }

    /**
    * fMP4 Segment Muxing Details
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the fMP4 muxing (required)
    * @return Fmp4Muxing
    * @throws BitmovinException if fails to make API call
    */
    public Fmp4Muxing get(String encodingId, String muxingId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, muxingId);
    }
    /**
    * List fMP4 Segment Muxings
    * 
    * @param encodingId Id of the encoding. (required)
    * @return List&lt;Fmp4Muxing&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Fmp4Muxing> list(String encodingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, new HashMap<String, Object>());
    }

    /**
    * List fMP4 Segment Muxings
    * 
    * @param encodingId Id of the encoding. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;Fmp4Muxing&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Fmp4Muxing> list(String encodingId, Fmp4MuxingsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, queryParams);
    }
}
