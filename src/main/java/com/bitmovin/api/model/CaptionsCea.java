package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BitmovinResource;
import com.bitmovin.api.model.EncodingOutput;
import com.bitmovin.api.model.InputStream;
import com.bitmovin.api.model.OutputFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * CaptionsCea
 */

public class CaptionsCea extends BitmovinResource {
  @JsonProperty("channel")
  private Integer channel;

  @JsonProperty("inputStream")
  private InputStream inputStream = null;

  @JsonProperty("outputFormat")
  private OutputFormat outputFormat = null;

  @JsonProperty("filename")
  private String filename;

  @JsonProperty("outputs")
  private List<EncodingOutput> outputs = new ArrayList<EncodingOutput>();


  /**
   * Select the channel for the caption information
   * @return channel
  **/
  public Integer getChannel() {
    return channel;
  }

  public void setChannel(Integer channel) {
    this.channel = channel;
  }


  /**
   * The input stream to extract the subtitle from
   * @return inputStream
  **/
  public InputStream getInputStream() {
    return inputStream;
  }

  public void setInputStream(InputStream inputStream) {
    this.inputStream = inputStream;
  }


  /**
   * Get outputFormat
   * @return outputFormat
  **/
  public OutputFormat getOutputFormat() {
    return outputFormat;
  }

  public void setOutputFormat(OutputFormat outputFormat) {
    this.outputFormat = outputFormat;
  }


  /**
   * Name of the captions file
   * @return filename
  **/
  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }


  public CaptionsCea addOutputsItem(EncodingOutput outputsItem) {
    this.outputs.add(outputsItem);
    return this;
  }

  /**
   * Get outputs
   * @return outputs
  **/
  public List<EncodingOutput> getOutputs() {
    return outputs;
  }

  public void setOutputs(List<EncodingOutput> outputs) {
    this.outputs = outputs;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CaptionsCea captionsCea = (CaptionsCea) o;
    return Objects.equals(this.channel, captionsCea.channel) &&
        Objects.equals(this.inputStream, captionsCea.inputStream) &&
        Objects.equals(this.outputFormat, captionsCea.outputFormat) &&
        Objects.equals(this.filename, captionsCea.filename) &&
        Objects.equals(this.outputs, captionsCea.outputs) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(channel, inputStream, outputFormat, filename, outputs, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CaptionsCea {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
    sb.append("    inputStream: ").append(toIndentedString(inputStream)).append("\n");
    sb.append("    outputFormat: ").append(toIndentedString(outputFormat)).append("\n");
    sb.append("    filename: ").append(toIndentedString(filename)).append("\n");
    sb.append("    outputs: ").append(toIndentedString(outputs)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

