package com.bitmovin.api.encoding.encodings.streams.thumbnails;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.streams.thumbnails.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThumbnailsApi
{
    private final ThumbnailsClient apiClient;
    public CustomdataApi customdata;

    public ThumbnailsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public ThumbnailsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public ThumbnailsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(ThumbnailsClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Add Thumbnail
    * 
    * @param encodingId Id of the encoding. (required)
    * @param streamId Id of the stream. (required)
    * @param thumbnail  (optional)
    * @return Thumbnail
    * @throws BitmovinException if fails to make API call
    */
    public Thumbnail create(String encodingId, String streamId, Thumbnail thumbnail) throws BitmovinException
    {
        return this.apiClient.create(encodingId, streamId, thumbnail);
    }

    /**
    * Delete Thumbnail
    * 
    * @param encodingId Id of the encoding. (required)
    * @param streamId Id of the stream. (required)
    * @param thumbnailId Id of the thumbnail. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String encodingId, String streamId, String thumbnailId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, streamId, thumbnailId);
    }

    /**
    * Thumbnail Details
    * 
    * @param encodingId Id of the encoding. (required)
    * @param streamId Id of the stream. (required)
    * @param thumbnailId Id of the thumbnail. (required)
    * @return Thumbnail
    * @throws BitmovinException if fails to make API call
    */
    public Thumbnail get(String encodingId, String streamId, String thumbnailId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, streamId, thumbnailId);
    }
    /**
    * List Thumbnails
    * 
    * @param encodingId Id of the encoding. (required)
    * @param streamId Id of the stream. (required)
    * @return List&lt;Thumbnail&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Thumbnail> list(String encodingId, String streamId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, streamId, new HashMap<String, Object>());
    }

    /**
    * List Thumbnails
    * 
    * @param encodingId Id of the encoding. (required)
    * @param streamId Id of the stream. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;Thumbnail&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Thumbnail> list(String encodingId, String streamId, ThumbnailsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, streamId, queryParams);
    }
}
