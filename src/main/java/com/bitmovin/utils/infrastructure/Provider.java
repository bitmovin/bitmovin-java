package com.bitmovin.utils.infrastructure;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by
 * David Moser [david.moser@bitmovin.com]
 * on 4/20/16
 */
public enum Provider
{
    GCE   ("gce"),
    AWS   ("aws"),
    AZURE ("azure");

    private String name;
    private static Map<String, Provider> map = new HashMap<>();

    static
    {
        map.put("gce",   GCE);
        map.put("aws",   AWS);
        map.put("azure", AZURE);
    }

    Provider(String s)
    {
        this.name = s;
    }

    @JsonCreator
    public static Provider forValue(String value)
    {
        return map.get(value);
    }

    @JsonValue
    public String toString()
    {
        return this.name;
    }
}
