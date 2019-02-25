package com.bitmovin.api.encoding.encodings.streams.input;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface InputClient {
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/streams/{stream_id}/input")
    EncodingStreamInputDetails get(@Param("encoding_id") String encodingId, @Param("stream_id") String streamId) throws BitmovinException;
}
