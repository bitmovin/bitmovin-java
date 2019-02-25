package com.bitmovin.api.analytics.queries.max;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface MaxClient {
    
    @RequestLine("POST /analytics/queries/max")
    AnalyticsResponse create(AnalyticsMaxQueryRequest analyticsMaxQueryRequest) throws BitmovinException;
}
