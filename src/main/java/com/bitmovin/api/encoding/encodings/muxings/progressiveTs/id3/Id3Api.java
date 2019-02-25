package com.bitmovin.api.encoding.encodings.muxings.progressiveTs.id3;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.muxings.progressiveTs.id3.raw.RawApi;
import com.bitmovin.api.encoding.encodings.muxings.progressiveTs.id3.frameId.FrameIdApi;
import com.bitmovin.api.encoding.encodings.muxings.progressiveTs.id3.plainText.PlainTextApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Id3Api
{
    private final Id3Client apiClient;
    public RawApi raw;
    public FrameIdApi frameId;
    public PlainTextApi plainText;

    public Id3Api(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public Id3Api(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public Id3Api(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(Id3Client.class);

        raw = new RawApi(clientFactory);
        frameId = new FrameIdApi(clientFactory);
        plainText = new PlainTextApi(clientFactory);
    }

    /**
    * List all ID3 Tags of Progressive TS Muxing
    * 
    * @param encodingId ID of the Encoding. (required)
    * @param muxingId ID of the Progressive TS Muxing (required)
    * @return List&lt;Id3Tag&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Id3Tag> list(String encodingId, String muxingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, muxingId, new HashMap<String, Object>());
    }

    /**
    * List all ID3 Tags of Progressive TS Muxing
    * 
    * @param encodingId ID of the Encoding. (required)
    * @param muxingId ID of the Progressive TS Muxing (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;Id3Tag&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Id3Tag> list(String encodingId, String muxingId, Id3TagsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, muxingId, queryParams);
    }
}
