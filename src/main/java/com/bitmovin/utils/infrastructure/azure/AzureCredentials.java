package com.bitmovin.utils.infrastructure.azure;

import com.bitmovin.utils.auth.Credentials;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by arudich on 14.09.17.
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AzureCredentials extends Credentials
{
    private String applicationId;
    private String tenantId;
    private String authenticationKey;

    public AzureCredentials()
    {
    }

    public AzureCredentials(String applicationId, String tenantId, String authenticationKey)
    {
        this.applicationId = applicationId;
        this.tenantId = tenantId;
        this.authenticationKey = authenticationKey;
    }

    public String getApplicationId()
    {
        return this.applicationId;
    }

    public void setApplicationId(String applicationId)
    {
        this.applicationId = applicationId;
    }

    public String getTenantId()
    {
        return this.tenantId;
    }

    public void setTenantId(String tenantId)
    {
        this.tenantId = tenantId;
    }

    public String getAuthenticationKey()
    {
        return this.authenticationKey;
    }

    public void setAuthenticationKey(String password)
    {
        this.authenticationKey = password;
    }
}
