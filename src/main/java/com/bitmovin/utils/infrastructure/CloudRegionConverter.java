package com.bitmovin.utils.infrastructure;

import com.bitmovin.utils.infrastructure.cloudRegion.AwsCloudRegion;
import com.bitmovin.utils.infrastructure.cloudRegion.AzureCloudRegion;
import com.bitmovin.utils.infrastructure.cloudRegion.GoogleCloudRegion;

/**
 * Created by Roland Kersche on 10/5/16.
 **/
public class CloudRegionConverter
{
    public static CloudRegion from(AwsCloudRegion aws)
    {
        switch (aws)
        {
            case US_EAST_1:
                return CloudRegion.AWS_US_EAST_1;
            case US_WEST_1:
                return CloudRegion.AWS_US_WEST_1;
            case US_WEST_2:
                return CloudRegion.AWS_US_WEST_2;
            case EU_WEST_1:
                return CloudRegion.AWS_EU_WEST_1;
            case EU_CENTRAL_1:
                return CloudRegion.AWS_EU_CENTRAL_1;
            case AP_SOUTHEAST_1:
                return CloudRegion.AWS_AP_SOUTHEAST_1;
            case AP_SOUTHEAST_2:
                return CloudRegion.AWS_AP_SOUTHEAST_2;
            case AP_NORTHEAST_1:
                return CloudRegion.AWS_AP_NORTHEAST_1;
            case AP_NORTHEAST_2:
                return CloudRegion.AWS_AP_NORTHEAST_2;
            case AP_SOUTH_1:
                return CloudRegion.AWS_AP_SOUTH_1;
            case SA_EAST_1:
                return CloudRegion.AWS_SA_EAST_1;
            case US_EAST_2:
                return CloudRegion.AWS_US_EAST_2;
            case CA_CENTRAL_1:
                return CloudRegion.AWS_CA_CENTRAL_1;
            case EU_WEST_2:
                return CloudRegion.AWS_EU_WEST_2;
        }
        throw new IllegalArgumentException();
    }

    public static CloudRegion from(GoogleCloudRegion google)
    {
        switch (google)
        {
            case US_CENTRAL_1:
                return CloudRegion.GOOGLE_US_CENTRAL_1;
            case US_EAST_1:
                return CloudRegion.GOOGLE_US_EAST_1;
            case ASIA_EAST_1:
                return CloudRegion.GOOGLE_ASIA_EAST_1;
            case EUROPE_WEST_1:
                return CloudRegion.GOOGLE_EUROPE_WEST_1;
            case US_WEST_1:
                return CloudRegion.GOOGLE_US_WEST_1;
            case US_EAST4:
                return CloudRegion.GOOGLE_US_EAST4;
            case SOUTHAMERICA_EAST1:
                return CloudRegion.GOOGLE_SOUTHAMERICA_EAST1;
            case EUROPE_WEST2:
                return CloudRegion.GOOGLE_EUROPE_WEST2;
            case EUROPE_WEST3:
                return CloudRegion.GOOGLE_EUROPE_WEST3;
            case AUSTRALIA_SOUTHEAST1:
                return CloudRegion.GOOGLE_AUSTRALIA_SOUTHEAST1;
        }
        throw new IllegalArgumentException();
    }

    public static CloudRegion from(AzureCloudRegion azure)
    {
        switch (azure)
        {
            case US_WEST:
                return CloudRegion.AZURE_US_WEST;
            case US_WEST2:
                return CloudRegion.AZURE_US_WEST2;
            case US_CENTRAL:
                return CloudRegion.AZURE_US_CENTRAL;
            case US_EAST:
                return CloudRegion.AZURE_US_EAST;
            case US_EAST2:
                return CloudRegion.AZURE_US_EAST2;
            case US_NORTH_CENTRAL:
                return CloudRegion.AZURE_US_NORTH_CENTRAL;
            case US_SOUTH_CENTRAL:
                return CloudRegion.AZURE_US_SOUTH_CENTRAL;
            case US_WEST_CENTRAL:
                return CloudRegion.AZURE_US_WEST_CENTRAL;
            case CANADA_CENTRAL:
                return CloudRegion.AZURE_CANADA_CENTRAL;
            case CANADA_EAST:
                return CloudRegion.AZURE_CANADA_EAST;
            case BRAZIL_SOUTH:
                return CloudRegion.AZURE_BRAZIL_SOUTH;
            case EUROPE_NORTH:
                return CloudRegion.AZURE_EUROPE_NORTH;
            case EUROPE_WEST:
                return CloudRegion.AZURE_EUROPE_WEST;
            case UK_SOUTH:
                return CloudRegion.AZURE_UK_SOUTH;
            case UK_WEST:
                return CloudRegion.AZURE_UK_WEST;
            case ASIA_EAST:
                return CloudRegion.AZURE_ASIA_EAST;
            case ASIA_SOUTHEAST:
                return CloudRegion.AZURE_ASIA_SOUTHEAST;
            case JAPAN_EAST:
                return CloudRegion.AZURE_JAPAN_EAST;
            case JAPAN_WEST:
                return CloudRegion.AZURE_JAPAN_WEST;
            case AUSTRALIA_EAST:
                return CloudRegion.AZURE_AUSTRALIA_EAST;
            case AUSTRALIA_SOUTHEAST:
                return CloudRegion.AZURE_AUSTRALIA_SOUTHEAST;
            case INDIA_CENTRAL:
                return CloudRegion.AZURE_INDIA_CENTRAL;
            case INDIA_SOUTH:
                return CloudRegion.AZURE_INDIA_SOUTH;
            case INDIA_WEST:
                return CloudRegion.AZURE_INDIA_WEST;
            case KOREA_CENTRAL:
                return CloudRegion.AZURE_KOREA_CENTRAL;
            case KOREA_SOUTH:
                return CloudRegion.AZURE_KOREA_SOUTH;
            case CHINA_NORTH:
                return CloudRegion.AZURE_CHINA_NORTH;
            case CHINA_EAST:
                return CloudRegion.AZURE_CHINA_EAST;
            case GERMANY_CENTRAL:
                return CloudRegion.AZURE_GERMANY_CENTRAL;
            case GERMANY_NORTHEAST:
                return CloudRegion.AZURE_GERMANY_NORTHEAST;
            case GOV_US_VIRGINIA:
                return CloudRegion.AZURE_GOV_US_VIRGINIA;
            case GOV_US_IOWA:
                return CloudRegion.AZURE_GOV_US_IOWA;
        }
        throw new IllegalArgumentException();
    }

    public static GoogleCloudRegion toGoogleCloudRegion(CloudRegion cloudRegion)
    {
        if (cloudRegion == null)
            return null;

        if(cloudRegion.toString().startsWith("GOOGLE_"))
            return GoogleCloudRegion.valueOf(cloudRegion.toString().replace("GOOGLE_", ""));
        else
            return null;
    }

    public static AwsCloudRegion toAwsCloudRegion(CloudRegion cloudRegion)
    {
        if(cloudRegion == null)
            return null;

        if(cloudRegion.toString().startsWith("AWS_"))
            return AwsCloudRegion.valueOf(cloudRegion.toString().replace("AWS_", ""));
        else
            return null;
    }


    public static AzureCloudRegion toAzureCloudRegion(CloudRegion cloudRegion)
    {
        if(cloudRegion == null)
            return null;

        if(cloudRegion.toString().startsWith("AZURE_"))
            return AzureCloudRegion.valueOf(cloudRegion.toString().replace("AZURE_", ""));
        else
            return null;
    }
}
