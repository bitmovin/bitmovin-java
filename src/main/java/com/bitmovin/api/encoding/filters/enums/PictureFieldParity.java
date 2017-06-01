package com.bitmovin.api.encoding.filters.enums;

import java.util.HashMap;

/**
 * Created by dmoser on 25.11.16.
 */
public enum PictureFieldParity
{
    AUTO("AUTO"),
    TOP_FIELD_FIRST("TOP_FIELD_FIRST"),
    BOTTOM_FIELD_FIRST("BOTTOM_FIELD_FIRST");

    private final String name;
    private static HashMap<String, PictureFieldParity> map;

    PictureFieldParity(String s)
    {
        this.name = s;
    }

    public static PictureFieldParity forValue(String value)
    {
        return map.get(value);
    }

    public String toString()
    {
        return this.name;
    }

    static
    {
        map = new HashMap<String, PictureFieldParity>(3);
        map.put("AUTO", AUTO);
        map.put("TOP_FIELD_FIRST", TOP_FIELD_FIRST);
        map.put("BOTTOM_FIELD_FIRST", BOTTOM_FIELD_FIRST);
    }
}
