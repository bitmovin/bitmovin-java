package com.bitmovin.api.analytics.queries.percentile;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface PercentileClient {
    
    @RequestLine("POST /analytics/queries/percentile")
    AnalyticsResponse create(AnalyticsPercentileQueryRequest analyticsPercentileQueryRequest) throws BitmovinException;
}
