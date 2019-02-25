package com.bitmovin.api.encoding.configurations.video.h265;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface H265Client {
    
    @RequestLine("POST /encoding/configurations/video/h265")
    H265VideoConfiguration create(H265VideoConfiguration h265VideoConfiguration) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/configurations/video/h265/{configuration_id}")
    BitmovinResponse delete(@Param("configuration_id") String configurationId) throws BitmovinException;
    
    @RequestLine("GET /encoding/configurations/video/h265/{configuration_id}")
    H265VideoConfiguration get(@Param("configuration_id") String configurationId) throws BitmovinException;
    
    @RequestLine("GET /encoding/configurations/video/h265")
    List<H265VideoConfiguration> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
