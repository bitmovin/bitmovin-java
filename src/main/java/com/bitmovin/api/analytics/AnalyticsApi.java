package com.bitmovin.api.analytics;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.analytics.impressions.ImpressionsApi;
import com.bitmovin.api.analytics.queries.QueriesApi;
import com.bitmovin.api.analytics.licenses.LicensesApi;


public class AnalyticsApi
{
    public ImpressionsApi impressions;
    public QueriesApi queries;
    public LicensesApi licenses;

    public AnalyticsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public AnalyticsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public AnalyticsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        impressions = new ImpressionsApi(clientFactory);
        queries = new QueriesApi(clientFactory);
        licenses = new LicensesApi(clientFactory);
    }

}
