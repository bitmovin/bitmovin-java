package com.bitmovin.api.encoding.encodings.muxings.mp4;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.muxings.mp4.customdata.CustomdataApi;
import com.bitmovin.api.encoding.encodings.muxings.mp4.information.InformationApi;
import com.bitmovin.api.encoding.encodings.muxings.mp4.drm.DrmApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mp4Api
{
    private final Mp4Client apiClient;
    public CustomdataApi customdata;
    public InformationApi information;
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

        customdata = new CustomdataApi(clientFactory);
        information = new InformationApi(clientFactory);
        drm = new DrmApi(clientFactory);
    }


    /**
    * Add MP4 Muxing
    * 
    * @param encodingId Id of the encoding. (required)
    * @param mp4Muxing  (optional)
    * @return Mp4Muxing
    * @throws BitmovinException if fails to make API call
    */
    public Mp4Muxing create(String encodingId, Mp4Muxing mp4Muxing) throws BitmovinException
    {
        return this.apiClient.create(encodingId, mp4Muxing);
    }

    /**
    * Delete MP4 Muxing
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the MP4 muxing (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String encodingId, String muxingId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, muxingId);
    }

    /**
    * MP4 Segment Muxing Details
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the MP4 muxing (required)
    * @return Mp4Muxing
    * @throws BitmovinException if fails to make API call
    */
    public Mp4Muxing get(String encodingId, String muxingId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, muxingId);
    }
    /**
    * List MP4 Muxings
    * 
    * @param encodingId Id of the encoding. (required)
    * @return List&lt;Mp4Muxing&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Mp4Muxing> list(String encodingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, new HashMap<String, Object>());
    }

    /**
    * List MP4 Muxings
    * 
    * @param encodingId Id of the encoding. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;Mp4Muxing&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Mp4Muxing> list(String encodingId, Mp4MuxingsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, queryParams);
    }
}
