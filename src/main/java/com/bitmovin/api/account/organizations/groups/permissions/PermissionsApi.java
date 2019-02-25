package com.bitmovin.api.account.organizations.groups.permissions;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermissionsApi
{
    private final PermissionsClient apiClient;

    public PermissionsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public PermissionsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public PermissionsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(PermissionsClient.class);

    }


    /**
    * Set Group Permissions
    * 
    * @param organizationId Id of the organization (required)
    * @param groupId Id of the group (required)
    * @param acl  (optional)
    * @return Acl
    * @throws BitmovinException if fails to make API call
    */
    public Acl create(String organizationId, String groupId, Acl acl) throws BitmovinException
    {
        return this.apiClient.create(organizationId, groupId, acl);
    }

    /**
    * Delete Permission
    * 
    * @param organizationId Id of the organization (required)
    * @param groupId Id of the group (required)
    * @param permissionId Id of the permission (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String organizationId, String groupId, String permissionId) throws BitmovinException
    {
        return this.apiClient.delete(organizationId, groupId, permissionId);
    }

    /**
    * Get Group Permissions
    * 
    * @param organizationId Id of the organization (required)
    * @param groupId Id of the group (required)
    * @return List&lt;Acl&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Acl> list(String organizationId, String groupId) throws BitmovinException
    {
        return this.apiClient.list(organizationId, groupId);
    }
}
