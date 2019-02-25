package com.bitmovin.api.encoding.encodings.muxings.segmentedRaw;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.muxings.segmentedRaw.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SegmentedRawApi
{
    private final SegmentedRawClient apiClient;
    public CustomdataApi customdata;

    public SegmentedRawApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public SegmentedRawApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public SegmentedRawApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(SegmentedRawClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Add Segmented RAW Muxing
    * 
    * @param encodingId Id of the encoding. (required)
    * @param segmentedRawMuxing  (optional)
    * @return SegmentedRawMuxing
    * @throws BitmovinException if fails to make API call
    */
    public SegmentedRawMuxing create(String encodingId, SegmentedRawMuxing segmentedRawMuxing) throws BitmovinException
    {
        return this.apiClient.create(encodingId, segmentedRawMuxing);
    }

    /**
    * Delete Segmented RAW Muxing
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the Segmented RAW muxing (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String encodingId, String muxingId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, muxingId);
    }

    /**
    * Segmented RAW Muxing Details
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the Segmented RAW muxing (required)
    * @return SegmentedRawMuxing
    * @throws BitmovinException if fails to make API call
    */
    public SegmentedRawMuxing get(String encodingId, String muxingId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, muxingId);
    }
    /**
    * List Segmented RAW Muxings
    * 
    * @param encodingId Id of the encoding. (required)
    * @return List&lt;SegmentedRawMuxing&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<SegmentedRawMuxing> list(String encodingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, new HashMap<String, Object>());
    }

    /**
    * List Segmented RAW Muxings
    * 
    * @param encodingId Id of the encoding. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;SegmentedRawMuxing&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<SegmentedRawMuxing> list(String encodingId, SegmentedRawMuxingsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, queryParams);
    }
}
