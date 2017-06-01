package com.bitmovin.api.encoding.manifest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by akopper on 09.08.16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ManifestCreationProcessResponse
{

    private String id;

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }
}
