package com.bitmovin.api.encoding.codecConfigurations.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by doweinberger on 8/31/16.
 **/
public enum ChannelLayout
{
    @JsonProperty("NONE")
    NONE,

    @JsonProperty("MONO")
    MONO,

    @JsonProperty("STEREO")
    CL_STEREO,

    @JsonProperty("2.1")
    CL_2_1,

    @JsonProperty("SURROUND")
    CL_SURROUND,

    @JsonProperty("3.1")
    CL_3_1,

    @JsonProperty("4.0")
    CL_4_0,

    @JsonProperty("4.1")
    CL_4_1,

    @JsonProperty("2.2")
    CL_2_2,

    @JsonProperty("QUAD")
    CL_QUAD,

    @JsonProperty("5.0")
    CL_5_0,

    @JsonProperty("5.1")
    CL_5_1,

    @JsonProperty("5.0_BACK")
    CL_5_0_BACK,

    @JsonProperty("5.1_BACK")
    CL_5_1_BACK,

    @JsonProperty("6.0")
    CL_6_0,

    @JsonProperty("6.0_FRONT")
    CL_6_0_FRONT,

    @JsonProperty("HEXAGONAL")
    CL_HEXAGONAL,

    @JsonProperty("6.1")
    CL_6_1,

    @JsonProperty("6.1_BACK")
    CL_6_1_BACK,

    @JsonProperty("6.1_FRONT")
    CL_6_1_FRONT,

    @JsonProperty("7.0")
    CL_7_0,

    @JsonProperty("7.0_FRONT")
    CL_7_0_FRONT,

    @JsonProperty("7.1")
    CL_7_1,

    @JsonProperty("7.1_WIDE")
    CL_7_1_WIDE,

    @JsonProperty("7.1_WIDE_BACK")
    CL_7_1_WIDE_BACK,

    @JsonProperty("OCTAGONAL")
    CL_OCTAGONAL,

    @JsonProperty("STEREO_DOWNMIX")
    CL_STEREO_DOWNMIX
}
