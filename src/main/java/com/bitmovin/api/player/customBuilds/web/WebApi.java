package com.bitmovin.api.player.customBuilds.web;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.player.customBuilds.web.domains.DomainsApi;
import com.bitmovin.api.player.customBuilds.web.status.StatusApi;
import com.bitmovin.api.player.customBuilds.web.download.DownloadApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebApi
{
    private final WebClient apiClient;
    public DomainsApi domains;
    public StatusApi status;
    public DownloadApi download;

    public WebApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public WebApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public WebApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(WebClient.class);

        domains = new DomainsApi(clientFactory);
        status = new StatusApi(clientFactory);
        download = new DownloadApi(clientFactory);
    }


    /**
    * Add Custom Web Player Build
    * 
    * @param customPlayerBuildDetails  (optional)
    * @return CustomPlayerBuildDetails
    * @throws BitmovinException if fails to make API call
    */
    public CustomPlayerBuildDetails create(CustomPlayerBuildDetails customPlayerBuildDetails) throws BitmovinException
    {
        return this.apiClient.create(customPlayerBuildDetails);
    }

    /**
    * Custom Web Player Build Details
    * 
    * @param customBuildId Id of the custom player build (required)
    * @return CustomPlayerBuildStatus
    * @throws BitmovinException if fails to make API call
    */
    public CustomPlayerBuildStatus get(String customBuildId) throws BitmovinException
    {
        return this.apiClient.get(customBuildId);
    }

    /**
    * List Custom Web Player Builds
    * 
    * @return List&lt;CustomPlayerBuildDetails&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<CustomPlayerBuildDetails> list() throws BitmovinException
    {
        return this.apiClient.list();
    }

    /**
    * Start Custom Web Player Build
    * 
    * @param customBuildId Id of the custom player build (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse start(String customBuildId) throws BitmovinException
    {
        return this.apiClient.start(customBuildId);
    }
}
