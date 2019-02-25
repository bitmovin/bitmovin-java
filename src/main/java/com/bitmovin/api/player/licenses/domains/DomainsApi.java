package com.bitmovin.api.player.licenses.domains;

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
    * @param licenseId Id of the Player License (required)
    * @param domain The Domain to be added to Player License Whitelist (optional)
    * @return Domain
    * @throws BitmovinException if fails to make API call
    */
    public Domain create(String licenseId, Domain domain) throws BitmovinException
    {
        return this.apiClient.create(licenseId, domain);
    }

    /**
    * Delete Domain
    * 
    * @param licenseId Id of license (required)
    * @param domainId Id of the domain (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String licenseId, String domainId) throws BitmovinException
    {
        return this.apiClient.delete(licenseId, domainId);
    }

    /**
    * List allowed Domains for Player License
    * 
    * @param licenseId Id of the Player License (required)
    * @return List&lt;Domain&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Domain> list(String licenseId) throws BitmovinException
    {
        return this.apiClient.list(licenseId);
    }
}
