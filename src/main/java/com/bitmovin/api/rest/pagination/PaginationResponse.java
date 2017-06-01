package com.bitmovin.api.rest.pagination;

import com.bitmovin.api.AbstractApiResponse;

import java.util.List;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 05.09.16.
 */
public class PaginationResponse extends AbstractApiResponse
{
    private long totalCount;
    private int offset;
    private int limit;
    private String previous;
    private String next;
    private List items;

    public int getOffset()
    {
        return this.offset;
    }

    public void setOffset(int offset)
    {
        this.offset = offset;
    }

    public int getLimit()
    {
        return this.limit;
    }

    public void setLimit(int limit)
    {
        this.limit = limit;
    }

    public String getPrevious()
    {
        return this.previous;
    }

    public void setPrevious(String previous)
    {
        this.previous = previous;
    }

    public String getNext()
    {
        return this.next;
    }

    public void setNext(String next)
    {
        this.next = next;
    }

    public List getItems()
    {
        return this.items;
    }

    public void setItems(List items)
    {
        this.items = items;
    }

    public long getTotalCount()
    {
        return this.totalCount;
    }

    public void setTotalCount(long totalCount)
    {
        this.totalCount = totalCount;
    }
}
