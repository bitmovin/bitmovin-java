package com.bitmovin.api.encoding.configurations.video.h264;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface H264Client {
    
    @RequestLine("POST /encoding/configurations/video/h264")
    H264VideoConfiguration create(H264VideoConfiguration h264VideoConfiguration) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/configurations/video/h264/{configuration_id}")
    BitmovinResponse delete(@Param("configuration_id") String configurationId) throws BitmovinException;
    
    @RequestLine("GET /encoding/configurations/video/h264/{configuration_id}")
    H264VideoConfiguration get(@Param("configuration_id") String configurationId) throws BitmovinException;
    
    @RequestLine("GET /encoding/configurations/video/h264")
    List<H264VideoConfiguration> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
