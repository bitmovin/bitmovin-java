package com.bitmovin.api.encoding.manifests;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.manifests.type.TypeApi;
import com.bitmovin.api.encoding.manifests.dash.DashApi;
import com.bitmovin.api.encoding.manifests.hls.HlsApi;
import com.bitmovin.api.encoding.manifests.smooth.SmoothApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManifestsApi
{
    private final ManifestsClient apiClient;
    public TypeApi type;
    public DashApi dash;
    public HlsApi hls;
    public SmoothApi smooth;

    public ManifestsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public ManifestsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public ManifestsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(ManifestsClient.class);

        type = new TypeApi(clientFactory);
        dash = new DashApi(clientFactory);
        hls = new HlsApi(clientFactory);
        smooth = new SmoothApi(clientFactory);
    }

    /**
    * List all Manifests
    * 
    * @return List&lt;Manifest&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Manifest> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List all Manifests
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;Manifest&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Manifest> list(ManifestsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
