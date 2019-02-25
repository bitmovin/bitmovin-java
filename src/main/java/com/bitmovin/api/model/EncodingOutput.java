package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.AclEntry;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * EncodingOutput
 */

public class EncodingOutput {
  @JsonProperty("outputId")
  private String outputId;

  @JsonProperty("outputPath")
  private String outputPath;

  @JsonProperty("acl")
  private List<AclEntry> acl;


  /**
   * Id of the corresponding output
   * @return outputId
  **/
  public String getOutputId() {
    return outputId;
  }

  public void setOutputId(String outputId) {
    this.outputId = outputId;
  }


  /**
   * Subdirectory where to save the files to
   * @return outputPath
  **/
  public String getOutputPath() {
    return outputPath;
  }

  public void setOutputPath(String outputPath) {
    this.outputPath = outputPath;
  }


  public EncodingOutput addAclItem(AclEntry aclItem) {
    if (this.acl == null) {
      this.acl = new ArrayList<>();
    }
    this.acl.add(aclItem);
    return this;
  }

  /**
   * Get acl
   * @return acl
  **/
  public List<AclEntry> getAcl() {
    return acl;
  }

  public void setAcl(List<AclEntry> acl) {
    this.acl = acl;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EncodingOutput encodingOutput = (EncodingOutput) o;
    return Objects.equals(this.outputId, encodingOutput.outputId) &&
        Objects.equals(this.outputPath, encodingOutput.outputPath) &&
        Objects.equals(this.acl, encodingOutput.acl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(outputId, outputPath, acl);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EncodingOutput {\n");
    
    sb.append("    outputId: ").append(toIndentedString(outputId)).append("\n");
    sb.append("    outputPath: ").append(toIndentedString(outputPath)).append("\n");
    sb.append("    acl: ").append(toIndentedString(acl)).append("\n");
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

