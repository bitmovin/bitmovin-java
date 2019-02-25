package com.bitmovin.api.account.organizations;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.account.organizations.groups.GroupsApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrganizationsApi
{
    private final OrganizationsClient apiClient;
    public GroupsApi groups;

    public OrganizationsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public OrganizationsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public OrganizationsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(OrganizationsClient.class);

        groups = new GroupsApi(clientFactory);
    }


    /**
    * Add Organization
    * 
    * @param organization Orgnaization Details (optional)
    * @return Organization
    * @throws BitmovinException if fails to make API call
    */
    public Organization create(Organization organization) throws BitmovinException
    {
        return this.apiClient.create(organization);
    }

    /**
    * Delete Organization
    * 
    * @param organizationId Id of the organization (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String organizationId) throws BitmovinException
    {
        return this.apiClient.delete(organizationId);
    }

    /**
    * Organization Details
    * 
    * @param organizationId Id of the organization (required)
    * @return Organization
    * @throws BitmovinException if fails to make API call
    */
    public Organization get(String organizationId) throws BitmovinException
    {
        return this.apiClient.get(organizationId);
    }

    /**
    * List Organizations
    * 
    * @return List&lt;Organization&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Organization> list() throws BitmovinException
    {
        return this.apiClient.list();
    }
}
