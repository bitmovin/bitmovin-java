package com.bitmovin.api.encoding.codecConfigurations.enums;

/**
 * Created by akopper on 20.07.16.
 */
public enum ConfigType
{
    AAC("AAC"),
    H264("H264"),
    H265("H265"),
    VP9("VP9");

    private final String name;

    ConfigType(String s)
    {
        this.name = s;
    }
}
