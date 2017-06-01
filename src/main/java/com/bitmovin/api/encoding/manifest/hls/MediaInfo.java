package com.bitmovin.api.encoding.manifest.hls;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

/**
 * Created by doweinberger on 8/12/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MediaInfo
{
    private String id;

    private MediaInfoType type;

    private String groupId;

    private String language;

    private String assocLanguage;

    private String name;

    private String uri;

    private Boolean isDefault;

    private Boolean autoselect;

    private Boolean forced;

    private String instreamId;

    private String encodingId;

    private String streamId;

    private String muxingId;

    private String drmId;

    private String segmentPath;

    private ArrayList<String> characteristics;

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public MediaInfoType getType()
    {
        return this.type;
    }

    public void setType(MediaInfoType type)
    {
        this.type = type;
    }

    public String getGroupId()
    {
        return this.groupId;
    }

    public void setGroupId(String groupId)
    {
        this.groupId = groupId;
    }

    public String getLanguage()
    {
        return this.language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public String getAssocLanguage()
    {
        return this.assocLanguage;
    }

    public void setAssocLanguage(String assocLanguage)
    {
        this.assocLanguage = assocLanguage;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Boolean getDefault()
    {
        return this.isDefault;
    }

    public void setDefault(Boolean aDefault)
    {
        this.isDefault = aDefault;
    }

    public Boolean getAutoselect()
    {
        return this.autoselect;
    }

    public void setAutoselect(Boolean autoselect)
    {
        this.autoselect = autoselect;
    }

    public Boolean getForced()
    {
        return this.forced;
    }

    public void setForced(Boolean forced)
    {
        this.forced = forced;
    }

    public String getInstreamId()
    {
        return this.instreamId;
    }

    public void setInstreamId(String instreamId)
    {
        this.instreamId = instreamId;
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

    public ArrayList<String> getCharacteristics()
    {
        return this.characteristics;
    }

    public void setCharacteristics(ArrayList<String> characteristics)
    {
        this.characteristics = characteristics;
    }

    public void addCharacteristic(String characteristic)
    {
        if(this.characteristics == null)
            this.characteristics = new ArrayList<>();

        this.characteristics.add(characteristic);
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
}
