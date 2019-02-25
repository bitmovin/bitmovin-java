package com.bitmovin.api.player.customBuilds.web.status;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface StatusClient {
    
    @RequestLine("GET /player/custom-builds/web/{custom_build_id}/status")
    CustomPlayerBuildStatus get(@Param("custom_build_id") String customBuildId) throws BitmovinException;
}
