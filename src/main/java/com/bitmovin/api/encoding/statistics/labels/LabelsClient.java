package com.bitmovin.api.encoding.statistics.labels;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface LabelsClient {
    
    @RequestLine("GET /encoding/statistics/labels/")
    List<StatisticsPerLabel> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
    
    @RequestLine("GET /encoding/statistics/labels/{from}/{to}")
    List<StatisticsPerLabel> listByDateRange(@Param("from") String from, @Param("to") String to, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
