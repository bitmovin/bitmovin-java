package com.bitmovin.api.encoding.statistics.encodings.liveStatistics;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface LiveStatisticsClient {
    
    @RequestLine("GET /encoding/statistics/encodings/{encoding_id}/live-statistics")
    LiveEncodingStats get(@Param("encoding_id") String encodingId) throws BitmovinException;
}
