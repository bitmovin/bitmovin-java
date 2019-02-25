package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.AclEntry;
import com.bitmovin.api.model.AwsCloudRegion;
import com.bitmovin.api.model.Output;
import com.bitmovin.api.model.OutputType;
import com.bitmovin.api.model.S3SignatureVersion;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * S3RoleBasedOutput
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public class S3RoleBasedOutput extends Output {
  @JsonProperty("bucketName")
  private String bucketName;

  @JsonProperty("roleArn")
  private String roleArn;

  @JsonProperty("md5MetaTag")
  private String md5MetaTag;

  @JsonProperty("cloudRegion")
  private AwsCloudRegion cloudRegion = null;

  @JsonProperty("signatureVersion")
  private S3SignatureVersion signatureVersion = null;


  /**
   * Amazon S3 bucket name
   * @return bucketName
  **/
  public String getBucketName() {
    return bucketName;
  }

  public void setBucketName(String bucketName) {
    this.bucketName = bucketName;
  }


  /**
   * Amazon ARN of the Role that will be assumed for S3 access.
   * @return roleArn
  **/
  public String getRoleArn() {
    return roleArn;
  }

  public void setRoleArn(String roleArn) {
    this.roleArn = roleArn;
  }


  /**
   * If set a user defined tag (x-amz-meta-) with that key will be used to store the MD5 hash of the file.
   * @return md5MetaTag
  **/
  public String getMd5MetaTag() {
    return md5MetaTag;
  }

  public void setMd5MetaTag(String md5MetaTag) {
    this.md5MetaTag = md5MetaTag;
  }


  /**
   * Get cloudRegion
   * @return cloudRegion
  **/
  public AwsCloudRegion getCloudRegion() {
    return cloudRegion;
  }

  public void setCloudRegion(AwsCloudRegion cloudRegion) {
    this.cloudRegion = cloudRegion;
  }


  /**
   * Specifies the method used for authentication
   * @return signatureVersion
  **/
  public S3SignatureVersion getSignatureVersion() {
    return signatureVersion;
  }

  public void setSignatureVersion(S3SignatureVersion signatureVersion) {
    this.signatureVersion = signatureVersion;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    S3RoleBasedOutput s3RoleBasedOutput = (S3RoleBasedOutput) o;
    return Objects.equals(this.bucketName, s3RoleBasedOutput.bucketName) &&
        Objects.equals(this.roleArn, s3RoleBasedOutput.roleArn) &&
        Objects.equals(this.md5MetaTag, s3RoleBasedOutput.md5MetaTag) &&
        Objects.equals(this.cloudRegion, s3RoleBasedOutput.cloudRegion) &&
        Objects.equals(this.signatureVersion, s3RoleBasedOutput.signatureVersion) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bucketName, roleArn, md5MetaTag, cloudRegion, signatureVersion, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class S3RoleBasedOutput {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    bucketName: ").append(toIndentedString(bucketName)).append("\n");
    sb.append("    roleArn: ").append(toIndentedString(roleArn)).append("\n");
    sb.append("    md5MetaTag: ").append(toIndentedString(md5MetaTag)).append("\n");
    sb.append("    cloudRegion: ").append(toIndentedString(cloudRegion)).append("\n");
    sb.append("    signatureVersion: ").append(toIndentedString(signatureVersion)).append("\n");
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

