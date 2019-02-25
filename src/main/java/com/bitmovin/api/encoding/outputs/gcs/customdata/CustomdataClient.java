package com.bitmovin.api.encoding.outputs.gcs.customdata;

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
    
    @RequestLine("GET /encoding/outputs/gcs/{output_id}/customData")
    CustomData getCustomData(@Param("output_id") String outputId) throws BitmovinException;
}
