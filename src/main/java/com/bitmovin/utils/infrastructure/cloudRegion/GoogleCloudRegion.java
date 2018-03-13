package com.bitmovin.utils.infrastructure.cloudRegion;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 30.08.16.
 */
public enum GoogleCloudRegion
{
    US_CENTRAL_1("US_CENTRAL_1"),
    US_EAST_1("US_EAST_1"),
    ASIA_EAST_1("ASIA_EAST_1"),
    EUROPE_WEST_1("EUROPE_WEST_1"),
    US_WEST_1("US_WEST_1"),
    US_EAST4("US_EAST4"),
    SOUTHAMERICA_EAST1("SOUTHAMERICA_EAST1"),
    EUROPE_WEST2("EUROPE_WEST2"),
    EUROPE_WEST3("EUROPE_WEST3"),
    AUSTRALIA_SOUTHEAST1("AUSTRALIA_SOUTHEAST1");

    private String name;
    private static Map<String, GoogleCloudRegion> map = new HashMap<>();

    static {
        map.put("US-CENTRAL-1", US_CENTRAL_1);
        map.put("US-EAST-1", US_EAST_1);
        map.put("ASIA-EAST-1", ASIA_EAST_1);
        map.put("EUROPE-WEST-1", EUROPE_WEST_1);
        map.put("US-WEST-1", US_WEST_1);
        map.put("US-EAST4", US_EAST4);
        map.put("SOUTHAMERICA-EAST1", SOUTHAMERICA_EAST1);
        map.put("EUROPE-WEST2", EUROPE_WEST2);
        map.put("EUROPE-WEST3", EUROPE_WEST3);
        map.put("AUSTRALIA-SOUTHEAST1", AUSTRALIA_SOUTHEAST1);

        map.put("US_CENTRAL_1", US_CENTRAL_1);
        map.put("US_EAST_1", US_EAST_1);
        map.put("ASIA_EAST_1", ASIA_EAST_1);
        map.put("EUROPE_WEST_1", EUROPE_WEST_1);
        map.put("US_WEST_1", US_WEST_1);
        map.put("US_EAST4", US_EAST4);
        map.put("SOUTHAMERICA_EAST1", SOUTHAMERICA_EAST1);
        map.put("EUROPE_WEST2", EUROPE_WEST2);
        map.put("EUROPE_WEST3", EUROPE_WEST3);
        map.put("AUSTRALIA_SOUTHEAST1", AUSTRALIA_SOUTHEAST1);
    }

    GoogleCloudRegion(String s)
    {
        this.name = s;
    }

    @JsonCreator
    public static GoogleCloudRegion forValue(String value)
    {
        return map.get(value);
    }

    @JsonValue
    public String toString()
    {
        return this.name;
    }
}
