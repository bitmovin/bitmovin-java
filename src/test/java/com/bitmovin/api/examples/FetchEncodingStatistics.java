package com.bitmovin.api.examples;

import com.bitmovin.api.BitmovinApi;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.GregorianCalendar;

public class FetchEncodingStatistics
{

    private static final String API_KEY = "<INSERT_YOUR_API_KEY>";
    private static BitmovinApi bitmovinApi;

    @Test
    public void testFetchEncodingStats() throws BitmovinApiException, UnirestException, URISyntaxException, IOException
    {
        bitmovinApi = new BitmovinApi(API_KEY);
        System.out.println(bitmovinApi.statistics.encodingStatistics.getEncodingStatistics("<INSERT_ENCODING_ID_HERE>"));
    }

    @Test
    public void testFetchLiveEncodingStats() throws BitmovinApiException, UnirestException, URISyntaxException, IOException
    {
        bitmovinApi = new BitmovinApi(API_KEY);
        System.out.println(bitmovinApi.statistics.liveEncodingStatistics.getEncodingStatistics(""));
    }

    @Test
    public void testFetchDailyStats() throws BitmovinApiException, UnirestException, URISyntaxException, IOException
    {
        bitmovinApi = new BitmovinApi(API_KEY);
        System.out.println(bitmovinApi.statistics.dailySummary.getStatistics());
    }

    @Test
    public void testFetchVodStats() throws BitmovinApiException, UnirestException, URISyntaxException, IOException
    {
        bitmovinApi = new BitmovinApi(API_KEY);
        System.out.println(bitmovinApi.statistics.vodSummary.getStatistics());
    }

    @Test
    public void testFetchLiveStats() throws BitmovinApiException, UnirestException, URISyntaxException, IOException
    {
        bitmovinApi = new BitmovinApi(API_KEY);
        System.out.println(bitmovinApi.statistics.liveSummary.getStatistics());
    }

    @Test
    public void testFetchVodStatsFromTo() throws BitmovinApiException, UnirestException, URISyntaxException, IOException
    {
        bitmovinApi = new BitmovinApi(API_KEY);
        Date from = new GregorianCalendar(2018, 9, 12).getTime();
        Date to = new GregorianCalendar(2018, 9, 24).getTime();
        System.out.println(bitmovinApi.statistics.vodSummary.getStatistics(from, to));
    }

    @Test
    public void testFetchVodStatsLimited() throws BitmovinApiException, UnirestException, URISyntaxException, IOException
    {
        bitmovinApi = new BitmovinApi(API_KEY);
        Date from = new GregorianCalendar(2018, 9, 12).getTime();
        Date to = new GregorianCalendar(2018, 9, 24).getTime();
        System.out.println(bitmovinApi.statistics.vodSummary.getStatistics(from, to, 0, 25));
    }

    @Test
    public void testFetchLiveEvents() throws IOException, BitmovinApiException, UnirestException, URISyntaxException
    {
        bitmovinApi = new BitmovinApi(API_KEY);
        System.out.println(bitmovinApi.statistics.liveEncodingEvents.getEvents("<INSERT_ENCODING_ID_HERE>"));
        System.out.println(bitmovinApi.statistics.liveEncodingEvents.getEvents("<INSERT_ENCODING_ID_HERE>", 0, 1));
    }
}
