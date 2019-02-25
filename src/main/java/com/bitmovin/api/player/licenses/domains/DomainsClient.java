package com.bitmovin.api.player.licenses.domains;

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
    
    @RequestLine("POST /player/licenses/{license_id}/domains")
    Domain create(@Param("license_id") String licenseId, Domain domain) throws BitmovinException;
    
    @RequestLine("DELETE /player/licenses/{license_id}/domains/{domain_id}")
    BitmovinResponse delete(@Param("license_id") String licenseId, @Param("domain_id") String domainId) throws BitmovinException;
    
    @RequestLine("GET /player/licenses/{license_id}/domains")
    List<Domain> list(@Param("license_id") String licenseId) throws BitmovinException;
}
