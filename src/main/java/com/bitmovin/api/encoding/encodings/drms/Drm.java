package com.bitmovin.api.encoding.encodings.drms;

import com.bitmovin.api.AbstractApiResponse;
import com.bitmovin.api.encoding.EncodingOutput;

import java.util.List;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 25.07.16.
 */
public class Drm extends AbstractApiResponse
{
    private List<EncodingOutput> outputs;

    public Drm() {
    }

    public List<EncodingOutput> getOutputs() {
        return this.outputs;
    }

    public void setOutputs(List<EncodingOutput> outputs) {
        this.outputs = outputs;
    }
}
