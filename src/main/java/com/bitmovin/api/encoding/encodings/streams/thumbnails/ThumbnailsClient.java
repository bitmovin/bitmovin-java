package com.bitmovin.api.encoding.encodings.streams.thumbnails;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface ThumbnailsClient {
    
    @RequestLine("POST /encoding/encodings/{encoding_id}/streams/{stream_id}/thumbnails")
    Thumbnail create(@Param("encoding_id") String encodingId, @Param("stream_id") String streamId, Thumbnail thumbnail) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/encodings/{encoding_id}/streams/{stream_id}/thumbnails/{thumbnail_id}")
    BitmovinResponse delete(@Param("encoding_id") String encodingId, @Param("stream_id") String streamId, @Param("thumbnail_id") String thumbnailId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/streams/{stream_id}/thumbnails/{thumbnail_id}")
    Thumbnail get(@Param("encoding_id") String encodingId, @Param("stream_id") String streamId, @Param("thumbnail_id") String thumbnailId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/streams/{stream_id}/thumbnails")
    List<Thumbnail> list(@Param("encoding_id") String encodingId, @Param("stream_id") String streamId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
