package com.bitmovin.api.encoding.encodings.captions.scc;

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
    
    @RequestLine("POST /encoding/encodings/{encoding_id}/captions/scc")
    ConvertSccCaption create(@Param("encoding_id") String encodingId, ConvertSccCaption convertSccCaption) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/encodings/{encoding_id}/captions/scc/{captions_id}")
    BitmovinResponse delete(@Param("encoding_id") String encodingId, @Param("captions_id") String captionsId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/captions/scc/{captions_id}")
    ConvertSccCaption get(@Param("encoding_id") String encodingId, @Param("captions_id") String captionsId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/captions/scc")
    List<ConvertSccCaption> list(@Param("encoding_id") String encodingId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
