package com.bitmovin.api.encoding.statistics.labels.daily;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface DailyClient {
    
    @RequestLine("GET /encoding/statistics/labels/daily")
    List<DailyStatisticsPerLabel> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
    
    @RequestLine("GET /encoding/statistics/labels/daily/{from}/{to}")
    List<DailyStatisticsPerLabel> listByDateRange(@Param("from") String from, @Param("to") String to, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
