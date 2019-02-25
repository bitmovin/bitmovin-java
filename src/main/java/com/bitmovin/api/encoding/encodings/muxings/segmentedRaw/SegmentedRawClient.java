package com.bitmovin.api.encoding.encodings.muxings.segmentedRaw;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface SegmentedRawClient {
    
    @RequestLine("POST /encoding/encodings/{encoding_id}/muxings/segmented-raw")
    SegmentedRawMuxing create(@Param("encoding_id") String encodingId, SegmentedRawMuxing segmentedRawMuxing) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/encodings/{encoding_id}/muxings/segmented-raw/{muxing_id}")
    BitmovinResponse delete(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/muxings/segmented-raw/{muxing_id}")
    SegmentedRawMuxing get(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/muxings/segmented-raw")
    List<SegmentedRawMuxing> list(@Param("encoding_id") String encodingId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
