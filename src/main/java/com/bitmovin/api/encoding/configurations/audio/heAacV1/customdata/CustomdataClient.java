package com.bitmovin.api.encoding.configurations.audio.heAacV1.customdata;

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
    
    @RequestLine("GET /encoding/configurations/audio/he-aac-v1/{configuration_id}/customData")
    CustomData getCustomData(@Param("configuration_id") String configurationId) throws BitmovinException;
}
