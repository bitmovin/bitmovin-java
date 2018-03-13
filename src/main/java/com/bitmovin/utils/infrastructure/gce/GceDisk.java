package com.bitmovin.utils.infrastructure.gce;

/**
 * Created by
 * David Moser [david.moser@bitmovin.com]
 * on 4/21/16
 */
public enum GceDisk
{
    SCRATCH     ("SCRATCH"),
    PERSISTENT  ("PERSISTENT");

    private final String name;

    GceDisk(String s) {
        name = s;
    }

    public String toString() {
        return this.name;
    }
}
