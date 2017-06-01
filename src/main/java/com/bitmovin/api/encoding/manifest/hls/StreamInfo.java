package com.bitmovin.api.encoding.manifest.hls;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by doweinberger on 8/12/16.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class StreamInfo
{
    private String id;

    private String audio;

    private String video;

    private String subtitles;

    private String closedCaptions;

    private String encodingId;

    private String streamId;

    private String muxingId;

    private String drmId;

    private String segmentPath;

    private String uri;

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getAudio()
    {
        return this.audio;
    }

    public void setAudio(String audio)
    {
        this.audio = audio;
    }

    public String getVideo()
    {
        return this.video;
    }

    public void setVideo(String video)
    {
        this.video = video;
    }

    public String getSubtitles()
    {
        return this.subtitles;
    }

    public void setSubtitles(String subtitles)
    {
        this.subtitles = subtitles;
    }

    public String getClosedCaptions()
    {
        return this.closedCaptions;
    }

    public void setClosedCaptions(String closedCaptions)
    {
        this.closedCaptions = closedCaptions;
    }

    public String getEncodingId()
    {
        return this.encodingId;
    }

    public void setEncodingId(String encodingId)
    {
        this.encodingId = encodingId;
    }

    public String getStreamId()
    {
        return this.streamId;
    }

    public void setStreamId(String streamId)
    {
        this.streamId = streamId;
    }

    public String getMuxingId()
    {
        return this.muxingId;
    }

    public void setMuxingId(String muxingId)
    {
        this.muxingId = muxingId;
    }

    public String getSegmentPath()
    {
        return this.segmentPath;
    }

    public void setSegmentPath(String segmentPath)
    {
        this.segmentPath = segmentPath;
    }

    public String getDrmId()
    {
        return this.drmId;
    }

    public void setDrmId(String drmId)
    {
        this.drmId = drmId;
    }

    public String getUri()
    {
        return this.uri;
    }

    public void setUri(String uri)
    {
        this.uri = uri;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof StreamInfo)) return false;

        StreamInfo that = (StreamInfo) o;

        if (this.id != null ? !this.id.equals(that.id) : that.id != null) return false;
        if (this.audio != null ? !this.audio.equals(that.audio) : that.audio != null) return false;
        if (this.video != null ? !this.video.equals(that.video) : that.video != null) return false;
        if (this.subtitles != null ? !this.subtitles.equals(that.subtitles) : that.subtitles != null) return false;
        if (this.closedCaptions != null ? !this.closedCaptions.equals(that.closedCaptions) : that.closedCaptions != null)
            return false;
        if (this.encodingId != null ? !this.encodingId.equals(that.encodingId) : that.encodingId != null) return false;
        if (this.streamId != null ? !this.streamId.equals(that.streamId) : that.streamId != null) return false;
        if (this.muxingId != null ? !this.muxingId.equals(that.muxingId) : that.muxingId != null) return false;
        if (this.drmId != null ? !this.drmId.equals(that.drmId) : that.drmId != null) return false;
        if (this.segmentPath != null ? !this.segmentPath.equals(that.segmentPath) : that.segmentPath != null) return false;
        return this.uri != null ? this.uri.equals(that.uri) : that.uri == null;

    }

    @Override
    public int hashCode()
    {
        int result = this.id != null ? this.id.hashCode() : 0;
        result = 31 * result + (this.audio != null ? this.audio.hashCode() : 0);
        result = 31 * result + (this.video != null ? this.video.hashCode() : 0);
        result = 31 * result + (this.subtitles != null ? this.subtitles.hashCode() : 0);
        result = 31 * result + (this.closedCaptions != null ? this.closedCaptions.hashCode() : 0);
        result = 31 * result + (this.encodingId != null ? this.encodingId.hashCode() : 0);
        result = 31 * result + (this.streamId != null ? this.streamId.hashCode() : 0);
        result = 31 * result + (this.muxingId != null ? this.muxingId.hashCode() : 0);
        result = 31 * result + (this.drmId != null ? this.drmId.hashCode() : 0);
        result = 31 * result + (this.segmentPath != null ? this.segmentPath.hashCode() : 0);
        result = 31 * result + (this.uri != null ? this.uri.hashCode() : 0);
        return result;
    }
}
