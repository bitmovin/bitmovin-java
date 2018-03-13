package com.bitmovin.utils.infrastructure.gce;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by David Moser [david.moser@bitmovin.com] on 4/21/16.
 * Google availability zones as defined in https://cloud.google.com/compute/docs/regions-zones/regions-zones
 * Zone list retrieved on 2017-09-19.
 **/
public enum GceZoneName
{
    US_EAST1_B("us-east1-b"),
    US_EAST1_C("us-east1-c"),
    US_EAST1_D("us-east1-d"),
    US_CENTRAL1_A("us-central1-a"),
    US_CENTRAL1_B("us-central1-b"),
    US_CENTRAL1_C("us-central1-c"),
    US_CENTRAL1_F("us-central1-f"),
    EUROPE_WEST1_B("europe-west1-b"),
    EUROPE_WEST1_C("europe-west1-c"),
    EUROPE_WEST1_D("europe-west1-d"),
    ASIA_EAST1_A("asia-east1-a"),
    ASIA_EAST1_B("asia-east1-b"),
    ASIA_EAST1_C("asia-east1-c"),
    US_WEST1_A("us-west1-a"),
    US_WEST1_B("us-west1-b"),
    ASIA_SOUTHEAST1_A("asia-southeast1-a"),
    ASIA_SOUTHEAST1_B("asia-southeast1-b"),
    ASIA_NORTHEAST1_A("asia-northeast1-a"),
    ASIA_NORTHEAST1_B("asia-northeast1-b"),
    ASIA_NORTHEAST1_C("asia-northeast1-c"),
    US_WEST1_C("us-west1-c"),
    US_EAST4_A("us-east4-a"),
    US_EAST4_B("us-east4-b"),
    US_EAST4_C("us-east4-c"),
    SOUTHAMERICA_EAST1_A("southamerica-east1-a"),
    SOUTHAMERICA_EAST1_B("southamerica-east1-b"),
    SOUTHAMERICA_EAST1_C("southamerica-east1-c"),
    EUROPE_WEST2_A("europe-west2-a"),
    EUROPE_WEST2_B("europe-west2-b"),
    EUROPE_WEST2_C("europe-west2-c"),
    EUROPE_WEST3_A("europe-west3-a"),
    EUROPE_WEST3_B("europe-west3-b"),
    EUROPE_WEST3_C("europe-west3-c"),
    AUSTRALIA_SOUTHEAST1_A("australia-southeast1-a"),
    AUSTRALIA_SOUTHEAST1_B("australia-southeast1-b"),
    AUSTRALIA_SOUTHEAST1_C("australia-southeast1-c");

    private String value;

    private GceZoneName(String value)
    {
        this.value = value;
    }

    @JsonCreator
    public static GceZoneName forValue(String value)
    {
        return valueOf(value.toUpperCase().replace('-', '_'));
    }

    @JsonValue
    public String toString()
    {
        return value;
    }
}
