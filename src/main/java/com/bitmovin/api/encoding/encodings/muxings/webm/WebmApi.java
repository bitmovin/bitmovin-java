package com.bitmovin.api.encoding.encodings.muxings.webm;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.muxings.webm.customdata.CustomdataApi;
import com.bitmovin.api.encoding.encodings.muxings.webm.drm.DrmApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebmApi
{
    private final WebmClient apiClient;
    public CustomdataApi customdata;
    public DrmApi drm;

    public WebmApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public WebmApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public WebmApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(WebmClient.class);

        customdata = new CustomdataApi(clientFactory);
        drm = new DrmApi(clientFactory);
    }


    /**
    * Add WebM Segment Muxing
    * 
    * @param encodingId Id of the encoding. (required)
    * @param webmMuxing  (optional)
    * @return WebmMuxing
    * @throws BitmovinException if fails to make API call
    */
    public WebmMuxing create(String encodingId, WebmMuxing webmMuxing) throws BitmovinException
    {
        return this.apiClient.create(encodingId, webmMuxing);
    }

    /**
    * Delete WebM Muxing
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the WebM muxing (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String encodingId, String muxingId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, muxingId);
    }

    /**
    * WebM Segment Muxing Details
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the WebM muxing (required)
    * @return WebmMuxing
    * @throws BitmovinException if fails to make API call
    */
    public WebmMuxing get(String encodingId, String muxingId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, muxingId);
    }
    /**
    * List WebM Segment Muxings
    * 
    * @param encodingId Id of the encoding. (required)
    * @return List&lt;WebmMuxing&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<WebmMuxing> list(String encodingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, new HashMap<String, Object>());
    }

    /**
    * List WebM Segment Muxings
    * 
    * @param encodingId Id of the encoding. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;WebmMuxing&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<WebmMuxing> list(String encodingId, WebmMuxingsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, queryParams);
    }
}
