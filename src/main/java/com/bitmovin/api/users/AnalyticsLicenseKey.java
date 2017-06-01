package com.bitmovin.api.users;

/**
 * Created by dhoelbling on 31.10.16.
 */
public class AnalyticsLicenseKey
{
    private String id;
    private String keyValue;

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getKeyValue()
    {
        return this.keyValue;
    }

    public void setKeyValue(String keyValue)
    {
        this.keyValue = keyValue;
    }
}
