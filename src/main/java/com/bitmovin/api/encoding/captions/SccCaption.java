package com.bitmovin.api.encoding.captions;

import com.bitmovin.api.AbstractApiResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SccCaption extends AbstractApiResponse
{
    private String name;
    private String description;
    private InputPath input;
    private Date modifiedAt;
    private String userId;
    private String orgId;
    private Date createdAt;
    private Date customDataCreatedAt;

    public SccCaption()
    {
        this.input = new InputPath();
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

    public InputPath getInput()
    {
        return this.input;
    }

    public void setInput(InputPath input)
    {
        this.input = input;
    }

    public Date getModifiedAt()
    {
        return this.modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt)
    {
        this.modifiedAt = modifiedAt;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getOrgId()
    {
        return this.orgId;
    }

    public void setOrgId(String orgId)
    {
        this.orgId = orgId;
    }

    public Date getCreatedAt()
    {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    public Date getCustomDataCreatedAt()
    {
        return this.customDataCreatedAt;
    }

    public void setCustomDataCreatedAt(Date customDataCreatedAt)
    {
        this.customDataCreatedAt = customDataCreatedAt;
    }
}
