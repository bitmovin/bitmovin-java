package com.bitmovin.api.encoding.encodings;

/**
 * Created by dmoser on 09.01.17.
 */
public class Trimming
{
    private Double offset;

    private Double duration;

    private String startPicTiming;

    private String endPicTiming;

    public Double getOffset()
    {
        return this.offset;
    }

    public void setOffset(Double offset)
    {
        this.offset = offset;
    }

    public Double getDuration()
    {
        return this.duration;
    }

    public void setDuration(Double duration)
    {
        this.duration = duration;
    }

    public String getStartPicTiming()
    {
        return this.startPicTiming;
    }

    public void setStartPicTiming(String startPicTiming)
    {
        this.startPicTiming = startPicTiming;
    }

    public String getEndPicTiming()
    {
        return this.endPicTiming;
    }

    public void setEndPicTiming(String endPicTiming)
    {
        this.endPicTiming = endPicTiming;
    }
}
