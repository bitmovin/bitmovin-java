package com.bitmovin.api.resource;

import com.bitmovin.api.RestClient;
import com.bitmovin.api.encoding.infrastructure.AwsAccount;
import com.bitmovin.api.encoding.infrastructure.AwsAccountRegionSettings;
import com.bitmovin.api.enums.AwsCloudRegion;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.network.http.RestException;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

/**
 * Created by arudich on 23.11.17.
 **/
public class AwsAccountRegionSettingsResource extends AbstractResource<AwsAccountRegionSettings>
{
    public AwsAccountRegionSettingsResource(Map<String, String> headers, String url)
    {
        super(headers, url, AwsAccountRegionSettings.class);
    }

    public AwsAccountRegionSettings createAndThrowException(AwsAccountRegionSettings item, AwsAccount account, AwsCloudRegion region)
            throws BitmovinApiException, IOException, RestException, UnirestException, URISyntaxException
    {
        return RestClient.post(this.headers, this.getRequestUrl(account, region), item, this.type);
    }

    private String getRequestUrl(AwsAccount account, AwsCloudRegion region)
    {
        return this.getRequestUrl(account.getId(), region);
    }

    private String getRequestUrl(String awsAccountId, AwsCloudRegion region)
    {
        return String.format("%s/%s", this.getListRequestUrl(awsAccountId), region.toString());
    }

    private String getListRequestUrl(String awsAccountId)
    {
        return this.url.replace("{awsAccountId}", awsAccountId);
    }
}
