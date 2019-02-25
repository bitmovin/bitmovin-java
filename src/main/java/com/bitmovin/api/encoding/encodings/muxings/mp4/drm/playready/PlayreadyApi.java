package com.bitmovin.api.encoding.encodings.muxings.mp4.drm.playready;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.muxings.mp4.drm.playready.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayreadyApi
{
    private final PlayreadyClient apiClient;
    public CustomdataApi customdata;

    public PlayreadyApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public PlayreadyApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public PlayreadyApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(PlayreadyClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Add PlayReady DRM to MP4
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the MP4 muxing. (required)
    * @param playReadyDrm  (optional)
    * @return PlayReadyDrm
    * @throws BitmovinException if fails to make API call
    */
    public PlayReadyDrm create(String encodingId, String muxingId, PlayReadyDrm playReadyDrm) throws BitmovinException
    {
        return this.apiClient.create(encodingId, muxingId, playReadyDrm);
    }

    /**
    * Delete PlayReady DRM from MP4
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the MP4 muxing. (required)
    * @param drmId Id of the PlayReady DRM configuration. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String encodingId, String muxingId, String drmId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, muxingId, drmId);
    }

    /**
    * PlayReady DRM Details of MP4
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the MP4 muxing. (required)
    * @param drmId Id of the PlayReady DRM configuration. (required)
    * @return PlayReadyDrm
    * @throws BitmovinException if fails to make API call
    */
    public PlayReadyDrm get(String encodingId, String muxingId, String drmId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, muxingId, drmId);
    }
    /**
    * List PlayReady DRMs of MP4
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the MP4 muxing. (required)
    * @return List&lt;PlayReadyDrm&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<PlayReadyDrm> list(String encodingId, String muxingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, muxingId, new HashMap<String, Object>());
    }

    /**
    * List PlayReady DRMs of MP4
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the MP4 muxing. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;PlayReadyDrm&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<PlayReadyDrm> list(String encodingId, String muxingId, PlayReadyDrmsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, muxingId, queryParams);
    }
}
