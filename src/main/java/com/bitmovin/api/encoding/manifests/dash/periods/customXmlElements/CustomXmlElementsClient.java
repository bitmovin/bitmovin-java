package com.bitmovin.api.encoding.manifests.dash.periods.customXmlElements;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface CustomXmlElementsClient {
    
    @RequestLine("POST /encoding/manifests/dash/{manifest_id}/periods/{period_id}/custom-xml-elements")
    CustomXmlElement create(@Param("manifest_id") String manifestId, @Param("period_id") String periodId, CustomXmlElement customXmlElement) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/manifests/dash/{manifest_id}/periods/{period_id}/custom-xml-elements/{custom_xml_element_id}")
    BitmovinResponse delete(@Param("manifest_id") String manifestId, @Param("period_id") String periodId, @Param("custom_xml_element_id") String customXmlElementId) throws BitmovinException;
    
    @RequestLine("GET /encoding/manifests/dash/{manifest_id}/periods/{period_id}/custom-xml-elements/{custom_xml_element_id}")
    CustomXmlElement get(@Param("manifest_id") String manifestId, @Param("period_id") String periodId, @Param("custom_xml_element_id") String customXmlElementId) throws BitmovinException;
    
    @RequestLine("GET /encoding/manifests/dash/{manifest_id}/periods/{period_id}/custom-xml-elements")
    List<CustomXmlElement> list(@Param("manifest_id") String manifestId, @Param("period_id") String periodId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
