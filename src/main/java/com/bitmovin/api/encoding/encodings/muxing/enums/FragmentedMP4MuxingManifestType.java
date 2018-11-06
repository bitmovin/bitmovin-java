package com.bitmovin.api.encoding.encodings.muxing.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public enum FragmentedMP4MuxingManifestType
{
    SMOOTH,
    DASH_ON_DEMAND,
    HLS_BYTE_RANGES
}
