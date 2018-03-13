package com.bitmovin.utils.infrastructure;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by
 * David Moser [david.moser@bitmovin.com]
 * on 01.03.16
 */
public enum InstanceStatus
{
    NOT_AVAILABLE   ("NOT_AVAILABLE"),
    STARTING        ("STARTING"),
    RUNNING         ("RUNNING"),
    STOPPING        ("STOPPING"),
    TERMINATED      ("TERMINATED");

    private final String name;

    InstanceStatus(String s) {
        name = s;
    }

    @JsonCreator
    public static InstanceStatus forValue(String value)
    {
        return valueOf(value);
    }

    @JsonValue
    public String toString()
    {
        return this.name;
    }
}
