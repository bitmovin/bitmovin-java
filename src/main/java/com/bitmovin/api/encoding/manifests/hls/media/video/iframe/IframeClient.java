package com.bitmovin.api.encoding.manifests.hls.media.video.iframe;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface IframeClient {
    
    @RequestLine("POST /encoding/manifests/hls/{manifest_id}/media/video/{media_id}/iframe")
    IFramePlaylist create(@Param("manifest_id") String manifestId, @Param("media_id") String mediaId, IFramePlaylist iframePlaylist) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/manifests/hls/{manifest_id}/media/video/{media_id}/iframe/{iframe_id}")
    BitmovinResponse delete(@Param("manifest_id") String manifestId, @Param("media_id") String mediaId, @Param("iframe_id") String iframeId) throws BitmovinException;
    
    @RequestLine("GET /encoding/manifests/hls/{manifest_id}/media/video/{media_id}/iframe/{iframe_id}")
    IFramePlaylist get(@Param("manifest_id") String manifestId, @Param("media_id") String mediaId, @Param("iframe_id") String iframeId) throws BitmovinException;
    
    @RequestLine("GET /encoding/manifests/hls/{manifest_id}/media/video/{media_id}/iframe")
    List<IFramePlaylist> list(@Param("manifest_id") String manifestId, @Param("media_id") String mediaId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
