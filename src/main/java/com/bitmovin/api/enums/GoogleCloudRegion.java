package com.bitmovin.api.enums;

/**
 * Created by Dominic Miglar [dominic.miglar@bitmovin.com] on 9/1/16 at 6:22 PM.
 */
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

public enum GoogleCloudRegion {
    US_CENTRAL_1("US_CENTRAL_1"),
    US_EAST_1("US_EAST_1"),
    ASIA_EAST_1("ASIA_EAST_1"),
    EUROPE_WEST_1("EUROPE_WEST_1"),
    US_WEST_1("US_WEST_1");


    private String name;
    private static Map<String, GoogleCloudRegion> map = new HashMap(15);

    GoogleCloudRegion(String s) {
        this.name = s;
    }

    @JsonCreator
    public static GoogleCloudRegion forValue(String value) {
        return map.get(value);
    }

    @JsonValue
    public String toString() {
        return this.name;
    }

    static {
        map.put("US_CENTRAL_1", US_CENTRAL_1);
        map.put("US_EAST_1", US_EAST_1);
        map.put("US_WEST_1", US_WEST_1);
        map.put("ASIA_EAST_1", ASIA_EAST_1);
        map.put("EUROPE_WEST_1", EUROPE_WEST_1);
    }
}
