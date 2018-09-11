package com.bitmovin.api.http;

import com.bitmovin.api.http.exceptions.RestClientException;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Map;

public interface IRestClient
{

    String getAsString(String uri, Map<String, String> headers)
            throws RestClientException;

    <T> T getAsObject(String uri, Map<String, String> headers, Class<T> responseClass)
            throws RestClientException;

    String postAsString(String uri, Map<String, String> headers, Object object)
            throws RestClientException;

    <T> T postAsObject(String uri, Map<String, String> headers, Object object, Class<T> responseClass)
            throws RestClientException;

    String patchAsString(String uri, Map<String, String> headers, Object object)
            throws RestClientException;

    <T> T patchAsObject(String uri, Map<String, String> headers, Object object, Class<T> responseClass)
            throws RestClientException;

    <T> T delete(String uri, Map<String, String> headers, Class<T> responseClass) throws RestClientException;
}
