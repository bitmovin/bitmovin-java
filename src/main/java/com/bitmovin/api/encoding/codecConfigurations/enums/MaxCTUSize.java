package com.bitmovin.api.encoding.codecConfigurations.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by akopper on 13.07.16.
 */
public enum MaxCTUSize
{

    @JsonProperty("16")
    S16,

    @JsonProperty("32")
    S32,

    @JsonProperty("64")
    S64

}
