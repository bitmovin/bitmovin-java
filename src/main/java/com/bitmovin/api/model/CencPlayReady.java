package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * CencPlayReady
 */

public class CencPlayReady {
  @JsonProperty("laUrl")
  private String laUrl;

  @JsonProperty("pssh")
  private String pssh;


  /**
   * Url of the license server. Either the laUrl or the pssh needs to be provided.
   * @return laUrl
  **/
  public String getLaUrl() {
    return laUrl;
  }

  public void setLaUrl(String laUrl) {
    this.laUrl = laUrl;
  }


  /**
   * Base64 encoded pssh payload.
   * @return pssh
  **/
  public String getPssh() {
    return pssh;
  }

  public void setPssh(String pssh) {
    this.pssh = pssh;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CencPlayReady cencPlayReady = (CencPlayReady) o;
    return Objects.equals(this.laUrl, cencPlayReady.laUrl) &&
        Objects.equals(this.pssh, cencPlayReady.pssh);
  }

  @Override
  public int hashCode() {
    return Objects.hash(laUrl, pssh);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CencPlayReady {\n");
    
    sb.append("    laUrl: ").append(toIndentedString(laUrl)).append("\n");
    sb.append("    pssh: ").append(toIndentedString(pssh)).append("\n");
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

