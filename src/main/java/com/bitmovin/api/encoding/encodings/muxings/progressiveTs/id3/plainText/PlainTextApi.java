package com.bitmovin.api.encoding.encodings.muxings.progressiveTs.id3.plainText;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.muxings.progressiveTs.id3.plainText.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlainTextApi
{
    private final PlainTextClient apiClient;
    public CustomdataApi customdata;

    public PlainTextApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public PlainTextApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public PlainTextApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(PlainTextClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Add Plain Text ID3 Tag to Progressive TS Muxing
    * 
    * @param encodingId ID of the Encoding. (required)
    * @param muxingId ID of the Progressive TS Muxing (required)
    * @param plaintextId3Tag  (optional)
    * @return PlaintextId3Tag
    * @throws BitmovinException if fails to make API call
    */
    public PlaintextId3Tag create(String encodingId, String muxingId, PlaintextId3Tag plaintextId3Tag) throws BitmovinException
    {
        return this.apiClient.create(encodingId, muxingId, plaintextId3Tag);
    }

    /**
    * Delete Plain Text ID3 Tag of Progressive TS Muxing
    * 
    * @param encodingId ID of the Encoding. (required)
    * @param muxingId ID of the Progressive TS Muxing (required)
    * @param id3TagId ID of the Plain Text ID3 Tag (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String encodingId, String muxingId, String id3TagId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, muxingId, id3TagId);
    }

    /**
    * Plain Text ID3 Tag Details of Progressive TS Muxing
    * 
    * @param encodingId ID of the Encoding. (required)
    * @param muxingId ID of the Progressive TS Muxing (required)
    * @param id3TagId ID of the Plain Text ID3 Tag (required)
    * @return PlaintextId3Tag
    * @throws BitmovinException if fails to make API call
    */
    public PlaintextId3Tag get(String encodingId, String muxingId, String id3TagId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, muxingId, id3TagId);
    }
    /**
    * List Plain Text ID3 Tags of Progressive TS Muxing
    * 
    * @param encodingId ID of the Encoding. (required)
    * @param muxingId ID of the Progressive TS Muxing (required)
    * @return List&lt;PlaintextId3Tag&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<PlaintextId3Tag> list(String encodingId, String muxingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, muxingId, new HashMap<String, Object>());
    }

    /**
    * List Plain Text ID3 Tags of Progressive TS Muxing
    * 
    * @param encodingId ID of the Encoding. (required)
    * @param muxingId ID of the Progressive TS Muxing (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;PlaintextId3Tag&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<PlaintextId3Tag> list(String encodingId, String muxingId, PlaintextId3TagsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, muxingId, queryParams);
    }
}
