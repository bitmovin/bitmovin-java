package com.bitmovin.api.encoding.manifests.hls.media.vtt;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VttApi
{
    private final VttClient apiClient;

    public VttApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public VttApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public VttApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(VttClient.class);

    }


    /**
    * Add VTT Media
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @param vttMediaInfo  (optional)
    * @return VttMediaInfo
    * @throws BitmovinException if fails to make API call
    */
    public VttMediaInfo create(String manifestId, VttMediaInfo vttMediaInfo) throws BitmovinException
    {
        return this.apiClient.create(manifestId, vttMediaInfo);
    }

    /**
    * Delete VTT Media
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @param mediaId Id of the VTT media. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String manifestId, String mediaId) throws BitmovinException
    {
        return this.apiClient.delete(manifestId, mediaId);
    }

    /**
    * VTT Media Details
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @param mediaId Id of the VTT media. (required)
    * @return VttMediaInfo
    * @throws BitmovinException if fails to make API call
    */
    public VttMediaInfo get(String manifestId, String mediaId) throws BitmovinException
    {
        return this.apiClient.get(manifestId, mediaId);
    }
    /**
    * List all VTT Media
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @return List&lt;VttMediaInfo&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<VttMediaInfo> list(String manifestId) throws BitmovinException
    {
        return this.apiClient.list(manifestId, new HashMap<String, Object>());
    }

    /**
    * List all VTT Media
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;VttMediaInfo&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<VttMediaInfo> list(String manifestId, VttMediaInfosListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(manifestId, queryParams);
    }
}
