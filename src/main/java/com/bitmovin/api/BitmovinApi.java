package com.bitmovin.api;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.account.AccountApi;
import com.bitmovin.api.analytics.AnalyticsApi;
import com.bitmovin.api.encoding.EncodingApi;
import com.bitmovin.api.notifications.NotificationsApi;
import com.bitmovin.api.player.PlayerApi;


public class BitmovinApi
{
    public AccountApi account;
    public AnalyticsApi analytics;
    public EncodingApi encoding;
    public NotificationsApi notifications;
    public PlayerApi player;

    public BitmovinApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public BitmovinApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public BitmovinApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        account = new AccountApi(clientFactory);
        analytics = new AnalyticsApi(clientFactory);
        encoding = new EncodingApi(clientFactory);
        notifications = new NotificationsApi(clientFactory);
        player = new PlayerApi(clientFactory);
    }

}
