package com.bitmovin.api.resource;

import com.bitmovin.api.encoding.infrastructure.AwsAccount;

import java.util.Map;

public class AwsAccountResource extends AbstractResource<AwsAccount>
{
    public AwsAccountResource(Map<String, String> headers, String url)
    {
        super(headers, url, AwsAccount.class);
    }
}
