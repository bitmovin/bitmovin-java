package com.bitmovin.api.encoding.encodings.captions.cea;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface CeaClient {
    
    @RequestLine("POST /encoding/encodings/{encoding_id}/captions/cea")
    CaptionsCea create(@Param("encoding_id") String encodingId, CaptionsCea captionsCea) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/encodings/{encoding_id}/captions/cea/{captions_id}")
    CaptionsCea delete(@Param("encoding_id") String encodingId, @Param("captions_id") String captionsId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/captions/cea/{captions_id}")
    CaptionsCea get(@Param("encoding_id") String encodingId, @Param("captions_id") String captionsId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/captions/cea")
    List<CaptionsCea> list(@Param("encoding_id") String encodingId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
