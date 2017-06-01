package com.bitmovin.api.resource;

import com.bitmovin.api.AbstractApiResource;

import java.util.Map;

/**
 * Created by rkersche on 9/5/16.
 */
public class UserResource<T extends AbstractApiResource> extends AbstractResource<T>
{

    public UserResource(Map<String, String> headers, String url, Class<T> type)
    {
        super(headers, url, type);
    }

}
