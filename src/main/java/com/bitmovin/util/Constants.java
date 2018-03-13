package com.bitmovin.util;

import com.bitmovin.api.encoding.enums.CloudRegion;

import java.util.HashMap;

/**
 * Created by akopper on 15.07.16.
 */
public class Constants
{

    public static final String API_KEY_NAME = "X-Api-Key";
    //public static final String API_ENDPOINT = "api.bitmovin.com";
    //public static final String API_ENDPOINT_WITH_PROTOCOL = "https://" + API_ENDPOINT;

    public static final String DEFAULT_FMP4_MUXING_INIT_SEGMENT_NAME = "init.mp4";
    public static final String DEFAULT_FMP4_MUXING_SEGMENT_NAME_TEMPLATE = "segment_%number%.m4s";

    public static final HashMap<CloudRegion, CloudRegion> defaultRegionsForAutomaticRegions;

    static
    {
        defaultRegionsForAutomaticRegions = new HashMap<>();
        defaultRegionsForAutomaticRegions.put(CloudRegion.NORTH_AMERICA, CloudRegion.GOOGLE_US_CENTRAL_1);
        defaultRegionsForAutomaticRegions.put(CloudRegion.SOUTH_AMERICA, CloudRegion.AWS_SA_EAST_1);
        defaultRegionsForAutomaticRegions.put(CloudRegion.EUROPE, CloudRegion.GOOGLE_EUROPE_WEST_1);
        defaultRegionsForAutomaticRegions.put(CloudRegion.AFRICA, CloudRegion.GOOGLE_EUROPE_WEST_1);
        defaultRegionsForAutomaticRegions.put(CloudRegion.ASIA, CloudRegion.GOOGLE_ASIA_EAST_1);
        defaultRegionsForAutomaticRegions.put(CloudRegion.AUSTRALIA, CloudRegion.GOOGLE_ASIA_EAST_1);
        defaultRegionsForAutomaticRegions.put(CloudRegion.AWS, CloudRegion.AWS_US_WEST_1);
        defaultRegionsForAutomaticRegions.put(CloudRegion.GOOGLE, CloudRegion.GOOGLE_US_CENTRAL_1);
        defaultRegionsForAutomaticRegions.put(CloudRegion.AUTO, CloudRegion.GOOGLE_EUROPE_WEST_1);
        defaultRegionsForAutomaticRegions.put(null, CloudRegion.GOOGLE_EUROPE_WEST_1);
    }

}
