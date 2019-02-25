package com.bitmovin.api.account.login;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface LoginClient {
    
    @RequestLine("POST /account/login")
    AccountInformation create(Login login) throws BitmovinException;
}
