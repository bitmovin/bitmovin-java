package com.bitmovin.api.encoding.infrastructure.aws.regions;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface RegionsClient {
    
    @RequestLine("POST /encoding/infrastructure/aws/{infrastructure_id}/regions/{region}")
    AwsAccountRegionSettings create(@Param("infrastructure_id") String infrastructureId, @Param("region") AwsCloudRegion region, AwsAccountRegionSettings awsAccountRegionSettings) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/infrastructure/aws/{infrastructure_id}/regions/{region}")
    AwsAccountRegionSettings delete(@Param("infrastructure_id") String infrastructureId, @Param("region") AwsCloudRegion region) throws BitmovinException;
    
    @RequestLine("GET /encoding/infrastructure/aws/{infrastructure_id}/regions/{region}")
    AwsAccountRegionSettings get(@Param("infrastructure_id") String infrastructureId, @Param("region") AwsCloudRegion region) throws BitmovinException;
    
    @RequestLine("GET /encoding/infrastructure/aws/{infrastructure_id}/regions")
    List<AwsAccountRegionSettings> list(@Param("infrastructure_id") String infrastructureId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
