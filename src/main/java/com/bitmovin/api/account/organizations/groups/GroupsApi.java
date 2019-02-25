package com.bitmovin.api.account.organizations.groups;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.account.organizations.groups.tenants.TenantsApi;
import com.bitmovin.api.account.organizations.groups.permissions.PermissionsApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupsApi
{
    private final GroupsClient apiClient;
    public TenantsApi tenants;
    public PermissionsApi permissions;

    public GroupsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public GroupsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public GroupsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(GroupsClient.class);

        tenants = new TenantsApi(clientFactory);
        permissions = new PermissionsApi(clientFactory);
    }


    /**
    * Add Group
    * 
    * @param organizationId Id of the organization (required)
    * @param group Tenant Group details (optional)
    * @return Group
    * @throws BitmovinException if fails to make API call
    */
    public Group create(String organizationId, Group group) throws BitmovinException
    {
        return this.apiClient.create(organizationId, group);
    }

    /**
    * Delete Group
    * 
    * @param organizationId Id of the organization (required)
    * @param groupId Id of the group (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String organizationId, String groupId) throws BitmovinException
    {
        return this.apiClient.delete(organizationId, groupId);
    }

    /**
    * Group Details
    * 
    * @param organizationId Id of the organization (required)
    * @param groupId Id of the group. (required)
    * @return Group
    * @throws BitmovinException if fails to make API call
    */
    public Group get(String organizationId, String groupId) throws BitmovinException
    {
        return this.apiClient.get(organizationId, groupId);
    }

    /**
    * List Groups
    * 
    * @param organizationId Id of the organization (required)
    * @return List&lt;Group&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Group> list(String organizationId) throws BitmovinException
    {
        return this.apiClient.list(organizationId);
    }
}
