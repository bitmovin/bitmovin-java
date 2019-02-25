package com.bitmovin.api.encoding.manifests.dash.periods;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface PeriodsClient {
    
    @RequestLine("POST /encoding/manifests/dash/{manifest_id}/periods")
    Period create(@Param("manifest_id") String manifestId, Period period) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/manifests/dash/{manifest_id}/periods/{period_id}")
    BitmovinResponse delete(@Param("manifest_id") String manifestId, @Param("period_id") String periodId) throws BitmovinException;
    
    @RequestLine("GET /encoding/manifests/dash/{manifest_id}/periods/{period_id}")
    Period get(@Param("manifest_id") String manifestId, @Param("period_id") String periodId) throws BitmovinException;
    
    @RequestLine("GET /encoding/manifests/dash/{manifest_id}/periods")
    List<Period> list(@Param("manifest_id") String manifestId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
