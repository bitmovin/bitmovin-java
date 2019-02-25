package com.bitmovin.api.encoding.encodings.muxings.progressiveTs.id3.raw;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.muxings.progressiveTs.id3.raw.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RawApi
{
    private final RawClient apiClient;
    public CustomdataApi customdata;

    public RawApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public RawApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public RawApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(RawClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Add Raw ID3 Tag to Progressive TS Muxing
    * 
    * @param encodingId ID of the Encoding. (required)
    * @param muxingId ID of the Progressive TS Muxing (required)
    * @param rawId3Tag  (optional)
    * @return RawId3Tag
    * @throws BitmovinException if fails to make API call
    */
    public RawId3Tag create(String encodingId, String muxingId, RawId3Tag rawId3Tag) throws BitmovinException
    {
        return this.apiClient.create(encodingId, muxingId, rawId3Tag);
    }

    /**
    * Delete Raw ID3 Tag of Progressive TS Muxing
    * 
    * @param encodingId ID of the Encoding. (required)
    * @param muxingId ID of the Progressive TS Muxing (required)
    * @param id3TagId ID of the RAW ID3 Tag (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String encodingId, String muxingId, String id3TagId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, muxingId, id3TagId);
    }

    /**
    * Raw ID3 Tag Details of Progressive TS Muxing
    * 
    * @param encodingId ID of the Encoding. (required)
    * @param muxingId ID of the Progressive TS Muxing (required)
    * @param id3TagId ID of the Raw ID3 Tag (required)
    * @return RawId3Tag
    * @throws BitmovinException if fails to make API call
    */
    public RawId3Tag get(String encodingId, String muxingId, String id3TagId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, muxingId, id3TagId);
    }
    /**
    * List Raw ID3 Tags of Progressive TS Muxing
    * 
    * @param encodingId ID of the Encoding. (required)
    * @param muxingId ID of the Progressive TS Muxing (required)
    * @return List&lt;RawId3Tag&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<RawId3Tag> list(String encodingId, String muxingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, muxingId, new HashMap<String, Object>());
    }

    /**
    * List Raw ID3 Tags of Progressive TS Muxing
    * 
    * @param encodingId ID of the Encoding. (required)
    * @param muxingId ID of the Progressive TS Muxing (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;RawId3Tag&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<RawId3Tag> list(String encodingId, String muxingId, RawId3TagsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, muxingId, queryParams);
    }
}
