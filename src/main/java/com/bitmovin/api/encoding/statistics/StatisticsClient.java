package com.bitmovin.api.encoding.statistics;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface StatisticsClient {
    
    @RequestLine("GET /encoding/statistics")
    Statistics get() throws BitmovinException;
    
    @RequestLine("GET /encoding/statistics/{from}/{to}")
    List<Statistics> list(@Param("from") String from, @Param("to") String to, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
