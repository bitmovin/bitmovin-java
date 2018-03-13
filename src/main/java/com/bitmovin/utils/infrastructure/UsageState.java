package com.bitmovin.utils.infrastructure;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by
 * David Moser [david.moser@bitmovin.com]
 * on 4/20/16
 */
public enum UsageState
{
    USED        ("USED"),
    UNUSED      ("UNUSED"),
    DEFUNCT     ("DEFUNCT"),
    NEW         ("NEW");

    private final String name;

    UsageState(String s) {
        name = s;
    }

    @JsonCreator
    public static UsageState forValue(String value)
    {
        return valueOf(value);
    }

    @JsonValue
    public String toString()
    {
        return this.name;
    }
}
