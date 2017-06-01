package com.bitmovin.api.encoding.encodings.thumbnails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by Dominic Miglar [dominic.miglar@bitmovin.com] on 9/9/16 at 1:42 PM.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SpriteList
{
    private int totalCount;
    private List<Sprite> sprites;

    public SpriteList()
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

    public List<Sprite> getSprites()
    {
        return this.sprites;
    }

    public void setSprites(List<Sprite> sprites)
    {
        this.sprites = sprites;
    }
}
