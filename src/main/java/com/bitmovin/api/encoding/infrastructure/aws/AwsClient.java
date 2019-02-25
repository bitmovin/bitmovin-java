package com.bitmovin.api.encoding.infrastructure.aws;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface AwsClient {
    
    @RequestLine("POST /encoding/infrastructure/aws")
    AwsAccount create(AwsAccount awsAccount) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/infrastructure/aws/{infrastructure_id}")
    AwsAccount delete(@Param("infrastructure_id") String infrastructureId) throws BitmovinException;
    
    @RequestLine("GET /encoding/infrastructure/aws/{infrastructure_id}")
    AwsAccount get(@Param("infrastructure_id") String infrastructureId) throws BitmovinException;
    
    @RequestLine("GET /encoding/infrastructure/aws")
    List<AwsAccount> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
