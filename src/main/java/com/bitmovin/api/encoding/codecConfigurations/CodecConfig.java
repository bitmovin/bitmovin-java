package com.bitmovin.api.encoding.codecConfigurations;

import com.bitmovin.api.AbstractApiResponse;
import com.bitmovin.api.encoding.codecConfigurations.enums.ConfigType;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 25.07.16.
 */
public class CodecConfig extends AbstractApiResponse
{
    private String name = "";

    private String description = "";

    private String userId;

    private String orgId;

    @JsonIgnore
    private ConfigType type;

    public CodecConfig()
    {

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

    public ConfigType getType()
    {
        return this.type;
    }

    public void setType(ConfigType type)
    {
        this.type = type;
    }

}
