package com.bitmovin.utils.infrastructure.cloudRegion;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com] on 30.08.16.
 * AWS regions as specified in http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-regions-availability-zones.html#concepts-available-regions
 **/
public enum AwsCloudRegion
{
    US_EAST_1("US_EAST_1"),
    US_WEST_1("US_WEST_1"),
    US_WEST_2("US_WEST_2"),
    EU_WEST_1("EU_WEST_1"),
    EU_CENTRAL_1("EU_CENTRAL_1"),
    AP_SOUTHEAST_1("AP_SOUTHEAST_1"),
    AP_SOUTHEAST_2("AP_SOUTHEAST_2"),
    AP_NORTHEAST_1("AP_NORTHEAST_1"),
    AP_NORTHEAST_2("AP_NORTHEAST_2"),
    AP_SOUTH_1("AP_SOUTH_1"),
    SA_EAST_1("SA_EAST_1"),
    US_EAST_2("US_EAST_2"),
    CA_CENTRAL_1("CA_CENTRAL_1"),
    EU_WEST_2("EU_WEST_2");

    private String name;
    private static Map<String, AwsCloudRegion> map = new HashMap<>();

    static
    {
        map.put("US-EAST-1", US_EAST_1);
        map.put("US-WEST-1", US_WEST_1);
        map.put("US-WEST-2", US_WEST_2);
        map.put("EU-WEST-1", EU_WEST_1);
        map.put("EU-CENTRAL-1", EU_CENTRAL_1);
        map.put("AP-SOUTHEAST-1", AP_SOUTHEAST_1);
        map.put("AP-SOUTHEAST-2", AP_SOUTHEAST_2);
        map.put("AP-NORTHEAST-1", AP_NORTHEAST_1);
        map.put("AP-NORTHEAST-2", AP_NORTHEAST_2);
        map.put("AP-SOUTH-1", AP_SOUTH_1);
        map.put("SA-EAST-1", SA_EAST_1);
        map.put("US-EAST-2", US_EAST_2);
        map.put("CA-CENTRAL-1", CA_CENTRAL_1);
        map.put("EU-WEST-2", EU_WEST_2);

        map.put("US_EAST_1", US_EAST_1);
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
        map.put("US_EAST_2", US_EAST_2);
        map.put("CA_CENTRAL_1", CA_CENTRAL_1);
        map.put("EU_WEST_2", EU_WEST_2);
    }

    AwsCloudRegion(String s)
    {
        this.name = s;
    }

    @JsonCreator
    public static AwsCloudRegion forValue(String value)
    {
        return map.get(value);
    }

    @JsonValue
    public String toString()
    {
        return this.name;
    }
}
