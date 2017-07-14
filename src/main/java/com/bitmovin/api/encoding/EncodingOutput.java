package com.bitmovin.api.encoding;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 25.07.16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EncodingOutput
{
    private String outputId;
    private String outputPath;
    private List<AclEntry> acl;

    public EncodingOutput() {
    }

    public EncodingOutput(String outputId, String outputPath)
    {
        this.outputId   = outputId;
        this.outputPath = outputPath;
    }

    public String getOutputId() {
        return this.outputId;
    }

    public void setOutputId(String outputId) {
        this.outputId = outputId;
    }

    public String getOutputPath() {
        return this.outputPath;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }

    public List<AclEntry> getAcl()
    {
        return this.acl;
    }
    public void setAcl(List<AclEntry> acl)
    {
        this.acl = acl;
    }
}
