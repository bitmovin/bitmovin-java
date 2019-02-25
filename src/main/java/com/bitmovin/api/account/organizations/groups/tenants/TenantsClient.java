package com.bitmovin.api.account.organizations.groups.tenants;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface TenantsClient {
    
    @RequestLine("POST /account/organizations/{organization_id}/groups/{group_id}/tenants")
    Tenant create(@Param("organization_id") String organizationId, @Param("group_id") String groupId, Tenant tenant) throws BitmovinException;
    
    @RequestLine("DELETE /account/organizations/{organization_id}/groups/{group_id}/tenants/{tenant_id}")
    BitmovinResponse delete(@Param("organization_id") String organizationId, @Param("group_id") String groupId, @Param("tenant_id") String tenantId) throws BitmovinException;
    
    @RequestLine("GET /account/organizations/{organization_id}/groups/{group_id}/tenants/{tenant_id}")
    Tenant get(@Param("organization_id") String organizationId, @Param("group_id") String groupId, @Param("tenant_id") String tenantId) throws BitmovinException;
    
    @RequestLine("GET /account/organizations/{organization_id}/groups/{group_id}/tenants")
    List<Tenant> list(@Param("organization_id") String organizationId, @Param("group_id") String groupId) throws BitmovinException;
}
