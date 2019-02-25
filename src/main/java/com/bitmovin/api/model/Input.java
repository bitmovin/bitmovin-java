package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BitmovinResource;
import com.bitmovin.api.model.InputType;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Input
 */

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = false)
@JsonSubTypes({
  @JsonSubTypes.Type(value = AkamaiNetStorageInput.class, name = "AKAMAI_NETSTORAGE"),
  @JsonSubTypes.Type(value = AsperaInput.class, name = "ASPERA"),
  @JsonSubTypes.Type(value = AzureInput.class, name = "AZURE"),
  @JsonSubTypes.Type(value = RedundantRtmpInput.class, name = "REDUNDANT_RTMP"),
  @JsonSubTypes.Type(value = FtpInput.class, name = "FTP"),
  @JsonSubTypes.Type(value = GenericS3Input.class, name = "GENERIC_S3"),
  @JsonSubTypes.Type(value = GcsInput.class, name = "GCS"),
  @JsonSubTypes.Type(value = HttpInput.class, name = "HTTP"),
  @JsonSubTypes.Type(value = HttpsInput.class, name = "HTTPS"),
  @JsonSubTypes.Type(value = LocalInput.class, name = "LOCAL"),
  @JsonSubTypes.Type(value = RtmpInput.class, name = "RTMP"),
  @JsonSubTypes.Type(value = S3Input.class, name = "S3"),
  @JsonSubTypes.Type(value = S3RoleBasedInput.class, name = "S3_ROLE_BASED"),
  @JsonSubTypes.Type(value = SftpInput.class, name = "SFTP"),
  @JsonSubTypes.Type(value = TcpInput.class, name = "TCP"),
  @JsonSubTypes.Type(value = UdpInput.class, name = "UDP"),
  @JsonSubTypes.Type(value = UdpMulticastInput.class, name = "UDP_MULTICAST"),
  @JsonSubTypes.Type(value = ZixiInput.class, name = "ZIXI"),
})

public class Input extends BitmovinResource {
  @JsonProperty("type")
  private InputType type = null;

  /**
   * The type of the input
   * @return type
  **/
  public InputType getType() {
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
    Input input = (Input) o;
    return Objects.equals(this.type, input.type) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Input {\n");
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

