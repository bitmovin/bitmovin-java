package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.ConvertSccPositionMode;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * ConvertSccCaptionWebVttSettings
 */

public class ConvertSccCaptionWebVttSettings {
  @JsonProperty("positionMode")
  private ConvertSccPositionMode positionMode = null;

  @JsonProperty("removeFlash")
  private Boolean removeFlash;

  @JsonProperty("removeColor")
  private Boolean removeColor;


  /**
   * Get positionMode
   * @return positionMode
  **/
  public ConvertSccPositionMode getPositionMode() {
    return positionMode;
  }

  public void setPositionMode(ConvertSccPositionMode positionMode) {
    this.positionMode = positionMode;
  }


  /**
   * Remove flash (blinking) information when converting SCC to WebVTT
   * @return removeFlash
  **/
  public Boolean getRemoveFlash() {
    return removeFlash;
  }

  public void setRemoveFlash(Boolean removeFlash) {
    this.removeFlash = removeFlash;
  }


  /**
   * Remove color information when converting SCC to WebVTT
   * @return removeColor
  **/
  public Boolean getRemoveColor() {
    return removeColor;
  }

  public void setRemoveColor(Boolean removeColor) {
    this.removeColor = removeColor;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConvertSccCaptionWebVttSettings convertSccCaptionWebVttSettings = (ConvertSccCaptionWebVttSettings) o;
    return Objects.equals(this.positionMode, convertSccCaptionWebVttSettings.positionMode) &&
        Objects.equals(this.removeFlash, convertSccCaptionWebVttSettings.removeFlash) &&
        Objects.equals(this.removeColor, convertSccCaptionWebVttSettings.removeColor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(positionMode, removeFlash, removeColor);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConvertSccCaptionWebVttSettings {\n");
    
    sb.append("    positionMode: ").append(toIndentedString(positionMode)).append("\n");
    sb.append("    removeFlash: ").append(toIndentedString(removeFlash)).append("\n");
    sb.append("    removeColor: ").append(toIndentedString(removeColor)).append("\n");
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

