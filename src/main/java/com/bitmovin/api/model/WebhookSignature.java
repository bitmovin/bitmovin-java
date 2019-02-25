package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.SignatureType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * WebhookSignature
 */

public class WebhookSignature {
  @JsonProperty("type")
  private SignatureType type = null;

  @JsonProperty("key")
  private String key;


  /**
   * The signature type used for the webhook
   * @return type
  **/
  public SignatureType getType() {
    return type;
  }

  public void setType(SignatureType type) {
    this.type = type;
  }

  /**
   * The key of the signature
   * @return key
  **/
  public String getKey() {
    return key;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WebhookSignature webhookSignature = (WebhookSignature) o;
    return Objects.equals(this.type, webhookSignature.type) &&
        Objects.equals(this.key, webhookSignature.key);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, key);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WebhookSignature {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
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

