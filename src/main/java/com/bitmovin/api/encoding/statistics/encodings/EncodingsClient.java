package com.bitmovin.api.encoding.statistics.encodings;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface EncodingsClient {
    
    @RequestLine("GET /encoding/statistics/encodings/{encoding_id}")
    EncodingStats get(@Param("encoding_id") String encodingId) throws BitmovinException;
}
