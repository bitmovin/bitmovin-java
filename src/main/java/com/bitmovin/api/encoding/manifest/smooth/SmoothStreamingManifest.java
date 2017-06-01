package com.bitmovin.api.encoding.manifest.smooth;

import com.bitmovin.api.AbstractApiResponse;
import com.bitmovin.api.encoding.EncodingOutput;

import java.util.ArrayList;
import java.util.List;

public class SmoothStreamingManifest extends AbstractApiResponse
{
    private String name;

    private String description;

    private String serverManifestName;

    private String clientManifestName;

    private List<EncodingOutput> outputs = new ArrayList<>();

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

    public String getServerManifestName()
    {
        return this.serverManifestName;
    }
    public void setServerManifestName(String serverManifestName)
    {
        this.serverManifestName = serverManifestName;
    }
    public String getClientManifestName()
    {
        return this.clientManifestName;
    }
    public void setClientManifestName(String clientManifestName)
    {
        this.clientManifestName = clientManifestName;
    }

    public String getDescription()
    {
        return this.description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }
}
