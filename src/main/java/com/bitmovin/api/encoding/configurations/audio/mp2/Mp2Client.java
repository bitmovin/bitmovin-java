package com.bitmovin.api.encoding.configurations.audio.mp2;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface Mp2Client {
    
    @RequestLine("POST /encoding/configurations/audio/mp2")
    Mp2AudioConfiguration create(Mp2AudioConfiguration mp2AudioConfiguration) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/configurations/audio/mp2/{configuration_id}")
    BitmovinResponse delete(@Param("configuration_id") String configurationId) throws BitmovinException;
    
    @RequestLine("GET /encoding/configurations/audio/mp2/{configuration_id}")
    Mp2AudioConfiguration get(@Param("configuration_id") String configurationId) throws BitmovinException;
}
