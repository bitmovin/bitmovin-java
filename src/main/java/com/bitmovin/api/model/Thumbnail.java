package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BitmovinResource;
import com.bitmovin.api.model.EncodingOutput;
import com.bitmovin.api.model.ThumbnailUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Thumbnail
 */

public class Thumbnail extends BitmovinResource {
  @JsonProperty("height")
  private Integer height;

  @JsonProperty("pattern")
  private String pattern;

  @JsonProperty("positions")
  private List<Double> positions = new ArrayList<Double>();

  @JsonProperty("outputs")
  private List<EncodingOutput> outputs;

  @JsonProperty("unit")
  private ThumbnailUnit unit = null;


  /**
   * Height of the thumbnail
   * @return height
  **/
  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }


  /**
   *  Pattern which describes the thumbnail filenames. For example with thumbnail-%number%.png as pattern and 3 positions: thumbnail-3.png, thumbnail-5.png and thumbnail-25_5.png. (The number represents the position in the source video in seconds, in the previous example the first filename represents the thumbnail at 3s, the second one at 5s and the third one at 25.5s)
   * @return pattern
  **/
  public String getPattern() {
    return pattern;
  }

  public void setPattern(String pattern) {
    this.pattern = pattern;
  }


  public Thumbnail addPositionsItem(Double positionsItem) {
    this.positions.add(positionsItem);
    return this;
  }

  /**
   * Position in the unit where the thumbnail should be created from.
   * @return positions
  **/
  public List<Double> getPositions() {
    return positions;
  }

  public void setPositions(List<Double> positions) {
    this.positions = positions;
  }


  public Thumbnail addOutputsItem(EncodingOutput outputsItem) {
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


  /**
   * Get unit
   * @return unit
  **/
  public ThumbnailUnit getUnit() {
    return unit;
  }

  public void setUnit(ThumbnailUnit unit) {
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
    Thumbnail thumbnail = (Thumbnail) o;
    return Objects.equals(this.height, thumbnail.height) &&
        Objects.equals(this.pattern, thumbnail.pattern) &&
        Objects.equals(this.positions, thumbnail.positions) &&
        Objects.equals(this.outputs, thumbnail.outputs) &&
        Objects.equals(this.unit, thumbnail.unit) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(height, pattern, positions, outputs, unit, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Thumbnail {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    height: ").append(toIndentedString(height)).append("\n");
    sb.append("    pattern: ").append(toIndentedString(pattern)).append("\n");
    sb.append("    positions: ").append(toIndentedString(positions)).append("\n");
    sb.append("    outputs: ").append(toIndentedString(outputs)).append("\n");
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

