package com.bitmovin.api.encoding.encodings.muxings.progressiveMov.information;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface InformationClient {
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/muxings/progressive-mov/{muxing_id}/information")
    ProgressiveMovMuxingInformation get(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId) throws BitmovinException;
}
