package com.bitmovin.api.encoding.manifest.dash;

/**
 * Created by arudich on 01.02.17.
 **/
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
