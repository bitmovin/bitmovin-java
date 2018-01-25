package com.bitmovin.api.encoding.inputs;

import com.bitmovin.api.AbstractApiResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 25.07.16.
 */
public class Input extends AbstractApiResponse
{
    @JsonIgnore
    private InputType type;
    
    private String name;
    private String description;

    public Input()
    {
        super();
    }

    public InputType getType()
    {
        return this.type;
    }

    public void setType(InputType type)
    {
        this.type = type;
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
    
    public void setDesciption(String description)
    {
    		this.description = description;
    }

}
