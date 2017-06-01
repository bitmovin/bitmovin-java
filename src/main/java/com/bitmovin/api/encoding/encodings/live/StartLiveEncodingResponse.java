package com.bitmovin.api.encoding.encodings.live;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by dmoser on 19.09.16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StartLiveEncodingResponse
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
