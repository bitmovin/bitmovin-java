package com.bitmovin.api.encoding.captions;

/**
 * Created by Sandro Linder [sandro.linder@bitmovin.com] on 18/06/2018
 */
public class InputPath
{
    private String inputId;
    private String inputPath;
    public InputPath()
    {

    }

    public String getInputId()
    {
        return this.inputId;
    }

    public void setInputId(String inputId)
    {
        this.inputId = inputId;
    }

    public String getInputPath()
    {
        return this.inputPath;
    }

    public void setInputPath(String inputPath)
    {
        this.inputPath = inputPath;
    }
}
