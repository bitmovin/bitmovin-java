package com.bitmovin.api.analytics.licenses;

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
    
    @RequestLine("GET /analytics/licenses/{license_id}")
    AnalyticsLicense get(@Param("license_id") String licenseId) throws BitmovinException;
    
    @RequestLine("GET /analytics/licenses")
    List<AnalyticsLicense> list() throws BitmovinException;
}
