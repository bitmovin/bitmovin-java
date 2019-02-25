package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BitmovinResource;
import com.bitmovin.api.model.ConvertSccCaptionWebVttSettings;
import com.bitmovin.api.model.EncodingOutput;
import com.bitmovin.api.model.InputPath;
import com.bitmovin.api.model.StreamCaptionOutputFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * ConvertSccCaption
 */

public class ConvertSccCaption extends BitmovinResource {
  @JsonProperty("input")
  private InputPath input = null;

  @JsonProperty("outputs")
  private List<EncodingOutput> outputs = new ArrayList<EncodingOutput>();

  @JsonProperty("fileName")
  private String fileName;

  @JsonProperty("outputFormat")
  private StreamCaptionOutputFormat outputFormat = null;

  @JsonProperty("webVttSettings")
  private ConvertSccCaptionWebVttSettings webVttSettings = null;


  /**
   * The input location to get the scc file from
   * @return input
  **/
  public InputPath getInput() {
    return input;
  }

  public void setInput(InputPath input) {
    this.input = input;
  }


  public ConvertSccCaption addOutputsItem(EncodingOutput outputsItem) {
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


  /**
   * Name of the captions file
   * @return fileName
  **/
  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }


  /**
   * Get outputFormat
   * @return outputFormat
  **/
  public StreamCaptionOutputFormat getOutputFormat() {
    return outputFormat;
  }

  public void setOutputFormat(StreamCaptionOutputFormat outputFormat) {
    this.outputFormat = outputFormat;
  }


  /**
   * Optional settings when converting SCC to WebVTT
   * @return webVttSettings
  **/
  public ConvertSccCaptionWebVttSettings getWebVttSettings() {
    return webVttSettings;
  }

  public void setWebVttSettings(ConvertSccCaptionWebVttSettings webVttSettings) {
    this.webVttSettings = webVttSettings;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConvertSccCaption convertSccCaption = (ConvertSccCaption) o;
    return Objects.equals(this.input, convertSccCaption.input) &&
        Objects.equals(this.outputs, convertSccCaption.outputs) &&
        Objects.equals(this.fileName, convertSccCaption.fileName) &&
        Objects.equals(this.outputFormat, convertSccCaption.outputFormat) &&
        Objects.equals(this.webVttSettings, convertSccCaption.webVttSettings) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(input, outputs, fileName, outputFormat, webVttSettings, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConvertSccCaption {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    input: ").append(toIndentedString(input)).append("\n");
    sb.append("    outputs: ").append(toIndentedString(outputs)).append("\n");
    sb.append("    fileName: ").append(toIndentedString(fileName)).append("\n");
    sb.append("    outputFormat: ").append(toIndentedString(outputFormat)).append("\n");
    sb.append("    webVttSettings: ").append(toIndentedString(webVttSettings)).append("\n");
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

