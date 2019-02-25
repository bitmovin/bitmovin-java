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
 * S3Output
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public class S3Output extends Output {
  @JsonProperty("bucketName")
  private String bucketName;

  @JsonProperty("accessKey")
  private String accessKey;

  @JsonProperty("secretKey")
  private String secretKey;

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
   * Amazon S3 access key
   * @return accessKey
  **/
  public String getAccessKey() {
    return accessKey;
  }

  public void setAccessKey(String accessKey) {
    this.accessKey = accessKey;
  }


  /**
   * Amazon S3 secret key
   * @return secretKey
  **/
  public String getSecretKey() {
    return secretKey;
  }

  public void setSecretKey(String secretKey) {
    this.secretKey = secretKey;
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
   * Get signatureVersion
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
    S3Output s3Output = (S3Output) o;
    return Objects.equals(this.bucketName, s3Output.bucketName) &&
        Objects.equals(this.accessKey, s3Output.accessKey) &&
        Objects.equals(this.secretKey, s3Output.secretKey) &&
        Objects.equals(this.md5MetaTag, s3Output.md5MetaTag) &&
        Objects.equals(this.cloudRegion, s3Output.cloudRegion) &&
        Objects.equals(this.signatureVersion, s3Output.signatureVersion) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bucketName, accessKey, secretKey, md5MetaTag, cloudRegion, signatureVersion, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class S3Output {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    bucketName: ").append(toIndentedString(bucketName)).append("\n");
    sb.append("    accessKey: ").append(toIndentedString(accessKey)).append("\n");
    sb.append("    secretKey: ").append(toIndentedString(secretKey)).append("\n");
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

