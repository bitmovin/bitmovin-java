package com.bitmovin.api.encoding.manifests.dash.periods.adaptationsets.audio;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface AudioClient {
    
    @RequestLine("POST /encoding/manifests/dash/{manifest_id}/periods/{period_id}/adaptationsets/audio")
    AudioAdaptationSet create(@Param("manifest_id") String manifestId, @Param("period_id") String periodId, AudioAdaptationSet audioAdaptationSet) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/manifests/dash/{manifest_id}/periods/{period_id}/adaptationsets/audio/{adaptationset_id}")
    BitmovinResponse delete(@Param("manifest_id") String manifestId, @Param("period_id") String periodId, @Param("adaptationset_id") String adaptationsetId) throws BitmovinException;
    
    @RequestLine("GET /encoding/manifests/dash/{manifest_id}/periods/{period_id}/adaptationsets/audio/{adaptationset_id}")
    AudioAdaptationSet get(@Param("manifest_id") String manifestId, @Param("period_id") String periodId, @Param("adaptationset_id") String adaptationsetId) throws BitmovinException;
    
    @RequestLine("GET /encoding/manifests/dash/{manifest_id}/periods/{period_id}/adaptationsets/audio")
    List<AudioAdaptationSet> list(@Param("manifest_id") String manifestId, @Param("period_id") String periodId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
