package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * BroadcastTsProgramConfiguration
 */

public class BroadcastTsProgramConfiguration {
  @JsonProperty("programNumber")
  private Integer programNumber;

  @JsonProperty("pidForPMT")
  private Integer pidForPMT;

  @JsonProperty("insertProgramClockRefOnPes")
  private Boolean insertProgramClockRefOnPes;


  /**
   * An integer value. Value for program_number field in Program Map Table (PMT). The value zero is reserved for the NIT PID entry in the PAT.
   * minimum: 1
   * maximum: 65535
   * @return programNumber
  **/
  public Integer getProgramNumber() {
    return programNumber;
  }

  public void setProgramNumber(Integer programNumber) {
    this.programNumber = programNumber;
  }


  /**
   * An integer value. Packet identifier (PID) to use for Program Map Table (PMT). Recommended value is 2 x programNumber.
   * minimum: 10
   * maximum: 8190
   * @return pidForPMT
  **/
  public Integer getPidForPMT() {
    return pidForPMT;
  }

  public void setPidForPMT(Integer pidForPMT) {
    this.pidForPMT = pidForPMT;
  }


  /**
   * Insert Program Clock References (PCRs) on all packetized elemementary stream packets. When false, indicates that PCRs should be inserted on every PES header. This parameter is effective only when the PCR packet identifier is the same as a video or audio elementary stream.
   * @return insertProgramClockRefOnPes
  **/
  public Boolean getInsertProgramClockRefOnPes() {
    return insertProgramClockRefOnPes;
  }

  public void setInsertProgramClockRefOnPes(Boolean insertProgramClockRefOnPes) {
    this.insertProgramClockRefOnPes = insertProgramClockRefOnPes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BroadcastTsProgramConfiguration broadcastTsProgramConfiguration = (BroadcastTsProgramConfiguration) o;
    return Objects.equals(this.programNumber, broadcastTsProgramConfiguration.programNumber) &&
        Objects.equals(this.pidForPMT, broadcastTsProgramConfiguration.pidForPMT) &&
        Objects.equals(this.insertProgramClockRefOnPes, broadcastTsProgramConfiguration.insertProgramClockRefOnPes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(programNumber, pidForPMT, insertProgramClockRefOnPes);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BroadcastTsProgramConfiguration {\n");
    
    sb.append("    programNumber: ").append(toIndentedString(programNumber)).append("\n");
    sb.append("    pidForPMT: ").append(toIndentedString(pidForPMT)).append("\n");
    sb.append("    insertProgramClockRefOnPes: ").append(toIndentedString(insertProgramClockRefOnPes)).append("\n");
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

