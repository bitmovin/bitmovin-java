package com.bitmovin.api.encoding;

import com.bitmovin.api.encoding.enums.StreamSelectionMode;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 25.07.16.
 */
public class InputStream
{
    String inputId;
    String inputPath;

    StreamSelectionMode selectionMode;
    Integer position;

    public InputStream() {
    }

    public String getInputPath() {
        return this.inputPath;
    }

    public void setInputPath(String inputPath) {
        this.inputPath = inputPath;
    }

    public StreamSelectionMode getSelectionMode() {
        return this.selectionMode;
    }

    public void setSelectionMode(StreamSelectionMode selectionMode) {
        this.selectionMode = selectionMode;
    }

    public Integer getPosition() {
        return this.position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getInputId() {
        return this.inputId;
    }

    public void setInputId(String inputId) {
        this.inputId = inputId;
    }
}
