package com.bitmovin.api.encoding.encodings.muxings;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface MuxingsClient {
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/muxings")
    List<Muxing> list(@Param("encoding_id") String encodingId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
