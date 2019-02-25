package com.bitmovin.api.encoding.encodings.streams.burnInSubtitles.srt;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface SrtClient {
    
    @RequestLine("POST /encoding/encodings/{encoding_id}/streams/{stream_id}/burn-in-subtitles/srt")
    BurnInSubtitleSrt create(@Param("encoding_id") String encodingId, @Param("stream_id") String streamId, BurnInSubtitleSrt burnInSubtitleSrt) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/encodings/{encoding_id}/streams/{stream_id}/burn-in-subtitles/srt/{subtitle_id}")
    BitmovinResponse delete(@Param("encoding_id") String encodingId, @Param("stream_id") String streamId, @Param("subtitle_id") String subtitleId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/streams/{stream_id}/burn-in-subtitles/srt/{subtitle_id}")
    BurnInSubtitleSrt get(@Param("encoding_id") String encodingId, @Param("stream_id") String streamId, @Param("subtitle_id") String subtitleId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/streams/{stream_id}/burn-in-subtitles/srt")
    List<BurnInSubtitleSrt> list(@Param("encoding_id") String encodingId, @Param("stream_id") String streamId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
