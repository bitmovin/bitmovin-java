package com.bitmovin.api.encoding.encodings.muxings.ts.captions.cea;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.muxings.ts.captions.cea.customdata.CustomdataApi;

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
    * TS Embed CEA 608/708 Captions
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the TS muxing. (required)
    * @param captionsEmbedCea The captions embed CEA to be created. (optional)
    * @return CaptionsEmbedCea
    * @throws BitmovinException if fails to make API call
    */
    public CaptionsEmbedCea create(String encodingId, String muxingId, CaptionsEmbedCea captionsEmbedCea) throws BitmovinException
    {
        return this.apiClient.create(encodingId, muxingId, captionsEmbedCea);
    }

    /**
    * Delete Embedded CEA 608/708 Captions
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the TS muxing. (required)
    * @param captionsId Id of the subtitle. (required)
    * @return CaptionsEmbedCea
    * @throws BitmovinException if fails to make API call
    */
    public CaptionsEmbedCea delete(String encodingId, String muxingId, String captionsId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, muxingId, captionsId);
    }

    /**
    * Embedded CEA 608/708 Captions Details
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the TS muxing. (required)
    * @param captionsId Id of the captions. (required)
    * @return CaptionsEmbedCea
    * @throws BitmovinException if fails to make API call
    */
    public CaptionsEmbedCea get(String encodingId, String muxingId, String captionsId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, muxingId, captionsId);
    }
    /**
    * List TS Embedded CEA 608/708 Captions
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the TS muxing. (required)
    * @return List&lt;CaptionsEmbedCea&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<CaptionsEmbedCea> list(String encodingId, String muxingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, muxingId, new HashMap<String, Object>());
    }

    /**
    * List TS Embedded CEA 608/708 Captions
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the TS muxing. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;CaptionsEmbedCea&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<CaptionsEmbedCea> list(String encodingId, String muxingId, CaptionsEmbedCeasListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, muxingId, queryParams);
    }
}
