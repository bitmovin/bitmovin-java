package com.bitmovin.api.encoding.encodings.captions.webvtt;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface WebvttClient {
    
    @RequestLine("POST /encoding/encodings/{encoding_id}/captions/webvtt")
    WebVttExtract create(@Param("encoding_id") String encodingId, WebVttExtract webVttExtract) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/encodings/{encoding_id}/captions/webvtt/{captions_id}")
    WebVttExtract delete(@Param("encoding_id") String encodingId, @Param("captions_id") String captionsId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/captions/webvtt/{captions_id}")
    WebVttExtract get(@Param("encoding_id") String encodingId, @Param("captions_id") String captionsId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/captions/webvtt")
    List<WebVttExtract> list(@Param("encoding_id") String encodingId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
