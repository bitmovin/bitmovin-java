package com.bitmovin.api.encoding.encodings.muxings.progressiveTs.id3.frameId;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.muxings.progressiveTs.id3.frameId.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrameIdApi
{
    private final FrameIdClient apiClient;
    public CustomdataApi customdata;

    public FrameIdApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public FrameIdApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public FrameIdApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(FrameIdClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Add Frame ID ID3 Tag to Progressive TS Muxing
    * 
    * @param encodingId ID of the Encoding. (required)
    * @param muxingId ID of the Progressive TS Muxing (required)
    * @param frameIdId3Tag  (optional)
    * @return FrameIdId3Tag
    * @throws BitmovinException if fails to make API call
    */
    public FrameIdId3Tag create(String encodingId, String muxingId, FrameIdId3Tag frameIdId3Tag) throws BitmovinException
    {
        return this.apiClient.create(encodingId, muxingId, frameIdId3Tag);
    }

    /**
    * Delete Frame ID ID3 Tag of Progressive TS Muxing
    * 
    * @param encodingId ID of the Encoding. (required)
    * @param muxingId ID of the Progressive TS Muxing (required)
    * @param id3TagId ID of the Frame ID ID3 Tag (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String encodingId, String muxingId, String id3TagId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, muxingId, id3TagId);
    }

    /**
    * Frame ID ID3 Tag Details of Progressive TS Muxing
    * 
    * @param encodingId ID of the Encoding. (required)
    * @param muxingId ID of the Progressive TS Muxing (required)
    * @param id3TagId ID of the Frame ID ID3 Tag (required)
    * @return FrameIdId3Tag
    * @throws BitmovinException if fails to make API call
    */
    public FrameIdId3Tag get(String encodingId, String muxingId, String id3TagId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, muxingId, id3TagId);
    }
    /**
    * List Frame ID ID3 Tags of Progressive TS Muxing
    * 
    * @param encodingId ID of the Encoding. (required)
    * @param muxingId ID of the Progressive TS Muxing (required)
    * @return List&lt;FrameIdId3Tag&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<FrameIdId3Tag> list(String encodingId, String muxingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, muxingId, new HashMap<String, Object>());
    }

    /**
    * List Frame ID ID3 Tags of Progressive TS Muxing
    * 
    * @param encodingId ID of the Encoding. (required)
    * @param muxingId ID of the Progressive TS Muxing (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;FrameIdId3Tag&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<FrameIdId3Tag> list(String encodingId, String muxingId, FrameIdId3TagsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, muxingId, queryParams);
    }
}
