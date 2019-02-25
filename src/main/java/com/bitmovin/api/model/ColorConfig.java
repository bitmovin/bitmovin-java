package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.ChromaLocation;
import com.bitmovin.api.model.ColorPrimaries;
import com.bitmovin.api.model.ColorRange;
import com.bitmovin.api.model.ColorSpace;
import com.bitmovin.api.model.ColorTransfer;
import com.bitmovin.api.model.InputColorRange;
import com.bitmovin.api.model.InputColorSpace;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * ColorConfig
 */

public class ColorConfig {
  @JsonProperty("copyChromaLocationFlag")
  private Boolean copyChromaLocationFlag;

  @JsonProperty("copyColorSpaceFlag")
  private Boolean copyColorSpaceFlag;

  @JsonProperty("copyColorPrimariesFlag")
  private Boolean copyColorPrimariesFlag;

  @JsonProperty("copyColorRangeFlag")
  private Boolean copyColorRangeFlag;

  @JsonProperty("copyColorTransferFlag")
  private Boolean copyColorTransferFlag;

  @JsonProperty("chromaLocation")
  private ChromaLocation chromaLocation = null;

  @JsonProperty("colorSpace")
  private ColorSpace colorSpace = null;

  @JsonProperty("colorPrimaries")
  private ColorPrimaries colorPrimaries = null;

  @JsonProperty("colorRange")
  private ColorRange colorRange = null;

  @JsonProperty("colorTransfer")
  private ColorTransfer colorTransfer = null;

  @JsonProperty("inputColorSpace")
  private InputColorSpace inputColorSpace = null;

  @JsonProperty("inputColorRange")
  private InputColorRange inputColorRange = null;


  /**
   * Copy the chroma location setting from the input source
   * @return copyChromaLocationFlag
  **/
  public Boolean getCopyChromaLocationFlag() {
    return copyChromaLocationFlag;
  }

  public void setCopyChromaLocationFlag(Boolean copyChromaLocationFlag) {
    this.copyChromaLocationFlag = copyChromaLocationFlag;
  }


  /**
   * Copy the color space setting from the input source
   * @return copyColorSpaceFlag
  **/
  public Boolean getCopyColorSpaceFlag() {
    return copyColorSpaceFlag;
  }

  public void setCopyColorSpaceFlag(Boolean copyColorSpaceFlag) {
    this.copyColorSpaceFlag = copyColorSpaceFlag;
  }


  /**
   * Copy the color primaries setting from the input source
   * @return copyColorPrimariesFlag
  **/
  public Boolean getCopyColorPrimariesFlag() {
    return copyColorPrimariesFlag;
  }

  public void setCopyColorPrimariesFlag(Boolean copyColorPrimariesFlag) {
    this.copyColorPrimariesFlag = copyColorPrimariesFlag;
  }


  /**
   * Copy the color range setting from the input source
   * @return copyColorRangeFlag
  **/
  public Boolean getCopyColorRangeFlag() {
    return copyColorRangeFlag;
  }

  public void setCopyColorRangeFlag(Boolean copyColorRangeFlag) {
    this.copyColorRangeFlag = copyColorRangeFlag;
  }


  /**
   * Copy the color transfer setting from the input source
   * @return copyColorTransferFlag
  **/
  public Boolean getCopyColorTransferFlag() {
    return copyColorTransferFlag;
  }

  public void setCopyColorTransferFlag(Boolean copyColorTransferFlag) {
    this.copyColorTransferFlag = copyColorTransferFlag;
  }


  /**
   * The chroma location to be applied
   * @return chromaLocation
  **/
  public ChromaLocation getChromaLocation() {
    return chromaLocation;
  }

  public void setChromaLocation(ChromaLocation chromaLocation) {
    this.chromaLocation = chromaLocation;
  }


  /**
   * The color space to be applied
   * @return colorSpace
  **/
  public ColorSpace getColorSpace() {
    return colorSpace;
  }

  public void setColorSpace(ColorSpace colorSpace) {
    this.colorSpace = colorSpace;
  }


  /**
   * The color primaries to be applied
   * @return colorPrimaries
  **/
  public ColorPrimaries getColorPrimaries() {
    return colorPrimaries;
  }

