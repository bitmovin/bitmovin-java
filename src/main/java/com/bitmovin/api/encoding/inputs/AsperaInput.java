package com.bitmovin.api.encoding.inputs;

import java.util.Date;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 25.07.16.
 */
public class AsperaInput extends Input
{
    private Date createdAt;

    private Date modifiedAt;

    private String name;

    private String description;

    private String minBandwidth;

    private String maxBandwidth;

    private String host;

    private String username;

    private String password;

    private String token;

    public AsperaInput()
    {
        this.setType(InputType.ASPERA);
    }

    public String getMinBandwidth()
    {
        return this.minBandwidth;
    }

    public void setMinBandwidth(String minBandwidth)
    {
        this.minBandwidth = minBandwidth;
    }

    public String getMaxBandwidth()
    {
        return this.maxBandwidth;
    }

    public void setMaxBandwidth(String maxBandwidth)
    {
        this.maxBandwidth = maxBandwidth;
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

    public String getToken()
    {
        return this.token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }

    public Date getCreatedAt()
    {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt()
    {
        return this.modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt)
    {
        this.modifiedAt = modifiedAt;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

}