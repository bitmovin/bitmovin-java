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
 * EnhancedWatermarkFilter
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public class EnhancedWatermarkFilter extends Filter {
  @JsonProperty("image")
  private String image;

  @JsonProperty("left")
  private Double left;

  @JsonProperty("right")
  private Double right;

  @JsonProperty("top")
  private Double top;

  @JsonProperty("bottom")
  private Double bottom;

  @JsonProperty("unit")
  private PositionUnit unit = null;


  /**
   * URL of the file to be used as watermark image. Supported image formats: PNG, JPEG, BMP, GIF
   * @return image
  **/
  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }


  /**
   * Distance from the left edge of the input video to the left edge of the watermark image. May not be set if &#39;right&#39; is set.
   * @return left
  **/
  public Double getLeft() {
    return left;
  }

  public void setLeft(Double left) {
    this.left = left;
  }


  /**
   * Distance from the right edge of the input video to the right edge of the watermark image . May not be set if &#39;left&#39; is set.
   * @return right
  **/
  public Double getRight() {
    return right;
  }

  public void setRight(Double right) {
    this.right = right;
  }


  /**
   * Distance from the top edge of the input video to the top edge of the watermark image. May not be set if &#39;bottom&#39; is set.
   * @return top
  **/
  public Double getTop() {
    return top;
  }

  public void setTop(Double top) {
    this.top = top;
  }


  /**
   * Distance from the bottom edge of the input video to the bottom edge of the watermark image. May not be set if &#39;top&#39; is set.
   * @return bottom
  **/
  public Double getBottom() {
    return bottom;
  }

  public void setBottom(Double bottom) {
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
    EnhancedWatermarkFilter enhancedWatermarkFilter = (EnhancedWatermarkFilter) o;
    return Objects.equals(this.image, enhancedWatermarkFilter.image) &&
        Objects.equals(this.left, enhancedWatermarkFilter.left) &&
        Objects.equals(this.right, enhancedWatermarkFilter.right) &&
        Objects.equals(this.top, enhancedWatermarkFilter.top) &&
        Objects.equals(this.bottom, enhancedWatermarkFilter.bottom) &&
        Objects.equals(this.unit, enhancedWatermarkFilter.unit) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(image, left, right, top, bottom, unit, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EnhancedWatermarkFilter {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
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

