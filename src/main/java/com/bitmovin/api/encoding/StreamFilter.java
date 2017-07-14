package com.bitmovin.api.encoding;

import com.bitmovin.api.encoding.filters.Filter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by doweinberger on 9/8/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StreamFilter
{
    private String id;

    @JsonIgnore
    private Filter filter;

    private Integer position;

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public Filter getFilter()
    {
        return this.filter;
    }

    public void setFilter(Filter filter)
    {
        this.filter = filter;
    }

    public Integer getPosition()
    {
        return this.position;
    }

    public void setPosition(Integer position)
    {
        this.position = position;
    }
}

