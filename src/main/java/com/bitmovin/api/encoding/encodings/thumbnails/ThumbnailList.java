package com.bitmovin.api.encoding.encodings.thumbnails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by Dominic Miglar [dominic.miglar@bitmovin.com] on 9/9/16 at 1:41 PM.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ThumbnailList
{
    private int totalCount;
    private List<Thumbnail> thumbnails;

    public ThumbnailList()
    {
    }

    public int getTotalCount()
    {
        return this.totalCount;
    }

    public void setTotalCount(int totalCount)
    {
        this.totalCount = totalCount;
    }

    public List<Thumbnail> getThumbnails()
    {
        return this.thumbnails;
    }

    public void setThumbnails(List<Thumbnail> thumbnails)
    {
        this.thumbnails = thumbnails;
    }

}
