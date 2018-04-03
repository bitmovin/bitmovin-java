package com.bitmovin.api.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dominic Miglar [dominic.miglar@bitmovin.com] on 9/1/16 at 6:31 PM.
 */

public enum AwsCloudRegion {
    US_EAST_1("US_EAST_1"),
    US_EAST_2("US_EAST_2"),
    US_WEST_1("US_WEST_1"),
    US_WEST_2("US_WEST_2"),
    EU_WEST_1("EU_WEST_1"),
    EU_CENTRAL_1("EU_CENTRAL_1"),
    AP_SOUTHEAST_1("AP_SOUTHEAST_1"),
    AP_SOUTHEAST_2("AP_SOUTHEAST_2"),
    AP_NORTHEAST_1("AP_NORTHEAST_1"),
    AP_NORTHEAST_2("AP_NORTHEAST_2"),
    AP_SOUTH_1("AP_SOUTH_1"),
    SA_EAST_1("SA_EAST_1");

    private String name;
    private static Map<String, AwsCloudRegion> map = new HashMap(15);

    AwsCloudRegion(String s) {
        this.name = s;
    }

    @JsonCreator
    public static AwsCloudRegion forValue(String value) {
        return map.get(value);
    }

    @JsonValue
    public String toString() {
        return this.name;
    }

    static {
        map.put("US_EAST_1", US_EAST_1);
        map.put("US_EAST_2", US_EAST_2);
        map.put("US_WEST_1", US_WEST_1);
        map.put("US_WEST_2", US_WEST_2);
        map.put("EU_WEST_1", EU_WEST_1);
        map.put("EU_CENTRAL_1", EU_CENTRAL_1);
        map.put("AP_SOUTHEAST_1", AP_SOUTHEAST_1);
        map.put("AP_SOUTHEAST_2", AP_SOUTHEAST_2);
        map.put("AP_NORTHEAST_1", AP_NORTHEAST_1);
        map.put("AP_NORTHEAST_2", AP_NORTHEAST_2);
        map.put("AP_SOUTH_1", AP_SOUTH_1);
        map.put("SA_EAST_1", SA_EAST_1);
    }
}
