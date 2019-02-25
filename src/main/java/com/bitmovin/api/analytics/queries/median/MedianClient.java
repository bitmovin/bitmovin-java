package com.bitmovin.api.analytics.queries.median;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface MedianClient {
    
    @RequestLine("POST /analytics/queries/median")
    AnalyticsResponse create(AnalyticsMedianQueryRequest analyticsMedianQueryRequest) throws BitmovinException;
}
