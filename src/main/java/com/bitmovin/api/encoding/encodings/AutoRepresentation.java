package com.bitmovin.api.encoding.encodings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AutoRepresentation
{
    private Double adoptConfigurationThreshold;

    public AutoRepresentation()
    {

    }

    public Double getAdoptConfigurationThreshold()
    {
        return this.adoptConfigurationThreshold;
    }

    public void setAdoptConfigurationThreshold(Double adoptConfigurationThreshold)
    {
        this.adoptConfigurationThreshold = adoptConfigurationThreshold;
    }
}
