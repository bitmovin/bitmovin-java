package com.bitmovin.api.encoding.encodings.muxings.fmp4.drm.cenc;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface CencClient {
    
    @RequestLine("POST /encoding/encodings/{encoding_id}/muxings/fmp4/{muxing_id}/drm/cenc")
    CencDrm create(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId, CencDrm cencDrm) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/encodings/{encoding_id}/muxings/fmp4/{muxing_id}/drm/cenc/{drm_id}")
    BitmovinResponse delete(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId, @Param("drm_id") String drmId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/muxings/fmp4/{muxing_id}/drm/cenc/{drm_id}")
    CencDrm get(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId, @Param("drm_id") String drmId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/muxings/fmp4/{muxing_id}/drm/cenc")
    List<CencDrm> list(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
