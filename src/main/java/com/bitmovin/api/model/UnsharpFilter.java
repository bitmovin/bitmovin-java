package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.Filter;
import com.bitmovin.api.model.FilterType;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * UnsharpFilter
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public class UnsharpFilter extends Filter {
  @JsonProperty("lumaMatrixHorizontalSize")
  private Integer lumaMatrixHorizontalSize;

  @JsonProperty("lumaMatrixVerticalSize")
  private Integer lumaMatrixVerticalSize;

  @JsonProperty("lumaEffectStrength")
  private Double lumaEffectStrength;

  @JsonProperty("chromaMatrixHorizontalSize")
  private Integer chromaMatrixHorizontalSize;

  @JsonProperty("chromaMatrixVerticalSize")
  private Integer chromaMatrixVerticalSize;

  @JsonProperty("chromaEffectStrength")
  private Double chromaEffectStrength;


  /**
   * Must be an odd integer between 3 and 23
   * @return lumaMatrixHorizontalSize
  **/
  public Integer getLumaMatrixHorizontalSize() {
    return lumaMatrixHorizontalSize;
  }

  public void setLumaMatrixHorizontalSize(Integer lumaMatrixHorizontalSize) {
    this.lumaMatrixHorizontalSize = lumaMatrixHorizontalSize;
  }


  /**
   * Must be an odd integer between 3 and 23
   * @return lumaMatrixVerticalSize
  **/
  public Integer getLumaMatrixVerticalSize() {
    return lumaMatrixVerticalSize;
  }

  public void setLumaMatrixVerticalSize(Integer lumaMatrixVerticalSize) {
    this.lumaMatrixVerticalSize = lumaMatrixVerticalSize;
  }


  /**
   * Negative value: blur, positive value: sharpen, floating point number, valid value range: -1.5 - 1.5
   * @return lumaEffectStrength
  **/
  public Double getLumaEffectStrength() {
    return lumaEffectStrength;
  }

  public void setLumaEffectStrength(Double lumaEffectStrength) {
    this.lumaEffectStrength = lumaEffectStrength;
  }


  /**
   * Must be an odd integer between 3 and 23
   * @return chromaMatrixHorizontalSize
  **/
  public Integer getChromaMatrixHorizontalSize() {
    return chromaMatrixHorizontalSize;
  }

  public void setChromaMatrixHorizontalSize(Integer chromaMatrixHorizontalSize) {
    this.chromaMatrixHorizontalSize = chromaMatrixHorizontalSize;
  }


  /**
   * Must be an odd integer between 3 and 23
   * @return chromaMatrixVerticalSize
  **/
  public Integer getChromaMatrixVerticalSize() {
    return chromaMatrixVerticalSize;
  }

  public void setChromaMatrixVerticalSize(Integer chromaMatrixVerticalSize) {
    this.chromaMatrixVerticalSize = chromaMatrixVerticalSize;
  }


  /**
   * Negative value: blur, positive value: sharpen, floating point number, valid value range: -1.5 - 1.5
   * @return chromaEffectStrength
  **/
  public Double getChromaEffectStrength() {
    return chromaEffectStrength;
  }

  public void setChromaEffectStrength(Double chromaEffectStrength) {
    this.chromaEffectStrength = chromaEffectStrength;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UnsharpFilter unsharpFilter = (UnsharpFilter) o;
    return Objects.equals(this.lumaMatrixHorizontalSize, unsharpFilter.lumaMatrixHorizontalSize) &&
        Objects.equals(this.lumaMatrixVerticalSize, unsharpFilter.lumaMatrixVerticalSize) &&
        Objects.equals(this.lumaEffectStrength, unsharpFilter.lumaEffectStrength) &&
        Objects.equals(this.chromaMatrixHorizontalSize, unsharpFilter.chromaMatrixHorizontalSize) &&
        Objects.equals(this.chromaMatrixVerticalSize, unsharpFilter.chromaMatrixVerticalSize) &&
        Objects.equals(this.chromaEffectStrength, unsharpFilter.chromaEffectStrength) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lumaMatrixHorizontalSize, lumaMatrixVerticalSize, lumaEffectStrength, chromaMatrixHorizontalSize, chromaMatrixVerticalSize, chromaEffectStrength, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UnsharpFilter {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    lumaMatrixHorizontalSize: ").append(toIndentedString(lumaMatrixHorizontalSize)).append("\n");
    sb.append("    lumaMatrixVerticalSize: ").append(toIndentedString(lumaMatrixVerticalSize)).append("\n");
    sb.append("    lumaEffectStrength: ").append(toIndentedString(lumaEffectStrength)).append("\n");
    sb.append("    chromaMatrixHorizontalSize: ").append(toIndentedString(chromaMatrixHorizontalSize)).append("\n");
    sb.append("    chromaMatrixVerticalSize: ").append(toIndentedString(chromaMatrixVerticalSize)).append("\n");
    sb.append("    chromaEffectStrength: ").append(toIndentedString(chromaEffectStrength)).append("\n");
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

