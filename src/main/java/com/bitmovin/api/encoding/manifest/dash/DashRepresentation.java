package com.bitmovin.api.encoding.manifest.dash;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by arudich on 01.02.17.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class DashRepresentation
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
