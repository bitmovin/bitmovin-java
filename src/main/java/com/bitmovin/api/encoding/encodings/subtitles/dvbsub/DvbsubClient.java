package com.bitmovin.api.encoding.encodings.subtitles.dvbsub;

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
    
    @RequestLine("POST /encoding/encodings/{encoding_id}/subtitles/dvbsub")
    DvbSubtitleSidecarDetails create(@Param("encoding_id") String encodingId, DvbSubtitleSidecarDetails dvbSubtitleSidecarDetails) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/encodings/{encoding_id}/subtitles/dvbsub/{subtitle_id}")
    BitmovinResponse delete(@Param("encoding_id") String encodingId, @Param("subtitle_id") String subtitleId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/subtitles/dvbsub/{subtitle_id}")
    DvbSubtitleSidecarDetails get(@Param("encoding_id") String encodingId, @Param("subtitle_id") String subtitleId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/subtitles/dvbsub")
    List<DvbSubtitleSidecarDetails> list(@Param("encoding_id") String encodingId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
