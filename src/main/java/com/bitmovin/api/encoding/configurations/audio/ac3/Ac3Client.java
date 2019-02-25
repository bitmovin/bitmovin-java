package com.bitmovin.api.encoding.configurations.audio.ac3;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface Ac3Client {
    
    @RequestLine("POST /encoding/configurations/audio/ac3")
    Ac3AudioConfiguration create(Ac3AudioConfiguration ac3AudioConfiguration) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/configurations/audio/ac3/{configuration_id}")
    BitmovinResponse delete(@Param("configuration_id") String configurationId) throws BitmovinException;
    
    @RequestLine("GET /encoding/configurations/audio/ac3/{configuration_id}")
    Ac3AudioConfiguration get(@Param("configuration_id") String configurationId) throws BitmovinException;
    
    @RequestLine("GET /encoding/configurations/audio/ac3")
    List<Ac3AudioConfiguration> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
