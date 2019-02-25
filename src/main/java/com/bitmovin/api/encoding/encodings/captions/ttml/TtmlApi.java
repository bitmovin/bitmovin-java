package com.bitmovin.api.encoding.encodings.captions.ttml;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.captions.ttml.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TtmlApi
{
    private final TtmlClient apiClient;
    public CustomdataApi customdata;

    public TtmlApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public TtmlApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public TtmlApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(TtmlClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Extract TTML Captions
    * 
    * @param encodingId Id of the encoding. (required)
    * @param ttmlExtract The TTML extract captions to be created (optional)
    * @return TtmlExtract
    * @throws BitmovinException if fails to make API call
    */
    public TtmlExtract create(String encodingId, TtmlExtract ttmlExtract) throws BitmovinException
    {
        return this.apiClient.create(encodingId, ttmlExtract);
    }

    /**
    * Delete TTML Extract Captions
    * 
    * @param encodingId Id of the encoding. (required)
    * @param captionsId Id of the captions configuration. (required)
    * @return TtmlExtract
    * @throws BitmovinException if fails to make API call
    */
    public TtmlExtract delete(String encodingId, String captionsId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, captionsId);
    }

    /**
    * TTML Extract Captions Details
    * 
    * @param encodingId Id of the encoding. (required)
    * @param captionsId Id of the captions. (required)
    * @return TtmlExtract
    * @throws BitmovinException if fails to make API call
    */
    public TtmlExtract get(String encodingId, String captionsId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, captionsId);
    }
    /**
    * List TTML Extract Captions
    * 
    * @param encodingId Id of the encoding. (required)
    * @return List&lt;TtmlExtract&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<TtmlExtract> list(String encodingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, new HashMap<String, Object>());
    }

    /**
    * List TTML Extract Captions
    * 
    * @param encodingId Id of the encoding. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;TtmlExtract&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<TtmlExtract> list(String encodingId, TtmlExtractsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, queryParams);
    }
}
