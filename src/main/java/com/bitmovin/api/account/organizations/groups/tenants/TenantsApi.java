package com.bitmovin.api.account.organizations.groups.tenants;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TenantsApi
{
    private final TenantsClient apiClient;

    public TenantsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public TenantsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public TenantsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(TenantsClient.class);

    }


    /**
    * Add Tenant to Group
    * 
    * @param organizationId Id of the organization (required)
    * @param groupId Id of the group (required)
    * @param tenant Tenant details (optional)
    * @return Tenant
    * @throws BitmovinException if fails to make API call
    */
    public Tenant create(String organizationId, String groupId, Tenant tenant) throws BitmovinException
    {
        return this.apiClient.create(organizationId, groupId, tenant);
    }

    /**
    * Delete Tenant
    * 
    * @param organizationId Id of the organization (required)
    * @param groupId Id of the group (required)
    * @param tenantId Id of the tenant. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String organizationId, String groupId, String tenantId) throws BitmovinException
    {
        return this.apiClient.delete(organizationId, groupId, tenantId);
    }

    /**
    * Tenant Details
    * 
    * @param organizationId Id of the organization (required)
    * @param groupId Id of the group (required)
    * @param tenantId Id of the tenant. (required)
    * @return Tenant
    * @throws BitmovinException if fails to make API call
    */
    public Tenant get(String organizationId, String groupId, String tenantId) throws BitmovinException
    {
        return this.apiClient.get(organizationId, groupId, tenantId);
    }

    /**
    * List Tenants
    * 
    * @param organizationId Id of the organization (required)
    * @param groupId Id of the group (required)
    * @return List&lt;Tenant&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Tenant> list(String organizationId, String groupId) throws BitmovinException
    {
        return this.apiClient.list(organizationId, groupId);
    }
}
