package com.bitmovin.api.player.channels;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface ChannelsClient {
    
    @RequestLine("GET /player/channels")
    List<PlayerChannel> list() throws BitmovinException;
}
