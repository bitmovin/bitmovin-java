package com.bitmovin.api.analytics.queries.avg;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface AvgClient {
    
    @RequestLine("POST /analytics/queries/avg")
    AnalyticsResponse create(AnalyticsAvgQueryRequest analyticsAvgQueryRequest) throws BitmovinException;
}
