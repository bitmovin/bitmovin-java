package com.bitmovin.api.encoding.encodings.streams.captions.cea.scc;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.streams.captions.cea.scc.customdata.CustomdataApi;

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
    * Embed SCC captions as 608/708 into Stream
    * 
    * @param encodingId Id of the encoding. (required)
    * @param streamId Id of the stream. (required)
    * @param sccCaption  (optional)
    * @return SccCaption
    * @throws BitmovinException if fails to make API call
    */
    public SccCaption create(String encodingId, String streamId, SccCaption sccCaption) throws BitmovinException
    {
        return this.apiClient.create(encodingId, streamId, sccCaption);
    }

    /**
    * Delete SCC captions as 608/708 from Stream
    * 
    * @param encodingId Id of the encoding. (required)
    * @param streamId Id of the stream. (required)
    * @param captionsId Id of the caption. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String encodingId, String streamId, String captionsId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, streamId, captionsId);
    }

    /**
    * Embed SCC captions as 608/708 Details
    * 
    * @param encodingId Id of the encoding. (required)
    * @param streamId Id of the stream. (required)
    * @param captionsId Id of the caption. (required)
    * @return SccCaption
    * @throws BitmovinException if fails to make API call
    */
    public SccCaption get(String encodingId, String streamId, String captionsId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, streamId, captionsId);
    }
    /**
    * List SCC captions as 608/708 from Stream
    * 
    * @param encodingId Id of the encoding. (required)
    * @param streamId Id of the stream. (required)
    * @return List&lt;SccCaption&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<SccCaption> list(String encodingId, String streamId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, streamId, new HashMap<String, Object>());
    }

    /**
    * List SCC captions as 608/708 from Stream
    * 
    * @param encodingId Id of the encoding. (required)
    * @param streamId Id of the stream. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;SccCaption&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<SccCaption> list(String encodingId, String streamId, SccCaptionsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, streamId, queryParams);
    }
}
