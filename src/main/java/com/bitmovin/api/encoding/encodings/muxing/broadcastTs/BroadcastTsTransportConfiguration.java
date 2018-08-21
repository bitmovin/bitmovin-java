package com.bitmovin.api.encoding.encodings.muxing.broadcastTs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BroadcastTsTransportConfiguration
{
    private Double muxrate;
    private Boolean stopOnError;
    private Boolean preventEmptyAdaptionFieldsInVideo;
    private Double patRepetitionRatePerSec;
    private Double pmtRepetitionRatePerSec;

    public BroadcastTsTransportConfiguration()
    {

    }

    public Double getMuxrate()
    {
        return muxrate;
    }

    public void setMuxrate(Double muxrate)
    {
        this.muxrate = muxrate;
    }

    public Boolean getStopOnError()
    {
        return this.stopOnError;
    }

    public void setStopOnError(Boolean stopOnError)
    {
        this.stopOnError = stopOnError;
    }

    public Boolean getPreventEmptyAdaptionFieldsInVideo()
    {
        return this.preventEmptyAdaptionFieldsInVideo;
    }

    public void setPreventEmptyAdaptionFieldsInVideo(Boolean preventEmptyAdaptionFieldsInVideo)
    {
        this.preventEmptyAdaptionFieldsInVideo = preventEmptyAdaptionFieldsInVideo;
    }

    public Double getPatRepetitionRatePerSec()
    {
        return this.patRepetitionRatePerSec;
    }

    public void setPatRepetitionRatePerSec(Double patRepetitionRatePerSec)
    {
        this.patRepetitionRatePerSec = patRepetitionRatePerSec;
    }

    public Double getPmtRepetitionRatePerSec()
    {
        return this.pmtRepetitionRatePerSec;
    }

    public void setPmtRepetitionRatePerSec(Double pmtRepetitionRatePerSec)
    {
        this.pmtRepetitionRatePerSec = pmtRepetitionRatePerSec;
    }
}
