package com.bitmovin.api.player.customBuilds.web;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface WebClient {
    
    @RequestLine("POST /player/custom-builds/web")
    CustomPlayerBuildDetails create(CustomPlayerBuildDetails customPlayerBuildDetails) throws BitmovinException;
    
    @RequestLine("GET /player/custom-builds/web/{custom_build_id}")
    CustomPlayerBuildStatus get(@Param("custom_build_id") String customBuildId) throws BitmovinException;
    
    @RequestLine("GET /player/custom-builds/web")
    List<CustomPlayerBuildDetails> list() throws BitmovinException;
    @Headers("Content-Type: text/plain")
    @Body(" ")
    
    @RequestLine("POST /player/custom-builds/web/{custom_build_id}/start")
    BitmovinResponse start(@Param("custom_build_id") String customBuildId) throws BitmovinException;
}
