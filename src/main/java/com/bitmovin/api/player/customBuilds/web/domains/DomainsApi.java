package com.bitmovin.api.player.customBuilds.web.domains;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DomainsApi
{
    private final DomainsClient apiClient;

    public DomainsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public DomainsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public DomainsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(DomainsClient.class);

    }


    /**
    * Add Domain
    * 
    * @param customWebPlayerBuildDomain  (optional)
    * @return CustomWebPlayerBuildDomain
    * @throws BitmovinException if fails to make API call
    */
    public CustomWebPlayerBuildDomain create(CustomWebPlayerBuildDomain customWebPlayerBuildDomain) throws BitmovinException
    {
        return this.apiClient.create(customWebPlayerBuildDomain);
    }

    /**
    * Delete Domain
    * 
    * @param domainId Id of the domain (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String domainId) throws BitmovinException
    {
        return this.apiClient.delete(domainId);
    }

    /**
    * Get Domain Details
    * 
    * @param domainId Id of the domain (required)
    * @return CustomWebPlayerBuildDomain
    * @throws BitmovinException if fails to make API call
    */
    public CustomWebPlayerBuildDomain get(String domainId) throws BitmovinException
    {
        return this.apiClient.get(domainId);
    }

    /**
    * List Domain Details
    * 
    * @return List&lt;CustomWebPlayerBuildDomain&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<CustomWebPlayerBuildDomain> list() throws BitmovinException
    {
        return this.apiClient.list();
    }
}
