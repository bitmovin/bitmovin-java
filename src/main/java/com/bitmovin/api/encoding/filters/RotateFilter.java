package com.bitmovin.api.encoding.filters;

/**
 * Created by Dominic Miglar [dominic.miglar@bitmovin.com] on 8/26/16 at 12:15 PM.
 */
public class RotateFilter extends Filter implements Cloneable
{
    private Integer rotation;

    public RotateFilter()
    {
        super();
        this.setType(FilterType.ROTATE);
    }

    public Integer getRotation()
    {
        return this.rotation;
    }

    public void setRotation(Integer rotation)
    {
        this.rotation = rotation;
    }
}
