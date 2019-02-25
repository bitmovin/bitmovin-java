package com.bitmovin.api.encoding.configurations.video.mjpeg;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface MjpegClient {
    
    @RequestLine("POST /encoding/configurations/video/mjpeg")
    MjpegVideoConfiguration create(MjpegVideoConfiguration mjpegVideoConfiguration) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/configurations/video/mjpeg/{configuration_id}")
    BitmovinResponse delete(@Param("configuration_id") String configurationId) throws BitmovinException;
    
    @RequestLine("GET /encoding/configurations/video/mjpeg/{configuration_id}")
    MjpegVideoConfiguration get(@Param("configuration_id") String configurationId) throws BitmovinException;
    
    @RequestLine("GET /encoding/configurations/video/mjpeg")
    List<MjpegVideoConfiguration> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
