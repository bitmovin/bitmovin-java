package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BitmovinResource;
import com.bitmovin.api.model.EncodingOutput;
import com.bitmovin.api.model.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * WebVttExtract
 */

public class WebVttExtract extends BitmovinResource {
  @JsonProperty("inputStream")
  private InputStream inputStream = null;

  @JsonProperty("outputs")
  private List<EncodingOutput> outputs = new ArrayList<EncodingOutput>();

  @JsonProperty("fileName")
  private String fileName;


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


  public WebVttExtract addOutputsItem(EncodingOutput outputsItem) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WebVttExtract webVttExtract = (WebVttExtract) o;
    return Objects.equals(this.inputStream, webVttExtract.inputStream) &&
        Objects.equals(this.outputs, webVttExtract.outputs) &&
        Objects.equals(this.fileName, webVttExtract.fileName) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(inputStream, outputs, fileName, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WebVttExtract {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    inputStream: ").append(toIndentedString(inputStream)).append("\n");
    sb.append("    outputs: ").append(toIndentedString(outputs)).append("\n");
    sb.append("    fileName: ").append(toIndentedString(fileName)).append("\n");
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

