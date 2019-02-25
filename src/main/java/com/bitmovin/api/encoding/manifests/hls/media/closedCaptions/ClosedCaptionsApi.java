package com.bitmovin.api.encoding.manifests.hls.media.closedCaptions;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClosedCaptionsApi
{
    private final ClosedCaptionsClient apiClient;

    public ClosedCaptionsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public ClosedCaptionsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public ClosedCaptionsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(ClosedCaptionsClient.class);

    }


    /**
    * Add Closed Captions Media
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @param closedCaptionsMediaInfo  (optional)
    * @return ClosedCaptionsMediaInfo
    * @throws BitmovinException if fails to make API call
    */
    public ClosedCaptionsMediaInfo create(String manifestId, ClosedCaptionsMediaInfo closedCaptionsMediaInfo) throws BitmovinException
    {
        return this.apiClient.create(manifestId, closedCaptionsMediaInfo);
    }

    /**
    * Delete Closed Captions Media
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @param mediaId Id of the closed captions media. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String manifestId, String mediaId) throws BitmovinException
    {
        return this.apiClient.delete(manifestId, mediaId);
    }

    /**
    * Closed Captions Media Details
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @param mediaId Id of the closed captions media. (required)
    * @return ClosedCaptionsMediaInfo
    * @throws BitmovinException if fails to make API call
    */
    public ClosedCaptionsMediaInfo get(String manifestId, String mediaId) throws BitmovinException
    {
        return this.apiClient.get(manifestId, mediaId);
    }
    /**
    * List all Closed Captions Media
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @return List&lt;ClosedCaptionsMediaInfo&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<ClosedCaptionsMediaInfo> list(String manifestId) throws BitmovinException
    {
        return this.apiClient.list(manifestId, new HashMap<String, Object>());
    }

    /**
    * List all Closed Captions Media
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;ClosedCaptionsMediaInfo&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<ClosedCaptionsMediaInfo> list(String manifestId, ClosedCaptionsMediaInfosListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(manifestId, queryParams);
    }
}
