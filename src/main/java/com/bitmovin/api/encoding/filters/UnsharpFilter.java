package com.bitmovin.api.encoding.filters;

/**
 * Created by jyeh on 11/14/18.
 */
public class UnsharpFilter extends Filter {
    private Integer lumaMatrixHorizontalSize;
    private Integer lumaMatrixVerticalSize;
    private Integer lumaEffectStrength;
    private Integer chromaMatrixHorizontalSize;
    private Integer chromaMatrixVerticalSize;
    private Integer chromaEffectStrength;

    public Integer getLumaMatrixHorizontalSize()
    {
        return lumaMatrixHorizontalSize;
    }

    public void setLumaMatrixHorizontalSize(Integer lumaMatrixHorizontalSize)
    {
        this.lumaMatrixHorizontalSize = lumaMatrixHorizontalSize;
    }

    public Integer getLumaMatrixVerticalSize()
    {
        return lumaMatrixVerticalSize;
    }

    public void setLumaMatrixVerticalSize(Integer lumaMatrixVerticalSize)
    {
        this.lumaMatrixVerticalSize = lumaMatrixVerticalSize;
    }

    public Integer getLumaEffectStrength()
    {
        return lumaEffectStrength;
    }

    public void setLumaEffectStrength(Integer lumaEffectStrength)
    {
        this.lumaEffectStrength= lumaEffectStrength;
    }

    public Integer getChromaMatrixHorizontalSize()
    {
        return chromaMatrixHorizontalSize;
    }

    public void setChromaMatrixHorizontalSize(Integer chromaMatrixHorizontalSize)
    {
        this.chromaMatrixHorizontalSize = chromaMatrixHorizontalSize;
    }

    public Integer getChromaMatrixVerticalSize()
    {
        return chromaMatrixVerticalSize;
    }

    public void setChromaMatrixVerticalSize(Integer chromaMatrixVerticalSize)
    {
        this.chromaMatrixVerticalSize = chromaMatrixVerticalSize;
    }

    public Integer getChromaEffectStrength()
    {
        return chromaEffectStrength;
    }

    public void setChromaEffectStrength(Integer chromaEffectStrength)
    {
        this.chromaEffectStrength= chromaEffectStrength;
    }

}
