package com.bitmovin.api.encoding.encodings.muxings.mp4.drm;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.muxings.mp4.drm.playready.PlayreadyApi;
import com.bitmovin.api.encoding.encodings.muxings.mp4.drm.clearkey.ClearkeyApi;
import com.bitmovin.api.encoding.encodings.muxings.mp4.drm.widevine.WidevineApi;
import com.bitmovin.api.encoding.encodings.muxings.mp4.drm.marlin.MarlinApi;
import com.bitmovin.api.encoding.encodings.muxings.mp4.drm.cenc.CencApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DrmApi
{
    private final DrmClient apiClient;
    public PlayreadyApi playready;
    public ClearkeyApi clearkey;
    public WidevineApi widevine;
    public MarlinApi marlin;
    public CencApi cenc;

    public DrmApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public DrmApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public DrmApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(DrmClient.class);

        playready = new PlayreadyApi(clientFactory);
        clearkey = new ClearkeyApi(clientFactory);
        widevine = new WidevineApi(clientFactory);
        marlin = new MarlinApi(clientFactory);
        cenc = new CencApi(clientFactory);
    }


    /**
    * List all DRM configurations of MP4 Muxing
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the MP4 muxing (required)
    * @return List&lt;Drm&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Drm> list(String encodingId, String muxingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, muxingId);
    }
}
