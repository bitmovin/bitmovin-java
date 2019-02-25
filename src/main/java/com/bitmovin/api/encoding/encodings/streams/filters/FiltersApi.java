package com.bitmovin.api.encoding.encodings.streams.filters;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FiltersApi
{
    private final FiltersClient apiClient;

    public FiltersApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public FiltersApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public FiltersApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(FiltersClient.class);

    }


    /**
    * Add Filters to Stream
    * 
    * @param encodingId Id of the encoding. (required)
    * @param streamId Id of the stream. (required)
    * @param streamFilter  (optional)
    * @return StreamFilterList
    * @throws BitmovinException if fails to make API call
    */
    public StreamFilterList create(String encodingId, String streamId, List<StreamFilter> streamFilter) throws BitmovinException
    {
        return this.apiClient.create(encodingId, streamId, streamFilter);
    }

    /**
    * Delete Specific Filter from Stream
    * 
    * @param encodingId Id of the encoding. (required)
    * @param streamId Id of the stream. (required)
    * @param filterId Id of the filter (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String encodingId, String streamId, String filterId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, streamId, filterId);
    }

    /**
    * Delete All Filters from Stream
    * 
    * @param encodingId Id of the encoding. (required)
    * @param streamId Id of the stream. (required)
    * @return BitmovinResponseList
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponseList deleteAll(String encodingId, String streamId) throws BitmovinException
    {
        return this.apiClient.deleteAll(encodingId, streamId);
    }
    /**
    * List the filters of a stream
    * 
    * @param encodingId Id of the encoding. (required)
    * @param streamId Id of the stream. (required)
    * @return StreamFilterList
    * @throws BitmovinException if fails to make API call
    */
    public StreamFilterList list(String encodingId, String streamId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, streamId, new HashMap<String, Object>());
    }

    /**
    * List the filters of a stream
    * 
    * @param encodingId Id of the encoding. (required)
    * @param streamId Id of the stream. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return StreamFilterList
    * @throws BitmovinException if fails to make API call
    */
    public StreamFilterList list(String encodingId, String streamId, StreamFilterListListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, streamId, queryParams);
    }
}
