package com.bitmovin.api.player.channels.versions.latest;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LatestApi
{
    private final LatestClient apiClient;

    public LatestApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public LatestApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public LatestApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(LatestClient.class);

    }


    /**
    * Get Latest Player Version for Channel
    * 
    * @param channelName Name of the channel to get the player versions for. (required)
    * @return PlayerVersion
    * @throws BitmovinException if fails to make API call
    */
    public PlayerVersion get(String channelName) throws BitmovinException
    {
        return this.apiClient.get(channelName);
    }
}
