package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.AdaptationSetRole;
import com.bitmovin.api.model.BitmovinResponse;
import com.bitmovin.api.model.CustomAttribute;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * AdaptationSet
 */

public class AdaptationSet extends BitmovinResponse {
  @JsonProperty("customAttributes")
  private List<CustomAttribute> customAttributes;

  @JsonProperty("roles")
  private List<AdaptationSetRole> roles;


  public AdaptationSet addCustomAttributesItem(CustomAttribute customAttributesItem) {
    if (this.customAttributes == null) {
      this.customAttributes = new ArrayList<>();
    }
    this.customAttributes.add(customAttributesItem);
    return this;
  }

  /**
   * Custom adaptation set attributes
   * @return customAttributes
  **/
  public List<CustomAttribute> getCustomAttributes() {
    return customAttributes;
  }

  public void setCustomAttributes(List<CustomAttribute> customAttributes) {
    this.customAttributes = customAttributes;
  }


  public AdaptationSet addRolesItem(AdaptationSetRole rolesItem) {
    if (this.roles == null) {
      this.roles = new ArrayList<>();
    }
    this.roles.add(rolesItem);
    return this;
  }

  /**
   * Roles of the adaptation set
   * @return roles
  **/
  public List<AdaptationSetRole> getRoles() {
    return roles;
  }

  public void setRoles(List<AdaptationSetRole> roles) {
    this.roles = roles;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AdaptationSet adaptationSet = (AdaptationSet) o;
    return Objects.equals(this.customAttributes, adaptationSet.customAttributes) &&
        Objects.equals(this.roles, adaptationSet.roles) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customAttributes, roles, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdaptationSet {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    customAttributes: ").append(toIndentedString(customAttributes)).append("\n");
    sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
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

