package com.bitmovin.utils.auth;

import java.util.HashMap;

/**
 * Created by chris on 30/12/15.
 */
public class Credentials
{
    protected HashMap<String, String> credentials;

    public Credentials ()
    {
        this.credentials = new HashMap<>();
    }

    public Credentials (HashMap<String, String> credentials)
    {
        this.credentials = credentials;
    }

    public void addCredentials (String key, String value)
    {
        this.credentials.put(key, value);
    }

    public String getCredential (String key)
    {
        return this.credentials.get(key);
    }
}
