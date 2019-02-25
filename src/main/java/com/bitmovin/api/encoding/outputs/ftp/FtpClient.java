package com.bitmovin.api.encoding.outputs.ftp;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface FtpClient {
    
    @RequestLine("POST /encoding/outputs/ftp")
    FtpOutput create(FtpOutput ftpOutput) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/outputs/ftp/{output_id}")
    FtpOutput delete(@Param("output_id") String outputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/outputs/ftp/{output_id}")
    FtpOutput get(@Param("output_id") String outputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/outputs/ftp")
    List<FtpOutput> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
