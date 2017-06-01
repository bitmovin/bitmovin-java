package com.bitmovin.api.encoding.encodings.transfer;

import com.bitmovin.api.AbstractApiResponse;
import com.bitmovin.api.encoding.enums.CloudRegion;

import java.util.HashSet;
import java.util.Set;

/**
 * Copied from transfer-resource-client and removed database stuff.
 **/

public class Transfer extends AbstractApiResponse
{
    private Set<OutputPath> outputs;

    private CloudRegion cloudRegion = CloudRegion.GOOGLE_EUROPE_WEST_1;


    public Transfer()
    {
        super();
        this.outputs = new HashSet<>();
    }

    public Set<OutputPath> getOutputs()
    {
        return this.outputs;
    }

    public void setOutputs(Set<OutputPath> outputs)
    {
        this.outputs = outputs;
    }

    public void addOutput(OutputPath destination)
    {
        this.outputs.add(destination);
    }

    public void removeOutput(OutputPath destination)
    {
        this.outputs.remove(destination);
    }

    public CloudRegion getCloudRegion() { return this.cloudRegion; }

    public void setCloudRegion(CloudRegion cloudRegion) { this.cloudRegion = cloudRegion; }

}
