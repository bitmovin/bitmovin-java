package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BitmovinResource;
import com.bitmovin.api.model.EncodingOutput;
import com.bitmovin.api.model.ManifestType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Manifest
 */

public class Manifest extends BitmovinResource {
  @JsonProperty("type")
  private ManifestType type = null;

  @JsonProperty("outputs")
  private List<EncodingOutput> outputs = new ArrayList<EncodingOutput>();

  /**
   * Get type
   * @return type
  **/
  public ManifestType getType() {
    return type;
  }


  public Manifest addOutputsItem(EncodingOutput outputsItem) {
    this.outputs.add(outputsItem);
    return this;
  }

  /**
   * The outputs to store the manifest
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
    Manifest manifest = (Manifest) o;
    return Objects.equals(this.type, manifest.type) &&
        Objects.equals(this.outputs, manifest.outputs) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, outputs, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Manifest {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

