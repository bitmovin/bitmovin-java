package com.bitmovin.api.encoding.enums;

import com.bitmovin.util.Constants;
import com.bitmovin.utils.infrastructure.cloudRegion.AwsCloudRegion;
import com.bitmovin.utils.infrastructure.cloudRegion.GoogleCloudRegion;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 25.07.16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public enum CloudRegion
{
    AWS_US_EAST_1,
    AWS_US_WEST_1,
    AWS_US_WEST_2,
    AWS_EU_WEST_1,
    AWS_EU_CENTRAL_1,
    AWS_AP_SOUTHEAST_1,
    AWS_AP_SOUTHEAST_2,
    AWS_AP_NORTHEAST_1,
    AWS_AP_NORTHEAST_2,
    AWS_AP_SOUTH_1,
    AWS_SA_EAST_1,
    GOOGLE_US_CENTRAL_1,
    GOOGLE_US_EAST_1,
    GOOGLE_ASIA_EAST_1,
    GOOGLE_EUROPE_WEST_1,
    GOOGLE_US_WEST_1,
    AZURE_US_WEST,
    AZURE_US_WEST2,
    AZURE_US_CENTRAL,
    AZURE_US_EAST,
    AZURE_US_EAST2,
    AZURE_US_NORTH_CENTRAL,
    AZURE_US_SOUTH_CENTRAL,
    AZURE_US_WEST_CENTRAL,
    AZURE_CANADA_CENTRAL,
    AZURE_CANADA_EAST,
    AZURE_BRAZIL_SOUTH,
    AZURE_EUROPE_NORTH,
    AZURE_EUROPE_WEST,
    AZURE_UK_SOUTH,
    AZURE_UK_WEST,
    AZURE_ASIA_EAST,
    AZURE_ASIA_SOUTHEAST,
    AZURE_JAPAN_EAST,
    AZURE_JAPAN_WEST,
    AZURE_AUSTRALIA_EAST,
    AZURE_AUSTRALIA_SOUTHEAST,
    AZURE_INDIA_CENTRAL,
    AZURE_INDIA_SOUTH,
    AZURE_INDIA_WEST,
    AZURE_KOREA_CENTRAL,
    AZURE_KOREA_SOUTH,
    AZURE_CHINA_NORTH,
    AZURE_CHINA_EAST,
    AZURE_GERMANY_CENTRAL,
    AZURE_GERMANY_NORTHEAST,
    AZURE_GOV_US_VIRGINIA,
    AZURE_GOV_US_IOWA,

    NORTH_AMERICA,
    SOUTH_AMERICA,
    EUROPE,
    AFRICA,
    ASIA,
    AUSTRALIA,
    AWS,
    GOOGLE,
    AZURE,
    @Deprecated
    KUBERNETES,
    EXTERNAL,
    AUTO;

    private static Map<String, CloudRegion> map = new HashMap<>();
    private static Map<GoogleCloudRegion, CloudRegion> googleCloudRegionHashMap = new HashMap<>();
    private static Map<AwsCloudRegion, CloudRegion> awsCloudRegionHashMap = new HashMap<>();
    public static final List<CloudRegion> CONTINENT_CLOUD_REGIONS = Arrays.asList(NORTH_AMERICA, SOUTH_AMERICA, EUROPE, AFRICA, ASIA, AUSTRALIA);


    public GoogleCloudRegion toGoogleCloudRegion()
    {
        if(isGoogle())
            return GoogleCloudRegion.valueOf(this.toString().toUpperCase().replace("GOOGLE_", ""));
        else
            return null;
    }

    public AwsCloudRegion toAwsCloudRegion()
    {
        if(isAws())
            return AwsCloudRegion.valueOf(this.toString().toUpperCase().replace("AWS_", ""));
        else
            return null;
    }

    public boolean isGoogle()
    {
        return this.toString().toUpperCase().contains("GOOGLE");
    }

    public boolean isAws()
    {
        return this.toString().toUpperCase().contains("AWS");
    }

    public com.bitmovin.api.enums.CloudRegion toInfrastructureRegion()
    {
        return com.bitmovin.api.enums.CloudRegion.valueOf(this.toString().toUpperCase());
    }

    public boolean isAutomaticCloudRegion()
    {
        return Constants.defaultRegionsForAutomaticRegions.keySet().contains(this);
    }

    public boolean isContinent()
    {
        return CONTINENT_CLOUD_REGIONS.contains(this);
    }
}
