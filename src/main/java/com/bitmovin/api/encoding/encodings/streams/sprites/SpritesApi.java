package com.bitmovin.api.encoding.encodings.streams.sprites;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.streams.sprites.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpritesApi
{
    private final SpritesClient apiClient;
    public CustomdataApi customdata;

    public SpritesApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public SpritesApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public SpritesApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(SpritesClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Add Sprite
    * 
    * @param encodingId Id of the encoding. (required)
    * @param streamId Id of the stream. (required)
    * @param sprite  (optional)
    * @return Sprite
    * @throws BitmovinException if fails to make API call
    */
    public Sprite create(String encodingId, String streamId, Sprite sprite) throws BitmovinException
    {
        return this.apiClient.create(encodingId, streamId, sprite);
    }

    /**
    * Delete Sprite
    * 
    * @param encodingId Id of the encoding. (required)
    * @param streamId Id of the stream. (required)
    * @param spriteId Id of the sprite. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String encodingId, String streamId, String spriteId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, streamId, spriteId);
    }

    /**
    * Sprite Details
    * 
    * @param encodingId Id of the encoding. (required)
    * @param streamId Id of the stream. (required)
    * @param spriteId Id of the sprite configuration. (required)
    * @return Sprite
    * @throws BitmovinException if fails to make API call
    */
    public Sprite get(String encodingId, String streamId, String spriteId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, streamId, spriteId);
    }
    /**
    * List Sprites
    * 
    * @param encodingId Id of the encoding. (required)
    * @param streamId Id of the stream. (required)
    * @return List&lt;Sprite&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Sprite> list(String encodingId, String streamId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, streamId, new HashMap<String, Object>());
    }

    /**
    * List Sprites
    * 
    * @param encodingId Id of the encoding. (required)
    * @param streamId Id of the stream. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;Sprite&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Sprite> list(String encodingId, String streamId, SpritesListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, streamId, queryParams);
    }
}
