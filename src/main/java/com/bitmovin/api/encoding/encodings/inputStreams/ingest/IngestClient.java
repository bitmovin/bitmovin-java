package com.bitmovin.api.encoding.encodings.inputStreams.ingest;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface IngestClient {
    
    @RequestLine("POST /encoding/encodings/{encoding_id}/input-streams/ingest")
    IngestInputStream create(@Param("encoding_id") String encodingId, IngestInputStream ingestInputStream) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/encodings/{encoding_id}/input-streams/ingest/{input_stream_id}")
    BitmovinResponse delete(@Param("encoding_id") String encodingId, @Param("input_stream_id") String inputStreamId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/input-streams/ingest/{input_stream_id}")
    IngestInputStream get(@Param("encoding_id") String encodingId, @Param("input_stream_id") String inputStreamId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/input-streams/ingest")
    List<IngestInputStream> list(@Param("encoding_id") String encodingId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
