package com.bitmovin.api.encoding.encodings.streams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Roland Kersche on 26.09.17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StreamInputAnalysis
{
    private String inputId;
    private String inputPath;
    private StreamInputAnalysisDetails details;

    public String getInputId()
    {
        return this.inputId;
    }

    public void setInputId(String inputId)
    {
        this.inputId = inputId;
    }

    public String getInputPath()
    {
        return this.inputPath;
    }

    public void setInputPath(String inputPath)
    {
        this.inputPath = inputPath;
    }

    public StreamInputAnalysisDetails getDetails()
    {
        return this.details;
    }

    public void setDetails(StreamInputAnalysisDetails details)
    {
        this.details = details;
    }
}
