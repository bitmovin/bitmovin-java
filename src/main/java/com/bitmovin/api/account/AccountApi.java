package com.bitmovin.api.account;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.account.information.InformationApi;
import com.bitmovin.api.account.login.LoginApi;
import com.bitmovin.api.account.apiKeys.ApiKeysApi;
import com.bitmovin.api.account.organizations.OrganizationsApi;


public class AccountApi
{
    public InformationApi information;
    public LoginApi login;
    public ApiKeysApi apiKeys;
    public OrganizationsApi organizations;

    public AccountApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public AccountApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public AccountApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        information = new InformationApi(clientFactory);
        login = new LoginApi(clientFactory);
        apiKeys = new ApiKeysApi(clientFactory);
        organizations = new OrganizationsApi(clientFactory);
    }

}
