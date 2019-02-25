package com.bitmovin.api.encoding.encodings.muxings.progressiveWebm;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.muxings.progressiveWebm.customdata.CustomdataApi;
import com.bitmovin.api.encoding.encodings.muxings.progressiveWebm.information.InformationApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProgressiveWebmApi
{
    private final ProgressiveWebmClient apiClient;
    public CustomdataApi customdata;
    public InformationApi information;

    public ProgressiveWebmApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public ProgressiveWebmApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public ProgressiveWebmApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(ProgressiveWebmClient.class);

        customdata = new CustomdataApi(clientFactory);
        information = new InformationApi(clientFactory);
    }


    /**
    * Add Progressive WebM Muxing
    * 
    * @param encodingId Id of the encoding. (required)
    * @param progressiveWebmMuxing  (optional)
    * @return ProgressiveWebmMuxing
    * @throws BitmovinException if fails to make API call
    */
    public ProgressiveWebmMuxing create(String encodingId, ProgressiveWebmMuxing progressiveWebmMuxing) throws BitmovinException
    {
        return this.apiClient.create(encodingId, progressiveWebmMuxing);
    }

    /**
    * Delete Progressive WebM Muxing
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the Progressive WebM muxing (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String encodingId, String muxingId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, muxingId);
    }

    /**
    * Progressive WebM Muxing Details
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the Progressive WebM muxing (required)
    * @return ProgressiveWebmMuxing
    * @throws BitmovinException if fails to make API call
    */
    public ProgressiveWebmMuxing get(String encodingId, String muxingId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, muxingId);
    }
    /**
    * List Progressive WebM Muxings
    * 
    * @param encodingId Id of the encoding. (required)
    * @return List&lt;ProgressiveWebmMuxing&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<ProgressiveWebmMuxing> list(String encodingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, new HashMap<String, Object>());
    }

    /**
    * List Progressive WebM Muxings
    * 
    * @param encodingId Id of the encoding. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;ProgressiveWebmMuxing&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<ProgressiveWebmMuxing> list(String encodingId, ProgressiveWebmMuxingsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, queryParams);
    }
}
