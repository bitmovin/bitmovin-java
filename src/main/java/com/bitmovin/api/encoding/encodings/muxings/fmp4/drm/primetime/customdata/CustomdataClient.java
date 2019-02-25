package com.bitmovin.api.encoding.encodings.muxings.fmp4.drm.primetime.customdata;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface CustomdataClient {
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/muxings/fmp4/{muxing_id}/drm/primetime/{drm_id}/customData")
    CustomData getCustomData(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId, @Param("drm_id") String drmId) throws BitmovinException;
}
