package com.bitmovin.api.encoding.encodings.streams.subtitles.dvbsub;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface DvbsubClient {
    
    @RequestLine("POST /encoding/encodings/{encoding_id}/streams/{stream_id}/subtitles/dvbsub")
    StreamDvbSubSubtitle create(@Param("encoding_id") String encodingId, @Param("stream_id") String streamId, StreamDvbSubSubtitle streamDvbSubSubtitle) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/encodings/{encoding_id}/streams/{stream_id}/subtitles/dvbsub/{subtitle_id}")
    BitmovinResponse delete(@Param("encoding_id") String encodingId, @Param("stream_id") String streamId, @Param("subtitle_id") String subtitleId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/streams/{stream_id}/subtitles/dvbsub/{subtitle_id}")
    StreamDvbSubSubtitle get(@Param("encoding_id") String encodingId, @Param("stream_id") String streamId, @Param("subtitle_id") String subtitleId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/streams/{stream_id}/subtitles/dvbsub")
    List<StreamDvbSubSubtitle> list(@Param("encoding_id") String encodingId, @Param("stream_id") String streamId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
