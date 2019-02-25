package com.bitmovin.api.encoding.encodings.muxings.broadcastTs;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.muxings.broadcastTs.customdata.CustomdataApi;
import com.bitmovin.api.encoding.encodings.muxings.broadcastTs.information.InformationApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BroadcastTsApi
{
    private final BroadcastTsClient apiClient;
    public CustomdataApi customdata;
    public InformationApi information;

    public BroadcastTsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public BroadcastTsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public BroadcastTsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(BroadcastTsClient.class);

        customdata = new CustomdataApi(clientFactory);
        information = new InformationApi(clientFactory);
    }


    /**
    * Add Broadcast TS Muxing
    * 
    * @param encodingId ID of the encoding. (required)
    * @param broadcastTsMuxing  (optional)
    * @return BroadcastTsMuxing
    * @throws BitmovinException if fails to make API call
    */
    public BroadcastTsMuxing create(String encodingId, BroadcastTsMuxing broadcastTsMuxing) throws BitmovinException
    {
        return this.apiClient.create(encodingId, broadcastTsMuxing);
    }

    /**
    * Delete Broadcast TS Muxing
    * 
    * @param encodingId ID of the Encoding. (required)
    * @param muxingId ID of the Broadcast TS muxing (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String encodingId, String muxingId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, muxingId);
    }

    /**
    * Broadcast TS Muxing Details
    * 
    * @param encodingId ID of the Encoding. (required)
    * @param muxingId ID of the Broadcast TS Muxing (required)
    * @return BroadcastTsMuxing
    * @throws BitmovinException if fails to make API call
    */
    public BroadcastTsMuxing get(String encodingId, String muxingId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, muxingId);
    }
    /**
    * List Broadcast TS Muxings
    * 
    * @param encodingId ID of the Encoding. (required)
    * @return List&lt;BroadcastTsMuxing&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<BroadcastTsMuxing> list(String encodingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, new HashMap<String, Object>());
    }

    /**
    * List Broadcast TS Muxings
    * 
    * @param encodingId ID of the Encoding. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;BroadcastTsMuxing&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<BroadcastTsMuxing> list(String encodingId, BroadcastTsMuxingsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, queryParams);
    }
}
