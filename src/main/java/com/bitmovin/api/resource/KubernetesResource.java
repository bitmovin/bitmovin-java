package com.bitmovin.api.resource;

import com.bitmovin.api.AbstractApiResponse;

import java.util.Map;

/**
 * Created by arudich on 15.09.16.
 **/
public class KubernetesResource<T extends AbstractApiResponse> extends AbstractResource<T>
{

    public KubernetesResource(Map<String, String> headers, String url, Class<T> type)
    {
        super(headers, url, type);
    }

}