  public void setColorPrimaries(ColorPrimaries colorPrimaries) {
    this.colorPrimaries = colorPrimaries;
  }


  /**
   * The color range to be applied
   * @return colorRange
  **/
  public ColorRange getColorRange() {
    return colorRange;
  }

  public void setColorRange(ColorRange colorRange) {
    this.colorRange = colorRange;
  }


  /**
   * The color transfer to be applied
   * @return colorTransfer
  **/
  public ColorTransfer getColorTransfer() {
    return colorTransfer;
  }

  public void setColorTransfer(ColorTransfer colorTransfer) {
    this.colorTransfer = colorTransfer;
  }


  /**
   * Override the color space detected in the input file. If not set the input color space will be automatically detected if possible.
   * @return inputColorSpace
  **/
  public InputColorSpace getInputColorSpace() {
    return inputColorSpace;
  }

  public void setInputColorSpace(InputColorSpace inputColorSpace) {
    this.inputColorSpace = inputColorSpace;
  }


  /**
   * Override the color range detected in the input file. If not set the input color range will be automatically detected if possible.
   * @return inputColorRange
  **/
  public InputColorRange getInputColorRange() {
    return inputColorRange;
  }

  public void setInputColorRange(InputColorRange inputColorRange) {
    this.inputColorRange = inputColorRange;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ColorConfig colorConfig = (ColorConfig) o;
    return Objects.equals(this.copyChromaLocationFlag, colorConfig.copyChromaLocationFlag) &&
        Objects.equals(this.copyColorSpaceFlag, colorConfig.copyColorSpaceFlag) &&
        Objects.equals(this.copyColorPrimariesFlag, colorConfig.copyColorPrimariesFlag) &&
        Objects.equals(this.copyColorRangeFlag, colorConfig.copyColorRangeFlag) &&
        Objects.equals(this.copyColorTransferFlag, colorConfig.copyColorTransferFlag) &&
        Objects.equals(this.chromaLocation, colorConfig.chromaLocation) &&
        Objects.equals(this.colorSpace, colorConfig.colorSpace) &&
        Objects.equals(this.colorPrimaries, colorConfig.colorPrimaries) &&
        Objects.equals(this.colorRange, colorConfig.colorRange) &&
        Objects.equals(this.colorTransfer, colorConfig.colorTransfer) &&
        Objects.equals(this.inputColorSpace, colorConfig.inputColorSpace) &&
        Objects.equals(this.inputColorRange, colorConfig.inputColorRange);
  }

  @Override
  public int hashCode() {
    return Objects.hash(copyChromaLocationFlag, copyColorSpaceFlag, copyColorPrimariesFlag, copyColorRangeFlag, copyColorTransferFlag, chromaLocation, colorSpace, colorPrimaries, colorRange, colorTransfer, inputColorSpace, inputColorRange);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ColorConfig {\n");
    
    sb.append("    copyChromaLocationFlag: ").append(toIndentedString(copyChromaLocationFlag)).append("\n");
    sb.append("    copyColorSpaceFlag: ").append(toIndentedString(copyColorSpaceFlag)).append("\n");
    sb.append("    copyColorPrimariesFlag: ").append(toIndentedString(copyColorPrimariesFlag)).append("\n");
    sb.append("    copyColorRangeFlag: ").append(toIndentedString(copyColorRangeFlag)).append("\n");
    sb.append("    copyColorTransferFlag: ").append(toIndentedString(copyColorTransferFlag)).append("\n");
    sb.append("    chromaLocation: ").append(toIndentedString(chromaLocation)).append("\n");
    sb.append("    colorSpace: ").append(toIndentedString(colorSpace)).append("\n");
    sb.append("    colorPrimaries: ").append(toIndentedString(colorPrimaries)).append("\n");
    sb.append("    colorRange: ").append(toIndentedString(colorRange)).append("\n");
    sb.append("    colorTransfer: ").append(toIndentedString(colorTransfer)).append("\n");
    sb.append("    inputColorSpace: ").append(toIndentedString(inputColorSpace)).append("\n");
    sb.append("    inputColorRange: ").append(toIndentedString(inputColorRange)).append("\n");
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

