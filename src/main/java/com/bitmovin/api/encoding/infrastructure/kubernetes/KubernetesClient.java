package com.bitmovin.api.encoding.infrastructure.kubernetes;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface KubernetesClient {
    
    @RequestLine("POST /encoding/infrastructure/kubernetes")
    KubernetesCluster create(KubernetesCluster kubernetesCluster) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/infrastructure/kubernetes/{infrastructure_id}")
    BitmovinResponse delete(@Param("infrastructure_id") String infrastructureId) throws BitmovinException;
    
    @RequestLine("GET /encoding/infrastructure/kubernetes/{infrastructure_id}")
    KubernetesCluster get(@Param("infrastructure_id") String infrastructureId) throws BitmovinException;
    
    @RequestLine("GET /encoding/infrastructure/kubernetes")
    List<KubernetesCluster> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
