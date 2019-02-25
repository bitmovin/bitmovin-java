package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.AclPermission;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * AclEntry
 */

public class AclEntry {
  @JsonProperty("scope")
  private String scope;

  @JsonProperty("permission")
  private AclPermission permission = null;


  /**
   * Get scope
   * @return scope
  **/
  public String getScope() {
    return scope;
  }

  public void setScope(String scope) {
    this.scope = scope;
  }


  /**
   * Get permission
   * @return permission
  **/
  public AclPermission getPermission() {
    return permission;
  }

  public void setPermission(AclPermission permission) {
    this.permission = permission;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AclEntry aclEntry = (AclEntry) o;
    return Objects.equals(this.scope, aclEntry.scope) &&
        Objects.equals(this.permission, aclEntry.permission);
  }

  @Override
  public int hashCode() {
    return Objects.hash(scope, permission);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AclEntry {\n");
    
    sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
    sb.append("    permission: ").append(toIndentedString(permission)).append("\n");
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

