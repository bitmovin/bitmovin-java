package com.bitmovin.api.encoding.encodings.streams;

import com.bitmovin.api.AbstractApiResponse;
import com.bitmovin.api.encoding.enums.StreamSelectionMode;

import java.util.List;

public class ConcatenationInputStream extends AbstractApiResponse
{

    private List<ConcatenationConfiguration> concatenation;

    public ConcatenationInputStream() {
    }

    public List<ConcatenationConfiguration> getConcatenation()
    {
        return this.concatenation;
    }

    public void setConcatenation(List<ConcatenationConfiguration> concatenation)
    {
        this.concatenation= concatenation;
    }
}
