package com.bitmovin.api.player.customBuilds.web.domains;

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
    
    @RequestLine("POST /player/custom-builds/web/domains")
    CustomWebPlayerBuildDomain create(CustomWebPlayerBuildDomain customWebPlayerBuildDomain) throws BitmovinException;
    
    @RequestLine("DELETE /player/custom-builds/web/domains/{domain_id}")
    BitmovinResponse delete(@Param("domain_id") String domainId) throws BitmovinException;
    
    @RequestLine("GET /player/custom-builds/web/domains/{domain_id}")
    CustomWebPlayerBuildDomain get(@Param("domain_id") String domainId) throws BitmovinException;
    
    @RequestLine("GET /player/custom-builds/web/domains")
    List<CustomWebPlayerBuildDomain> list() throws BitmovinException;
}
