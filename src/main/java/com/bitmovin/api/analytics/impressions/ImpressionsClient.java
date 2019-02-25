package com.bitmovin.api.analytics.impressions;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface ImpressionsClient {
    
    @RequestLine("POST /analytics/impressions/{impression_id}")
    AnalyticsImpressionDetails create(@Param("impression_id") String impressionId, AnalyticsLicense analyticsLicense) throws BitmovinException;
}
