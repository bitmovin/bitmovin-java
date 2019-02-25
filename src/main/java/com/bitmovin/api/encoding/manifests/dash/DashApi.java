package com.bitmovin.api.encoding.manifests.dash;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.manifests.dash.customdata.CustomdataApi;
import com.bitmovin.api.encoding.manifests.dash.periods.PeriodsApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DashApi
{
    private final DashClient apiClient;
    public CustomdataApi customdata;
    public PeriodsApi periods;

    public DashApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public DashApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public DashApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(DashClient.class);

        customdata = new CustomdataApi(clientFactory);
        periods = new PeriodsApi(clientFactory);
    }


    /**
    * Create DASH Manifest
    * 
    * @param dashManifest The DASH manifest to be created (optional)
    * @return DashManifest
    * @throws BitmovinException if fails to make API call
    */
    public DashManifest create(DashManifest dashManifest) throws BitmovinException
    {
        return this.apiClient.create(dashManifest);
    }

    /**
    * Delete DASH Manifest
    * 
    * @param manifestId UUID of the DASH manifest to be deleted (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String manifestId) throws BitmovinException
    {
        return this.apiClient.delete(manifestId);
    }

    /**
    * DASH Manifest Details
    * 
    * @param manifestId UUID of the dash manifest (required)
    * @return DashManifest
    * @throws BitmovinException if fails to make API call
    */
    public DashManifest get(String manifestId) throws BitmovinException
    {
        return this.apiClient.get(manifestId);
    }
    /**
    * List DASH Manifests
    * 
    * @return List&lt;DashManifest&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<DashManifest> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List DASH Manifests
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;DashManifest&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<DashManifest> list(DashManifestsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }

    /**
    * Start DASH Manifest Creation
    * 
    * @param manifestId Id of the DASH manifest. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse start(String manifestId) throws BitmovinException
    {
        return this.apiClient.start(manifestId);
    }

    /**
    * DASH Manifest Creation Status
    * 
    * @param manifestId Id of the DASH manifest. (required)
    * @return Task
    * @throws BitmovinException if fails to make API call
    */
    public Task status(String manifestId) throws BitmovinException
    {
        return this.apiClient.status(manifestId);
    }

    /**
    * Stop DASH Manifest Creation
    * 
    * @param manifestId Id of the DASH manifest. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse stop(String manifestId) throws BitmovinException
    {
        return this.apiClient.stop(manifestId);
    }
}
