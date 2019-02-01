package com.bitmovin.api.encoding.statistics;

import com.bitmovin.api.encoding.encodings.EncodingMode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BillableEncodingMinutes
{
    private EncodingMode encodingMode;
    private String codec;
    private PerTitleResultStream perTitleResultStream;
    private Map<String, Double> billableMinutes = new HashMap<>();

    public String getCodec()
    {
        return this.codec;
    }

    public void setCodec(String codec)
    {
        this.codec = codec;
    }

    public Map<String, Double> getBillableMinutes()
    {
        return this.billableMinutes;
    }

    public void setBillableMinutes(Map<String, Double> billableMinutes)
    {
        this.billableMinutes = billableMinutes;
    }

    public EncodingMode getEncodingMode()
    {
        return this.encodingMode;
    }

    public void setEncodingMode(EncodingMode encodingMode)
    {
        this.encodingMode = encodingMode;
    }

    public PerTitleResultStream getPerTitleResultStream()
    {
        return perTitleResultStream;
    }

    public void setPerTitleResultStream(PerTitleResultStream perTitleResultStream)
    {
        this.perTitleResultStream = perTitleResultStream;
    }

    @Override
    public String toString()
    {
        return "BillableEncodingMinutes{" +
                "encodingMode=" + encodingMode +
                ", codec='" + codec + '\'' +
                ", perTitleResultStream=" + perTitleResultStream +
                ", billableMinutes=" + billableMinutes +
                '}';
    }
}
