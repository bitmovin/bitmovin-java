package com.bitmovin.api.encoding.encodings.streams.input;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputApi
{
    private final InputClient apiClient;

    public InputApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public InputApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public InputApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(InputClient.class);

    }


    /**
    * Stream Input Details
    * 
    * @param encodingId Id of the encoding. (required)
    * @param streamId Id of the stream. (required)
    * @return EncodingStreamInputDetails
    * @throws BitmovinException if fails to make API call
    */
    public EncodingStreamInputDetails get(String encodingId, String streamId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, streamId);
    }
}
