package com.bitmovin.utils.infrastructure.azure;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by arudich on 04.10.17.
 **/
public enum AzureDiskType
{
    STANDARD_LRS("Standard_LRS"),
    PREMIUM_LRS("Premium_LRS");

    private String name;
    private static Map<String, AzureDiskType> map = new HashMap<>();

    static
    {
        map.put("Standard_LRS", STANDARD_LRS);
        map.put("Premium_LRS", PREMIUM_LRS);
    }

    AzureDiskType(String s)
    {
        this.name = s;
    }

    @JsonCreator
    public static AzureDiskType forValue(String value)
    {
        return map.get(value);
    }

    @JsonValue
    public String toString()
    {
        return this.name;
    }
}
