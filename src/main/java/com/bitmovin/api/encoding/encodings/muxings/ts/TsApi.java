package com.bitmovin.api.encoding.encodings.muxings.ts;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.muxings.ts.customdata.CustomdataApi;
import com.bitmovin.api.encoding.encodings.muxings.ts.drm.DrmApi;
import com.bitmovin.api.encoding.encodings.muxings.ts.captions.CaptionsApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TsApi
{
    private final TsClient apiClient;
    public CustomdataApi customdata;
    public DrmApi drm;
    public CaptionsApi captions;

    public TsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public TsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public TsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(TsClient.class);

        customdata = new CustomdataApi(clientFactory);
        drm = new DrmApi(clientFactory);
        captions = new CaptionsApi(clientFactory);
    }


    /**
    * Add TS Segment Muxing
    * 
    * @param encodingId Id of the encoding. (required)
    * @param tsMuxing  (optional)
    * @return TsMuxing
    * @throws BitmovinException if fails to make API call
    */
    public TsMuxing create(String encodingId, TsMuxing tsMuxing) throws BitmovinException
    {
        return this.apiClient.create(encodingId, tsMuxing);
    }

    /**
    * Delete TS Segment Muxing
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the ts segment muxing (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String encodingId, String muxingId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, muxingId);
    }

    /**
    * TS Segment Muxing Details
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the ts segment muxing (required)
    * @return TsMuxing
    * @throws BitmovinException if fails to make API call
    */
    public TsMuxing get(String encodingId, String muxingId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, muxingId);
    }
    /**
    * List TS Segment Muxings
    * 
    * @param encodingId Id of the encoding. (required)
    * @return List&lt;TsMuxing&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<TsMuxing> list(String encodingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, new HashMap<String, Object>());
    }

    /**
    * List TS Segment Muxings
    * 
    * @param encodingId Id of the encoding. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;TsMuxing&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<TsMuxing> list(String encodingId, TsMuxingsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, queryParams);
    }
}
