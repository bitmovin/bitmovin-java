package com.bitmovin.api.container;

import com.bitmovin.api.constants.ApiUrls;
import com.bitmovin.api.encoding.statistics.DaillySummaryEncodingStatistics;
import com.bitmovin.api.encoding.statistics.EncodingStatistics;
import com.bitmovin.api.encoding.statistics.LiveEncodingStatistics;
import com.bitmovin.api.encoding.statistics.SummaryEncodingStatistics;
import com.bitmovin.api.encoding.statistics.SummaryVodEncodingStatistics;
import com.bitmovin.api.resource.EncodingStatisticsResource;
import com.bitmovin.api.resource.EncodingSummaryStatisticsResource;
import com.bitmovin.api.resource.LiveEncodingEventsResource;

import java.util.Map;

public class StatisticsContainer
{
    public EncodingStatisticsResource encodingStatistics;
    public EncodingStatisticsResource liveEncodingStatistics;
    public LiveEncodingEventsResource liveEncodingEvents;
    public EncodingSummaryStatisticsResource<DaillySummaryEncodingStatistics> dailySummary;
    public EncodingSummaryStatisticsResource<SummaryVodEncodingStatistics> vodSummary;
    public EncodingSummaryStatisticsResource<SummaryEncodingStatistics> liveSummary;

    private Map<String, String> headers;

    public StatisticsContainer(Map<String, String> headers)
    {
        this.headers = headers;
        this.encodingStatistics = new EncodingStatisticsResource(headers, ApiUrls.encodingStatistics, EncodingStatistics.class);
        this.liveEncodingStatistics = new EncodingStatisticsResource(headers, ApiUrls.liveEncodingStatistics, LiveEncodingStatistics.class);
        this.liveEncodingEvents = new LiveEncodingEventsResource(headers, ApiUrls.liveEncodingEvents);
        this.dailySummary = new EncodingSummaryStatisticsResource<>(headers, ApiUrls.dailyEncodingStatistics, DaillySummaryEncodingStatistics.class);
        this.vodSummary = new EncodingSummaryStatisticsResource<>(headers, ApiUrls.summaryVodEncodingStatistics, SummaryVodEncodingStatistics.class);
        this.liveSummary = new EncodingSummaryStatisticsResource<>(headers, ApiUrls.summaryLiveEncodingStatistics, SummaryEncodingStatistics.class);
    }
}
