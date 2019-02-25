package com.bitmovin.api.encoding.encodings.muxings.ts.drm.aes;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface AesClient {
    
    @RequestLine("POST /encoding/encodings/{encoding_id}/muxings/ts/{muxing_id}/drm/aes")
    AesEncryptionDrm create(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId, AesEncryptionDrm aesEncryptionDrm) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/encodings/{encoding_id}/muxings/ts/{muxing_id}/drm/aes/{drm_id}")
    BitmovinResponse delete(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId, @Param("drm_id") String drmId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/muxings/ts/{muxing_id}/drm/aes/{drm_id}")
    AesEncryptionDrm get(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId, @Param("drm_id") String drmId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/muxings/ts/{muxing_id}/drm/aes")
    List<AesEncryptionDrm> list(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
