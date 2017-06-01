package com.bitmovin.api.encoding;

import com.bitmovin.api.AbstractApiResource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by doweinberger on 9/8/16.
 */
public class StreamFilterList extends AbstractApiResource
{
    private List<StreamFilter> filters = new ArrayList<>();

    public List<StreamFilter> getFilters()
    {
        return this.filters;
    }

    public void setFilters(List<StreamFilter> filters)
    {
        this.filters = filters;
    }
}
