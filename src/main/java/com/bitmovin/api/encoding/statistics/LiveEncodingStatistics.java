package com.bitmovin.api.encoding.statistics;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LiveEncodingStatistics
{
    private String id;
    private Date createdAt;
    private String encodingId;
    private String status;
    private List<LiveInputEvent> events = new ArrayList<>();
    private List<LiveEncodingStatisticsList> statistics = new ArrayList<>();

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public Date getCreatedAt() { return createdAt; }

    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public String getEncodingId() { return encodingId; }

    public void setEncodingId(String encodingId) { this.encodingId = encodingId; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public List<LiveInputEvent> getEvents() { return events; }

    public void setEvents(List<LiveInputEvent> events) { this.events = events; }

    public List<LiveEncodingStatisticsList> getStatistics() { return statistics; }

    public void setStatistics(List<LiveEncodingStatisticsList> statistics) { this.statistics = statistics; }

    @Override
    public String toString()
    {
        return "LiveEncodingStatistics{" +
                "id='" + id + '\'' +
                ", createdAt=" + createdAt +
                ", encodingId='" + encodingId + '\'' +
                ", status='" + status + '\'' +
                ", events=" + events +
                ", statistics=" + statistics +
                '}';
    }
}
