package com.bitmovin.api.account.organizations.groups;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface GroupsClient {
    
    @RequestLine("POST /account/organizations/{organization_id}/groups")
    Group create(@Param("organization_id") String organizationId, Group group) throws BitmovinException;
    
    @RequestLine("DELETE /account/organizations/{organization_id}/groups/{group_id}")
    BitmovinResponse delete(@Param("organization_id") String organizationId, @Param("group_id") String groupId) throws BitmovinException;
    
    @RequestLine("GET /account/organizations/{organization_id}/groups/{group_id}")
    Group get(@Param("organization_id") String organizationId, @Param("group_id") String groupId) throws BitmovinException;
    
    @RequestLine("GET /account/organizations/{organization_id}/groups")
    List<Group> list(@Param("organization_id") String organizationId) throws BitmovinException;
}
