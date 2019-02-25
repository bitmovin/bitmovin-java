package com.bitmovin.api.encoding.encodings.muxings.fmp4.drm.marlin;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface MarlinClient {
    
    @RequestLine("POST /encoding/encodings/{encoding_id}/muxings/fmp4/{muxing_id}/drm/marlin")
    MarlinDrm create(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId, MarlinDrm marlinDrm) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/encodings/{encoding_id}/muxings/fmp4/{muxing_id}/drm/marlin/{drm_id}")
    BitmovinResponse delete(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId, @Param("drm_id") String drmId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/muxings/fmp4/{muxing_id}/drm/marlin/{drm_id}")
    MarlinDrm get(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId, @Param("drm_id") String drmId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/muxings/fmp4/{muxing_id}/drm/marlin")
    List<MarlinDrm> list(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
