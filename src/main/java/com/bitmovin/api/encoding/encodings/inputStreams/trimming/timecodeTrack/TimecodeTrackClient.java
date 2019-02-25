package com.bitmovin.api.encoding.encodings.inputStreams.trimming.timecodeTrack;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface TimecodeTrackClient {
    
    @RequestLine("POST /encoding/encodings/{encoding_id}/input-streams/trimming/timecode-track")
    TimecodeTrackTrimmingInputStream create(@Param("encoding_id") String encodingId, TimecodeTrackTrimmingInputStream timecodeTrackTrimmingInputStream) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/encodings/{encoding_id}/input-streams/trimming/timecode-track/{input_stream_id}")
    BitmovinResponse delete(@Param("encoding_id") String encodingId, @Param("input_stream_id") String inputStreamId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/input-streams/trimming/timecode-track/{input_stream_id}")
    TimecodeTrackTrimmingInputStream get(@Param("encoding_id") String encodingId, @Param("input_stream_id") String inputStreamId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/input-streams/trimming/timecode-track")
    List<TimecodeTrackTrimmingInputStream> list(@Param("encoding_id") String encodingId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
