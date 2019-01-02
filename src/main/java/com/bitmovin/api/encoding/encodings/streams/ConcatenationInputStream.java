package com.bitmovin.api.encoding.encodings.streams;

import com.bitmovin.api.AbstractApiResponse;

import java.util.ArrayList;
import java.util.List;

public class ConcatenationInputStream extends AbstractApiResponse
{

    private List<ConcatenationConfiguration> concatenation;

    public ConcatenationInputStream() {
        this.concatenation = new ArrayList<>();
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
