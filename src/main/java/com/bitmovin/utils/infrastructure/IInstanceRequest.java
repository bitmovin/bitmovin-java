package com.bitmovin.utils.infrastructure;

import com.bitmovin.utils.auth.Credentials;

/**
 * Created by
 * David Moser [david.moser@bitmovin.com]
 * on 4/19/16
 */
public interface IInstanceRequest
{
    Credentials getCredentials();
    AbstractInstanceConfiguration getConfiguration();
    int getCount();
}
