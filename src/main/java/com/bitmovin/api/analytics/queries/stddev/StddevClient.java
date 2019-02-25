package com.bitmovin.api.analytics.queries.stddev;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface StddevClient {
    
    @RequestLine("POST /analytics/queries/stddev")
    AnalyticsResponse create(AnalyticsStddevQueryRequest analyticsStddevQueryRequest) throws BitmovinException;
}
