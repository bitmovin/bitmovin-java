package com.bitmovin.api.encoding.manifest.dash;

import com.bitmovin.api.AbstractApiResponse;
import com.bitmovin.api.encoding.EncodingOutput;
import com.bitmovin.api.encoding.manifest.Manifest;
import com.bitmovin.api.encoding.outputs.Output;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akopper on 08.08.16.
 */
public class DashManifest extends Manifest
{
    private String name;

    private List<EncodingOutput> outputs = new ArrayList<>();

    private DashProfile profile;

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<EncodingOutput> getOutputs()
    {
        return new ArrayList<>(this.outputs);
    }

    public void setOutputs(List<EncodingOutput> outputs)
    {
        this.outputs = outputs;
    }

    public void addOutput(EncodingOutput output)
    {
        if(this.outputs == null)
            this.outputs = new ArrayList<>();

        this.outputs.add(output);
    }

    public DashProfile getProfile()
    {
        return this.profile;
    }

    public void setProfile(DashProfile profile)
    {
        this.profile = profile;
    }
}
