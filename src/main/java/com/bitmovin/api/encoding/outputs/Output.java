package com.bitmovin.api.encoding.outputs;

import com.bitmovin.api.AbstractApiResponse;
import com.bitmovin.api.encoding.AclEntry;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 25.07.16.
 **/
public class Output extends AbstractApiResponse
{
    @JsonIgnore
    protected OutputType type;
    
    protected List<AclEntry> acl;
    
    private String name;
    private String description;

    public Output()
    {
        this.acl = new ArrayList<>();
    }

    public OutputType getType()
    {
        return this.type;
    }

    public void setType(OutputType type)
    {
        this.type = type;
    }

    public List<AclEntry> getAcl()
    {
        return this.acl;
    }

    public void setAcl(List<AclEntry> acl)
    {
        this.acl = acl;
    }

    public void addAclElement(AclEntry aclElement)
    {
        this.acl.add(aclElement);
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
