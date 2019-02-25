package com.bitmovin.api.encoding.statistics.encodings.liveStatistics.events;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface EventsClient {
    
    @RequestLine("GET /encoding/statistics/encodings/{encoding_id}/live-statistics/events")
    List<LiveEncodingStatsEvent> list(@Param("encoding_id") String encodingId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
