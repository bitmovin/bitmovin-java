package com.bitmovin.api.player;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.player.channels.ChannelsApi;
import com.bitmovin.api.player.licenses.LicensesApi;
import com.bitmovin.api.player.customBuilds.CustomBuildsApi;


public class PlayerApi
{
    public ChannelsApi channels;
    public LicensesApi licenses;
    public CustomBuildsApi customBuilds;

    public PlayerApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public PlayerApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public PlayerApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        channels = new ChannelsApi(clientFactory);
        licenses = new LicensesApi(clientFactory);
        customBuilds = new CustomBuildsApi(clientFactory);
    }

}
