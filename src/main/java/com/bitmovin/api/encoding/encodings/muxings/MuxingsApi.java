package com.bitmovin.api.encoding.encodings.muxings;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.muxings.fmp4.Fmp4Api;
import com.bitmovin.api.encoding.encodings.muxings.segmentedRaw.SegmentedRawApi;
import com.bitmovin.api.encoding.encodings.muxings.ts.TsApi;
import com.bitmovin.api.encoding.encodings.muxings.webm.WebmApi;
import com.bitmovin.api.encoding.encodings.muxings.mp3.Mp3Api;
import com.bitmovin.api.encoding.encodings.muxings.mp4.Mp4Api;
import com.bitmovin.api.encoding.encodings.muxings.progressiveTs.ProgressiveTsApi;
import com.bitmovin.api.encoding.encodings.muxings.broadcastTs.BroadcastTsApi;
import com.bitmovin.api.encoding.encodings.muxings.progressiveWebm.ProgressiveWebmApi;
import com.bitmovin.api.encoding.encodings.muxings.progressiveMov.ProgressiveMovApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MuxingsApi
{
    private final MuxingsClient apiClient;
    public Fmp4Api fmp4;
    public SegmentedRawApi segmentedRaw;
    public TsApi ts;
    public WebmApi webm;
    public Mp3Api mp3;
    public Mp4Api mp4;
    public ProgressiveTsApi progressiveTs;
    public BroadcastTsApi broadcastTs;
    public ProgressiveWebmApi progressiveWebm;
    public ProgressiveMovApi progressiveMov;

    public MuxingsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public MuxingsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public MuxingsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(MuxingsClient.class);

        fmp4 = new Fmp4Api(clientFactory);
        segmentedRaw = new SegmentedRawApi(clientFactory);
        ts = new TsApi(clientFactory);
        webm = new WebmApi(clientFactory);
        mp3 = new Mp3Api(clientFactory);
        mp4 = new Mp4Api(clientFactory);
        progressiveTs = new ProgressiveTsApi(clientFactory);
        broadcastTs = new BroadcastTsApi(clientFactory);
        progressiveWebm = new ProgressiveWebmApi(clientFactory);
        progressiveMov = new ProgressiveMovApi(clientFactory);
    }

    /**
    * List All Muxings
    * 
    * @param encodingId Id of the encoding. (required)
    * @return List&lt;Muxing&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Muxing> list(String encodingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, new HashMap<String, Object>());
    }

    /**
    * List All Muxings
    * 
    * @param encodingId Id of the encoding. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;Muxing&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Muxing> list(String encodingId, MuxingsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, queryParams);
    }
}
