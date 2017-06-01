package com.bitmovin.api.users;

import com.bitmovin.api.AbstractApiResponse;

import java.util.List;

/**
 * Created by Dominic Miglar [dominic.miglar@bitmovin.com] on 9/1/16 at 5:07 PM.
 */
public class ApiUser extends AbstractApiResponse
{
    private String email;
    private String password;
    private String createdByUserId;
    private String userIdAtApiGateway;
    private List<ApiKey> apiKeys;
    private List<PlayerLicenseKey> playerLicenseKeys;
    private List<AnalyticsLicenseKey> analyticsLicenseKeys;

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getCreatedByUserId()
    {
        return this.createdByUserId;
    }

    public void setCreatedByUserId(String createdByUserId)
    {
        this.createdByUserId = createdByUserId;
    }

    public String getUserIdAtApiGateway()
    {
        return this.userIdAtApiGateway;
    }

    public void setUserIdAtApiGateway(String userIdAtApiGateway)
    {
        this.userIdAtApiGateway = userIdAtApiGateway;
    }

    public List<ApiKey> getApiKeys()
    {
        return this.apiKeys;
    }

    public void setApiKeys(List<ApiKey> apiKeys)
    {
        this.apiKeys = apiKeys;
    }

    public List<PlayerLicenseKey> getPlayerLicenseKeys()
    {
        return this.playerLicenseKeys;
    }

    public void setPlayerLicenseKeys(List<PlayerLicenseKey> playerLicenseKeys)
    {
        this.playerLicenseKeys = playerLicenseKeys;
    }

    public List<AnalyticsLicenseKey> getAnalyticsLicenseKeys()
    {
        return this.analyticsLicenseKeys;
    }

    public void setAnalyticsLicenseKeys(List<AnalyticsLicenseKey> analyticsLicenseKeys)
    {
        this.analyticsLicenseKeys = analyticsLicenseKeys;
    }
}
