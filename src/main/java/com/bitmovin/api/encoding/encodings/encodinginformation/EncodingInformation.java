package com.bitmovin.api.encoding.encodings.encodinginformation;

import com.bitmovin.api.AbstractApiResponse;
import com.bitmovin.api.encoding.encodings.Encoding;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by doweinberger on 8/4/16.
 */

public class EncodingInformation extends AbstractApiResponse
{
    private double mediaPresentationDuration;

    private Encoding encoding;

    private Map<String, StreamInformation> streams = new HashMap<String, StreamInformation>();

    public double getMediaPresentationDuration()
    {
        return this.mediaPresentationDuration;
    }

    public void setMediaPresentationDuration(double mediaPresentationDuration)
    {
        this.mediaPresentationDuration = mediaPresentationDuration;
    }

    public Encoding getEncoding()
    {
        return this.encoding;
    }

    public void setEncoding(Encoding encoding)
    {
        this.encoding = encoding;
    }

    public Map<String, StreamInformation> getStreams()
    {
        return this.streams;
    }

    public void setStreams(Map<String, StreamInformation> streams)
    {
        this.streams = streams;
    }

}
