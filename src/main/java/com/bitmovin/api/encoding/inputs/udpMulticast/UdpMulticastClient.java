package com.bitmovin.api.encoding.inputs.udpMulticast;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface UdpMulticastClient {
    
    @RequestLine("POST /encoding/inputs/udp-multicast")
    UdpMulticastInput create(UdpMulticastInput udpMulticastInput) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/inputs/udp-multicast/{input_id}")
    UdpMulticastInput delete(@Param("input_id") String inputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/inputs/udp-multicast/{input_id}")
    UdpMulticastInput get(@Param("input_id") String inputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/inputs/udp-multicast")
    List<UdpMulticastInput> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
