package com.bitmovin.api.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 13.09.16.
 */
public enum CloudRegion {
    @SerializedName("AWS_US_EAST_1")
    AWS_US_EAST_1("AWS_US_EAST_1"),
    @SerializedName("AWS_US_WEST_1")
    AWS_US_WEST_1("AWS_US_WEST_1"),
    @SerializedName("AWS_US_WEST_2")
    AWS_US_WEST_2("AWS_US_WEST_2"),
    @SerializedName("AWS_EU_WEST_1")
    AWS_EU_WEST_1("AWS_EU_WEST_1"),
    @SerializedName("AWS_EU_CENTRAL_1")
    AWS_EU_CENTRAL_1("AWS_EU_CENTRAL_1"),
    @SerializedName("AWS_AP_SOUTHEAST_1")
    AWS_AP_SOUTHEAST_1("AWS_AP_SOUTHEAST_1"),
    @SerializedName("AWS_AP_SOUTHEAST_2")
    AWS_AP_SOUTHEAST_2("AWS_AP_SOUTHEAST_2"),
    @SerializedName("AWS_AP_NORTHEAST_1")
    AWS_AP_NORTHEAST_1("AWS_AP_NORTHEAST_1"),
    @SerializedName("AWS_AP_NORTHEAST_2")
    AWS_AP_NORTHEAST_2("AWS_AP_NORTHEAST_2"),
    @SerializedName("AWS_AP_SOUTH_1")
    AWS_AP_SOUTH_1("AWS_AP_SOUTH_1"),
    @SerializedName("AWS_SA_EAST_1")
    AWS_SA_EAST_1("AWS_SA_EAST_1"),
    @SerializedName("GOOGLE_US_CENTRAL_1")
    GOOGLE_US_CENTRAL_1("GOOGLE_US_CENTRAL_1"),
    @SerializedName("GOOGLE_US_EAST_1")
    GOOGLE_US_EAST_1("GOOGLE_US_EAST_1"),
    @SerializedName("GOOGLE_ASIA_EAST_1")
    GOOGLE_ASIA_EAST_1("GOOGLE_ASIA_EAST_1"),
    @SerializedName("GOOGLE_EUROPE_WEST_1")
    GOOGLE_EUROPE_WEST_1("GOOGLE_EUROPE_WEST_1");

    private String name;
    private static Map<String, com.bitmovin.utils.infrastructure.CloudRegion> map;

    private CloudRegion(String s) {
        this.name = s;
    }

    @JsonCreator
    public static com.bitmovin.utils.infrastructure.CloudRegion forValue(String value) {
        return (com.bitmovin.utils.infrastructure.CloudRegion)map.get(value);
    }

    @JsonValue
    public String toString() {
        return this.name;
    }
}