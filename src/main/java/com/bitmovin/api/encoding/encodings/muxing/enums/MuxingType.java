package com.bitmovin.api.encoding.encodings.muxing.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 25.07.16.
 */
public enum MuxingType
{
    FMP4("FMP4"),
    MP4("MP4"),
    TS("TS"),
    WEBM("WEBM"),
    PROGRESSIVE_TS("PROGRESSIVE_TS"),
    BROADCAST_TS("BROADCAST_TS");

    private final String name;
    private static HashMap<String, MuxingType> map;

    MuxingType(String s)
    {
        this.name = s;
    }

    @JsonCreator
    public static MuxingType forValue(String value)
    {
        return map.get(value);
    }

    @JsonValue
    public String toString()
    {
        return this.name;
    }

    static
    {
        map = new HashMap();
        map.put("FMP4", FMP4);
        map.put("MP4", MP4);
        map.put("TS", TS);
        map.put("WEBM", WEBM);
        map.put("PROGRESSIVE_TS", PROGRESSIVE_TS);
        map.put("BROADCAST_TS", BROADCAST_TS);
    }
}