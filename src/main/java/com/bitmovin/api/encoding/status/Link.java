package com.bitmovin.api.encoding.status;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 26.07.16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Link
{
    private String href;
    private String title;

    public Link()
    {
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
