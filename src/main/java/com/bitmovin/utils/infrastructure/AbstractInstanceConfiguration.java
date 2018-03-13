package com.bitmovin.utils.infrastructure;

import org.apache.commons.lang3.NotImplementedException;

/**
 * Created by
 * David Moser [david.moser@bitmovin.com]
 * on 4/20/16
 */
public abstract class AbstractInstanceConfiguration implements IInstanceConfiguration
{
    private Long id;

    @Override
    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    @Override
    public boolean compareTo(IInstanceConfiguration other)
    {
        throw new NotImplementedException("Compare to not implemented!");
    }
}
