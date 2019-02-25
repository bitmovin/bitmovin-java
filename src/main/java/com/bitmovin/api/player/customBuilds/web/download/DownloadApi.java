package com.bitmovin.api.player.customBuilds.web.download;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DownloadApi
{
    private final DownloadClient apiClient;

    public DownloadApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public DownloadApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public DownloadApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(DownloadClient.class);

    }


    /**
    * Custom Web Player Build Download Link
    * 
    * @param customBuildId Id of the custom player build (required)
    * @return CustomPlayerBuildDownload
    * @throws BitmovinException if fails to make API call
    */
    public CustomPlayerBuildDownload get(String customBuildId) throws BitmovinException
    {
        return this.apiClient.get(customBuildId);
    }
}
