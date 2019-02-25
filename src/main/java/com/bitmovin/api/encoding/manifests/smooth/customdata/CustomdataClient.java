package com.bitmovin.api.encoding.manifests.smooth.customdata;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface CustomdataClient {
    
    @RequestLine("GET /encoding/manifests/smooth/{manifest_id}/customData")
    CustomData getCustomData(@Param("manifest_id") String manifestId) throws BitmovinException;
}
