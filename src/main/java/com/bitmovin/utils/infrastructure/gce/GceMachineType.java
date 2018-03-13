package com.bitmovin.utils.infrastructure.gce;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by
 * David Moser [david.moser@bitmovin.com]
 * on 4/21/16
 */
public enum GceMachineType
{
    N1_STANDARD_1  ("n1-standard-1", 1),
    N1_STANDARD_2  ("n1-standard-2", 2),
    N1_STANDARD_4  ("n1-standard-4", 4),
    N1_STANDARD_8  ("n1-standard-8", 8),
    N1_STANDARD_16 ("n1-standard-16", 16),
    N1_STANDARD_32 ("n1-standard-32", 32),
    N1_HIGHCPU_16  ("n1-highcpu-16", 16),
    N1_HIGHCPU_32  ("n1-highcpu-32", 32),
    F1_MICRO       ("f1-micro", 1),
    G1_SMALL       ("g1-small", 1);

    private String value;
    private int cpuCount;

    GceMachineType(String value, int cpuCount)
    {
        this.value = value;
        this.cpuCount = cpuCount;
    }

    @JsonCreator
    public static GceMachineType forValue(String value)
    {
        return valueOf(value.toUpperCase().replace('-', '_'));
    }

    @JsonValue
    public String toString()
    {
        return value;
    }

    public int getCPUCount () {
        return this.cpuCount;
    }

    public static GceMachineType uriToMachineType(URI gceMachineTypeURI)
    {
        Path machineTypePath = Paths.get(gceMachineTypeURI.getPath());

        return forValue(machineTypePath.getFileName().toString());
    }
}
