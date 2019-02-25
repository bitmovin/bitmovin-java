package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BitmovinResource;
import com.bitmovin.api.model.WebhookEncryption;
import com.bitmovin.api.model.WebhookHttpMethod;
import com.bitmovin.api.model.WebhookSignature;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Webhook
 */

public class Webhook extends BitmovinResource {
  @JsonProperty("url")
  private String url;

  @JsonProperty("method")
  private WebhookHttpMethod method = null;

  @JsonProperty("insecureSsl")
  private Boolean insecureSsl;

  @JsonProperty("encryption")
  private WebhookEncryption encryption = null;

  @JsonProperty("signature")
  private WebhookSignature signature = null;


  /**
   * Webhook url
   * @return url
  **/
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


  /**
   * HTTP method used for the webhook
   * @return method
  **/
  public WebhookHttpMethod getMethod() {
    return method;
  }

  public void setMethod(WebhookHttpMethod method) {
    this.method = method;
  }


  /**
   * Whether to skip SSL certification verification or not
   * @return insecureSsl
  **/
  public Boolean getInsecureSsl() {
    return insecureSsl;
  }

  public void setInsecureSsl(Boolean insecureSsl) {
    this.insecureSsl = insecureSsl;
  }


  /**
   * Encryption used for the webhook
   * @return encryption
  **/
  public WebhookEncryption getEncryption() {
    return encryption;
  }

  public void setEncryption(WebhookEncryption encryption) {
    this.encryption = encryption;
  }


  /**
   * Signature used for the webhook
   * @return signature
  **/
  public WebhookSignature getSignature() {
    return signature;
  }

  public void setSignature(WebhookSignature signature) {
    this.signature = signature;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Webhook webhook = (Webhook) o;
    return Objects.equals(this.url, webhook.url) &&
        Objects.equals(this.method, webhook.method) &&
        Objects.equals(this.insecureSsl, webhook.insecureSsl) &&
        Objects.equals(this.encryption, webhook.encryption) &&
        Objects.equals(this.signature, webhook.signature) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(url, method, insecureSsl, encryption, signature, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Webhook {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    insecureSsl: ").append(toIndentedString(insecureSsl)).append("\n");
    sb.append("    encryption: ").append(toIndentedString(encryption)).append("\n");
    sb.append("    signature: ").append(toIndentedString(signature)).append("\n");
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

