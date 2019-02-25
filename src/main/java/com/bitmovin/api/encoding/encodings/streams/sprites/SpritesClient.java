package com.bitmovin.api.encoding.encodings.streams.sprites;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface SpritesClient {
    
    @RequestLine("POST /encoding/encodings/{encoding_id}/streams/{stream_id}/sprites")
    Sprite create(@Param("encoding_id") String encodingId, @Param("stream_id") String streamId, Sprite sprite) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/encodings/{encoding_id}/streams/{stream_id}/sprites/{sprite_id}")
    BitmovinResponse delete(@Param("encoding_id") String encodingId, @Param("stream_id") String streamId, @Param("sprite_id") String spriteId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/streams/{stream_id}/sprites/{sprite_id}")
    Sprite get(@Param("encoding_id") String encodingId, @Param("stream_id") String streamId, @Param("sprite_id") String spriteId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/streams/{stream_id}/sprites")
    List<Sprite> list(@Param("encoding_id") String encodingId, @Param("stream_id") String streamId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
