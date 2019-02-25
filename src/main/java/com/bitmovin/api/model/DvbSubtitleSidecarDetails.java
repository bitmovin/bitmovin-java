package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BitmovinResource;
import com.bitmovin.api.model.InputStream;
import com.bitmovin.api.model.Output;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * DvbSubtitleSidecarDetails
 */

public class DvbSubtitleSidecarDetails extends BitmovinResource {
  @JsonProperty("inputStream")
  private InputStream inputStream = null;

  @JsonProperty("outputs")
  private List<Output> outputs;

  @JsonProperty("imageFileNaming")
  private String imageFileNaming;

  @JsonProperty("indexFilename")
  private String indexFilename;

  @JsonProperty("imageFormat")
  private String imageFormat;

  @JsonProperty("outputFormat")
  private String outputFormat;


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


  public DvbSubtitleSidecarDetails addOutputsItem(Output outputsItem) {
    if (this.outputs == null) {
      this.outputs = new ArrayList<>();
    }
    this.outputs.add(outputsItem);
    return this;
  }

  /**
   * The output where the extracted subtitle should be written to
   * @return outputs
  **/
  public List<Output> getOutputs() {
    return outputs;
  }

  public void setOutputs(List<Output> outputs) {
    this.outputs = outputs;
  }


  /**
   * Naming strategy for the image files
   * @return imageFileNaming
  **/
  public String getImageFileNaming() {
    return imageFileNaming;
  }

  public void setImageFileNaming(String imageFileNaming) {
    this.imageFileNaming = imageFileNaming;
  }


  /**
   * Name of the index file
   * @return indexFilename
  **/
  public String getIndexFilename() {
    return indexFilename;
  }

  public void setIndexFilename(String indexFilename) {
    this.indexFilename = indexFilename;
  }


  /**
   * Specify the format of the generated images
   * @return imageFormat
  **/
  public String getImageFormat() {
    return imageFormat;
  }

  public void setImageFormat(String imageFormat) {
    this.imageFormat = imageFormat;
  }


  /**
   * Get outputFormat
   * @return outputFormat
  **/
  public String getOutputFormat() {
    return outputFormat;
  }

  public void setOutputFormat(String outputFormat) {
    this.outputFormat = outputFormat;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DvbSubtitleSidecarDetails dvbSubtitleSidecarDetails = (DvbSubtitleSidecarDetails) o;
    return Objects.equals(this.inputStream, dvbSubtitleSidecarDetails.inputStream) &&
        Objects.equals(this.outputs, dvbSubtitleSidecarDetails.outputs) &&
        Objects.equals(this.imageFileNaming, dvbSubtitleSidecarDetails.imageFileNaming) &&
        Objects.equals(this.indexFilename, dvbSubtitleSidecarDetails.indexFilename) &&
        Objects.equals(this.imageFormat, dvbSubtitleSidecarDetails.imageFormat) &&
        Objects.equals(this.outputFormat, dvbSubtitleSidecarDetails.outputFormat) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(inputStream, outputs, imageFileNaming, indexFilename, imageFormat, outputFormat, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DvbSubtitleSidecarDetails {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    inputStream: ").append(toIndentedString(inputStream)).append("\n");
    sb.append("    outputs: ").append(toIndentedString(outputs)).append("\n");
    sb.append("    imageFileNaming: ").append(toIndentedString(imageFileNaming)).append("\n");
    sb.append("    indexFilename: ").append(toIndentedString(indexFilename)).append("\n");
    sb.append("    imageFormat: ").append(toIndentedString(imageFormat)).append("\n");
    sb.append("    outputFormat: ").append(toIndentedString(outputFormat)).append("\n");
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

