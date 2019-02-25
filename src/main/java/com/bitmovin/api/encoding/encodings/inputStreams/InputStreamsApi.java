package com.bitmovin.api.encoding.encodings.inputStreams;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.inputStreams.ingest.IngestApi;
import com.bitmovin.api.encoding.encodings.inputStreams.concatenation.ConcatenationApi;
import com.bitmovin.api.encoding.encodings.inputStreams.trimming.TrimmingApi;


public class InputStreamsApi
{
    public IngestApi ingest;
    public ConcatenationApi concatenation;
    public TrimmingApi trimming;

    public InputStreamsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public InputStreamsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public InputStreamsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        ingest = new IngestApi(clientFactory);
        concatenation = new ConcatenationApi(clientFactory);
        trimming = new TrimmingApi(clientFactory);
    }

}
