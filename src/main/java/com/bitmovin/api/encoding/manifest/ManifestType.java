package com.bitmovin.api.encoding.manifest;

import java.util.HashMap;

/**
 * Created by dmoser on 24.10.16.
 */
public enum ManifestType
{
    DASH("DASH"),
    HLS("HLS");

    private final String name;
    private static HashMap<String, ManifestType> map;

    ManifestType(String s)
    {
        this.name = s;
    }

    public static ManifestType forValue(String value)
    {
        return map.get(value);
    }

    public String toString()
    {
        return this.name;
    }

    static {
        map = new HashMap<String, ManifestType>(2);
        map.put("DASH", DASH);
        map.put("HLS", HLS);
    }
}
