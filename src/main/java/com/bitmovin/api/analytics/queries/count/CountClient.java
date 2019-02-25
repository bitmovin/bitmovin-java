package com.bitmovin.api.analytics.queries.count;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface CountClient {
    
    @RequestLine("POST /analytics/queries/count")
    AnalyticsResponse create(AnalyticsCountQueryRequest analyticsCountQueryRequest) throws BitmovinException;
}
