package com.bitmovin.api.encoding.encodings.muxings.progressiveMov;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.muxings.progressiveMov.customdata.CustomdataApi;
import com.bitmovin.api.encoding.encodings.muxings.progressiveMov.information.InformationApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProgressiveMovApi
{
    private final ProgressiveMovClient apiClient;
    public CustomdataApi customdata;
    public InformationApi information;

    public ProgressiveMovApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public ProgressiveMovApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public ProgressiveMovApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(ProgressiveMovClient.class);

        customdata = new CustomdataApi(clientFactory);
        information = new InformationApi(clientFactory);
    }


    /**
    * Add Progressive MOV Muxing
    * 
    * @param encodingId Id of the encoding. (required)
    * @param progressiveMovMuxing  (optional)
    * @return ProgressiveMovMuxing
    * @throws BitmovinException if fails to make API call
    */
    public ProgressiveMovMuxing create(String encodingId, ProgressiveMovMuxing progressiveMovMuxing) throws BitmovinException
    {
        return this.apiClient.create(encodingId, progressiveMovMuxing);
    }

    /**
    * Delete Progressive MOV Muxing
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the Progressive MOV muxing (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String encodingId, String muxingId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, muxingId);
    }

    /**
    * Progressive MOV Muxing Details
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the Progressive MOV muxing (required)
    * @return ProgressiveMovMuxing
    * @throws BitmovinException if fails to make API call
    */
    public ProgressiveMovMuxing get(String encodingId, String muxingId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, muxingId);
    }
    /**
    * List Progressive MOV Muxings
    * 
    * @param encodingId Id of the encoding. (required)
    * @return List&lt;ProgressiveMovMuxing&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<ProgressiveMovMuxing> list(String encodingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, new HashMap<String, Object>());
    }

    /**
    * List Progressive MOV Muxings
    * 
    * @param encodingId Id of the encoding. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;ProgressiveMovMuxing&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<ProgressiveMovMuxing> list(String encodingId, ProgressiveMovMuxingsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, queryParams);
    }
}
