package com.bitmovin.api.player.channels.versions;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.player.channels.versions.latest.LatestApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VersionsApi
{
    private final VersionsClient apiClient;
    public LatestApi latest;

    public VersionsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public VersionsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public VersionsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(VersionsClient.class);

        latest = new LatestApi(clientFactory);
    }


    /**
    * List Player Versions for Channel
    * 
    * @param channelName Name of the channel to get the player versions for. (required)
    * @return List&lt;PlayerVersion&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<PlayerVersion> list(String channelName) throws BitmovinException
    {
        return this.apiClient.list(channelName);
    }
}
