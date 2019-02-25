package com.bitmovin.api.encoding.filters.audioMix.customdata;

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
    
    @RequestLine("GET /encoding/filters/audio-mix/{filter_id}/customData")
    CustomData getCustomData(@Param("filter_id") String filterId) throws BitmovinException;
}
