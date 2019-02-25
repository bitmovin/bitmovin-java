package com.bitmovin.api.encoding.configurations.audio.opus;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface OpusClient {
    
    @RequestLine("POST /encoding/configurations/audio/opus")
    OpusAudioConfiguration create(OpusAudioConfiguration opusAudioConfiguration) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/configurations/audio/opus/{configuration_id}")
    BitmovinResponse delete(@Param("configuration_id") String configurationId) throws BitmovinException;
    
    @RequestLine("GET /encoding/configurations/audio/opus/{configuration_id}")
    OpusAudioConfiguration get(@Param("configuration_id") String configurationId) throws BitmovinException;
    
    @RequestLine("GET /encoding/configurations/audio/opus")
    List<OpusAudioConfiguration> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
