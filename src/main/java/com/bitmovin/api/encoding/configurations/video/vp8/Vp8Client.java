package com.bitmovin.api.encoding.configurations.video.vp8;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface Vp8Client {
    
    @RequestLine("POST /encoding/configurations/video/vp8")
    Vp8VideoConfiguration create(Vp8VideoConfiguration vp8VideoConfiguration) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/configurations/video/vp8/{configuration_id}")
    BitmovinResponse delete(@Param("configuration_id") String configurationId) throws BitmovinException;
    
    @RequestLine("GET /encoding/configurations/video/vp8/{configuration_id}")
    Vp8VideoConfiguration get(@Param("configuration_id") String configurationId) throws BitmovinException;
    
    @RequestLine("GET /encoding/configurations/video/vp8")
    List<Vp8VideoConfiguration> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
