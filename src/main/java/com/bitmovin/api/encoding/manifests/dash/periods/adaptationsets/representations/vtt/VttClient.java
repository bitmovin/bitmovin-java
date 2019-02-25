package com.bitmovin.api.encoding.manifests.dash.periods.adaptationsets.representations.vtt;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface VttClient {
    
    @RequestLine("POST /encoding/manifests/dash/{manifest_id}/periods/{period_id}/adaptationsets/{adaptationset_id}/representations/vtt")
    DashVttRepresentation create(@Param("manifest_id") String manifestId, @Param("period_id") String periodId, @Param("adaptationset_id") String adaptationsetId, DashVttRepresentation dashVttRepresentation) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/manifests/dash/{manifest_id}/periods/{period_id}/adaptationsets/{adaptationset_id}/representations/vtt/{representation_id}")
    BitmovinResponse delete(@Param("manifest_id") String manifestId, @Param("period_id") String periodId, @Param("adaptationset_id") String adaptationsetId, @Param("representation_id") String representationId) throws BitmovinException;
    
    @RequestLine("GET /encoding/manifests/dash/{manifest_id}/periods/{period_id}/adaptationsets/{adaptationset_id}/representations/vtt/{representation_id}")
    DashVttRepresentation get(@Param("manifest_id") String manifestId, @Param("period_id") String periodId, @Param("adaptationset_id") String adaptationsetId, @Param("representation_id") String representationId) throws BitmovinException;
    
    @RequestLine("GET /encoding/manifests/dash/{manifest_id}/periods/{period_id}/adaptationsets/{adaptationset_id}/representations/vtt")
    List<DashVttRepresentation> list(@Param("manifest_id") String manifestId, @Param("period_id") String periodId, @Param("adaptationset_id") String adaptationsetId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
