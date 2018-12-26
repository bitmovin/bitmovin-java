package com.bitmovin.api.encoding.encodings.streams;

import com.bitmovin.api.AbstractApiResponse;
import com.bitmovin.api.encoding.enums.StreamSelectionMode;

public class IngestInputStream extends AbstractApiResponse
{

    private String inputId;

    private String inputPath;

    private StreamSelectionMode selectionMode;

    private Integer position;

    public IngestInputStream() {
    }

    public String getInputId()
    {
        return this.inputId;
    }

    public void setInputId(String inputId)
    {
        this.inputId= inputId;
    }

    public String getInputPath()
    {
        return this.inputPath;
    }

    public void setInputPath(String inputPath)
    {
        this.inputPath= inputPath;
    }

    public StreamSelectionMode getSelectionMode() {
        return this.selectionMode;
    }

    public void setSelectionMode(StreamSelectionMode selectionMode) {
        this.selectionMode = selectionMode;
    }

    public Integer getPosition() { return this.position; }

    public void setPosition(Integer position) { this.position = position; }
}
