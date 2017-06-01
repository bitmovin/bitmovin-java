package com.bitmovin.api.encoding.outputs;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 25.07.16.
 **/
public class LocalOutput extends Output
{

    private String path;

    public LocalOutput()
    {
        super();
        this.setType(OutputType.LOCAL);
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
