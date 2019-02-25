package com.bitmovin.api.encoding.configurations.video.av1;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface Av1Client {
    
    @RequestLine("POST /encoding/configurations/video/av1")
    Av1VideoConfiguration create(Av1VideoConfiguration av1VideoConfiguration) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/configurations/video/av1/{configuration_id}")
    BitmovinResponse delete(@Param("configuration_id") String configurationId) throws BitmovinException;
    
    @RequestLine("GET /encoding/configurations/video/av1/{configuration_id}")
    Av1VideoConfiguration get(@Param("configuration_id") String configurationId) throws BitmovinException;
    
    @RequestLine("GET /encoding/configurations/video/av1")
    List<Av1VideoConfiguration> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
