package com.bitmovin.api.resource;

import com.bitmovin.api.RestClient;
import com.bitmovin.api.encoding.infrastructure.AwsAccount;
import com.bitmovin.api.encoding.infrastructure.AwsAccountRegionSettings;
import com.bitmovin.api.enums.AwsCloudRegion;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class AwsAccountRegionSettingsResource extends AbstractResource<AwsAccountRegionSettings>
{
    public AwsAccountRegionSettingsResource(Map<String, String> headers, String url)
    {
        super(headers, url, AwsAccountRegionSettings.class);
    }

    public AwsAccountRegionSettings create(AwsAccountRegionSettings item, AwsAccount account, AwsCloudRegion region) throws BitmovinApiException, UnirestException, IOException, URISyntaxException
    {
       return RestClient.post(this.headers, String.format("%s/%s", this.url.replace("{awsAccountId}", account.getId()), region.toString()), item, this.type);
    }

}
