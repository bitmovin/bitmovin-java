package com.bitmovin.api.encoding.encodings.streams.captions.cea.scc;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface SccClient {
    
    @RequestLine("POST /encoding/encodings/{encoding_id}/streams/{stream_id}/captions/608-708/scc")
    SccCaption create(@Param("encoding_id") String encodingId, @Param("stream_id") String streamId, SccCaption sccCaption) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/encodings/{encoding_id}/streams/{stream_id}/captions/608-708/scc/{captions_id}")
    BitmovinResponse delete(@Param("encoding_id") String encodingId, @Param("stream_id") String streamId, @Param("captions_id") String captionsId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/streams/{stream_id}/captions/608-708/scc/{captions_id}")
    SccCaption get(@Param("encoding_id") String encodingId, @Param("stream_id") String streamId, @Param("captions_id") String captionsId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/streams/{stream_id}/captions/608-708/scc")
    List<SccCaption> list(@Param("encoding_id") String encodingId, @Param("stream_id") String streamId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
