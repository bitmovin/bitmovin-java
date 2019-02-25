package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.Filter;
import com.bitmovin.api.model.FilterType;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * DenoiseHqdn3dFilter
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public class DenoiseHqdn3dFilter extends Filter {
  @JsonProperty("lumaSpatial")
  private Double lumaSpatial;

  @JsonProperty("chromaSpatial")
  private Double chromaSpatial;

  @JsonProperty("lumaTmp")
  private Double lumaTmp;

  @JsonProperty("chromaTmp")
  private Double chromaTmp;


  /**
   * A non-negative floating point number which specifies spatial luma strength. It defaults to 4.0.
   * @return lumaSpatial
  **/
  public Double getLumaSpatial() {
    return lumaSpatial;
  }

  public void setLumaSpatial(Double lumaSpatial) {
    this.lumaSpatial = lumaSpatial;
  }


  /**
   * A non-negative floating point number which specifies spatial chroma strength. It defaults to 3.0*luma_spatial/4.0.
   * @return chromaSpatial
  **/
  public Double getChromaSpatial() {
    return chromaSpatial;
  }

  public void setChromaSpatial(Double chromaSpatial) {
    this.chromaSpatial = chromaSpatial;
  }


  /**
   * A floating point number which specifies luma temporal strength. It defaults to 6.0*luma_spatial/4.0.
   * @return lumaTmp
  **/
  public Double getLumaTmp() {
    return lumaTmp;
  }

  public void setLumaTmp(Double lumaTmp) {
    this.lumaTmp = lumaTmp;
  }


  /**
   * A floating point number which specifies chroma temporal strength. It defaults to luma_tmp*chroma_spatial/luma_spatial.
   * @return chromaTmp
  **/
  public Double getChromaTmp() {
    return chromaTmp;
  }

  public void setChromaTmp(Double chromaTmp) {
    this.chromaTmp = chromaTmp;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DenoiseHqdn3dFilter denoiseHqdn3dFilter = (DenoiseHqdn3dFilter) o;
    return Objects.equals(this.lumaSpatial, denoiseHqdn3dFilter.lumaSpatial) &&
        Objects.equals(this.chromaSpatial, denoiseHqdn3dFilter.chromaSpatial) &&
        Objects.equals(this.lumaTmp, denoiseHqdn3dFilter.lumaTmp) &&
        Objects.equals(this.chromaTmp, denoiseHqdn3dFilter.chromaTmp) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lumaSpatial, chromaSpatial, lumaTmp, chromaTmp, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DenoiseHqdn3dFilter {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    lumaSpatial: ").append(toIndentedString(lumaSpatial)).append("\n");
    sb.append("    chromaSpatial: ").append(toIndentedString(chromaSpatial)).append("\n");
    sb.append("    lumaTmp: ").append(toIndentedString(lumaTmp)).append("\n");
    sb.append("    chromaTmp: ").append(toIndentedString(chromaTmp)).append("\n");
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

