package com.bitmovin.api.encoding.filters.denoiseHqdn3d;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface DenoiseHqdn3dClient {
    
    @RequestLine("POST /encoding/filters/denoise-hqdn3d")
    DenoiseHqdn3dFilter create(DenoiseHqdn3dFilter denoiseHqdn3dFilter) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/filters/denoise-hqdn3d/{filter_id}")
    BitmovinResponse delete(@Param("filter_id") String filterId) throws BitmovinException;
    
    @RequestLine("GET /encoding/filters/denoise-hqdn3d/{filter_id}")
    DenoiseHqdn3dFilter get(@Param("filter_id") String filterId) throws BitmovinException;
    
    @RequestLine("GET /encoding/filters/denoise-hqdn3d")
    List<DenoiseHqdn3dFilter> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
