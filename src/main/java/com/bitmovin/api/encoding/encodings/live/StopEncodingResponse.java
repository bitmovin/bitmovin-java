package com.bitmovin.api.encoding.encodings.live;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by dmoser on 10.10.16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StopEncodingResponse
{
    private String id;

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }
}
