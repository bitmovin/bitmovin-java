package com.bitmovin.api.rest.enums;

import java.util.HashMap;

public enum ServiceMessageType
{
    ERROR("ERROR"),
    WARNING("WARNING"),
    INFO("INFO"),
    DEBUG("DEBUG"),
    TRACE("TRACE");

    private final String name;
    private static HashMap<String, ServiceMessageType> map;

    ServiceMessageType(String s)
    {
        this.name = s;
    }

    public static ServiceMessageType forValue(String value)
    {
        return map.get(value);
    }

    public String toString()
    {
        return this.name;
    }

    static
    {
        map = new HashMap<>(5);
        map.put("ERROR", ERROR);
        map.put("WARNING", WARNING);
        map.put("INFO", INFO);
        map.put("DEBUG", DEBUG);
        map.put("TRACE", TRACE);
    }
}