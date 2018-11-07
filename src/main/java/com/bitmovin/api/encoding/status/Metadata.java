package com.bitmovin.api.encoding.status;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
class Metadata
{
    private Date date;
    private Map<String, Object> data;

    public Metadata()
    {
    }

    public Date getDate()
    {
        return this.date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public Map<String, Object> getData()
    {
        return this.data;
    }

    public void setData(Map<String, Object> data)
    {
        this.data = data;
    }
}
