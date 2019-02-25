package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.EncryptionType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * WebhookEncryption
 */

public class WebhookEncryption {
  @JsonProperty("type")
  private EncryptionType type = null;

  @JsonProperty("key")
  private String key;


  /**
   * The encryption algorithm used for the webhook
   * @return type
  **/
  public EncryptionType getType() {
    return type;
  }

  public void setType(EncryptionType type) {
    this.type = type;
  }


  /**
   * The key of the encryption
   * @return key
  **/
  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WebhookEncryption webhookEncryption = (WebhookEncryption) o;
    return Objects.equals(this.type, webhookEncryption.type) &&
        Objects.equals(this.key, webhookEncryption.key);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, key);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WebhookEncryption {\n");
    
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

