package com.bitmovin.api.encoding.captions;

import com.bitmovin.api.AbstractApiResponse;
import com.bitmovin.api.encoding.EncodingOutput;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.List;

/**
 * Created by Sandro Linder [sandro.linder@bitmovin.com] on 18/06/2018
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ConvertSccCaption extends AbstractApiResponse
{
    private String name;
    private String description;
    private Date modifiedAt;
    private InputPath input;
    private List<EncodingOutput> outputs;
    private String fileName;
    private StreamCaptionOutputFormat outputFormat;
    private ConvertSccCaptionWebVttSettings webVttSettings;

    public ConvertSccCaption()
    {
        this.input = new InputPath();
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Date getModifiedAt()
    {
        return this.modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt)
    {
        this.modifiedAt = modifiedAt;
    }

    public InputPath getInput()
    {
        return this.input;
    }

    public void setInput(InputPath input)
    {
        this.input = input;
    }

    public List<EncodingOutput> getOutputs()
    {
        return this.outputs;
    }

    public void setOutputs(List<EncodingOutput> outputs)
    {
        this.outputs = outputs;
    }

    public String getFileName()
    {
        return this.fileName;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public StreamCaptionOutputFormat getOutputFormat()
    {
        return this.outputFormat;
    }

    public void setOutputFormat(StreamCaptionOutputFormat streamCaptionOutputFormat)
    {
        this.outputFormat = streamCaptionOutputFormat;
    }

    public ConvertSccCaptionWebVttSettings getWebVttSettings()
    {
        return this.webVttSettings;
    }

    public void setWebVttSettings(ConvertSccCaptionWebVttSettings webVttSettings)
    {
        this.webVttSettings = webVttSettings;
    }
}
