package com.bitmovin.api.encoding.encodings.thumbnails;

import com.bitmovin.api.AbstractApiResponse;
import com.bitmovin.api.encoding.EncodingOutput;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dominic Miglar [dominic.miglar@bitmovin.com] on 9/9/16 at 11:40 AM.
 */
public class Thumbnail extends AbstractApiResponse
{
    private Integer height;
    private String pattern;

    private Set<Double> positions;
    private Set<EncodingOutput> outputs;
    private ThumbnailUnit unit = ThumbnailUnit.SECONDS;

    public Thumbnail()
    {
        this.positions = new HashSet<>();
        this.outputs = new HashSet<>();
    }

    public Integer getHeight()
    {
        return this.height;
    }

    public void setHeight(Integer height)
    {
        this.height = height;
    }

    public String getPattern()
    {
        return this.pattern;
    }

    public void setPattern(String pattern)
    {
        this.pattern = pattern;
    }

    public Set<Double> getPositions()
    {
        return this.positions;
    }

    public void setPositions(Set<Double> positions)
    {
        this.positions = positions;
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

    public void addPosition(Double position)
    {
        this.positions.add(position);
    }

    public ThumbnailUnit getUnit()
    {
        return this.unit;
    }

    public void setUnit(ThumbnailUnit unit)
    {
        this.unit = unit;
    }
}
