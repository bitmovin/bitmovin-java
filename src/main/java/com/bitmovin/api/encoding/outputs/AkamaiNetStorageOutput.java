package com.bitmovin.api.encoding.outputs;

/**
 * Created by Germano Fronza on 08.01.18.
 */
public class AkamaiNetStorageOutput extends Output
{
    private String host;

    private String username;

    private String password;

    public AkamaiNetStorageOutput()
    {
        super();
        this.setType(OutputType.AKAMAI_NETSTORAGE);
    }

    public String getHost()
    {
        return this.host;
    }

    public void setHost(String host)
    {
        this.host = host;
    }

    public String getUsername()
    {
        return this.username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}