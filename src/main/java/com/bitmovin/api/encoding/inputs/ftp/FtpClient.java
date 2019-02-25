package com.bitmovin.api.encoding.inputs.ftp;

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
    
    @RequestLine("POST /encoding/inputs/ftp")
    FtpInput create(FtpInput ftpInput) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/inputs/ftp/{input_id}")
    FtpInput delete(@Param("input_id") String inputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/inputs/ftp/{input_id}")
    FtpInput get(@Param("input_id") String inputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/inputs/ftp")
    List<FtpInput> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
