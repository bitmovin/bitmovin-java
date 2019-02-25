package com.bitmovin.api.encoding.statistics.encodings;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.statistics.encodings.live.LiveApi;
import com.bitmovin.api.encoding.statistics.encodings.vod.VodApi;
import com.bitmovin.api.encoding.statistics.encodings.liveStatistics.LiveStatisticsApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EncodingsApi
{
    private final EncodingsClient apiClient;
    public LiveApi live;
    public VodApi vod;
    public LiveStatisticsApi liveStatistics;

    public EncodingsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public EncodingsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public EncodingsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(EncodingsClient.class);

        live = new LiveApi(clientFactory);
        vod = new VodApi(clientFactory);
        liveStatistics = new LiveStatisticsApi(clientFactory);
    }


    /**
    * Get Statistics from an Encoding
    * 
    * @param encodingId Id of the encoding (required)
    * @return EncodingStats
    * @throws BitmovinException if fails to make API call
    */
    public EncodingStats get(String encodingId) throws BitmovinException
    {
        return this.apiClient.get(encodingId);
    }
}
