package com.bitmovin.api.encoding.encodings.encodinginformation;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Created by doweinberger on 8/4/16.
 */
@JsonTypeName("AUDIO")
public class EncodingDetailsAudio extends EncodingDetails
{
    private int streamId;
    private String language;
    private String label;
    private int samplingRate;
    private String channelLayout;

    public EncodingDetailsAudio()
    {
        this.setType(EncodingDetailsType.AUDIO);
    }

    public int getStreamId()
    {
        return this.streamId;
    }

    public void setStreamId(int streamId)
    {
        this.streamId = streamId;
    }

    public String getLanguage()
    {
        return this.language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public String getLabel()
    {
        return this.label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }

    public int getSamplingRate()
    {
        return this.samplingRate;
    }

    public void setSamplingRate(int samplingRate)
    {
        this.samplingRate = samplingRate;
    }

    public String getChannelLayout()
    {
        return this.channelLayout;
    }

    public void setChannelLayout(String channelLayout)
    {
        this.channelLayout = channelLayout;
    }
}
