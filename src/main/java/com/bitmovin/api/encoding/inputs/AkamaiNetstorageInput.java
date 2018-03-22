package com.bitmovin.api.encoding.inputs;

/**
 * Created by arudich on 04.07.17.
 **/
public class AkamaiNetstorageInput extends Input
{
    private String host;

    private String username;

    private String password;

    public AkamaiNetstorageInput()
    {
        this.setType(InputType.AKAMAI_NETSTORAGE);
    }

    public String getHost()
    {
        return host;
    }

    public void setHost(String host)
    {
        this.host = host;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
