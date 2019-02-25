package com.bitmovin.api.encoding.encodings.muxings.progressiveTs.id3.frameId;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface FrameIdClient {
    
    @RequestLine("POST /encoding/encodings/{encoding_id}/muxings/progressive-ts/{muxing_id}/id3/frame-id")
    FrameIdId3Tag create(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId, FrameIdId3Tag frameIdId3Tag) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/encodings/{encoding_id}/muxings/progressive-ts/{muxing_id}/id3/frame-id/{id3_tag_id}")
    BitmovinResponse delete(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId, @Param("id3_tag_id") String id3TagId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/muxings/progressive-ts/{muxing_id}/id3/frame-id/{id3_tag_id}")
    FrameIdId3Tag get(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId, @Param("id3_tag_id") String id3TagId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/muxings/progressive-ts/{muxing_id}/id3/frame-id")
    List<FrameIdId3Tag> list(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
