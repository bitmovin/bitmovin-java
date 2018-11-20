package com.bitmovin.api.encoding.filters;

import com.bitmovin.api.encoding.filters.enums.InterlaceMode;
import com.bitmovin.api.encoding.filters.enums.VerticalLowPassFilteringMode;

/**
 * Created by jyeh on 11/14/18.
 */
public class InterlaceFilter extends Filter {
    private InterlaceMode mode;
    private VerticalLowPassFilteringMode verticalLowPassFilteringMode;

    public InterlaceFilter()
    {
        super();
        this.setType(FilterType.INTERLACE);
    }

    public InterlaceMode getInterlaceMode()
    {
        return this.mode;
    }

    public void setInterleaveMode(InterlaceMode mode)
    {
        this.mode = mode;
    }

    public VerticalLowPassFilteringMode getVerticalLowPassFilteringMode()
    {
        return this.verticalLowPassFilteringMode;
    }

    public void setVerticalLowPassFilteringMode(VerticalLowPassFilteringMode verticalLowPassFilteringMode)
    {
        this.verticalLowPassFilteringMode = verticalLowPassFilteringMode;
    }
}
