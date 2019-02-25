package com.bitmovin.api.analytics.queries.sum;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface SumClient {
    
    @RequestLine("POST /analytics/queries/sum")
    AnalyticsResponse create(AnalyticsSumQueryRequest analyticsSumQueryRequest) throws BitmovinException;
}
