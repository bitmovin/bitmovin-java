package com.bitmovin.api.encoding.manifests.dash.periods.adaptationsets.custom;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface CustomClient {
    
    @RequestLine("POST /encoding/manifests/dash/{manifest_id}/periods/{period_id}/adaptationsets/custom")
    AdaptationSet create(@Param("manifest_id") String manifestId, @Param("period_id") String periodId, AdaptationSet adaptationSet) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/manifests/dash/{manifest_id}/periods/{period_id}/adaptationsets/custom/{adaptationset_id}")
    BitmovinResponse delete(@Param("manifest_id") String manifestId, @Param("period_id") String periodId, @Param("adaptationset_id") String adaptationsetId) throws BitmovinException;
    
    @RequestLine("GET /encoding/manifests/dash/{manifest_id}/periods/{period_id}/adaptationsets/custom/{adaptationset_id}")
    AdaptationSet get(@Param("manifest_id") String manifestId, @Param("period_id") String periodId, @Param("adaptationset_id") String adaptationsetId) throws BitmovinException;
    
    @RequestLine("GET /encoding/manifests/dash/{manifest_id}/periods/{period_id}/adaptationsets/custom")
    List<AdaptationSet> list(@Param("manifest_id") String manifestId, @Param("period_id") String periodId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
