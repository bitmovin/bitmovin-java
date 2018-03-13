package com.bitmovin.utils.infrastructure;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by akopper on 21.07.16.
 */
public class CloudRegionCombo
{

    private Provider provider;
    private String region;

    public CloudRegionCombo(Provider provider, String region) {
        this.provider = provider;
        this.region = region;
    }

    public Provider getProvider()
    {
        return provider;
    }

    public void setProvider(Provider provider)
    {
        this.provider = provider;
    }

    public String getRegion()
    {
        return region;
    }

    public void setRegion(String region)
    {
        this.region = region;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (!(o instanceof CloudRegionCombo)) return false;

        CloudRegionCombo that = (CloudRegionCombo) o;

        return new EqualsBuilder()
                .append(provider, that.provider)
                .append(region, that.region)
                .isEquals();
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder(17, 37)
                .append(provider)
                .append(region)
                .toHashCode();
    }
}


