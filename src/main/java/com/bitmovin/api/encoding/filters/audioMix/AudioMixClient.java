package com.bitmovin.api.encoding.filters.audioMix;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface AudioMixClient {
    
    @RequestLine("POST /encoding/filters/audio-mix")
    AudioMixFilter create(AudioMixFilter audioMixFilter) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/filters/audio-mix/{filter_id}")
    BitmovinResponse delete(@Param("filter_id") String filterId) throws BitmovinException;
    
    @RequestLine("GET /encoding/filters/audio-mix/{filter_id}")
    AudioMixFilter get(@Param("filter_id") String filterId) throws BitmovinException;
    
    @RequestLine("GET /encoding/filters/audio-mix")
    List<AudioMixFilter> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
