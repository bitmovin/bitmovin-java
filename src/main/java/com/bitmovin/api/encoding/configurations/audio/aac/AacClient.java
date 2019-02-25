package com.bitmovin.api.encoding.configurations.audio.aac;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface AacClient {
    
    @RequestLine("POST /encoding/configurations/audio/aac")
    AacAudioConfiguration create(AacAudioConfiguration aacAudioConfiguration) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/configurations/audio/aac/{configuration_id}")
    BitmovinResponse delete(@Param("configuration_id") String configurationId) throws BitmovinException;
    
    @RequestLine("GET /encoding/configurations/audio/aac/{configuration_id}")
    AacAudioConfiguration get(@Param("configuration_id") String configurationId) throws BitmovinException;
    
    @RequestLine("GET /encoding/configurations/audio/aac")
    List<AacAudioConfiguration> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
