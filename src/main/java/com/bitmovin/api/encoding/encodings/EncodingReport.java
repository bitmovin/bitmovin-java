package com.bitmovin.api.encoding.encodings;

import com.bitmovin.api.AbstractApiResponse;

/**
 * Created by akopper on 30.08.16.
 */
public class EncodingReport extends AbstractApiResponse
{

    private long numberOfSegments;

    public long getNumberOfSegments()
    {
        return this.numberOfSegments;
    }

    public void setNumberOfSegments(long numberOfSegments)
    {
        this.numberOfSegments = numberOfSegments;
    }

}

