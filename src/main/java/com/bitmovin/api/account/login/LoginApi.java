package com.bitmovin.api.account.login;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginApi
{
    private final LoginClient apiClient;

    public LoginApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public LoginApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public LoginApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(LoginClient.class);

    }


    /**
    * Login
    * 
    * @param login  (optional)
    * @return AccountInformation
    * @throws BitmovinException if fails to make API call
    */
    public AccountInformation create(Login login) throws BitmovinException
    {
        return this.apiClient.create(login);
    }
}
