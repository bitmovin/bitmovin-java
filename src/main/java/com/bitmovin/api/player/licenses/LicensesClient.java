package com.bitmovin.api.player.licenses;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface LicensesClient {
    
    @RequestLine("GET /player/licenses/{license_id}")
    PlayerLicense get(@Param("license_id") String licenseId) throws BitmovinException;
    
    @RequestLine("GET /player/licenses")
    List<PlayerLicense> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
