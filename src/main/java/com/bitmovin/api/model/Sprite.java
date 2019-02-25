package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BitmovinResource;
import com.bitmovin.api.model.EncodingOutput;
import com.bitmovin.api.model.SpriteUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Sprite
 */

public class Sprite extends BitmovinResource {
  @JsonProperty("height")
  private Integer height;

  @JsonProperty("width")
  private Integer width;

  @JsonProperty("unit")
  private SpriteUnit unit = null;

  @JsonProperty("distance")
  private Double distance;

  @JsonProperty("spriteName")
  private String spriteName;

  @JsonProperty("fileName")
  private String fileName;

  @JsonProperty("vttName")
  private String vttName;

  @JsonProperty("outputs")
  private List<EncodingOutput> outputs;

  @JsonProperty("imagesPerFile")
  private Integer imagesPerFile;


  /**
   * Height of one thumbnail
   * @return height
  **/
  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }


  /**
   * Width of one thumbnail
   * @return width
  **/
  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }


  /**
   * Get unit
   * @return unit
  **/
  public SpriteUnit getUnit() {
    return unit;
  }

  public void setUnit(SpriteUnit unit) {
    this.unit = unit;
  }


  /**
   * Distance in the given unit between a screenshot
   * @return distance
  **/
  public Double getDistance() {
    return distance;
  }

  public void setDistance(Double distance) {
    this.distance = distance;
  }


  /**
   * Name of the sprite image. File extension \&quot;.jpg\&quot; or \&quot;.png\&quot; is required.
   * @return spriteName
  **/
  public String getSpriteName() {
    return spriteName;
  }

  public void setSpriteName(String spriteName) {
    this.spriteName = spriteName;
  }


  /**
   * Filename of the sprite image. If not set, spriteName will be used, but without an extension.
   * @return fileName
  **/
  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }


  /**
   * Filename of the vtt-file. The file-extension \&quot;.vtt\&quot; is required.
   * @return vttName
  **/
  public String getVttName() {
    return vttName;
  }

  public void setVttName(String vttName) {
    this.vttName = vttName;
  }


  public Sprite addOutputsItem(EncodingOutput outputsItem) {
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
   * Number of images per file. If more images are generated than specified in this value, multiple sprites will be created. You can use the placeholder &#39;%number%&#39; in the spriteName to specify the naming policy.
   * @return imagesPerFile
  **/
  public Integer getImagesPerFile() {
    return imagesPerFile;
  }

  public void setImagesPerFile(Integer imagesPerFile) {
    this.imagesPerFile = imagesPerFile;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Sprite sprite = (Sprite) o;
    return Objects.equals(this.height, sprite.height) &&
        Objects.equals(this.width, sprite.width) &&
        Objects.equals(this.unit, sprite.unit) &&
        Objects.equals(this.distance, sprite.distance) &&
        Objects.equals(this.spriteName, sprite.spriteName) &&
        Objects.equals(this.fileName, sprite.fileName) &&
        Objects.equals(this.vttName, sprite.vttName) &&
        Objects.equals(this.outputs, sprite.outputs) &&
        Objects.equals(this.imagesPerFile, sprite.imagesPerFile) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(height, width, unit, distance, spriteName, fileName, vttName, outputs, imagesPerFile, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Sprite {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    height: ").append(toIndentedString(height)).append("\n");
    sb.append("    width: ").append(toIndentedString(width)).append("\n");
    sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
    sb.append("    distance: ").append(toIndentedString(distance)).append("\n");
    sb.append("    spriteName: ").append(toIndentedString(spriteName)).append("\n");
    sb.append("    fileName: ").append(toIndentedString(fileName)).append("\n");
    sb.append("    vttName: ").append(toIndentedString(vttName)).append("\n");
    sb.append("    outputs: ").append(toIndentedString(outputs)).append("\n");
    sb.append("    imagesPerFile: ").append(toIndentedString(imagesPerFile)).append("\n");
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

