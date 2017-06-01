package com.bitmovin.api.encoding.filters.enums;

import java.util.HashMap;

/**
 * Created by dmoser on 25.11.16.
 */
public enum DeinterlaceMode
{
    FRAME("FRAME"),
    FIELD("FIELD"),
    FRAME_NOSPATIAL("FRAME_NOSPATIAL"),
    FIELD_NOSPATIAL("FIELD_NOSPATIAL");

    private final String name;
    private static HashMap<String, DeinterlaceMode> map;

    DeinterlaceMode(String s)
    {
        this.name = s;
    }

    public static DeinterlaceMode forValue(String value)
    {
        return map.get(value);
    }
    public String toString()
    {
        return this.name;
    }

    static
    {
        map = new HashMap<String, DeinterlaceMode>(4);
        map.put("FRAME", FRAME);
        map.put("FIELD", FIELD);
        map.put("FRAME_NOSPATIAL", FRAME_NOSPATIAL);
        map.put("FIELD_NOSPATIAL", FIELD_NOSPATIAL);
    }
}

