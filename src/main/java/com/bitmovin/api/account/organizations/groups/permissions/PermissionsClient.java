package com.bitmovin.api.account.organizations.groups.permissions;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface PermissionsClient {
    
    @RequestLine("POST /account/organizations/{organization_id}/groups/{group_id}/permissions")
    Acl create(@Param("organization_id") String organizationId, @Param("group_id") String groupId, Acl acl) throws BitmovinException;
    
    @RequestLine("DELETE /account/organizations/{organization_id}/groups/{group_id}/permissions/{permission_id}")
    BitmovinResponse delete(@Param("organization_id") String organizationId, @Param("group_id") String groupId, @Param("permission_id") String permissionId) throws BitmovinException;
    
    @RequestLine("GET /account/organizations/{organization_id}/groups/{group_id}/permissions")
    List<Acl> list(@Param("organization_id") String organizationId, @Param("group_id") String groupId) throws BitmovinException;
}
