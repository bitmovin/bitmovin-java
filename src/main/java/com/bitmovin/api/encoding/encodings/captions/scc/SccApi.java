package com.bitmovin.api.encoding.encodings.captions.scc;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.captions.scc.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SccApi
{
    private final SccClient apiClient;
    public CustomdataApi customdata;

    public SccApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public SccApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public SccApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(SccClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Convert SCC captions
    * 
    * @param encodingId Id of the encoding. (required)
    * @param convertSccCaption The SCC captions to be created (optional)
    * @return ConvertSccCaption
    * @throws BitmovinException if fails to make API call
    */
    public ConvertSccCaption create(String encodingId, ConvertSccCaption convertSccCaption) throws BitmovinException
    {
        return this.apiClient.create(encodingId, convertSccCaption);
    }

    /**
    * Delete Convert SCC captions
    * 
    * @param encodingId Id of the encoding. (required)
    * @param captionsId Id of the caption. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String encodingId, String captionsId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, captionsId);
    }

    /**
    * Convert SCC captions Details
    * 
    * @param encodingId Id of the encoding. (required)
    * @param captionsId Id of the caption. (required)
    * @return ConvertSccCaption
    * @throws BitmovinException if fails to make API call
    */
    public ConvertSccCaption get(String encodingId, String captionsId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, captionsId);
    }
    /**
    * List Convert SCC captions
    * 
    * @param encodingId Id of the encoding. (required)
    * @return List&lt;ConvertSccCaption&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<ConvertSccCaption> list(String encodingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, new HashMap<String, Object>());
    }

    /**
    * List Convert SCC captions
    * 
    * @param encodingId Id of the encoding. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;ConvertSccCaption&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<ConvertSccCaption> list(String encodingId, ConvertSccCaptionsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, queryParams);
    }
}
