package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.AwsCloudRegion;
import com.bitmovin.api.model.Input;
import com.bitmovin.api.model.InputType;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * S3Input
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public class S3Input extends Input {
  @JsonProperty("cloudRegion")
  private AwsCloudRegion cloudRegion = null;

  @JsonProperty("bucketName")
  private String bucketName;

  @JsonProperty("accessKey")
  private String accessKey;

  @JsonProperty("secretKey")
  private String secretKey;


  /**
   * The cloud region in which the bucket is located. Is used to determine the ideal location for your encodings automatically.
   * @return cloudRegion
  **/
  public AwsCloudRegion getCloudRegion() {
    return cloudRegion;
  }

  public void setCloudRegion(AwsCloudRegion cloudRegion) {
    this.cloudRegion = cloudRegion;
  }


  /**
   * Name of the bucket
   * @return bucketName
  **/
  public String getBucketName() {
    return bucketName;
  }

  public void setBucketName(String bucketName) {
    this.bucketName = bucketName;
  }


  /**
   * Amazon access key
   * @return accessKey
  **/
  public String getAccessKey() {
    return accessKey;
  }

  public void setAccessKey(String accessKey) {
    this.accessKey = accessKey;
  }


  /**
   * Amazon secret key
   * @return secretKey
  **/
  public String getSecretKey() {
    return secretKey;
  }

  public void setSecretKey(String secretKey) {
    this.secretKey = secretKey;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    S3Input s3Input = (S3Input) o;
    return Objects.equals(this.cloudRegion, s3Input.cloudRegion) &&
        Objects.equals(this.bucketName, s3Input.bucketName) &&
        Objects.equals(this.accessKey, s3Input.accessKey) &&
        Objects.equals(this.secretKey, s3Input.secretKey) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cloudRegion, bucketName, accessKey, secretKey, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class S3Input {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    cloudRegion: ").append(toIndentedString(cloudRegion)).append("\n");
    sb.append("    bucketName: ").append(toIndentedString(bucketName)).append("\n");
    sb.append("    accessKey: ").append(toIndentedString(accessKey)).append("\n");
    sb.append("    secretKey: ").append(toIndentedString(secretKey)).append("\n");
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

