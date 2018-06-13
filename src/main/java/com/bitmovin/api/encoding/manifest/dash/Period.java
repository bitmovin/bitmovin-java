package com.bitmovin.api.encoding.manifest.dash;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by akopper on 08.08.16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Period
{

    private String id;

    private Double start;

    private Double duration;

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public Double getStart()
    {
        return this.start;
    }

    public void setStart(Double start)
    {
        this.start = start;
    }

    public Double getDuration()
    {
        return this.duration;
    }

    public void setDuration(Double duration)
    {
        this.duration = duration;
    }
}
