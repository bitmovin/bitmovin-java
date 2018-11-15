package com.bitmovin.api.encoding.filters;

/**
 * Created by jyeh on 11/14/18.
 */
public class UnsharpFilter extends Filter {
    private Integer lumaMatrixHorizontalSize;
    private Integer lumaMatrixVerticalSize;
    private Float lumaEffectStrength;
    private Integer chromaMatrixHorizontalSize;
    private Integer chromaMatrixVerticalSize;
    private Float chromaEffectStrength;

    public UnsharpFilter()
    {
        super();
        this.setType(FilterType.UNSHARP);
    }

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

    public Float getLumaEffectStrength()
    {
        return lumaEffectStrength;
    }

    public void setLumaEffectStrength(Float lumaEffectStrength)
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

    public Float getChromaEffectStrength()
    {
        return chromaEffectStrength;
    }

    public void setChromaEffectStrength(Float chromaEffectStrength)
    {
        this.chromaEffectStrength= chromaEffectStrength;
    }

}
