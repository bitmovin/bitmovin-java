package com.bitmovin.api.player.licenses.thirdPartyLicensing;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface ThirdPartyLicensingClient {
    
    @RequestLine("POST /player/licenses/{license_id}/third-party-licensing")
    PlayerThirdPartyLicensing create(@Param("license_id") String licenseId, PlayerThirdPartyLicensing playerThirdPartyLicensing) throws BitmovinException;
    
    @RequestLine("DELETE /player/licenses/{license_id}/third-party-licensing")
    BitmovinResponse delete(@Param("license_id") String licenseId) throws BitmovinException;
    
    @RequestLine("GET /player/licenses/{license_id}/third-party-licensing")
    PlayerThirdPartyLicensing get(@Param("license_id") String licenseId) throws BitmovinException;
}
