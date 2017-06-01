package com.bitmovin.api.rest;

public class Link
{
    private String href;
    private String title;

    public Link() {

    }

    public Link(String href)
    {
        this.href = href;
    }

    public Link(String href, String title)
    {
        this.href = href;
        this.title = title;
    }

    public String getHref()
    {
        return this.href;
    }

    public void setHref(String href)
    {
        this.href = href;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }
}