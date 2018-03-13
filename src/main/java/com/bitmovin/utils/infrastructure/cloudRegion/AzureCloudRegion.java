package com.bitmovin.utils.infrastructure.cloudRegion;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by arudich on 19.09.17.
 **/
public enum AzureCloudRegion
{
    US_WEST,
    US_WEST2,
    US_CENTRAL,
    US_EAST,
    US_EAST2,
    US_NORTH_CENTRAL,
    US_SOUTH_CENTRAL,
    US_WEST_CENTRAL,
    CANADA_CENTRAL,
    CANADA_EAST,
    BRAZIL_SOUTH,
    EUROPE_NORTH,
    EUROPE_WEST,
    UK_SOUTH,
    UK_WEST,
    ASIA_EAST,
    ASIA_SOUTHEAST,
    JAPAN_EAST,
    JAPAN_WEST,
    AUSTRALIA_EAST,
    AUSTRALIA_SOUTHEAST,
    INDIA_CENTRAL,
    INDIA_SOUTH,
    INDIA_WEST,
    KOREA_CENTRAL,
    KOREA_SOUTH,
    CHINA_NORTH,
    CHINA_EAST,
    GERMANY_CENTRAL,
    GERMANY_NORTHEAST,
    GOV_US_VIRGINIA,
    GOV_US_IOWA;

    private static Map<String, AzureCloudRegion> map = new HashMap<>();

    static
    {
        map.put("US-WEST", US_WEST);
        map.put("US-WEST2", US_WEST2);
        map.put("US-CENTRAL", US_CENTRAL);
        map.put("US-EAST", US_EAST);
        map.put("US-EAST2", US_EAST2);
        map.put("US-NORTH-CENTRAL", US_NORTH_CENTRAL);
        map.put("US-SOUTH-CENTRAL", US_SOUTH_CENTRAL);
        map.put("US-WEST-CENTRAL", US_WEST_CENTRAL);
        map.put("CANADA-CENTRAL", CANADA_CENTRAL);
        map.put("CANADA-EAST", CANADA_EAST);
        map.put("BRAZIL-SOUTH", BRAZIL_SOUTH);
        map.put("EUROPE-NORTH", EUROPE_NORTH);
        map.put("EUROPE-WEST", EUROPE_WEST);
        map.put("UK-SOUTH", UK_SOUTH);
        map.put("UK-WEST", UK_WEST);
        map.put("ASIA-EAST", ASIA_EAST);
        map.put("ASIA-SOUTHEAST", ASIA_SOUTHEAST);
        map.put("JAPAN-EAST", JAPAN_EAST);
        map.put("JAPAN-WEST", JAPAN_WEST);
        map.put("AUSTRALIA-EAST", AUSTRALIA_EAST);
        map.put("AUSTRALIA-SOUTHEAST", AUSTRALIA_SOUTHEAST);
        map.put("INDIA-CENTRAL", INDIA_CENTRAL);
        map.put("INDIA-SOUTH", INDIA_SOUTH);
        map.put("INDIA-WEST", INDIA_WEST);
        map.put("KOREA-CENTRAL", KOREA_CENTRAL);
        map.put("KOREA-SOUTH", KOREA_SOUTH);
        map.put("CHINA-NORTH", CHINA_NORTH);
        map.put("CHINA-EAST", CHINA_EAST);
        map.put("GERMANY-CENTRAL", GERMANY_CENTRAL);
        map.put("GERMANY-NORTHEAST", GERMANY_NORTHEAST);
        map.put("GOV-US-VIRGINIA", GOV_US_VIRGINIA);
        map.put("GOV-US-IOWA", GOV_US_IOWA);

        map.put("US_WEST", US_WEST);
        map.put("US_WEST2", US_WEST2);
        map.put("US_CENTRAL", US_CENTRAL);
        map.put("US_EAST", US_EAST);
        map.put("US_EAST2", US_EAST2);
        map.put("US_NORTH_CENTRAL", US_NORTH_CENTRAL);
        map.put("US_SOUTH_CENTRAL", US_SOUTH_CENTRAL);
        map.put("US_WEST_CENTRAL", US_WEST_CENTRAL);
        map.put("CANADA_CENTRAL", CANADA_CENTRAL);
        map.put("CANADA_EAST", CANADA_EAST);
        map.put("BRAZIL_SOUTH", BRAZIL_SOUTH);
        map.put("EUROPE_NORTH", EUROPE_NORTH);
        map.put("EUROPE_WEST", EUROPE_WEST);
        map.put("UK_SOUTH", UK_SOUTH);
        map.put("UK_WEST", UK_WEST);
        map.put("ASIA_EAST", ASIA_EAST);
        map.put("ASIA_SOUTHEAST", ASIA_SOUTHEAST);
        map.put("JAPAN_EAST", JAPAN_EAST);
        map.put("JAPAN_WEST", JAPAN_WEST);
        map.put("AUSTRALIA_EAST", AUSTRALIA_EAST);
        map.put("AUSTRALIA_SOUTHEAST", AUSTRALIA_SOUTHEAST);
        map.put("INDIA_CENTRAL", INDIA_CENTRAL);
        map.put("INDIA_SOUTH", INDIA_SOUTH);
        map.put("INDIA_WEST", INDIA_WEST);
        map.put("KOREA_CENTRAL", KOREA_CENTRAL);
        map.put("KOREA_SOUTH", KOREA_SOUTH);
        map.put("CHINA_NORTH", CHINA_NORTH);
        map.put("CHINA_EAST", CHINA_EAST);
        map.put("GERMANY_CENTRAL", GERMANY_CENTRAL);
        map.put("GERMANY_NORTHEAST", GERMANY_NORTHEAST);
        map.put("GOV_US_VIRGINIA", GOV_US_VIRGINIA);
        map.put("GOV_US_IOWA", GOV_US_IOWA);
    }

    @JsonCreator
    public static AzureCloudRegion forValue(String value)
    {
        return map.get(value);
    }

    @JsonValue
    public String toString()
    {
        return super.toString();
    }
}
