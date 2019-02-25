package com.bitmovin.api.encoding.encodings.muxings.fmp4.captions.webvtt;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.muxings.fmp4.captions.webvtt.customdata.CustomdataApi;

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
    * FMP4 Embed WebVtt Captions
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the fMP4 muxing. (required)
    * @param webVttEmbed The WebVtt captions to be created. (optional)
    * @return WebVttEmbed
    * @throws BitmovinException if fails to make API call
    */
    public WebVttEmbed create(String encodingId, String muxingId, WebVttEmbed webVttEmbed) throws BitmovinException
    {
        return this.apiClient.create(encodingId, muxingId, webVttEmbed);
    }

    /**
    * Get FMP4 Embed WebVtt Captions Details
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the fMP4 muxing. (required)
    * @param captionsId Id of the captions config. (required)
    * @return WebVttEmbed
    * @throws BitmovinException if fails to make API call
    */
    public WebVttEmbed get(String encodingId, String muxingId, String captionsId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, muxingId, captionsId);
    }

    /**
    * List FMP4 Embed WebVtt Captions
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the fMP4 muxing. (required)
    * @return List&lt;WebVttEmbed&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<WebVttEmbed> list(String encodingId, String muxingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, muxingId);
    }
}
