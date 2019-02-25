package com.bitmovin.api.encoding.encodings.sidecars;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface SidecarsClient {
    
    @RequestLine("POST /encoding/encodings/{encoding_id}/sidecars")
    SidecarFile create(@Param("encoding_id") String encodingId, SidecarFile sidecarFile) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/encodings/{encoding_id}/sidecars/{sidecar_id}")
    BitmovinResponse delete(@Param("encoding_id") String encodingId, @Param("sidecar_id") String sidecarId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/sidecars/{sidecar_id}")
    SidecarFile get(@Param("encoding_id") String encodingId, @Param("sidecar_id") String sidecarId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/sidecars")
    List<SidecarFile> list(@Param("encoding_id") String encodingId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
