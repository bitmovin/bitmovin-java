package com.bitmovin.api.encoding.encodings.pertitle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VP8PerTitleConfiguration extends PerTitleConfiguration
{

    private Double targetQualityCrf;

    public Double getTargetQualityCrf()
    {
        return this.targetQualityCrf;
    }

    public void setTargetQualityCrf(Double targetQualityCrf)
    {
        this.targetQualityCrf = targetQualityCrf;
    }

}
