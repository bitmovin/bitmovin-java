package com.bitmovin.api.users;

import com.bitmovin.api.AbstractApiResponse;

/**
 * Created by Dominic Miglar [dominic.miglar@bitmovin.com] on 9/1/16 at 5:57 PM.
 */
public class ApiKey extends AbstractApiResponse
{
    private String keyValue;

    public String getKeyValue()
    {
        return this.keyValue;
    }

    public void setKeyValue(String keyValue)
    {
        this.keyValue = keyValue;
    }
}
