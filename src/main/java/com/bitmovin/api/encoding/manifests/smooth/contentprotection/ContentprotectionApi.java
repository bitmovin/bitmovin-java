package com.bitmovin.api.encoding.manifests.smooth.contentprotection;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContentprotectionApi
{
    private final ContentprotectionClient apiClient;

    public ContentprotectionApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public ContentprotectionApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public ContentprotectionApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(ContentprotectionClient.class);

    }


    /**
    * Add Content Protection to Smooth Streaming
    * 
    * @param manifestId Id of the Smooth Streaming manifest. (required)
    * @param smoothManifestContentProtection  (optional)
    * @return SmoothManifestContentProtection
    * @throws BitmovinException if fails to make API call
    */
    public SmoothManifestContentProtection create(String manifestId, SmoothManifestContentProtection smoothManifestContentProtection) throws BitmovinException
    {
        return this.apiClient.create(manifestId, smoothManifestContentProtection);
    }

    /**
    * Delete Content Protection of Smooth Streaming
    * 
    * @param manifestId Id of the Smooth Streaming manifest. (required)
    * @param protectionId Id of the content protection. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String manifestId, String protectionId) throws BitmovinException
    {
        return this.apiClient.delete(manifestId, protectionId);
    }

    /**
    * Content Protection of Smooth Streaming Representation Details
    * 
    * @param manifestId Id of the Smooth Streaming manifest. (required)
    * @param protectionId Id of the content protection. (required)
    * @return SmoothManifestContentProtection
    * @throws BitmovinException if fails to make API call
    */
    public SmoothManifestContentProtection get(String manifestId, String protectionId) throws BitmovinException
    {
        return this.apiClient.get(manifestId, protectionId);
    }
    /**
    * List Content Protection of Smooth Streaming
    * 
    * @param manifestId Id of the Smooth Streaming manifest. (required)
    * @return List&lt;SmoothManifestContentProtection&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<SmoothManifestContentProtection> list(String manifestId) throws BitmovinException
    {
        return this.apiClient.list(manifestId, new HashMap<String, Object>());
    }

    /**
    * List Content Protection of Smooth Streaming
    * 
    * @param manifestId Id of the Smooth Streaming manifest. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;SmoothManifestContentProtection&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<SmoothManifestContentProtection> list(String manifestId, SmoothManifestContentProtectionsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(manifestId, queryParams);
    }
}
