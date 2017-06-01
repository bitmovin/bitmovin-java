package com.bitmovin.api.encoding.manifest.dash;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by akopper on 08.08.16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Period
{

    private String id;

    private String start;

    private String duration;

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getStart()
    {
        return this.start;
    }

    public void setStart(String start)
    {
        this.start = start;
    }

    public String getDuration()
    {
        return this.duration;
    }

    public void setDuration(String duration)
    {
        this.duration = duration;
    }
}
