package com.bitmovin.api.encoding.inputs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 27.07.16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InputList <T extends Input>
{
    private int totalCount;
    private List<T> inputs;

    public InputList()
    {
    }

    public int getTotalCount()
    {
        return this.totalCount;
    }

    public void setTotalCount(int totalCount)
    {
        this.totalCount = totalCount;
    }

    public List<T> getInputs()
    {
        return this.inputs;
    }

    public void setInputs(List<T> inputs)
    {
        this.inputs = inputs;
    }
}
