package com.bitmovin.api.encoding.manifests.dash.periods.adaptationsets.representations.fmp4;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface Fmp4Client {
    
    @RequestLine("POST /encoding/manifests/dash/{manifest_id}/periods/{period_id}/adaptationsets/{adaptationset_id}/representations/fmp4")
    DashFmp4Representation create(@Param("manifest_id") String manifestId, @Param("period_id") String periodId, @Param("adaptationset_id") String adaptationsetId, DashFmp4Representation dashFmp4Representation) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/manifests/dash/{manifest_id}/periods/{period_id}/adaptationsets/{adaptationset_id}/representations/fmp4/{representation_id}")
    BitmovinResponse delete(@Param("manifest_id") String manifestId, @Param("period_id") String periodId, @Param("adaptationset_id") String adaptationsetId, @Param("representation_id") String representationId) throws BitmovinException;
    
    @RequestLine("GET /encoding/manifests/dash/{manifest_id}/periods/{period_id}/adaptationsets/{adaptationset_id}/representations/fmp4/{representation_id}")
    DashFmp4Representation get(@Param("manifest_id") String manifestId, @Param("period_id") String periodId, @Param("adaptationset_id") String adaptationsetId, @Param("representation_id") String representationId) throws BitmovinException;
    
    @RequestLine("GET /encoding/manifests/dash/{manifest_id}/periods/{period_id}/adaptationsets/{adaptationset_id}/representations/fmp4")
    List<DashFmp4Representation> list(@Param("manifest_id") String manifestId, @Param("period_id") String periodId, @Param("adaptationset_id") String adaptationsetId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
