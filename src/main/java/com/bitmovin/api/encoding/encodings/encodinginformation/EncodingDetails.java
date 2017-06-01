package com.bitmovin.api.encoding.encodings.encodinginformation;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Created by doweinberger on 8/4/16.
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(name = "AUDIO", value = EncodingDetailsAudio.class),
        @JsonSubTypes.Type(name = "VIDEO", value = EncodingDetailsVideo.class)
})
public class EncodingDetails
{
    private Integer id;

    private EncodingDetailsType type;

    private String EncodingReferenceStreamId;
    private int representationId;
    private String mimeType;
    private String codec;
    private String widevinePssh;
    private int bitrate;
    private String dashInitSegment;
    private String dashMediaTemplate;
    private String hlsMediaTemplate;
    private int duration;
    private int timescale;
    private int numberOfSegments;
    private int numberOfSegmentsDash;
    private int numberOfSegmentsHls;
    private double segmentDurationHls;

    public String getEncodingReferenceStreamId()
    {
        return this.EncodingReferenceStreamId;
    }

    public void setEncodingReferenceStreamId(String encodingReferenceStreamId)
    {
        this.EncodingReferenceStreamId = encodingReferenceStreamId;
    }

    public int getRepresentationId()
    {
        return this.representationId;
    }

    public void setRepresentationId(int representationId)
    {
        this.representationId = representationId;
    }

    public String getMimeType()
    {
        return this.mimeType;
    }

    public void setMimeType(String mimeType)
    {
        this.mimeType = mimeType;
    }

    public String getCodec()
    {
        return this.codec;
    }

    public void setCodec(String codec)
    {
        this.codec = codec;
    }

    public String getWidevinePssh()
    {
        return this.widevinePssh;
    }

    public void setWidevinePssh(String widevinePssh)
    {
        this.widevinePssh = widevinePssh;
    }

    public int getBitrate()
    {
        return this.bitrate;
    }

    public void setBitrate(int bitrate)
    {
        this.bitrate = bitrate;
    }

    public String getDashInitSegment()
    {
        return this.dashInitSegment;
    }

    public void setDashInitSegment(String dashInitSegment)
    {
        this.dashInitSegment = dashInitSegment;
    }

    public String getDashMediaTemplate()
    {
        return this.dashMediaTemplate;
    }

    public void setDashMediaTemplate(String dashMediaTemplate)
    {
        this.dashMediaTemplate = dashMediaTemplate;
    }

    public String getHlsMediaTemplate()
    {
        return this.hlsMediaTemplate;
    }

    public void setHlsMediaTemplate(String hlsMediaTemplate)
    {
        this.hlsMediaTemplate = hlsMediaTemplate;
    }

    public int getDuration()
    {
        return this.duration;
    }

    public void setDuration(int duration)
    {
        this.duration = duration;
    }

    public int getTimescale()
    {
        return this.timescale;
    }

    public void setTimescale(int timescale)
    {
        this.timescale = timescale;
    }

    public int getNumberOfSegments()
    {
        return this.numberOfSegments;
    }

    public void setNumberOfSegments(int numberOfSegments)
    {
        this.numberOfSegments = numberOfSegments;
    }

    public int getNumberOfSegmentsDash()
    {
        return this.numberOfSegmentsDash;
    }

    public void setNumberOfSegmentsDash(int numberOfSegmentsDash)
    {
        this.numberOfSegmentsDash = numberOfSegmentsDash;
    }

    public int getNumberOfSegmentsHls()
    {
        return this.numberOfSegmentsHls;
    }

    public void setNumberOfSegmentsHls(int numberOfSegmentsHls)
    {
        this.numberOfSegmentsHls = numberOfSegmentsHls;
    }

    public double getSegmentDurationHls()
    {
        return this.segmentDurationHls;
    }

    public void setSegmentDurationHls(double segmentDurationHls)
    {
        this.segmentDurationHls = segmentDurationHls;
    }

    public Integer getId()
    {
        return this.id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public EncodingDetailsType getType()
    {
        return this.type;
    }

    public void setType(EncodingDetailsType type)
    {
        this.type = type;
    }
}
