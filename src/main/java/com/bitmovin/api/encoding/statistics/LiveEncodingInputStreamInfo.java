package com.bitmovin.api.encoding.statistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LiveEncodingInputStreamInfo
{
    private String streamId;
    private String mediaType;
    private Long width;
    private Long height;
    private Double rate;
    private String codec;
    private Double samplesReadPerSecondMin;
    private Double samplesReadPerSecondAvg;
    private Double samplesReadPerSecondMax;
    private Double samplesBackupPerSecondMin;
    private Double samplesBackupPerSecondAvg;
    private Double samplesBackupPerSecondMax;
    private Double bytesReadPerSecondMin;
    private Double bytesReadPerSecondAvg;
    private Double bytesReadPerSecondMax;
    private Double bytesBackupPerSecondMin;
    private Double bytesBackupPerSecondAvg;
    private Double bytesBackupPerSecondMax;

    private List<Double> samplesReadPerSecond = new ArrayList<>();
    private List<Double> samplesBackupPerSecond = new ArrayList<>();
    private List<Double> bytesReadPerSecond = new ArrayList<>();
    private List<Double> bytesBackupPerSecond = new ArrayList<>();


    public String getStreamId() { return streamId; }

    public void setStreamId(String streamId) { this.streamId = streamId; }

    public String getMediaType() { return mediaType; }

    public void setMediaType(String mediaType) { this.mediaType = mediaType; }

    public Long getWidth() { return width; }

    public void setWidth(Long width) { this.width = width; }

    public Long getHeight() { return height; }

    public void setHeight(Long height) { this.height = height; }

    public Double getRate() { return rate; }

    public void setRate(Double rate) { this.rate = rate; }

    public String getCodec() { return codec; }

    public void setCodec(String codec) { this.codec = codec; }

    public Double getSamplesReadPerSecondMin() { return samplesReadPerSecondMin; }

    public void setSamplesReadPerSecondMin(Double samplesReadPerSecondMin) { this.samplesReadPerSecondMin = samplesReadPerSecondMin; }

    public Double getSamplesReadPerSecondAvg() { return samplesReadPerSecondAvg; }

    public void setSamplesReadPerSecondAvg(Double samplesReadPerSecondAvg) { this.samplesReadPerSecondAvg = samplesReadPerSecondAvg; }

    public Double getSamplesReadPerSecondMax() { return samplesReadPerSecondMax; }

    public void setSamplesReadPerSecondMax(Double samplesReadPerSecondMax) { this.samplesReadPerSecondMax = samplesReadPerSecondMax; }

    public Double getSamplesBackupPerSecondMin() { return samplesBackupPerSecondMin; }

    public void setSamplesBackupPerSecondMin(Double samplesBackupPerSecondMin) { this.samplesBackupPerSecondMin = samplesBackupPerSecondMin; }

    public Double getSamplesBackupPerSecondAvg() { return samplesBackupPerSecondAvg; }

    public void setSamplesBackupPerSecondAvg(Double samplesBackupPerSecondAvg) { this.samplesBackupPerSecondAvg = samplesBackupPerSecondAvg; }

    public Double getSamplesBackupPerSecondMax() { return samplesBackupPerSecondMax; }

    public void setSamplesBackupPerSecondMax(Double samplesBackupPerSecondMax) { this.samplesBackupPerSecondMax = samplesBackupPerSecondMax; }

    public Double getBytesReadPerSecondMin() { return bytesReadPerSecondMin; }

    public void setBytesReadPerSecondMin(Double bytesReadPerSecondMin) { this.bytesReadPerSecondMin = bytesReadPerSecondMin; }

    public Double getBytesReadPerSecondAvg() { return bytesReadPerSecondAvg; }

    public void setBytesReadPerSecondAvg(Double bytesReadPerSecondAvg) { this.bytesReadPerSecondAvg = bytesReadPerSecondAvg; }

    public Double getBytesReadPerSecondMax() { return bytesReadPerSecondMax; }

    public void setBytesReadPerSecondMax(Double bytesReadPerSecondMax) { this.bytesReadPerSecondMax = bytesReadPerSecondMax; }

    public Double getBytesBackupPerSecondMin() { return bytesBackupPerSecondMin; }

    public void setBytesBackupPerSecondMin(Double bytesBackupPerSecondMin) { this.bytesBackupPerSecondMin = bytesBackupPerSecondMin; }

    public Double getBytesBackupPerSecondAvg() { return bytesBackupPerSecondAvg; }

    public void setBytesBackupPerSecondAvg(Double bytesBackupPerSecondAvg) { this.bytesBackupPerSecondAvg = bytesBackupPerSecondAvg; }

    public Double getBytesBackupPerSecondMax() { return bytesBackupPerSecondMax; }

    public void setBytesBackupPerSecondMax(Double bytesBackupPerSecondMax) { this.bytesBackupPerSecondMax = bytesBackupPerSecondMax; }

    public List<Double> getSamplesReadPerSecond() { return samplesReadPerSecond; }

    public void setSamplesReadPerSecond(List<Double> samplesReadPerSecond) { this.samplesReadPerSecond = samplesReadPerSecond; }

    public List<Double> getSamplesBackupPerSecond() { return samplesBackupPerSecond; }

    public void setSamplesBackupPerSecond(List<Double> samplesBackupPerSecond) { this.samplesBackupPerSecond = samplesBackupPerSecond; }

    public List<Double> getBytesReadPerSecond() { return bytesReadPerSecond; }

    public void setBytesReadPerSecond(List<Double> bytesReadPerSecond) { this.bytesReadPerSecond = bytesReadPerSecond; }

    public List<Double> getBytesBackupPerSecond() { return bytesBackupPerSecond; }

    public void setBytesBackupPerSecond(List<Double> bytesBackupPerSecond) { this.bytesBackupPerSecond = bytesBackupPerSecond; }

    @Override
    public String toString()
    {
        return "LiveEncodingInputStreamInfo{" +
                "streamId='" + streamId + '\'' +
                ", mediaType='" + mediaType + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", rate=" + rate +
                ", codec='" + codec + '\'' +
                ", samplesReadPerSecondMin=" + samplesReadPerSecondMin +
                ", samplesReadPerSecondAvg=" + samplesReadPerSecondAvg +
                ", samplesReadPerSecondMax=" + samplesReadPerSecondMax +
                ", samplesBackupPerSecondMin=" + samplesBackupPerSecondMin +
                ", samplesBackupPerSecondAvg=" + samplesBackupPerSecondAvg +
                ", samplesBackupPerSecondMax=" + samplesBackupPerSecondMax +
                ", bytesReadPerSecondMin=" + bytesReadPerSecondMin +
                ", bytesReadPerSecondAvg=" + bytesReadPerSecondAvg +
                ", bytesReadPerSecondMax=" + bytesReadPerSecondMax +
                ", bytesBackupPerSecondMin=" + bytesBackupPerSecondMin +
                ", bytesBackupPerSecondAvg=" + bytesBackupPerSecondAvg +
                ", bytesBackupPerSecondMax=" + bytesBackupPerSecondMax +
                ", samplesReadPerSecond=" + samplesReadPerSecond +
                ", samplesBackupPerSecond=" + samplesBackupPerSecond +
                ", bytesReadPerSecond=" + bytesReadPerSecond +
                ", bytesBackupPerSecond=" + bytesBackupPerSecond +
                '}';
    }
}
