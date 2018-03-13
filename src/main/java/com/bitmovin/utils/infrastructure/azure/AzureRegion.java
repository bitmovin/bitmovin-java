package com.bitmovin.utils.infrastructure.azure;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by arudich on 13.09.17.
 **/
public enum AzureRegion
{
    US_WEST             ("westus"),
    US_WEST2            ("westus2"),
    US_CENTRAL          ("centralus"),
    US_EAST             ("eastus"),
    US_EAST2            ("eastus2"),
    US_NORTH_CENTRAL    ("northcentralus"),
    US_SOUTH_CENTRAL    ("southcentralus"),
    US_WEST_CENTRAL     ("westcentralus"),
    CANADA_CENTRAL      ("canadacentral"),
    CANADA_EAST         ("canadaeast"),
    BRAZIL_SOUTH        ("brazilsouth"),
    EUROPE_NORTH        ("northeurope"),
    EUROPE_WEST         ("westeurope"),
    UK_SOUTH            ("uksouth"),
    UK_WEST             ("ukwest"),
    ASIA_EAST           ("eastasia"),
    ASIA_SOUTHEAST      ("southeastasia"),
    JAPAN_EAST          ("japaneast"),
    JAPAN_WEST          ("japanwest"),
    AUSTRALIA_EAST      ("australiaeast"),
    AUSTRALIA_SOUTHEAST ("australiasoutheast"),
    INDIA_CENTRAL       ("centralindia"),
    INDIA_SOUTH         ("southindia"),
    INDIA_WEST          ("westindia"),
    KOREA_CENTRAL       ("koreacentral"),
    KOREA_SOUTH         ("koreasouth"),
    CHINA_NORTH         ("chinanorth"),
    CHINA_EAST          ("chinaeast"),
    GERMANY_CENTRAL     ("germanycentral"),
    GERMANY_NORTHEAST   ("germanynortheast"),
    GOV_US_VIRGINIA     ("usgovvirginia"),
    GOV_US_IOWA         ("usgoviowa");

    private String name;
    private static Map<String, AzureRegion> map = new HashMap<>();

    static
    {
        map.put("westus",             US_WEST);
        map.put("westus2",            US_WEST2);
        map.put("centralus",          US_CENTRAL);
        map.put("eastus",             US_EAST);
        map.put("eastus2",            US_EAST2);
        map.put("northcentralus",     US_NORTH_CENTRAL);
        map.put("southcentralus",     US_SOUTH_CENTRAL);
        map.put("westcentralus",      US_WEST_CENTRAL);
        map.put("canadacentral",      CANADA_CENTRAL);
        map.put("canadaeast",         CANADA_EAST);
        map.put("brazilsouth",        BRAZIL_SOUTH);
        map.put("northeurope",        EUROPE_NORTH);
        map.put("westeurope",         EUROPE_WEST);
        map.put("uksouth",            UK_SOUTH);
        map.put("ukwest",             UK_WEST);
        map.put("eastasia",           ASIA_EAST);
        map.put("southeastasia",      ASIA_SOUTHEAST);
        map.put("japaneast",          JAPAN_EAST);
        map.put("japanwest",          JAPAN_WEST);
        map.put("australiaeast",      AUSTRALIA_EAST);
        map.put("australiasoutheast", AUSTRALIA_SOUTHEAST);
        map.put("centralindia",       INDIA_CENTRAL);
        map.put("southindia",         INDIA_SOUTH);
        map.put("westindia",          INDIA_WEST);
        map.put("koreacentral",       KOREA_CENTRAL);
        map.put("koreasouth",         KOREA_SOUTH);
        map.put("chinanorth",         CHINA_NORTH);
        map.put("chinaeast",          CHINA_EAST);
        map.put("germanycentral",     GERMANY_CENTRAL);
        map.put("germanynortheast",   GERMANY_NORTHEAST);
        map.put("usgovvirginia",      GOV_US_VIRGINIA);
        map.put("usgoviowa",          GOV_US_IOWA);
    }

    AzureRegion(String s)
    {
        this.name = s;
    }

    @JsonCreator
    public static AzureRegion forValue(String value)
    {
        return map.get(value);
    }

    @JsonValue
    public String toString()
    {
        return this.name;
    }
}
