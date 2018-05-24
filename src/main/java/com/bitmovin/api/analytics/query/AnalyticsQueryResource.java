package com.bitmovin.api.analytics.query;

import com.bitmovin.api.RestClient;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.resource.AbstractResource;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Map;

public class AnalyticsQueryResource extends AbstractResource<AnalyticsQuery>
{
    public AnalyticsQueryResource(Map<String, String> headers, String url)
    {
        super(headers, url, AnalyticsQuery.class);
    }

    public JSONArray avg(AnalyticsQuery query) throws BitmovinApiException, UnirestException, URISyntaxException, IOException
    {
        return executeQuery(AnalyticsQueryMethod.AVG, query);
    }

    public JSONArray count(AnalyticsQuery query) throws BitmovinApiException, UnirestException, URISyntaxException, IOException
    {
        return executeQuery(AnalyticsQueryMethod.COUNT, query);
    }

    public JSONArray max(AnalyticsQuery query) throws BitmovinApiException, UnirestException, URISyntaxException, IOException
    {
        return executeQuery(AnalyticsQueryMethod.MAX, query);
    }

    public JSONArray median(AnalyticsQuery query) throws BitmovinApiException, UnirestException, URISyntaxException, IOException
    {
        return executeQuery(AnalyticsQueryMethod.MEDIAN, query);
    }

    public JSONArray min(AnalyticsQuery query) throws BitmovinApiException, UnirestException, URISyntaxException, IOException
    {
        return executeQuery(AnalyticsQueryMethod.MIN, query);
    }

    public JSONArray percentile(AnalyticsQuery query) throws BitmovinApiException, UnirestException, URISyntaxException, IOException
    {
        return executeQuery(AnalyticsQueryMethod.PERCENTILE, query);
    }

    public JSONArray stddev(AnalyticsQuery query) throws BitmovinApiException, UnirestException, URISyntaxException, IOException
    {
        return executeQuery(AnalyticsQueryMethod.STDDEV, query);
    }

    public JSONArray sum(AnalyticsQuery query) throws BitmovinApiException, UnirestException, URISyntaxException, IOException
    {
        return executeQuery(AnalyticsQueryMethod.SUM, query);
    }

    public JSONArray variance(AnalyticsQuery query) throws BitmovinApiException, UnirestException, URISyntaxException, IOException
    {
        return executeQuery(AnalyticsQueryMethod.VARIANCE, query);
    }

    private JSONArray executeQuery(AnalyticsQueryMethod method, AnalyticsQuery query) throws BitmovinApiException, UnirestException, URISyntaxException, IOException
    {
        String url = Paths.get(this.url, method.toString()).toString();
        return RestClient.postAnalyticsQuery(url, headers, query);
    }
}
