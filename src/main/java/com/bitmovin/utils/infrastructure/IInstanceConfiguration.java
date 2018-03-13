package com.bitmovin.utils.infrastructure;

/**
 * Created by
 * David Moser [david.moser@bitmovin.com]
 * on 29.02.16
 */
public interface IInstanceConfiguration
{
    Long getId();
    String getRegion();
    boolean  compareTo(IInstanceConfiguration other);
}
