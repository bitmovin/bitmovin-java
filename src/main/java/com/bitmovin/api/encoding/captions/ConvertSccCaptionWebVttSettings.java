package com.bitmovin.api.encoding.captions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Sandro Linder [sandro.linder@bitmovin.com] on 19/06/2018
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ConvertSccCaptionWebVttSettings
{
    private Boolean simplePositions;

    private Boolean removeFlash;

    private Boolean removeColor;

    public ConvertSccCaptionWebVttSettings()
    {
    }

    public Boolean getSimplePositions()
    {
        return this.simplePositions;
    }

    public void setSimplePositions(Boolean simplePositions)
    {
        this.simplePositions = simplePositions;
    }

    public Boolean getRemoveFlash()
    {
        return this.removeFlash;
    }

    public void setRemoveFlash(Boolean removeFlash)
    {
        this.removeFlash = removeFlash;
    }

    public Boolean getRemoveColor()
    {
        return this.removeColor;
    }

    public void setRemoveColor(Boolean removeColor)
    {
        this.removeColor = removeColor;
    }
}
