package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.RaiUnit;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * BroadcastTsInputStreamConfiguration
 */

public class BroadcastTsInputStreamConfiguration {
  @JsonProperty("streamId")
  private String streamId;

  @JsonProperty("packetIdentifier")
  private Integer packetIdentifier;

  @JsonProperty("startWithDiscontinuityIndicator")
  private Boolean startWithDiscontinuityIndicator;

  @JsonProperty("alignPes")
  private Boolean alignPes;

  @JsonProperty("setRaiOnAu")
  private RaiUnit setRaiOnAu = null;


  /**
   * The UUID of the stream to which this configuration belongs to. This has to be a ID of a stream that has been added to the current muxing.
   * @return streamId
  **/
  public String getStreamId() {
    return streamId;
  }

  public void setStreamId(String streamId) {
    this.streamId = streamId;
  }


  /**
   * An integer value. Packet Identifier (PID) for this stream.
   * minimum: 16
   * maximum: 8190
   * @return packetIdentifier
  **/
  public Integer getPacketIdentifier() {
    return packetIdentifier;
  }

  public void setPacketIdentifier(Integer packetIdentifier) {
    this.packetIdentifier = packetIdentifier;
  }


  /**
   * Start stream with initial discontinuity indicator set to one. If true, set the discontinuity indicator in the first packet for this PID.
   * @return startWithDiscontinuityIndicator
  **/
  public Boolean getStartWithDiscontinuityIndicator() {
    return startWithDiscontinuityIndicator;
  }

  public void setStartWithDiscontinuityIndicator(Boolean startWithDiscontinuityIndicator) {
    this.startWithDiscontinuityIndicator = startWithDiscontinuityIndicator;
  }


  /**
   * Align access units to PES packets. If true, align access units to PES packet headers. Uses adaptation field stuffing to position an access unit at the beginning of each PES packet.
   * @return alignPes
  **/
  public Boolean getAlignPes() {
    return alignPes;
  }

  public void setAlignPes(Boolean alignPes) {
    this.alignPes = alignPes;
  }


  /**
   * Get setRaiOnAu
   * @return setRaiOnAu
  **/
  public RaiUnit getSetRaiOnAu() {
    return setRaiOnAu;
  }

  public void setSetRaiOnAu(RaiUnit setRaiOnAu) {
    this.setRaiOnAu = setRaiOnAu;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BroadcastTsInputStreamConfiguration broadcastTsInputStreamConfiguration = (BroadcastTsInputStreamConfiguration) o;
    return Objects.equals(this.streamId, broadcastTsInputStreamConfiguration.streamId) &&
        Objects.equals(this.packetIdentifier, broadcastTsInputStreamConfiguration.packetIdentifier) &&
        Objects.equals(this.startWithDiscontinuityIndicator, broadcastTsInputStreamConfiguration.startWithDiscontinuityIndicator) &&
        Objects.equals(this.alignPes, broadcastTsInputStreamConfiguration.alignPes) &&
        Objects.equals(this.setRaiOnAu, broadcastTsInputStreamConfiguration.setRaiOnAu);
  }

  @Override
  public int hashCode() {
    return Objects.hash(streamId, packetIdentifier, startWithDiscontinuityIndicator, alignPes, setRaiOnAu);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BroadcastTsInputStreamConfiguration {\n");
    
    sb.append("    streamId: ").append(toIndentedString(streamId)).append("\n");
    sb.append("    packetIdentifier: ").append(toIndentedString(packetIdentifier)).append("\n");
    sb.append("    startWithDiscontinuityIndicator: ").append(toIndentedString(startWithDiscontinuityIndicator)).append("\n");
    sb.append("    alignPes: ").append(toIndentedString(alignPes)).append("\n");
    sb.append("    setRaiOnAu: ").append(toIndentedString(setRaiOnAu)).append("\n");
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

