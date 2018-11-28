package com.bitmovin.api.encoding.encodings.drms.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;

public enum IvSize
{
    EIGHT_BYTES("8_BYTES"),
    SIXTEEN_BYTES("16_BYTES");

    private static HashMap<String, IvSize> map;

    private final String name;

    IvSize(String s)
    {
        this.name = s;
    }

    static
    {
        map = new HashMap<>(2);
        map.put("8_BYTES", EIGHT_BYTES);
        map.put("16_BYTES", SIXTEEN_BYTES);
    }

    @JsonCreator
    public static IvSize forValue(String value)
    {
        return map.get(value);
    }

    @JsonValue
    public String toString()
    {
        return this.name;
    }

}
