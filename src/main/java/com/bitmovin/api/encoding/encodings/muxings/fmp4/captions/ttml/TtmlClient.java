package com.bitmovin.api.encoding.encodings.muxings.fmp4.captions.ttml;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface TtmlClient {
    
    @RequestLine("POST /encoding/encodings/{encoding_id}/muxings/fmp4/{muxing_id}/captions/ttml")
    TtmlEmbed create(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId, TtmlEmbed ttmlEmbed) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/encodings/{encoding_id}/muxings/fmp4/{muxing_id}/captions/ttml/{captions_id}")
    TtmlEmbed delete(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId, @Param("captions_id") String captionsId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/muxings/fmp4/{muxing_id}/captions/ttml/{captions_id}")
    TtmlEmbed get(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId, @Param("captions_id") String captionsId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/muxings/fmp4/{muxing_id}/captions/ttml")
    List<TtmlEmbed> list(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
