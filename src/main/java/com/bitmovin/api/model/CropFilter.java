package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.Filter;
import com.bitmovin.api.model.FilterType;
import com.bitmovin.api.model.PositionUnit;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * CropFilter
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public class CropFilter extends Filter {
  @JsonProperty("left")
  private Integer left;

  @JsonProperty("right")
  private Integer right;

  @JsonProperty("top")
  private Integer top;

  @JsonProperty("bottom")
  private Integer bottom;

  @JsonProperty("unit")
  private PositionUnit unit = null;


  /**
   * Amount of pixels which will be cropped of the input video from the left side.
   * @return left
  **/
  public Integer getLeft() {
    return left;
  }

  public void setLeft(Integer left) {
    this.left = left;
  }


  /**
   * Amount of pixels which will be cropped of the input video from the right side.
   * @return right
  **/
  public Integer getRight() {
    return right;
  }

  public void setRight(Integer right) {
    this.right = right;
  }


  /**
   * Amount of pixels which will be cropped of the input video from the top.
   * @return top
  **/
  public Integer getTop() {
    return top;
  }

  public void setTop(Integer top) {
    this.top = top;
  }


  /**
   * Amount of pixels which will be cropped of the input video from the bottom.
   * @return bottom
  **/
  public Integer getBottom() {
    return bottom;
  }

  public void setBottom(Integer bottom) {
    this.bottom = bottom;
  }


  /**
   * Get unit
   * @return unit
  **/
  public PositionUnit getUnit() {
    return unit;
  }

  public void setUnit(PositionUnit unit) {
    this.unit = unit;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CropFilter cropFilter = (CropFilter) o;
    return Objects.equals(this.left, cropFilter.left) &&
        Objects.equals(this.right, cropFilter.right) &&
        Objects.equals(this.top, cropFilter.top) &&
        Objects.equals(this.bottom, cropFilter.bottom) &&
        Objects.equals(this.unit, cropFilter.unit) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(left, right, top, bottom, unit, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CropFilter {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    left: ").append(toIndentedString(left)).append("\n");
    sb.append("    right: ").append(toIndentedString(right)).append("\n");
    sb.append("    top: ").append(toIndentedString(top)).append("\n");
    sb.append("    bottom: ").append(toIndentedString(bottom)).append("\n");
    sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
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

