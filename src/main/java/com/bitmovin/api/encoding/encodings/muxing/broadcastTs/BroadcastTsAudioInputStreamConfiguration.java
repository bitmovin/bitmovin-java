package com.bitmovin.api.encoding.encodings.muxing.broadcastTs;

public class BroadcastTsAudioInputStreamConfiguration extends BroadcastTsInputStreamConfiguration
{
    private Boolean useATSCBufferModel;
    private String language;

    public BroadcastTsAudioInputStreamConfiguration()
    {
        super();
    }

    public Boolean getUseATSCBufferModel()
    {
        return this.useATSCBufferModel;
    }

    public void setUseATSCBufferModel(Boolean useATSCBufferModel)
    {
        this.useATSCBufferModel = useATSCBufferModel;
    }

    public String getLanguage()
    {
        return this.language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }
}
