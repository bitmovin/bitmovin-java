package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BitmovinResource;
import com.bitmovin.api.model.Permission;
import com.bitmovin.api.model.Policy;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Acl
 */

public class Acl extends BitmovinResource {
  @JsonProperty("resource")
  private String resource;

  @JsonProperty("policy")
  private Policy policy = null;

  @JsonProperty("permissions")
  private List<Permission> permissions = new ArrayList<Permission>();


  /**
   * Resource to define the permission for.
   * @return resource
  **/
  public String getResource() {
    return resource;
  }

  public void setResource(String resource) {
    this.resource = resource;
  }


  /**
   * Get policy
   * @return policy
  **/
  public Policy getPolicy() {
    return policy;
  }

  public void setPolicy(Policy policy) {
    this.policy = policy;
  }


  public Acl addPermissionsItem(Permission permissionsItem) {
    this.permissions.add(permissionsItem);
    return this;
  }

  /**
   * Permissions to assign.
   * @return permissions
  **/
  public List<Permission> getPermissions() {
    return permissions;
  }

  public void setPermissions(List<Permission> permissions) {
    this.permissions = permissions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Acl acl = (Acl) o;
    return Objects.equals(this.resource, acl.resource) &&
        Objects.equals(this.policy, acl.policy) &&
        Objects.equals(this.permissions, acl.permissions) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resource, policy, permissions, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Acl {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    resource: ").append(toIndentedString(resource)).append("\n");
    sb.append("    policy: ").append(toIndentedString(policy)).append("\n");
    sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
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

