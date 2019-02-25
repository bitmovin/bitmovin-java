package com.bitmovin.api.encoding.encodings.muxings.ts.captions.cea;

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
    
    @RequestLine("POST /encoding/encodings/{encoding_id}/muxings/ts/{muxing_id}/captions/cea")
    CaptionsEmbedCea create(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId, CaptionsEmbedCea captionsEmbedCea) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/encodings/{encoding_id}/muxings/ts/{muxing_id}/captions/cea/{captions_id}")
    CaptionsEmbedCea delete(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId, @Param("captions_id") String captionsId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/muxings/ts/{muxing_id}/captions/cea/{captions_id}")
    CaptionsEmbedCea get(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId, @Param("captions_id") String captionsId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/muxings/ts/{muxing_id}/captions/cea")
    List<CaptionsEmbedCea> list(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
