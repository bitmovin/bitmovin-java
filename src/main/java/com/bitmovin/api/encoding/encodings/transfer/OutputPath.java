package com.bitmovin.api.encoding.encodings.transfer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Copied from transfer-resource-client and removed database stuff.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class OutputPath
{
    @JsonIgnore
    private String id;


    private String outputId;

    private String outputPath;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<OutputAcl> acl;

    public OutputPath()
    {
        this.acl = new HashSet<>();
    }

    public OutputPath(String outputId, String outputPath)
    {
        this.outputId = outputId;
        this.outputPath = outputPath;
        this.acl = new HashSet<>();
    }

    public String getId() { return this.id; }

    public void setId(String id) { this.id = id; }

    public String getOutputId()
    {
        return this.outputId;
    }

    public void setOutputId(String outputId)
    {
        this.outputId = outputId;
    }

    public String getOutputPath()
    {
        return this.outputPath;
    }

    public void setOutputPath(String outputPath)
    {
        this.outputPath = outputPath;
    }

    public Set<OutputAcl> getAcl() { return this.acl; }

    public void addAcl(OutputAcl acl)
    {
        this.acl.add(acl);
    }

    public void clearAcl()
    {
        this.acl.clear();
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        OutputPath that = (OutputPath) o;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.outputId, that.outputId) &&
                Objects.equals(this.outputPath, that.outputPath) &&
                Objects.equals(this.acl, that.acl);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(this.id, this.outputId, this.outputPath, this.acl);
    }
}