package com.bitmovin.api.encoding.filters;

import com.bitmovin.api.encoding.filters.enums.DeinterlaceMode;
import com.bitmovin.api.encoding.filters.enums.PictureFieldParity;

/**
 * Created by dmoser on 25.11.16.
 */
public class DeinterlaceFilter extends Filter
{
    PictureFieldParity parity;
    DeinterlaceMode mode;

    public PictureFieldParity getParity()
    {
        return this.parity;
    }

    public void setParity(PictureFieldParity parity)
    {
        this.parity = parity;
    }

    public DeinterlaceMode getMode()
    {
        return this.mode;
    }

    public void setMode(DeinterlaceMode mode)
    {
        this.mode = mode;
    }
}
