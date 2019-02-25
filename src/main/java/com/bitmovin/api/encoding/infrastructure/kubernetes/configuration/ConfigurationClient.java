package com.bitmovin.api.encoding.infrastructure.kubernetes.configuration;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface ConfigurationClient {
    
    @RequestLine("GET /encoding/infrastructure/kubernetes/{infrastructure_id}/configuration")
    KubernetesClusterConfiguration get(@Param("infrastructure_id") String infrastructureId) throws BitmovinException;
    
    @RequestLine("PUT /encoding/infrastructure/kubernetes/{infrastructure_id}/configuration")
    KubernetesClusterConfiguration putEncodingInfrastructureKubernetesConfigurationByInfrastructureId(@Param("infrastructure_id") String infrastructureId, KubernetesClusterConfiguration kubernetesClusterConfiguration) throws BitmovinException;
}
