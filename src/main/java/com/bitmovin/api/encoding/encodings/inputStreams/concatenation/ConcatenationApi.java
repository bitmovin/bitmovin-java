package com.bitmovin.api.encoding.encodings.inputStreams.concatenation;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConcatenationApi
{
    private final ConcatenationClient apiClient;

    public ConcatenationApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public ConcatenationApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public ConcatenationApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(ConcatenationClient.class);

    }


    /**
    * Add Concatenation Input Stream
    * 
    * @param encodingId Id of the encoding. (required)
    * @param concatenationInputStream  (optional)
    * @return ConcatenationInputStream
    * @throws BitmovinException if fails to make API call
    */
    public ConcatenationInputStream create(String encodingId, ConcatenationInputStream concatenationInputStream) throws BitmovinException
    {
        return this.apiClient.create(encodingId, concatenationInputStream);
    }

    /**
    * Delete Concatenation Input Stream
    * 
    * @param encodingId Id of the encoding. (required)
    * @param inputStreamId Id of the Concatenation input stream. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String encodingId, String inputStreamId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, inputStreamId);
    }

    /**
    * Concatenation Input Stream Details
    * 
    * @param encodingId Id of the encoding. (required)
    * @param inputStreamId Id of the concatenation input stream. (required)
    * @return ConcatenationInputStream
    * @throws BitmovinException if fails to make API call
    */
    public ConcatenationInputStream get(String encodingId, String inputStreamId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, inputStreamId);
    }
    /**
    * List Concatenation Input Streams
    * 
    * @param encodingId Id of the encoding. (required)
    * @return List&lt;ConcatenationInputStream&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<ConcatenationInputStream> list(String encodingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, new HashMap<String, Object>());
    }

    /**
    * List Concatenation Input Streams
    * 
    * @param encodingId Id of the encoding. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;ConcatenationInputStream&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<ConcatenationInputStream> list(String encodingId, ConcatenationInputStreamsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, queryParams);
    }
}
