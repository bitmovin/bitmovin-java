package com.bitmovin.api.encoding.configurations.audio.eac3;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface Eac3Client {
    
    @RequestLine("POST /encoding/configurations/audio/eac3")
    Eac3AudioConfiguration create(Eac3AudioConfiguration eac3AudioConfiguration) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/configurations/audio/eac3/{configuration_id}")
    BitmovinResponse delete(@Param("configuration_id") String configurationId) throws BitmovinException;
    
    @RequestLine("GET /encoding/configurations/audio/eac3/{configuration_id}")
    Eac3AudioConfiguration get(@Param("configuration_id") String configurationId) throws BitmovinException;
    
    @RequestLine("GET /encoding/configurations/audio/eac3")
    List<Eac3AudioConfiguration> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
