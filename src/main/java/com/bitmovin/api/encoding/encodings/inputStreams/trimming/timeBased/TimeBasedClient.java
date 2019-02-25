package com.bitmovin.api.encoding.encodings.inputStreams.trimming.timeBased;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface TimeBasedClient {
    
    @RequestLine("POST /encoding/encodings/{encoding_id}/input-streams/trimming/time-based")
    TimeBasedTrimmingInputStream create(@Param("encoding_id") String encodingId, TimeBasedTrimmingInputStream timeBasedTrimmingInputStream) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/encodings/{encoding_id}/input-streams/trimming/time-based/{input_stream_id}")
    BitmovinResponse delete(@Param("encoding_id") String encodingId, @Param("input_stream_id") String inputStreamId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/input-streams/trimming/time-based/{input_stream_id}")
    TimeBasedTrimmingInputStream get(@Param("encoding_id") String encodingId, @Param("input_stream_id") String inputStreamId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/input-streams/trimming/time-based")
    List<TimeBasedTrimmingInputStream> list(@Param("encoding_id") String encodingId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
