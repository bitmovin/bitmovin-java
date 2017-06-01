package com.bitmovin.api.encoding.analysis;

import com.bitmovin.api.encoding.enums.CloudRegion;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by akopper on 10.08.16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnalysisStartRequest
{

    private String path;

    private CloudRegion cloudRegion;

    public AnalysisStartRequest()
    {
    }

    public AnalysisStartRequest(String path)
    {
        this.path = path;
    }

    public String getPath()
    {
        return this.path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public CloudRegion getCloudRegion()
    {
        return this.cloudRegion;
    }

    public void setCloudRegion(CloudRegion cloudRegion)
    {
        this.cloudRegion = cloudRegion;
    }
}
