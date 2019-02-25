package com.bitmovin.api.analytics.queries.min;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface MinClient {
    
    @RequestLine("POST /analytics/queries/min")
    AnalyticsResponse create(AnalyticsMinQueryRequest analyticsMinQueryRequest) throws BitmovinException;
}
