package com.bitmovin.api.resource;

import com.bitmovin.api.RestClient;
import com.bitmovin.api.encoding.statistics.SummaryEncodingStatistics;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public class EncodingSummaryStatisticsResource<T extends SummaryEncodingStatistics>
{
    protected Map<String, String> headers;
    protected String url;
    protected Class<T> type;

    public EncodingSummaryStatisticsResource(Map<String, String> headers, String url, Class<T> type)
    {
        this.headers = headers;
        this.url = url;
        this.type = type;
    }

    public List<T> getStatistics() throws BitmovinApiException, UnirestException, IOException, URISyntaxException
    {
        return RestClient.getItems(url, headers, type);
    }

    private String fromTo(Date from, Date to)
    {
        // This is _not_ constructed on the class because SimpleDateFormat is _not_ thread safe
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return this.url + "/" + dateFormat.format(from) + "/" + dateFormat.format(to);
    }

    public List<T> getStatistics(Date from, Date to) throws BitmovinApiException, UnirestException, IOException, URISyntaxException
    {
        return RestClient.getItems(fromTo(from, to), headers, type);
    }

    public List<T> getStatistics(Date from, Date to, int offset, int limit) throws BitmovinApiException, UnirestException, IOException, URISyntaxException
    {
        String limitUrl = fromTo(from, to) + "?offset=" + String.valueOf(offset) + "&limit=" + String.valueOf(limit);
        return RestClient.getItems(limitUrl, headers, type);
    }
}
