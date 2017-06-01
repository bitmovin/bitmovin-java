package com.bitmovin.api.encoding.encodings.drms.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;

/**
 * Created by doweinberger on 8/16/16.
 */
public enum AESEncryptionMethod
{
    @JsonProperty("SAMPLE_AES")
    SAMPLE_AES("SAMPLE_AES"),
    @JsonProperty("AES_128")
    AES_128("AES_128");

    private final String name;
    private static HashMap<String, AESEncryptionMethod> map;

    AESEncryptionMethod(String s)
    {
        this.name = s;
    }

    @JsonCreator
    public static AESEncryptionMethod forValue(String value)
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
        map.put("SAMPLE_AES", SAMPLE_AES);
        map.put("AES_128", AES_128);
    }
}
