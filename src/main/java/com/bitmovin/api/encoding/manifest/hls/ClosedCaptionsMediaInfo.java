package com.bitmovin.api.encoding.manifest.hls;

/**
 * Created by arudich on 11.01.17.
 **/
public class ClosedCaptionsMediaInfo extends SegmentsMediaInfo
{
    private String instreamId;

    public String getInstreamId() { return this.instreamId; }

    public void setInstreamId(String instreamId) { this.instreamId = instreamId; }
}
