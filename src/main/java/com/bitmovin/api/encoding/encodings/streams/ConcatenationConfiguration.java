package com.bitmovin.api.encoding.encodings.streams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConcatenationConfiguration
{
    private String inputStreamId;
    private Boolean isMain;
    private Integer position;

    public String getInputStreamId()
    {
        return this.inputStreamId;
    }

    public void setInputStreamId(String inputStreamId)
    {
        this.inputStreamId = inputStreamId;
    }

    public Boolean getIsMain()
    {
        return this.isMain;
    }

    public void setIsMain(Boolean isMain)
    {
        this.isMain= isMain;
    }

    public Integer getPosition()
    {
        return this.position;
    }

    public void setPosition(Integer position)
    {
        this.position= position;
    }
}
