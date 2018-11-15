package com.bitmovin.api.encoding.filters;

import java.util.HashMap;

/**
 * Created by dmoser on 24.10.16.
 */
public enum FilterType
{
    CROP("CROP"),
    WATERMARK("WATERMARK"),
    ROTATE("ROTATE"),
    AUDIO_MIX("AUDIO_MIX"),
    DEINTERLACE("DEINTERLACE"),
    SCALE("SCALE"),
    TEXT("TEXT"),
    UNSHARP("UNSHARP"),
    INTERLACE("INTERLACE");

    private final String name;
    private static HashMap<String, FilterType> map;

    FilterType(String s)
    {
        this.name = s;
    }

    public static FilterType forValue(String value)
    {
        return map.get(value);
    }

    public String toString()
    {
        return this.name;
    }

    static
    {
        map = new HashMap<String, FilterType>(4);
        map.put("CROP", CROP);
        map.put("WATERMARK", WATERMARK);
        map.put("ROTATE", ROTATE);
        map.put("AUDIO_MIX", AUDIO_MIX);
        map.put("DEINTERLACE", DEINTERLACE);
        map.put("SCALE", SCALE);
        map.put("TEXT", TEXT);
        map.put("UNSHARP", UNSHARP);
        map.put("INTERLACE", INTERLACE);
    }
}
