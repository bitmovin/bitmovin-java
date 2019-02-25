package com.bitmovin.api.encoding.filters.audioVolume.customdata;

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
    
    @RequestLine("GET /encoding/filters/audio-volume/{filter_id}/customData")
    CustomData getCustomData(@Param("filter_id") String filterId) throws BitmovinException;
}
