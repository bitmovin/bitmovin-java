package com.bitmovin.api.analytics.licenses.domains;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface DomainsClient {
    
    @RequestLine("POST /analytics/licenses/{license_id}/domains")
    Domain create(@Param("license_id") String licenseId, Domain domain) throws BitmovinException;
    
    @RequestLine("DELETE /analytics/licenses/{license_id}/domains/{domain_id}")
    BitmovinResponse delete(@Param("license_id") String licenseId, @Param("domain_id") String domainId) throws BitmovinException;
    
    @RequestLine("GET /analytics/licenses/{license_id}/domains")
    DomainList get(@Param("license_id") String licenseId) throws BitmovinException;
}
