package com.bitmovin.api.encoding.encodings.inputStreams.ingest;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IngestApi
{
    private final IngestClient apiClient;

    public IngestApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public IngestApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public IngestApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(IngestClient.class);

    }


    /**
    * Add Ingest Input Stream
    * 
    * @param encodingId Id of the encoding. (required)
    * @param ingestInputStream  (optional)
    * @return IngestInputStream
    * @throws BitmovinException if fails to make API call
    */
    public IngestInputStream create(String encodingId, IngestInputStream ingestInputStream) throws BitmovinException
    {
        return this.apiClient.create(encodingId, ingestInputStream);
    }

    /**
    * Delete Ingest Input Stream
    * 
    * @param encodingId Id of the encoding. (required)
    * @param inputStreamId Id of the ingest input stream. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String encodingId, String inputStreamId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, inputStreamId);
    }

    /**
    * Ingest Input Stream Details
    * 
    * @param encodingId Id of the encoding. (required)
    * @param inputStreamId Id of the ingest input stream. (required)
    * @return IngestInputStream
    * @throws BitmovinException if fails to make API call
    */
    public IngestInputStream get(String encodingId, String inputStreamId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, inputStreamId);
    }
    /**
    * List Ingest Input Streams
    * 
    * @param encodingId Id of the encoding. (required)
    * @return List&lt;IngestInputStream&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<IngestInputStream> list(String encodingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, new HashMap<String, Object>());
    }

    /**
    * List Ingest Input Streams
    * 
    * @param encodingId Id of the encoding. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;IngestInputStream&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<IngestInputStream> list(String encodingId, IngestInputStreamsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, queryParams);
    }
}
