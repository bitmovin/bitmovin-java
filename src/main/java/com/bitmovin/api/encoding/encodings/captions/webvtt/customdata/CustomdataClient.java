package com.bitmovin.api.encoding.encodings.captions.webvtt.customdata;

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
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/captions/webvtt/{captions_id}/customData")
    CustomData getCustomData(@Param("encoding_id") String encodingId, @Param("captions_id") String captionsId) throws BitmovinException;
}
