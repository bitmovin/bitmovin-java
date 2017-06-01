package com.bitmovin.api.encoding.encodings.muxing;

import com.bitmovin.api.AbstractApiResponse;
import com.bitmovin.api.encoding.EncodingOutput;
import com.bitmovin.api.encoding.encodings.drms.Drm;
import com.bitmovin.api.encoding.encodings.muxing.enums.MuxingType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 25.07.16.
 */
public class Muxing extends AbstractApiResponse
{

    protected List<MuxingStream> streams = new ArrayList<>();
    protected List<EncodingOutput> outputs = new ArrayList();
    protected MuxingType type;
    protected List<Drm> drmConfigs = new ArrayList();

    public Muxing()
    {
    }

    public List<MuxingStream> getStreams()
    {
        return this.streams;
    }

    public void setStreams(List<MuxingStream> streams)
    {
        this.streams = streams;
    }

    public void addStream(MuxingStream stream)
    {
        this.streams.add(stream);
    }

    public void addOutput(EncodingOutput output)
    {
        this.outputs.add(output);
    }

    public List<EncodingOutput> getOutputs()
    {
        return this.outputs;
    }

    public void setOutputs(List<EncodingOutput> outputs)
    {
        this.outputs = outputs;
    }

    public MuxingType getType()
    {
        return this.type;
    }

    public void setType(MuxingType type)
    {
        this.type = type;
    }

    public List<Drm> getDrmConfigs()
    {
        return this.drmConfigs;
    }
    public void setDrmConfigs(List<Drm> drmConfigs)
    {
        this.drmConfigs = drmConfigs;
    }

}
