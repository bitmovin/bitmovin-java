package com.bitmovin.api.encoding.encodings.captions.webvtt;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.captions.webvtt.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebvttApi
{
    private final WebvttClient apiClient;
    public CustomdataApi customdata;

    public WebvttApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public WebvttApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public WebvttApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(WebvttClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Extract WebVtt Captions
    * 
    * @param encodingId Id of the encoding. (required)
    * @param webVttExtract The extract WebVtt captions to be created (optional)
    * @return WebVttExtract
    * @throws BitmovinException if fails to make API call
    */
    public WebVttExtract create(String encodingId, WebVttExtract webVttExtract) throws BitmovinException
    {
        return this.apiClient.create(encodingId, webVttExtract);
    }

    /**
    * Delete Extract WebVtt Captions
    * 
    * @param encodingId Id of the encoding. (required)
    * @param captionsId Id of the captions configuration. (required)
    * @return WebVttExtract
    * @throws BitmovinException if fails to make API call
    */
    public WebVttExtract delete(String encodingId, String captionsId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, captionsId);
    }

    /**
    * Get Extract WebVtt Captions Details
    * 
    * @param encodingId Id of the encoding. (required)
    * @param captionsId Id of the captions. (required)
    * @return WebVttExtract
    * @throws BitmovinException if fails to make API call
    */
    public WebVttExtract get(String encodingId, String captionsId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, captionsId);
    }
    /**
    * List Extract WebVtt Captions
    * 
    * @param encodingId Id of the encoding. (required)
    * @return List&lt;WebVttExtract&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<WebVttExtract> list(String encodingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, new HashMap<String, Object>());
    }

    /**
    * List Extract WebVtt Captions
    * 
    * @param encodingId Id of the encoding. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;WebVttExtract&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<WebVttExtract> list(String encodingId, WebVttExtractsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, queryParams);
    }
}
