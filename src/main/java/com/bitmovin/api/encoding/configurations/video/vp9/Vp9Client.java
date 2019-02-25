package com.bitmovin.api.encoding.configurations.video.vp9;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface Vp9Client {
    
    @RequestLine("POST /encoding/configurations/video/vp9")
    Vp9VideoConfiguration create(Vp9VideoConfiguration vp9VideoConfiguration) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/configurations/video/vp9/{configuration_id}")
    BitmovinResponse delete(@Param("configuration_id") String configurationId) throws BitmovinException;
    
    @RequestLine("GET /encoding/configurations/video/vp9/{configuration_id}")
    Vp9VideoConfiguration get(@Param("configuration_id") String configurationId) throws BitmovinException;
    
    @RequestLine("GET /encoding/configurations/video/vp9")
    List<Vp9VideoConfiguration> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
