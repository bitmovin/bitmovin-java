package com.bitmovin.api.encoding.filters;

/**
 * Created by Dominic Miglar [dominic.miglar@bitmovin.com] on 8/26/16 at 12:15 PM.
 */
public class CropFilter extends Filter implements Cloneable
{
    private Integer left;
    private Integer right;
    private Integer top;
    private Integer bottom;

    public CropFilter()
    {
        super();
        this.setType(FilterType.CROP);
    }

    public Integer getLeft()
    {
        return this.left;
    }

    public void setLeft(Integer left)
    {
        this.left = left;
    }

    public Integer getRight()
    {
        return this.right;
    }

    public void setRight(Integer right)
    {
        this.right = right;
    }

    public Integer getTop()
    {
        return this.top;
    }

    public void setTop(Integer top)
    {
        this.top = top;
    }

    public Integer getBottom()
    {
        return this.bottom;
    }

    public void setBottom(Integer bottom)
    {
        this.bottom = bottom;
    }
}
