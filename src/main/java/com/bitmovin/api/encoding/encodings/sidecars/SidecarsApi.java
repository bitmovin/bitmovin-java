package com.bitmovin.api.encoding.encodings.sidecars;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.sidecars.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SidecarsApi
{
    private final SidecarsClient apiClient;
    public CustomdataApi customdata;

    public SidecarsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public SidecarsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public SidecarsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(SidecarsClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Add Sidecar
    * 
    * @param encodingId Id of the encoding. (required)
    * @param sidecarFile  (optional)
    * @return SidecarFile
    * @throws BitmovinException if fails to make API call
    */
    public SidecarFile create(String encodingId, SidecarFile sidecarFile) throws BitmovinException
    {
        return this.apiClient.create(encodingId, sidecarFile);
    }

    /**
    * Delete Sidecar
    * 
    * @param encodingId Id of the encoding. (required)
    * @param sidecarId Id of the sidecar. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String encodingId, String sidecarId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, sidecarId);
    }

    /**
    * Sidecar Details
    * 
    * @param encodingId Id of the encoding. (required)
    * @param sidecarId Id of the sidecar. (required)
    * @return SidecarFile
    * @throws BitmovinException if fails to make API call
    */
    public SidecarFile get(String encodingId, String sidecarId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, sidecarId);
    }
    /**
    * List Sidecars
    * 
    * @param encodingId Id of the encoding. (required)
    * @return List&lt;SidecarFile&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<SidecarFile> list(String encodingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, new HashMap<String, Object>());
    }

    /**
    * List Sidecars
    * 
    * @param encodingId Id of the encoding. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;SidecarFile&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<SidecarFile> list(String encodingId, SidecarFilesListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, queryParams);
    }
}
