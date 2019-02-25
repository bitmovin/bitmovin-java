package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BitmovinResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * BitmovinResource
 */

public class BitmovinResource extends BitmovinResponse {
  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  @JsonProperty("createdAt")
  private Date createdAt;

  @JsonProperty("modifiedAt")
  private Date modifiedAt;

  @JsonProperty("customData")
  private Map<String, Object> customData;


  /**
   * Name of the resource. Can be freely chosen by the user.
   * @return name
  **/
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  /**
   * Description of the resource. Can be freely chosen by the user.
   * @return description
  **/
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Creation timestamp expressed in UTC: YYYY-MM-DDThh:mm:ssZ
   * @return createdAt
  **/
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * Modified timestamp expressed in UTC: YYYY-MM-DDThh:mm:ssZ
   * @return modifiedAt
  **/
  public Date getModifiedAt() {
    return modifiedAt;
  }


  public BitmovinResource putCustomDataItem(String key, Object customDataItem) {
    if (this.customData == null) {
      this.customData = new HashMap<String, Object>();
    }
    this.customData.put(key, customDataItem);
    return this;
  }

  /**
   * User-specific meta data. This can hold anything.
   * @return customData
  **/
  public Map<String, Object> getCustomData() {
    return customData;
  }

  public void setCustomData(Map<String, Object> customData) {
    this.customData = customData;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BitmovinResource bitmovinResource = (BitmovinResource) o;
    return Objects.equals(this.name, bitmovinResource.name) &&
        Objects.equals(this.description, bitmovinResource.description) &&
        Objects.equals(this.createdAt, bitmovinResource.createdAt) &&
        Objects.equals(this.modifiedAt, bitmovinResource.modifiedAt) &&
        Objects.equals(this.customData, bitmovinResource.customData) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, createdAt, modifiedAt, customData, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BitmovinResource {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    modifiedAt: ").append(toIndentedString(modifiedAt)).append("\n");
    sb.append("    customData: ").append(toIndentedString(customData)).append("\n");
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

