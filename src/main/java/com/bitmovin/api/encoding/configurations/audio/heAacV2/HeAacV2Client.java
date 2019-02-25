package com.bitmovin.api.encoding.configurations.audio.heAacV2;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface HeAacV2Client {
    
    @RequestLine("POST /encoding/configurations/audio/he-aac-v2")
    HeAacV2AudioConfiguration create(HeAacV2AudioConfiguration heAacV2AudioConfiguration) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/configurations/audio/he-aac-v2/{configuration_id}")
    BitmovinResponse delete(@Param("configuration_id") String configurationId) throws BitmovinException;
    
    @RequestLine("GET /encoding/configurations/audio/he-aac-v2/{configuration_id}")
    HeAacV2AudioConfiguration get(@Param("configuration_id") String configurationId) throws BitmovinException;
    
    @RequestLine("GET /encoding/configurations/audio/he-aac-v2")
    List<HeAacV2AudioConfiguration> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
