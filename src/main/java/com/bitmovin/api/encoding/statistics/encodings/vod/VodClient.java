package com.bitmovin.api.encoding.statistics.encodings.vod;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface VodClient {
    
    @RequestLine("GET /encoding/statistics/encodings/vod")
    List<EncodingStatisticsVod> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
    
    @RequestLine("GET /encoding/statistics/encodings/vod/{from}/{to}")
    List<EncodingStatisticsVod> listByDateRange(@Param("from") String from, @Param("to") String to, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
