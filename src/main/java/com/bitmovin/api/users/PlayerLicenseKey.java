package com.bitmovin.api.users;

/**
 * Created by dhoelbling on 31.10.16.
 */
public class PlayerLicenseKey
{
    private String id;

    public PlayerLicenseKey()
    {
    }

    public PlayerLicenseKey(String id, String keyValue)
    {
        this.id = id;
        this.keyValue = keyValue;
    }

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

    private String keyValue;
}
