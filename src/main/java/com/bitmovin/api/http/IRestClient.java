package com.bitmovin.api.http;

import com.bitmovin.api.http.exceptions.RestClientException;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Map;

public interface IRestClient
{
    <T> T getAsObject(String uri, Map<String, String> headers, Class<T> responseClass)
            throws RestClientException;


    <T> T postAsObject(String uri, Map<String, String> headers, Object object, Class<T> responseClass)
            throws RestClientException;

    <T> T patchAsObject(String uri, Map<String, String> headers, Object object, Class<T> responseClass)
            throws RestClientException;

    <T> T deleteAsObject(String uri, Map<String, String> headers, Class<T> responseClass) throws RestClientException;

    void getIgnoreResponse(String uri, Map<String, String> headers) throws RestClientException;
    void postIgnoreResponse(String uri, Map<String, String> headers, Object body) throws RestClientException;
    void deleteIgnoreResponse(String uri, Map<String, String> headers) throws RestClientException;
}
