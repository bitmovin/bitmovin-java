package com.bitmovin.api.account.organizations;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface OrganizationsClient {
    
    @RequestLine("POST /account/organizations")
    Organization create(Organization organization) throws BitmovinException;
    
    @RequestLine("DELETE /account/organizations/{organization_id}")
    BitmovinResponse delete(@Param("organization_id") String organizationId) throws BitmovinException;
    
    @RequestLine("GET /account/organizations/{organization_id}")
    Organization get(@Param("organization_id") String organizationId) throws BitmovinException;
    
    @RequestLine("GET /account/organizations")
    List<Organization> list() throws BitmovinException;
}
