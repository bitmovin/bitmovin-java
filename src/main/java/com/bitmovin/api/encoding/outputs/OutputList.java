package com.bitmovin.api.encoding.outputs;

import com.bitmovin.api.encoding.inputs.Input;

import java.util.List;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 27.07.16.
 */
public class OutputList<T extends Output>
{
    private int totalCount;
    private List<T> outputs;

    public OutputList()
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

    public List<T> getOutputs()
    {
        return this.outputs;
    }

    public void setOutputs(List<T> outputs)
    {
        this.outputs = outputs;
    }
}
