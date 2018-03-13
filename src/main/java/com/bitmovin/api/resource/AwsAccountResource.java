package com.bitmovin.api.resource;

import com.bitmovin.api.encoding.infrastructure.AwsAccount;

import java.util.Map;

/**
 * Created by arudich on 23.11.17.
 **/
public class AwsAccountResource extends AbstractResource<AwsAccount>
{
    public AwsAccountResource(Map<String, String> headers, String url)
    {
        super(headers, url, AwsAccount.class);
    }
}
