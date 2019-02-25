package com.bitmovin.api.encoding.configurations.audio.vorbis;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface VorbisClient {
    
    @RequestLine("POST /encoding/configurations/audio/vorbis")
    VorbisAudioConfiguration create(VorbisAudioConfiguration vorbisAudioConfiguration) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/configurations/audio/vorbis/{configuration_id}")
    BitmovinResponse delete(@Param("configuration_id") String configurationId) throws BitmovinException;
    
    @RequestLine("GET /encoding/configurations/audio/vorbis/{configuration_id}")
    VorbisAudioConfiguration get(@Param("configuration_id") String configurationId) throws BitmovinException;
    
    @RequestLine("GET /encoding/configurations/audio/vorbis")
    List<VorbisAudioConfiguration> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
