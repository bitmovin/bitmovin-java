package com.bitmovin.api.encoding.manifests.hls.media.type;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface TypeClient {
    
    @RequestLine("GET /encoding/manifests/hls/{manifest_id}/media/{media_id}/type")
    MediaInfoTypeResponse get(@Param("manifest_id") String manifestId, @Param("media_id") String mediaId) throws BitmovinException;
}
