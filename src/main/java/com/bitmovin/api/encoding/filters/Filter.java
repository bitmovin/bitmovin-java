package com.bitmovin.api.encoding.filters;

import com.bitmovin.api.AbstractApiResource;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by Dominic Miglar [dominic.miglar@bitmovin.com] on 8/26/16 at 12:10 PM.
 */
public class Filter extends AbstractApiResource
{
    @JsonIgnore
    private FilterType type;

    public Filter()
    {
        super();
    }

    public FilterType getType()
    {
        return this.type;
    }

    public void setType(FilterType type)
    {
        this.type = type;
    }
}
