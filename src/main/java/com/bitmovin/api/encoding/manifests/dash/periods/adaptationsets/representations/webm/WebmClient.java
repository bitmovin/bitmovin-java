package com.bitmovin.api.encoding.manifests.dash.periods.adaptationsets.representations.webm;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface WebmClient {
    
    @RequestLine("POST /encoding/manifests/dash/{manifest_id}/periods/{period_id}/adaptationsets/{adaptationset_id}/representations/webm")
    DashWebmRepresentation create(@Param("manifest_id") String manifestId, @Param("period_id") String periodId, @Param("adaptationset_id") String adaptationsetId, DashWebmRepresentation dashWebmRepresentation) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/manifests/dash/{manifest_id}/periods/{period_id}/adaptationsets/{adaptationset_id}/representations/webm/{representation_id}")
    BitmovinResponse delete(@Param("manifest_id") String manifestId, @Param("period_id") String periodId, @Param("adaptationset_id") String adaptationsetId, @Param("representation_id") String representationId) throws BitmovinException;
    
    @RequestLine("GET /encoding/manifests/dash/{manifest_id}/periods/{period_id}/adaptationsets/{adaptationset_id}/representations/webm/{representation_id}")
    DashWebmRepresentation get(@Param("manifest_id") String manifestId, @Param("period_id") String periodId, @Param("adaptationset_id") String adaptationsetId, @Param("representation_id") String representationId) throws BitmovinException;
    
    @RequestLine("GET /encoding/manifests/dash/{manifest_id}/periods/{period_id}/adaptationsets/{adaptationset_id}/representations/webm")
    List<DashWebmRepresentation> list(@Param("manifest_id") String manifestId, @Param("period_id") String periodId, @Param("adaptationset_id") String adaptationsetId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
