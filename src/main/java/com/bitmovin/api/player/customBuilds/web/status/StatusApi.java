package com.bitmovin.api.player.customBuilds.web.status;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatusApi
{
    private final StatusClient apiClient;

    public StatusApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public StatusApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public StatusApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(StatusClient.class);

    }


    /**
    * Custom Web Player Build Status
    * 
    * @param customBuildId Id of the custom player build (required)
    * @return CustomPlayerBuildStatus
    * @throws BitmovinException if fails to make API call
    */
    public CustomPlayerBuildStatus get(String customBuildId) throws BitmovinException
    {
        return this.apiClient.get(customBuildId);
    }
}
