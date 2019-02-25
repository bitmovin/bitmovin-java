package com.bitmovin.api.encoding.filters.audioVolume;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface AudioVolumeClient {
    
    @RequestLine("POST /encoding/filters/audio-volume")
    AudioVolumeFilter create(AudioVolumeFilter audioVolumeFilter) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/filters/audio-volume/{filter_id}")
    BitmovinResponse delete(@Param("filter_id") String filterId) throws BitmovinException;
    
    @RequestLine("GET /encoding/filters/audio-volume/{filter_id}")
    AudioVolumeFilter get(@Param("filter_id") String filterId) throws BitmovinException;
    
    @RequestLine("GET /encoding/filters/audio-volume")
    List<AudioVolumeFilter> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
