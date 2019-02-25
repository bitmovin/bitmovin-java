package com.bitmovin.api.player.channels.versions;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface VersionsClient {
    
    @RequestLine("GET /player/channels/{channel_name}/versions")
    List<PlayerVersion> list(@Param("channel_name") String channelName) throws BitmovinException;
}
