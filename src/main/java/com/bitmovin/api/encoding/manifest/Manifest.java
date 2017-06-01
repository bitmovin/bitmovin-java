package com.bitmovin.api.encoding.manifest;

import com.bitmovin.api.AbstractApiResource;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by dmoser on 24.10.16.
 */
public class Manifest extends AbstractApiResource
{
    @JsonIgnore
    private ManifestType type;

    public ManifestType getType()
    {
        return this.type;
    }

    public void setType(ManifestType type)
    {
        this.type = type;
    }
}
