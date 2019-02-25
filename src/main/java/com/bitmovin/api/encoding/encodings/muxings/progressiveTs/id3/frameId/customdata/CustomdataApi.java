package com.bitmovin.api.encoding.encodings.muxings.progressiveTs.id3.frameId.customdata;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomdataApi
{
    private final CustomdataClient apiClient;

    public CustomdataApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public CustomdataApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public CustomdataApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(CustomdataClient.class);

    }


    /**
    * Frame ID ID3 Tag Custom Data of Progressive TS Muxing
    * 
    * @param encodingId ID of the Encoding. (required)
    * @param muxingId ID of the Progressive TS Muxing (required)
    * @param id3TagId ID of the Frame ID ID3 Tag (required)
    * @return CustomData
    * @throws BitmovinException if fails to make API call
    */
    public CustomData getCustomData(String encodingId, String muxingId, String id3TagId) throws BitmovinException
    {
        return this.apiClient.getCustomData(encodingId, muxingId, id3TagId);
    }
}
