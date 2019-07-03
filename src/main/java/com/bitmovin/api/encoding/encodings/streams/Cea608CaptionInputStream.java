package com.bitmovin.api.encoding.encodings.streams;

import com.bitmovin.api.AbstractApiResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gfronza on 7/3/19.
 */
public class Cea608CaptionInputStream extends AbstractApiResponse
{
    private String inputId;
    private String inputPath;
    private Cea608ChannelType channel;

    public String getInputId() { return inputId; }

    public String getInputPath() { return inputPath; }

    public void setInputId(String inputId) { this.inputId = inputId; }

    public void setInputPath(String inputPath) { this.inputPath = inputPath; }

    public Cea608ChannelType getChannel() { return channel; }

    public void setChannel(Cea608ChannelType channel) { this.channel = channel; }
}
