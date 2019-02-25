package com.bitmovin.api.encoding.manifests.smooth.representations.mp4;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mp4Api
{
    private final Mp4Client apiClient;

    public Mp4Api(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public Mp4Api(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public Mp4Api(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(Mp4Client.class);

    }


    /**
    * Add MP4 Representation to Smooth Streaming Manifest
    * 
    * @param manifestId Id of the Smooth Streaming manifest. (required)
    * @param smoothStreamingRepresentation  (optional)
    * @return SmoothStreamingRepresentation
    * @throws BitmovinException if fails to make API call
    */
    public SmoothStreamingRepresentation create(String manifestId, SmoothStreamingRepresentation smoothStreamingRepresentation) throws BitmovinException
    {
        return this.apiClient.create(manifestId, smoothStreamingRepresentation);
    }

    /**
    * Delete Smooth Streaming MP4 Representation
    * 
    * @param manifestId Id of the Smooth Streaming manifest. (required)
    * @param representationId Id of the MP4 representation. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String manifestId, String representationId) throws BitmovinException
    {
        return this.apiClient.delete(manifestId, representationId);
    }

    /**
    * Smooth Streaming MP4 Representation Details
    * 
    * @param manifestId Id of the Smooth Streaming manifest. (required)
    * @param representationId Id of the MP4 representation. (required)
    * @return SmoothStreamingRepresentation
    * @throws BitmovinException if fails to make API call
    */
    public SmoothStreamingRepresentation get(String manifestId, String representationId) throws BitmovinException
    {
        return this.apiClient.get(manifestId, representationId);
    }
    /**
    * List MP4 Representation
    * 
    * @param manifestId Id of the Smooth Streaming manifest. (required)
    * @return List&lt;SmoothStreamingRepresentation&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<SmoothStreamingRepresentation> list(String manifestId) throws BitmovinException
    {
        return this.apiClient.list(manifestId, new HashMap<String, Object>());
    }

    /**
    * List MP4 Representation
    * 
    * @param manifestId Id of the Smooth Streaming manifest. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;SmoothStreamingRepresentation&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<SmoothStreamingRepresentation> list(String manifestId, SmoothStreamingRepresentationsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(manifestId, queryParams);
    }
}
