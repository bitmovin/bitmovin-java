package com.bitmovin.api.encoding.inputs.sftp;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface SftpClient {
    
    @RequestLine("POST /encoding/inputs/sftp")
    SftpInput create(SftpInput sftpInput) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/inputs/sftp/{input_id}")
    SftpInput delete(@Param("input_id") String inputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/inputs/sftp/{input_id}")
    SftpInput get(@Param("input_id") String inputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/inputs/sftp")
    List<SftpInput> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
