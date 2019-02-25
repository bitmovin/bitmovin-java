package com.bitmovin.api.player.customBuilds;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.player.customBuilds.web.WebApi;


public class CustomBuildsApi
{
    public WebApi web;

    public CustomBuildsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public CustomBuildsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public CustomBuildsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        web = new WebApi(clientFactory);
    }

}
