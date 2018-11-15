package com.bitmovin.api.encoding.filters;

import com.bitmovin.api.encoding.filters.enums.ScalingAlgorithm;

/**
 * Created by jyeh on 11/14/18.
 */
public class ScaleFilter extends Filter {
    private Integer width;
    private Integer height;
    private ScalingAlgorithm scalingAlgorithm;

    public ScaleFilter()
    {
        super();
        this.setType(FilterType.SCALE);
    }

    public Integer getWidth()
    {
        return width;
    }

    public void setWidth(Integer width)
    {
        this.width = width;
    }

    public Integer getHeight()
    {
        return height;
    }

    public void setHeight(Integer height)
    {
        this.height = height;
    }

    public ScalingAlgorithm getScalingAlgorithm()
    {
        return this.scalingAlgorithm;
    }

    public void setScalingAlgorithm(ScalingAlgorithm scalingAlgorithm)
    {
        this.scalingAlgorithm = scalingAlgorithm;
    }
}
