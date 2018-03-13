package com.bitmovin.utils.infrastructure.util;

import com.bitmovin.utils.infrastructure.CloudRegion;
import com.bitmovin.utils.infrastructure.CloudRegionCombo;
import com.bitmovin.utils.infrastructure.Provider;

/**
 * Created by akopper on 21.07.16.
 **/
public class CloudRegionConverter
{

    /**
     * Converts a cloud region into a pair fo provider and region
     * @param cloudRegion
     * @return
     */
    public static CloudRegionCombo CloudRegionToCombo(CloudRegion cloudRegion)
    {
        if (cloudRegion.toString().startsWith("GOOGLE_"))
        {
            String region = cloudRegion.toString().replace("GOOGLE_", "");
            return new CloudRegionCombo(Provider.GCE, region);
        }
        else if (cloudRegion.toString().startsWith("AWS_"))
        {
            String region = cloudRegion.toString().replace("AWS_", "");
            return new CloudRegionCombo(Provider.AWS, region);
        }
        else if (cloudRegion.toString().startsWith("AZURE_"))
        {
            String region = cloudRegion.toString().replace("AZURE_", "");
            return new CloudRegionCombo(Provider.AZURE, region);
        }
        else
        {
            throw new UnsupportedOperationException(String.format("The cloud (%s) is unkonwn.", cloudRegion));
        }
    }

}
