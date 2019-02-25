package com.bitmovin.api.encoding.encodings.streams.filters;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface FiltersClient {
    
    @RequestLine("POST /encoding/encodings/{encoding_id}/streams/{stream_id}/filters")
    StreamFilterList create(@Param("encoding_id") String encodingId, @Param("stream_id") String streamId, List<StreamFilter> streamFilter) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/encodings/{encoding_id}/streams/{stream_id}/filters/{filter_id}")
    BitmovinResponse delete(@Param("encoding_id") String encodingId, @Param("stream_id") String streamId, @Param("filter_id") String filterId) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/encodings/{encoding_id}/streams/{stream_id}/filters")
    BitmovinResponseList deleteAll(@Param("encoding_id") String encodingId, @Param("stream_id") String streamId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/streams/{stream_id}/filters")
    StreamFilterList list(@Param("encoding_id") String encodingId, @Param("stream_id") String streamId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
