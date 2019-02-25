package com.bitmovin.api.analytics.queries.variance;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface VarianceClient {
    
    @RequestLine("POST /analytics/queries/variance")
    AnalyticsResponse create(AnalyticsVarianceQueryRequest analyticsVarianceQueryRequest) throws BitmovinException;
}
