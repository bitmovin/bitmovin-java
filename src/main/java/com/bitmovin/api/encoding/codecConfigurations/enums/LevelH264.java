package com.bitmovin.api.encoding.codecConfigurations.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by akopper on 13.07.16.
 */
public enum LevelH264
{

    @JsonProperty("1")
    L1,

    @JsonProperty("1b")
    L1b,

    @JsonProperty("1.1")
    L1_1,

    @JsonProperty("1.2")
    L1_2,

    @JsonProperty("1.3")
    L1_3,

    @JsonProperty("2")
    L2,

    @JsonProperty("2.1")
    L2_1,

    @JsonProperty("2.2")
    L2_2,

    @JsonProperty("3")
    L3,

    @JsonProperty("3.1")
    L3_1,

    @JsonProperty("3.2")
    L3_2,

    @JsonProperty("4")
    L4,

    @JsonProperty("4.1")
    L4_1,

    @JsonProperty("4.2")
    L4_2,

    @JsonProperty("5")
    L5,

    @JsonProperty("5.1")
    L5_1,

    @JsonProperty("5.2")
    L5_2

}
