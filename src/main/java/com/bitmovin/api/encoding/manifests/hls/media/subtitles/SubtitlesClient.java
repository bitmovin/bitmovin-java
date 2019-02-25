package com.bitmovin.api.encoding.manifests.hls.media.subtitles;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface SubtitlesClient {
    
    @RequestLine("POST /encoding/manifests/hls/{manifest_id}/media/subtitles")
    SubtitlesMediaInfo create(@Param("manifest_id") String manifestId, SubtitlesMediaInfo subtitlesMediaInfo) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/manifests/hls/{manifest_id}/media/subtitles/{media_id}")
    BitmovinResponse delete(@Param("manifest_id") String manifestId, @Param("media_id") String mediaId) throws BitmovinException;
    
    @RequestLine("GET /encoding/manifests/hls/{manifest_id}/media/subtitles/{media_id}")
    SubtitlesMediaInfo get(@Param("manifest_id") String manifestId, @Param("media_id") String mediaId) throws BitmovinException;
    
    @RequestLine("GET /encoding/manifests/hls/{manifest_id}/media/subtitles")
    List<SubtitlesMediaInfo> list(@Param("manifest_id") String manifestId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
