package com.bitmovin.api.storage.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 05.09.16.
 */
public enum FolderEntryType
{
    FILE("FILE"),
    FOLDER("FOLDER");

    private String name;
    private static Map<String, FolderEntryType> map = new HashMap(2);

    FolderEntryType(String s)
    {
        this.name = s;
    }

    @JsonCreator
    public static FolderEntryType forValue(String value)
    {
        return map.get(value);
    }

    @JsonValue
    public String toString()
    {
        return this.name;
    }

    static {
        map.put("FILE", FILE);
        map.put("FOLDER", FOLDER);
    }
}
