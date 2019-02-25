package com.bitmovin.api.encoding.configurations.audio.heAacV1;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface HeAacV1Client {
    
    @RequestLine("POST /encoding/configurations/audio/he-aac-v1")
    HeAacV1AudioConfiguration create(HeAacV1AudioConfiguration heAacV1AudioConfiguration) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/configurations/audio/he-aac-v1/{configuration_id}")
    BitmovinResponse delete(@Param("configuration_id") String configurationId) throws BitmovinException;
    
    @RequestLine("GET /encoding/configurations/audio/he-aac-v1/{configuration_id}")
    HeAacV1AudioConfiguration get(@Param("configuration_id") String configurationId) throws BitmovinException;
    
    @RequestLine("GET /encoding/configurations/audio/he-aac-v1")
    List<HeAacV1AudioConfiguration> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
