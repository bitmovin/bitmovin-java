package com.bitmovin.api.encoding.manifest.hls;

import com.bitmovin.api.encoding.EncodingOutput;
import com.bitmovin.api.encoding.manifest.Manifest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by doweinberger on 8/12/16.
 */
public class HlsManifest extends Manifest
{
    private String name;

    private List<EncodingOutput> outputs = new ArrayList<>();

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setOutputs(List<EncodingOutput> outputs)
    {
        this.outputs = outputs;
    }

    public List<EncodingOutput> getOutputs()
    {
        return new ArrayList<>(this.outputs);
    }

    public void addOutput(EncodingOutput output)
    {
        if(this.outputs == null)
            this.outputs = new ArrayList<>();

        this.outputs.add(output);
    }

}
