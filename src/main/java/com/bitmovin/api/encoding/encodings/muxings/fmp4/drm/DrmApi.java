package com.bitmovin.api.encoding.encodings.muxings.fmp4.drm;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.muxings.fmp4.drm.widevine.WidevineApi;
import com.bitmovin.api.encoding.encodings.muxings.fmp4.drm.playready.PlayreadyApi;
import com.bitmovin.api.encoding.encodings.muxings.fmp4.drm.primetime.PrimetimeApi;
import com.bitmovin.api.encoding.encodings.muxings.fmp4.drm.fairplay.FairplayApi;
import com.bitmovin.api.encoding.encodings.muxings.fmp4.drm.marlin.MarlinApi;
import com.bitmovin.api.encoding.encodings.muxings.fmp4.drm.clearkey.ClearkeyApi;
import com.bitmovin.api.encoding.encodings.muxings.fmp4.drm.cenc.CencApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DrmApi
{
    private final DrmClient apiClient;
    public WidevineApi widevine;
    public PlayreadyApi playready;
    public PrimetimeApi primetime;
    public FairplayApi fairplay;
    public MarlinApi marlin;
    public ClearkeyApi clearkey;
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

        widevine = new WidevineApi(clientFactory);
        playready = new PlayreadyApi(clientFactory);
        primetime = new PrimetimeApi(clientFactory);
        fairplay = new FairplayApi(clientFactory);
        marlin = new MarlinApi(clientFactory);
        clearkey = new ClearkeyApi(clientFactory);
        cenc = new CencApi(clientFactory);
    }


    /**
    * List all DRMs of FMP4 Muxing
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the fMP4 muxing (required)
    * @return List&lt;Drm&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Drm> list(String encodingId, String muxingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, muxingId);
    }
}
