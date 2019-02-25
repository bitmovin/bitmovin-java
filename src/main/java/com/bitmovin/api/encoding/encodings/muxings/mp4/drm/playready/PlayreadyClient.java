package com.bitmovin.api.encoding.encodings.muxings.mp4.drm.playready;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface PlayreadyClient {
    
    @RequestLine("POST /encoding/encodings/{encoding_id}/muxings/mp4/{muxing_id}/drm/playready")
    PlayReadyDrm create(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId, PlayReadyDrm playReadyDrm) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/encodings/{encoding_id}/muxings/mp4/{muxing_id}/drm/playready/{drm_id}")
    BitmovinResponse delete(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId, @Param("drm_id") String drmId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/muxings/mp4/{muxing_id}/drm/playready/{drm_id}")
    PlayReadyDrm get(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId, @Param("drm_id") String drmId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/muxings/mp4/{muxing_id}/drm/playready")
    List<PlayReadyDrm> list(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
