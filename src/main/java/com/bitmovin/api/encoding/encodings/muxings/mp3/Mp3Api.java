package com.bitmovin.api.encoding.encodings.muxings.mp3;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.muxings.mp3.customdata.CustomdataApi;
import com.bitmovin.api.encoding.encodings.muxings.mp3.information.InformationApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mp3Api
{
    private final Mp3Client apiClient;
    public CustomdataApi customdata;
    public InformationApi information;

    public Mp3Api(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public Mp3Api(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public Mp3Api(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(Mp3Client.class);

        customdata = new CustomdataApi(clientFactory);
        information = new InformationApi(clientFactory);
    }


    /**
    * Add MP3 Muxing
    * 
    * @param encodingId Id of the encoding. (required)
    * @param mp3Muxing  (optional)
    * @return Mp3Muxing
    * @throws BitmovinException if fails to make API call
    */
    public Mp3Muxing create(String encodingId, Mp3Muxing mp3Muxing) throws BitmovinException
    {
        return this.apiClient.create(encodingId, mp3Muxing);
    }

    /**
    * Delete MP3 Muxing
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the MP3 muxing (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String encodingId, String muxingId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, muxingId);
    }

    /**
    * MP3 Muxing Details
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the MP3 muxing (required)
    * @return Mp3Muxing
    * @throws BitmovinException if fails to make API call
    */
    public Mp3Muxing get(String encodingId, String muxingId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, muxingId);
    }
    /**
    * List MP3 Muxings
    * 
    * @param encodingId Id of the encoding. (required)
    * @return List&lt;Mp3Muxing&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Mp3Muxing> list(String encodingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, new HashMap<String, Object>());
    }

    /**
    * List MP3 Muxings
    * 
    * @param encodingId Id of the encoding. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;Mp3Muxing&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Mp3Muxing> list(String encodingId, Mp3MuxingsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, queryParams);
    }
}
