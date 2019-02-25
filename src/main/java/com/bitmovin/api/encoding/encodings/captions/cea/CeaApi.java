package com.bitmovin.api.encoding.encodings.captions.cea;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.captions.cea.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CeaApi
{
    private final CeaClient apiClient;
    public CustomdataApi customdata;

    public CeaApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public CeaApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public CeaApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(CeaClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Extract CEA 608/708 Captions
    * 
    * @param encodingId Id of the encoding. (required)
    * @param captionsCea The CEA 608/708 captions to be created (optional)
    * @return CaptionsCea
    * @throws BitmovinException if fails to make API call
    */
    public CaptionsCea create(String encodingId, CaptionsCea captionsCea) throws BitmovinException
    {
        return this.apiClient.create(encodingId, captionsCea);
    }

    /**
    * Delete CEA 608/708 Captions
    * 
    * @param encodingId Id of the encoding. (required)
    * @param captionsId Id of the captions configuration. (required)
    * @return CaptionsCea
    * @throws BitmovinException if fails to make API call
    */
    public CaptionsCea delete(String encodingId, String captionsId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, captionsId);
    }

    /**
    * CEA 608/708 Captions Details
    * 
    * @param encodingId Id of the encoding. (required)
    * @param captionsId Id of the captions. (required)
    * @return CaptionsCea
    * @throws BitmovinException if fails to make API call
    */
    public CaptionsCea get(String encodingId, String captionsId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, captionsId);
    }
    /**
    * List CEA 608/708 Captions
    * 
    * @param encodingId Id of the encoding. (required)
    * @return List&lt;CaptionsCea&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<CaptionsCea> list(String encodingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, new HashMap<String, Object>());
    }

    /**
    * List CEA 608/708 Captions
    * 
    * @param encodingId Id of the encoding. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;CaptionsCea&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<CaptionsCea> list(String encodingId, CaptionsCeasListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, queryParams);
    }
}
