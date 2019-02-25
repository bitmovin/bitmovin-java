package com.bitmovin.api.common;

import java.util.List;

public class BitmovinErrorDetails
{
    private String id;
    private String type;
    private String text;
    private String field;
    private List<BitmovinLink> links;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public String getField()
    {
        return field;
    }

    public void setField(String field)
    {
        this.field = field;
    }

    public List<BitmovinLink> getLinks()
    {
        return links;
    }

    public void setLinks(List<BitmovinLink> links)
    {
        this.links = links;
    }
}
