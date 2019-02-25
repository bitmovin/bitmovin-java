package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.DashProfile;
import com.bitmovin.api.model.EncodingOutput;
import com.bitmovin.api.model.Manifest;
import com.bitmovin.api.model.ManifestType;
import com.bitmovin.api.model.XmlNamespace;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * DashManifest
 */

public class DashManifest extends Manifest {
  @JsonProperty("profile")
  private DashProfile profile = null;

  @JsonProperty("manifestName")
  private String manifestName;

  @JsonProperty("namespaces")
  private List<XmlNamespace> namespaces;


  /**
   * Get profile
   * @return profile
  **/
  public DashProfile getProfile() {
    return profile;
  }

  public void setProfile(DashProfile profile) {
    this.profile = profile;
  }


  /**
   * The filename of your manifest
   * @return manifestName
  **/
  public String getManifestName() {
    return manifestName;
  }

  public void setManifestName(String manifestName) {
    this.manifestName = manifestName;
  }


  public DashManifest addNamespacesItem(XmlNamespace namespacesItem) {
    if (this.namespaces == null) {
      this.namespaces = new ArrayList<>();
    }
    this.namespaces.add(namespacesItem);
    return this;
  }

  /**
   * List of additional XML namespaces to add to the DASH Manifest
   * @return namespaces
  **/
  public List<XmlNamespace> getNamespaces() {
    return namespaces;
  }

  public void setNamespaces(List<XmlNamespace> namespaces) {
    this.namespaces = namespaces;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DashManifest dashManifest = (DashManifest) o;
    return Objects.equals(this.profile, dashManifest.profile) &&
        Objects.equals(this.manifestName, dashManifest.manifestName) &&
        Objects.equals(this.namespaces, dashManifest.namespaces) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(profile, manifestName, namespaces, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DashManifest {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    profile: ").append(toIndentedString(profile)).append("\n");
    sb.append("    manifestName: ").append(toIndentedString(manifestName)).append("\n");
    sb.append("    namespaces: ").append(toIndentedString(namespaces)).append("\n");
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

