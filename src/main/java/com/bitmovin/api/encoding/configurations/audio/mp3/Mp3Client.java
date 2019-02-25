package com.bitmovin.api.encoding.configurations.audio.mp3;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface Mp3Client {
    
    @RequestLine("POST /encoding/configurations/audio/mp3")
    Mp3AudioConfiguration create(Mp3AudioConfiguration mp3AudioConfiguration) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/configurations/audio/mp3/{configuration_id}")
    BitmovinResponse delete(@Param("configuration_id") String configurationId) throws BitmovinException;
    
    @RequestLine("GET /encoding/configurations/audio/mp3/{configuration_id}")
    Mp3AudioConfiguration get(@Param("configuration_id") String configurationId) throws BitmovinException;
    
    @RequestLine("GET /encoding/configurations/audio/mp3")
    List<Mp3AudioConfiguration> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
