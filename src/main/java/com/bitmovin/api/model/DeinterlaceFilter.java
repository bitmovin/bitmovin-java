package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.DeinterlaceFrameSelectionMode;
import com.bitmovin.api.model.DeinterlaceMode;
import com.bitmovin.api.model.Filter;
import com.bitmovin.api.model.FilterType;
import com.bitmovin.api.model.PictureFieldParity;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * DeinterlaceFilter
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public class DeinterlaceFilter extends Filter {
  @JsonProperty("parity")
  private PictureFieldParity parity = null;

  @JsonProperty("mode")
  private DeinterlaceMode mode = null;

  @JsonProperty("frameSelectionMode")
  private DeinterlaceFrameSelectionMode frameSelectionMode = null;


  /**
   * Get parity
   * @return parity
  **/
  public PictureFieldParity getParity() {
    return parity;
  }

  public void setParity(PictureFieldParity parity) {
    this.parity = parity;
  }


  /**
   * Get mode
   * @return mode
  **/
  public DeinterlaceMode getMode() {
    return mode;
  }

  public void setMode(DeinterlaceMode mode) {
    this.mode = mode;
  }


  /**
   * Get frameSelectionMode
   * @return frameSelectionMode
  **/
  public DeinterlaceFrameSelectionMode getFrameSelectionMode() {
    return frameSelectionMode;
  }

  public void setFrameSelectionMode(DeinterlaceFrameSelectionMode frameSelectionMode) {
    this.frameSelectionMode = frameSelectionMode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeinterlaceFilter deinterlaceFilter = (DeinterlaceFilter) o;
    return Objects.equals(this.parity, deinterlaceFilter.parity) &&
        Objects.equals(this.mode, deinterlaceFilter.mode) &&
        Objects.equals(this.frameSelectionMode, deinterlaceFilter.frameSelectionMode) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(parity, mode, frameSelectionMode, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeinterlaceFilter {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    parity: ").append(toIndentedString(parity)).append("\n");
    sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
    sb.append("    frameSelectionMode: ").append(toIndentedString(frameSelectionMode)).append("\n");
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

