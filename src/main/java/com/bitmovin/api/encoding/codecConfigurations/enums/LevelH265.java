package com.bitmovin.api.encoding.codecConfigurations.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by akopper on 13.07.16.
 */
public enum LevelH265
{

    @JsonProperty("1")
    L1,

    @JsonProperty("2")
    L2,

    @JsonProperty("2.1")
    L2_1,

    @JsonProperty("3")
    L3,

    @JsonProperty("3.1")
    L3_1,

    @JsonProperty("4")
    L4,

    @JsonProperty("4.1")
    L4_1,

    @JsonProperty("5")
    L5,

    @JsonProperty("5.1")
    L5_1,

    @JsonProperty("5.2")
    L5_2,

    @JsonProperty("6")
    L6,

    @JsonProperty("6.1")
    L6_1,

    @JsonProperty("6.2")
    L6_2

}
