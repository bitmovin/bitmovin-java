package com.bitmovin.api.encoding;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum S3SignatureVersion
{
    S3_V2,
    S3_V4
}
