package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BitmovinResource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * KubernetesCluster
 */

public class KubernetesCluster extends BitmovinResource {
  @JsonProperty("online")
  private Boolean online;

  @JsonProperty("connected")
  private Boolean connected;

  @JsonProperty("agentDeploymentDownloadUrl")
  private String agentDeploymentDownloadUrl;

  /**
   * Shows if the Bitmovin Agent is alive
   * @return online
  **/
  public Boolean getOnline() {
    return online;
  }

  /**
   * Shows if the Kubernetes cluster is accessible by the Bitmovin Agent
   * @return connected
  **/
  public Boolean getConnected() {
    return connected;
  }

  /**
   * Get agentDeploymentDownloadUrl
   * @return agentDeploymentDownloadUrl
  **/
  public String getAgentDeploymentDownloadUrl() {
    return agentDeploymentDownloadUrl;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KubernetesCluster kubernetesCluster = (KubernetesCluster) o;
    return Objects.equals(this.online, kubernetesCluster.online) &&
        Objects.equals(this.connected, kubernetesCluster.connected) &&
        Objects.equals(this.agentDeploymentDownloadUrl, kubernetesCluster.agentDeploymentDownloadUrl) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(online, connected, agentDeploymentDownloadUrl, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class KubernetesCluster {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    online: ").append(toIndentedString(online)).append("\n");
    sb.append("    connected: ").append(toIndentedString(connected)).append("\n");
    sb.append("    agentDeploymentDownloadUrl: ").append(toIndentedString(agentDeploymentDownloadUrl)).append("\n");
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

