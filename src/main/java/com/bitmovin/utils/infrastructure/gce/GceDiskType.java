package com.bitmovin.utils.infrastructure.gce;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by
 * David Moser [david.moser@bitmovin.com]
 * on 4/21/16
 */
public enum GceDiskType
{
    SSD ("pd-ssd"),
    HDD ("pd-standard");

    private static Map<String, GceDiskType> map = new HashMap<String, GceDiskType>(2);

    static {
        map.put("pd-ssd", SSD);
        map.put("pd-standard", HDD);
    }

    private final String name;

    GceDiskType(String s)
    {
        name = s;
    }

    @JsonCreator
    public static GceDiskType forValue(String value)
    {
        return map.get(value);
    }

    @JsonValue
    public String toString()
    {
        return this.name;
    }
}
