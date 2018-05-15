package com.bitmovin.api.encoding.encodings.thumbnails;

import com.bitmovin.api.AbstractApiResponse;
import com.bitmovin.api.encoding.EncodingOutput;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dominic Miglar [dominic.miglar@bitmovin.com] on 9/9/16 at 11:40 AM.
 */
public class Sprite extends AbstractApiResponse
{
    private Integer height;
    private Integer width;
    private Double  distance;
    private String  filename;
    private String  spriteName;
    private String  vttName;
    private Set<EncodingOutput> outputs;

    public Sprite()
    {
        this.outputs = new HashSet<>();
    }

    public Sprite(Integer height, Integer width, Double distance, String spriteName, String vttName, Set<EncodingOutput> outputs)
    {
        this.height = height;
        this.width = width;
        this.distance = distance;
        this.spriteName = spriteName;
        this.vttName = vttName;
        this.outputs = outputs;
    }

    public Integer getHeight()
    {
        return this.height;
    }

    public void setHeight(Integer height)
    {
        this.height = height;
    }

    public Integer getWidth()
    {
        return this.width;
    }

    public void setWidth(Integer width)
    {
        this.width = width;
    }

    public Double getDistance()
    {
        return this.distance;
    }

    public void setDistance(Double distance)
    {
        this.distance = distance;
    }

    public String getFilename()
    {
        return this.filename;
    }

    public void setFilename(String filename)
    {
        this.filename = filename;
    }

    public Set<EncodingOutput> getOutputs()
    {
        return this.outputs;
    }

    public void setOutputs(Set<EncodingOutput> outputs)
    {
        this.outputs = outputs;
    }

    public void addOutput(EncodingOutput output)
    {
        this.outputs.add(output);
    }

    public String getSpriteName()
    {
        return this.spriteName;
    }

    public void setSpriteName(String spriteName)
    {
        this.spriteName = spriteName;
    }

    public String getVttName()
    {
        return this.vttName;
    }

    public void setVttName(String vttName)
    {
        this.vttName = vttName;
    }
}
