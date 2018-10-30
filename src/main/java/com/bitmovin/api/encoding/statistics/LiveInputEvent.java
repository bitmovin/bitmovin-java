package com.bitmovin.api.encoding.statistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LiveInputEvent
{
    private String time;
    private Map<String, Object> details = new HashMap<>();

    public String getTime() { return time; }

    public void setTime(String time) { this.time = time; }

    public Map<String, Object> getDetails() { return details; }

    public void setDetails(Map<String, Object> details) { this.details = details; }

    @Override
    public String toString()
    {
        return "LiveInputEvent{" +
                "time='" + time + '\'' +
                ", details=" + details +
                '}';
    }
}