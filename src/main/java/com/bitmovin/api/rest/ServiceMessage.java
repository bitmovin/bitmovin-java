package com.bitmovin.api.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceMessage
{
    private Date timestamp;
    private ServiceMessageType type;
    private String text;
    private String field;
    private List<Link> links;
    private Object more;

    public ServiceMessage()
    {
    }

    public ServiceMessage(ServiceMessageType type, String text)
    {
        this.type = type;
        this.text = text;
        this.links = new ArrayList<>();
    }

    public ServiceMessageType getType()
    {
        return this.type;
    }

    public void setType(ServiceMessageType type)
    {
        this.type = type;
    }

    public String getText()
    {
        return this.text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public String getField()
    {
        return this.field;
    }

    public void setField(String field)
    {
        this.field = field;
    }

    public List<Link> getLinks()
    {
        return this.links;
    }

    public void setLinks(List<Link> links)
    {
        this.links = links;
    }

    public Object getMore()
    {
        return this.more;
    }

    public void setMore(Object more)
    {
        this.more = more;
    }

    public Date getTimestamp()
    {
        return this.timestamp;
    }

    public void setTimestamp(Date timestamp)
    {
        this.timestamp = timestamp;
    }
}