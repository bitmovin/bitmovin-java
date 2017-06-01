package com.bitmovin.api.encoding.encodings.drms.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;

/**
 * Created by doweinberger on 8/16/16.
 */
public enum PlayReadyEncryptionMethod
{
    MPEG_CENC("MPEG_CENC"),
    PIFF_CTR("PIFF_CTR");

    private final String name;
    private static HashMap<String, PlayReadyEncryptionMethod> map;

    PlayReadyEncryptionMethod(String s)
    {
        this.name = s;
    }

    @JsonCreator
    public static PlayReadyEncryptionMethod forValue(String value)
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
        map = new HashMap(2);
        map.put("MPEG_CENC", MPEG_CENC);
        map.put("PIFF_CTR", PIFF_CTR);
    }
}
