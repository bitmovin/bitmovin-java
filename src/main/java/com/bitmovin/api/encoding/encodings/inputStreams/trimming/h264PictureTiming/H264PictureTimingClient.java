package com.bitmovin.api.encoding.encodings.inputStreams.trimming.h264PictureTiming;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface H264PictureTimingClient {
    
    @RequestLine("POST /encoding/encodings/{encoding_id}/input-streams/trimming/h264-picture-timing")
    H264PictureTimingTrimmingInputStream create(@Param("encoding_id") String encodingId, H264PictureTimingTrimmingInputStream h264PictureTimingTrimmingInputStream) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/encodings/{encoding_id}/input-streams/trimming/h264-picture-timing/{input_stream_id}")
    BitmovinResponse delete(@Param("encoding_id") String encodingId, @Param("input_stream_id") String inputStreamId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/input-streams/trimming/h264-picture-timing/{input_stream_id}")
    H264PictureTimingTrimmingInputStream get(@Param("encoding_id") String encodingId, @Param("input_stream_id") String inputStreamId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/input-streams/trimming/h264-picture-timing")
    List<H264PictureTimingTrimmingInputStream> list(@Param("encoding_id") String encodingId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
