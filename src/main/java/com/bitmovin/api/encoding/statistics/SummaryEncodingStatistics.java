package com.bitmovin.api.encoding.statistics;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.sql.Date;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SummaryEncodingStatistics
{
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private Long bytesEncoded;
    private Long timeEncoded;

    public SummaryEncodingStatistics() {}

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public Long getBytesEncoded() { return bytesEncoded; }

    public void setBytesEncoded(Long bytesEncoded) { this.bytesEncoded = bytesEncoded; }

    public Long getTimeEncoded() { return timeEncoded; }

    public void setTimeEncoded(Long timeEncoded) { this.timeEncoded = timeEncoded; }

    @Override
    public String toString()
    {
        return "SummaryEncodingStatistics{" +
                "date=" + date +
                ", bytesEncoded=" + bytesEncoded +
                ", timeEncoded=" + timeEncoded +
                '}';
    }
}
