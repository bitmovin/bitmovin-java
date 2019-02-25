package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BitmovinResource;
import com.bitmovin.api.model.CodecConfigType;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * CodecConfiguration
 */

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = false)
@JsonSubTypes({
  @JsonSubTypes.Type(value = AacAudioConfiguration.class, name = "AAC"),
  @JsonSubTypes.Type(value = HeAacV1AudioConfiguration.class, name = "HE_AAC_V1"),
  @JsonSubTypes.Type(value = HeAacV2AudioConfiguration.class, name = "HE_AAC_V2"),
  @JsonSubTypes.Type(value = H264VideoConfiguration.class, name = "H264"),
  @JsonSubTypes.Type(value = H265VideoConfiguration.class, name = "H265"),
  @JsonSubTypes.Type(value = Vp9VideoConfiguration.class, name = "VP9"),
  @JsonSubTypes.Type(value = Vp8VideoConfiguration.class, name = "VP8"),
  @JsonSubTypes.Type(value = Mp2AudioConfiguration.class, name = "MP2"),
  @JsonSubTypes.Type(value = Mp3AudioConfiguration.class, name = "MP3"),
  @JsonSubTypes.Type(value = Ac3AudioConfiguration.class, name = "AC3"),
  @JsonSubTypes.Type(value = Eac3AudioConfiguration.class, name = "EAC3"),
  @JsonSubTypes.Type(value = OpusAudioConfiguration.class, name = "OPUS"),
  @JsonSubTypes.Type(value = VorbisAudioConfiguration.class, name = "VORBIS"),
  @JsonSubTypes.Type(value = MjpegVideoConfiguration.class, name = "MJPEG"),
  @JsonSubTypes.Type(value = Av1VideoConfiguration.class, name = "AV1"),
})

public class CodecConfiguration extends BitmovinResource {
  @JsonProperty("type")
  private CodecConfigType type = null;

  /**
   * The type of the codec configuration
   * @return type
  **/
  public CodecConfigType getType() {
    return type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CodecConfiguration codecConfiguration = (CodecConfiguration) o;
    return Objects.equals(this.type, codecConfiguration.type) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CodecConfiguration {\n");
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

