package com.bitmovin.api.encoding.encodings.streams;

import com.bitmovin.api.AbstractApiResponse;
import com.bitmovin.api.encoding.EncodingOutput;
import com.bitmovin.api.encoding.InputStream;
import com.bitmovin.api.encoding.StreamFilter;
import com.bitmovin.api.encoding.encodings.conditions.AbstractCondition;
import com.bitmovin.api.encoding.encodings.muxing.Muxing;
import com.bitmovin.api.encoding.encodings.thumbnails.Sprite;
import com.bitmovin.api.encoding.encodings.thumbnails.Thumbnail;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Stream extends AbstractApiResponse
{
    private Set<InputStream> inputStreams;

    private Set<EncodingOutput> outputs;

    private Boolean createQualityMetaData;

    @JsonIgnore
    private List<Muxing> muxings;

    @JsonIgnore
    private Set<Thumbnail> thumbnails;

    @JsonIgnore
    private Set<Sprite> sprites;

    @JsonIgnore
    private List<StreamFilter> filters;

    private String codecConfigId;

    private Integer segmentsEncoded;

    private AbstractCondition conditions;

    private List<Ignoring> ignoredBy;

    private StreamMode mode;

    private StreamMetadata metadata;

    public Stream()
    {
        this.inputStreams = new HashSet<>();
        this.outputs = new HashSet<>();

        this.muxings = new ArrayList<>();
        this.filters = new ArrayList<>();

        this.thumbnails = new HashSet<>();
        this.sprites = new HashSet<>();
    }

    public Set<InputStream> getInputStreams()
    {
        return this.inputStreams;
    }

    public void addInputStream(InputStream inputStream)
    {
        this.inputStreams.add(inputStream);
    }

    public void setInputStreams(Set<InputStream> inputStreams)
    {
        this.inputStreams = inputStreams;
    }

    public Boolean getCreateQualityMetaData()
    {
        return this.createQualityMetaData;
    }

    public void setCreateQualityMetaData(Boolean createQualityMetaData)
    {
        this.createQualityMetaData = createQualityMetaData;
    }

    public String getCodecConfigId()
    {
        return this.codecConfigId;
    }

    public void setCodecConfigId(String codecConfigId)
    {
        this.codecConfigId = codecConfigId;
    }

    public void addMuxing(Muxing muxing)
    {
        this.muxings.add(muxing);
    }

    public List<Muxing> getMuxings()
    {
        return this.muxings;
    }

    public void setMuxings(List<Muxing> muxings)
    {
        this.muxings = muxings;
    }

    public void addOutput(EncodingOutput output)
    {
        this.outputs.add(output);
    }

    public Set<EncodingOutput> getOutputs()
    {
        return this.outputs;
    }

    public void setOutputs(Set<EncodingOutput> outputs)
    {
        this.outputs = outputs;
    }

    public Set<Thumbnail> getThumbnails()
    {
        return this.thumbnails;
    }

    public void setThumbnails(Set<Thumbnail> thumbnails)
    {
        this.thumbnails = thumbnails;
    }

    public Set<Sprite> getSprites()
    {
        return this.sprites;
    }

    public void setSprites(Set<Sprite> sprites)
    {
        this.sprites = sprites;
    }

    public void addThumbnail(Thumbnail thumbnail)
    {
        this.thumbnails.add(thumbnail);
    }

    public void addSprite(Sprite sprite)
    {
        this.sprites.add(sprite);
    }

    public List<StreamFilter> getFilters()
    {
        return this.filters;
    }

    public void setFilters(List<StreamFilter> filters)
    {
        this.filters = filters;
    }

    public void addFilter(StreamFilter filter)
    {
        this.filters.add(filter);
    }

    public Integer getSegmentsEncoded()
    {
        return this.segmentsEncoded;
    }

    public void setSegmentsEncoded(Integer segmentsEncoded)
    {
        this.segmentsEncoded = segmentsEncoded;
    }

    public AbstractCondition getConditions()
    {
        return this.conditions;
    }

    public void setConditions(AbstractCondition conditions)
    {
        this.conditions = conditions;
    }

    public List<Ignoring> getIgnoredBy()
    {
        return this.ignoredBy;
    }

    public void setIgnoredBy(List<Ignoring> ignoredBy)
    {
        this.ignoredBy = ignoredBy;
    }

    public StreamMode getMode()
    {
        return this.mode;
    }

    public void setMode(StreamMode mode)
    {
        this.mode = mode;
    }

    public StreamMetadata getMetadata()
    {
        return this.metadata;
    }

    public void setMetadata(StreamMetadata metadata)
    {
        this.metadata = metadata;
    }
}
