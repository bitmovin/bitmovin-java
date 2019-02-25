package com.bitmovin.api.account.apiKeys;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface ApiKeysClient {
    @Headers("Content-Type: text/plain")
    @Body(" ")
    
    @RequestLine("POST /account/api-keys")
    AccountApiKey create() throws BitmovinException;
    
    @RequestLine("DELETE /account/api-keys/{api_key_id}")
    BitmovinResponse delete(@Param("api_key_id") String apiKeyId) throws BitmovinException;
    
    @RequestLine("GET /account/api-keys/{api_key_id}")
    AccountApiKey get(@Param("api_key_id") String apiKeyId) throws BitmovinException;
    
    @RequestLine("GET /account/api-keys")
    List<AccountApiKey> list() throws BitmovinException;
}
