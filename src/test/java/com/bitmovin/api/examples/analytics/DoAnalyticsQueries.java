package com.bitmovin.api.examples.analytics;

import com.bitmovin.api.BitmovinApi;
import com.bitmovin.api.analytics.query.*;
import org.json.JSONArray;
import org.junit.Before;
import org.junit.Test;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static java.time.temporal.ChronoUnit.HOURS;

public class DoAnalyticsQueries
{
    private static final String apiKey = "<INSERT_YOUR_API_KEY>";
    private static final String analyticsLicenseKey = "<INSERT_YOUR_ANALYTICS_LICENSE_KEY>";
    private static final String impressionId = "<INSERT_IMPRESSION_ID>";

    private BitmovinApi bitmovinApi;

    @Before
    public void setUp() throws Exception
    {
        this.bitmovinApi = new BitmovinApi(apiKey);
    }

    @Test
    public void testAvgQuery() throws Exception
    {
        AnalyticsQuery query = getBasicAnalyticsQuery("STARTUPTIME");
        query.setGroupBy("PLAYER_VERSION");

        JSONArray response = bitmovinApi.analytics.query.avg(query);
        System.out.println("Average startup time per player version: " + response);
    }

    @Test
    public void testCountImpressionsByImpressionID() throws Exception
    {
        AnalyticsQuery query = getBasicAnalyticsQuery("IMPRESSION_ID");

        List<AnalyticsFilter> filters = new ArrayList<>();
        filters.add(new AnalyticsFilter("IMPRESSION_ID", AnalyticsOperator.EQ, impressionId));

        query.setFilters(filters);

        JSONArray response = bitmovinApi.analytics.query.count(query);
        System.out.println(String.format("Number of impressions for %s: %s", impressionId, response));
    }

    @Test
    public void testMaxQuery() throws Exception
    {
        AnalyticsQuery query = getBasicAnalyticsQuery("STARTUPTIME");
        query.setGroupBy("PLAYER_VERSION");

        JSONArray response = bitmovinApi.analytics.query.max(query);
        System.out.println("Max startup time per player version: " + response);
    }

    @Test
    public void testMedianQuery() throws Exception
    {
        AnalyticsQuery query = getBasicAnalyticsQuery("STARTUPTIME");

        List<AnalyticsFilter> filters = new ArrayList<>();
        filters.add(new AnalyticsFilter("STARTUPTIME", AnalyticsOperator.GT, 0));
        filters.add(new AnalyticsFilter("PAGE_LOAD_TYPE", AnalyticsOperator.EQ, 1));

        query.setFilters(filters);

        JSONArray response = bitmovinApi.analytics.query.median(query);
        System.out.println("Median: " + response);
    }

    @Test
    public void testMinQuery() throws Exception
    {
        AnalyticsQuery query = getBasicAnalyticsQuery("STARTUPTIME");
        query.setGroupBy("PLAYER_VERSION");

        JSONArray response = bitmovinApi.analytics.query.min(query);
        System.out.println("Min startup time per player version: " + response);
    }

    @Test
    public void testPercentileQuery() throws Exception
    {
        int percentile = 90;
        AnalyticsQuery query = getBasicAnalyticsQuery("STARTUPTIME");
        query.setPercentile(percentile);
        query.setInterval(AnalyticsInterval.HOUR);

        List<AnalyticsOrderByEntry> orderBy = new ArrayList<>();
        orderBy.add(new AnalyticsOrderByEntry(AnalyticsInterval.HOUR.toString(), AnalyticsOrder.ASC));

        query.setOrderBy(orderBy);

        List<AnalyticsFilter> filters = new ArrayList<>();
        filters.add(new AnalyticsFilter("STARTUPTIME", AnalyticsOperator.GT, 0));
        filters.add(new AnalyticsFilter("PAGE_LOAD_TYPE", AnalyticsOperator.EQ, 1));

        query.setFilters(filters);

        JSONArray response = bitmovinApi.analytics.query.percentile(query);
        System.out.println(String.format("%d' percentile: %s", percentile, response));
    }

    @Test
    public void testStddevQuery() throws Exception
    {
        AnalyticsQuery query = getBasicAnalyticsQuery("STARTUPTIME");
        query.setPercentile(90);
        query.setInterval(AnalyticsInterval.MINUTE);

        List<AnalyticsOrderByEntry> orderBy = new ArrayList<>();
        orderBy.add(new AnalyticsOrderByEntry(AnalyticsInterval.MINUTE.toString(), AnalyticsOrder.ASC));
        query.setOrderBy(orderBy);

        List<AnalyticsFilter> filters = new ArrayList<>();
        filters.add(new AnalyticsFilter("STARTUPTIME", AnalyticsOperator.GT, 0));
        filters.add(new AnalyticsFilter("PAGE_LOAD_TYPE", AnalyticsOperator.EQ, 1));
        query.setFilters(filters);

        JSONArray response = bitmovinApi.analytics.query.stddev(query);
        System.out.println("Standard deviation: " + response);
    }

    @Test
    public void testSumQuery() throws Exception
    {
        AnalyticsQuery query = getBasicAnalyticsQuery("DURATION");
        query.setGroupBy("IMPRESSION_ID");

        JSONArray response = bitmovinApi.analytics.query.sum(query);
        System.out.println("Sum of durations per impression: " + response);
    }

    @Test
    public void testVarianceQuery() throws Exception
    {
        AnalyticsQuery query = getBasicAnalyticsQuery("STARTUPTIME");

        JSONArray response = bitmovinApi.analytics.query.variance(query);
        System.out.println("Variance: " + response);
    }

    private AnalyticsQuery getBasicAnalyticsQuery(String dimension)
    {
        AnalyticsQuery query = new AnalyticsQuery();
        query.setDimension(dimension);
        query.setLicenseKey(analyticsLicenseKey);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'").withLocale(Locale.UK).withZone(ZoneId.of("UTC"));
        query.setStart(dateTimeFormatter.format(addTime(-24 * 50)));
        query.setEnd(dateTimeFormatter.format(addTime(+24)));
        return query;
    }

    private Instant addTime(int hours)
    {
        Instant now = Instant.now();
        return now.plus(hours, HOURS);
    }
}
