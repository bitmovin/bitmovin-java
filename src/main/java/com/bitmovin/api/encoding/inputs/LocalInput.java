package com.bitmovin.api.encoding.inputs;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 25.07.16.
 */
public class LocalInput extends Input
{

    private String path;

    public LocalInput()
    {
        this.setType(InputType.LOCAL);
    }

    public String getPath()
    {
        return this.path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }
}