package com.bitmovin.api.common;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class BitmovinHeadersInterceptor implements RequestInterceptor
{
    private final String apiKey;
    private String tenantOrgId;

    public BitmovinHeadersInterceptor(String apiKey)
    {
        this.apiKey = apiKey;
    }

    public BitmovinHeadersInterceptor(String apiKey, String tenantOrgId)
    {
        this(apiKey);
        this.tenantOrgId = tenantOrgId;
    }

    public void apply(RequestTemplate requestTemplate)
    {
        requestTemplate.header("Content-Type", "application/json");
        requestTemplate.header("X-Api-Key", this.apiKey);

        if (this.tenantOrgId != null && !this.tenantOrgId.isEmpty()) {
            requestTemplate.header("X-Tenant-Org-Id", this.tenantOrgId);
        }
    }
}
