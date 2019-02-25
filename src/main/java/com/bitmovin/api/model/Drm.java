package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BitmovinResource;
import com.bitmovin.api.model.DrmType;
import com.bitmovin.api.model.EncodingOutput;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Drm
 */

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = false)
@JsonSubTypes({
  @JsonSubTypes.Type(value = WidevineDrm.class, name = "WIDEVINE"),
  @JsonSubTypes.Type(value = PlayReadyDrm.class, name = "PLAYREADY"),
  @JsonSubTypes.Type(value = PrimeTimeDrm.class, name = "PRIMETIME"),
  @JsonSubTypes.Type(value = FairPlayDrm.class, name = "FAIRPLAY"),
  @JsonSubTypes.Type(value = MarlinDrm.class, name = "MARLIN"),
  @JsonSubTypes.Type(value = ClearKeyDrm.class, name = "CLEARKEY"),
  @JsonSubTypes.Type(value = AesEncryptionDrm.class, name = "AES"),
  @JsonSubTypes.Type(value = CencDrm.class, name = "CENC"),
})

public class Drm extends BitmovinResource {
  @JsonProperty("type")
  private DrmType type = null;

  @JsonProperty("outputs")
  private List<EncodingOutput> outputs;

  /**
   * Get type
   * @return type
  **/
  public DrmType getType() {
    return type;
  }


  public Drm addOutputsItem(EncodingOutput outputsItem) {
    if (this.outputs == null) {
      this.outputs = new ArrayList<>();
    }
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
    Drm drm = (Drm) o;
    return Objects.equals(this.type, drm.type) &&
        Objects.equals(this.outputs, drm.outputs) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, outputs, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Drm {\n");
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

