package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BitmovinResource;
import com.bitmovin.api.model.FilterType;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Filter
 */

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = false)
@JsonSubTypes({
  @JsonSubTypes.Type(value = CropFilter.class, name = "CROP"),
  @JsonSubTypes.Type(value = WatermarkFilter.class, name = "WATERMARK"),
  @JsonSubTypes.Type(value = EnhancedWatermarkFilter.class, name = "ENHANCED_WATERMARK"),
  @JsonSubTypes.Type(value = RotateFilter.class, name = "ROTATE"),
  @JsonSubTypes.Type(value = DeinterlaceFilter.class, name = "DEINTERLACE"),
  @JsonSubTypes.Type(value = AudioMixFilter.class, name = "AUDIO_MIX"),
  @JsonSubTypes.Type(value = DenoiseHqdn3dFilter.class, name = "DENOISE_HQDN3D"),
  @JsonSubTypes.Type(value = TextFilter.class, name = "TEXT"),
  @JsonSubTypes.Type(value = UnsharpFilter.class, name = "UNSHARP"),
  @JsonSubTypes.Type(value = ScaleFilter.class, name = "SCALE"),
  @JsonSubTypes.Type(value = InterlaceFilter.class, name = "INTERLACE"),
  @JsonSubTypes.Type(value = AudioVolumeFilter.class, name = "AUDIO_VOLUME"),
})

public class Filter extends BitmovinResource {
  @JsonProperty("type")
  private FilterType type = null;


  /**
   * Get type
   * @return type
  **/
  public FilterType getType() {
    return type;
  }

  public void setType(FilterType type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Filter filter = (Filter) o;
    return Objects.equals(this.type, filter.type) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Filter {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

