package com.bitmovin.api.analytics.queries;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.analytics.queries.count.CountApi;
import com.bitmovin.api.analytics.queries.sum.SumApi;
import com.bitmovin.api.analytics.queries.avg.AvgApi;
import com.bitmovin.api.analytics.queries.min.MinApi;
import com.bitmovin.api.analytics.queries.max.MaxApi;
import com.bitmovin.api.analytics.queries.stddev.StddevApi;
import com.bitmovin.api.analytics.queries.percentile.PercentileApi;
import com.bitmovin.api.analytics.queries.variance.VarianceApi;
import com.bitmovin.api.analytics.queries.median.MedianApi;


public class QueriesApi
{
    public CountApi count;
    public SumApi sum;
    public AvgApi avg;
    public MinApi min;
    public MaxApi max;
    public StddevApi stddev;
    public PercentileApi percentile;
    public VarianceApi variance;
    public MedianApi median;

    public QueriesApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public QueriesApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public QueriesApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        count = new CountApi(clientFactory);
        sum = new SumApi(clientFactory);
        avg = new AvgApi(clientFactory);
        min = new MinApi(clientFactory);
        max = new MaxApi(clientFactory);
        stddev = new StddevApi(clientFactory);
        percentile = new PercentileApi(clientFactory);
        variance = new VarianceApi(clientFactory);
        median = new MedianApi(clientFactory);
    }

}
