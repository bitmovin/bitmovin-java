package com.bitmovin.api.encoding.statistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LiveEncodingStatisticsList
{
    private Date time;
    private List<LiveEncodingInputStreamInfo> streamInfos = new ArrayList<>();
    private String id;
    private String orgId;
    private String userId;
    private String customData;
    private Date createdAt;
    private Date customDataCreatedAt;

    public Date getTime() { return time; }

    public void setTime(Date time) { this.time = time; }

    public List<LiveEncodingInputStreamInfo> getStreamInfos() { return streamInfos; }

    public void setStreamInfos(List<LiveEncodingInputStreamInfo> streamInfos) { this.streamInfos = streamInfos; }

    public String getOrgId() { return orgId; }

    public void setOrgId(String orgId) { this.orgId = orgId; }

    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }

    public String getCustomData() { return customData; }

    public void setCustomData(String customData) { this.customData = customData; }

    public Date getCreatedAt() { return createdAt; }

    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public Date getCustomDataCreatedAt() { return customDataCreatedAt; }

    public void setCustomDataCreatedAt(Date customDataCreatedAt) { this.customDataCreatedAt = customDataCreatedAt; }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    @Override
    public String toString()
    {
        return "LiveEncodingStatisticsList{" +
                "time=" + time +
                ", streamInfos=" + streamInfos +
                ", orgId='" + orgId + '\'' +
                ", userId='" + userId + '\'' +
                ", customData='" + customData + '\'' +
                ", createdAt=" + createdAt +
                ", customDataCreatedAt=" + customDataCreatedAt +
                '}';
    }
}
