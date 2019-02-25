package com.bitmovin.api.common;

public interface BitmovinApiClientFactory
{
    <T> T createApiClient(Class<T> apiClientClass);
}
