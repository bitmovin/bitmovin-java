package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * KubernetesClusterConfiguration
 */

public class KubernetesClusterConfiguration {
  @JsonProperty("parallelEncodings")
  private Integer parallelEncodings;

  @JsonProperty("workersPerEncoding")
  private Integer workersPerEncoding;


  /**
   * Number of parallel scheduled encodings on the Kubernetes cluster
   * @return parallelEncodings
  **/
  public Integer getParallelEncodings() {
    return parallelEncodings;
  }

  public void setParallelEncodings(Integer parallelEncodings) {
    this.parallelEncodings = parallelEncodings;
  }


  /**
   * Number of worker nodes used for each encoding on the Kubernetes cluster
   * @return workersPerEncoding
  **/
  public Integer getWorkersPerEncoding() {
    return workersPerEncoding;
  }

  public void setWorkersPerEncoding(Integer workersPerEncoding) {
    this.workersPerEncoding = workersPerEncoding;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KubernetesClusterConfiguration kubernetesClusterConfiguration = (KubernetesClusterConfiguration) o;
    return Objects.equals(this.parallelEncodings, kubernetesClusterConfiguration.parallelEncodings) &&
        Objects.equals(this.workersPerEncoding, kubernetesClusterConfiguration.workersPerEncoding);
  }

  @Override
  public int hashCode() {
    return Objects.hash(parallelEncodings, workersPerEncoding);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class KubernetesClusterConfiguration {\n");
    
    sb.append("    parallelEncodings: ").append(toIndentedString(parallelEncodings)).append("\n");
    sb.append("    workersPerEncoding: ").append(toIndentedString(workersPerEncoding)).append("\n");
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

