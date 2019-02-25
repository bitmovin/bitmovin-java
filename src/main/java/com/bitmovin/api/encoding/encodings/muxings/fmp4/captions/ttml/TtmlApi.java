package com.bitmovin.api.encoding.encodings.muxings.fmp4.captions.ttml;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.muxings.fmp4.captions.ttml.customdata.CustomdataApi;

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
    * FMP4 Embed TTML Captions
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the fMP4 muxing. (required)
    * @param ttmlEmbed The TTML embed captions to be created. (optional)
    * @return TtmlEmbed
    * @throws BitmovinException if fails to make API call
    */
    public TtmlEmbed create(String encodingId, String muxingId, TtmlEmbed ttmlEmbed) throws BitmovinException
    {
        return this.apiClient.create(encodingId, muxingId, ttmlEmbed);
    }

    /**
    * Delete TTML Embed Captions
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the fMP4 muxing. (required)
    * @param captionsId Id of the captions configuration. (required)
    * @return TtmlEmbed
    * @throws BitmovinException if fails to make API call
    */
    public TtmlEmbed delete(String encodingId, String muxingId, String captionsId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, muxingId, captionsId);
    }

    /**
    * TTML Embed Captions Details
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the fMP4 muxing. (required)
    * @param captionsId Id of the captions. (required)
    * @return TtmlEmbed
    * @throws BitmovinException if fails to make API call
    */
    public TtmlEmbed get(String encodingId, String muxingId, String captionsId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, muxingId, captionsId);
    }
    /**
    * List TTML Embed Captions
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the fMP4 muxing. (required)
    * @return List&lt;TtmlEmbed&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<TtmlEmbed> list(String encodingId, String muxingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, muxingId, new HashMap<String, Object>());
    }

    /**
    * List TTML Embed Captions
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the fMP4 muxing. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;TtmlEmbed&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<TtmlEmbed> list(String encodingId, String muxingId, TtmlEmbedsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, muxingId, queryParams);
    }
}
