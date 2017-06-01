package com.bitmovin.api.encoding.user;

import com.bitmovin.api.AbstractApiResource;

/**
 * Created by alexanderkopper on 25/10/2016.
 */
public class Organization extends AbstractApiResource
{

    private String name;
    private String description;

    public Organization()
    {
        super();
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
