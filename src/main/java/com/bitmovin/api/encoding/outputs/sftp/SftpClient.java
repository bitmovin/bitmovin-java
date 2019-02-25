package com.bitmovin.api.encoding.outputs.sftp;

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
    
    @RequestLine("POST /encoding/outputs/sftp")
    SftpOutput create(SftpOutput sftpOutput) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/outputs/sftp/{output_id}")
    SftpOutput delete(@Param("output_id") String outputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/outputs/sftp/{output_id}")
    SftpOutput get(@Param("output_id") String outputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/outputs/sftp")
    List<SftpOutput> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
