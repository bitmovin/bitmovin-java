package com.bitmovin.api.player.channels;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.player.channels.versions.VersionsApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChannelsApi
{
    private final ChannelsClient apiClient;
    public VersionsApi versions;

    public ChannelsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public ChannelsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public ChannelsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(ChannelsClient.class);

        versions = new VersionsApi(clientFactory);
    }


    /**
    * List Player Channels
    * 
    * @return List&lt;PlayerChannel&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<PlayerChannel> list() throws BitmovinException
    {
        return this.apiClient.list();
    }
}
