package com.bitmovin.api.encoding.manifests.dash.periods.adaptationsets.subtitle;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface SubtitleClient {
    
    @RequestLine("POST /encoding/manifests/dash/{manifest_id}/periods/{period_id}/adaptationsets/subtitle")
    SubtitleAdaptationSet create(@Param("manifest_id") String manifestId, @Param("period_id") String periodId, SubtitleAdaptationSet subtitleAdaptationSet) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/manifests/dash/{manifest_id}/periods/{period_id}/adaptationsets/subtitle/{adaptationset_id}")
    BitmovinResponse delete(@Param("manifest_id") String manifestId, @Param("period_id") String periodId, @Param("adaptationset_id") String adaptationsetId) throws BitmovinException;
    
    @RequestLine("GET /encoding/manifests/dash/{manifest_id}/periods/{period_id}/adaptationsets/subtitle/{adaptationset_id}")
    SubtitleAdaptationSet get(@Param("manifest_id") String manifestId, @Param("period_id") String periodId, @Param("adaptationset_id") String adaptationsetId) throws BitmovinException;
    
    @RequestLine("GET /encoding/manifests/dash/{manifest_id}/periods/{period_id}/adaptationsets/subtitle")
    List<SubtitleAdaptationSet> list(@Param("manifest_id") String manifestId, @Param("period_id") String periodId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
