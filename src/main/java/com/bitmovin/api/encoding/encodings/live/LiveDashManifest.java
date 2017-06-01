package com.bitmovin.api.encoding.encodings.live;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Roland Kersche on 12/19/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LiveDashManifest
{
    private String manifestId;
    private Double timeshift;
    private Double liveEdgeOffset;

    public String getManifestId()
    {
        return this.manifestId;
    }

    public void setManifestId(String manifestId)
    {
        this.manifestId = manifestId;
    }

    public Double getTimeshift()
    {
        return this.timeshift;
    }

    public void setTimeshift(Double timeshift)
    {
        this.timeshift = timeshift;
    }

    public Double getLiveEdgeOffset()
    {
        return this.liveEdgeOffset;
    }

    public void setLiveEdgeOffset(Double liveEdgeOffset)
    {
        this.liveEdgeOffset = liveEdgeOffset;
    }
}
