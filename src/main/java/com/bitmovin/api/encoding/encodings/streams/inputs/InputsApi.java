package com.bitmovin.api.encoding.encodings.streams.inputs;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputsApi
{
    private final InputsClient apiClient;

    public InputsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public InputsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public InputsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(InputsClient.class);

    }


    /**
    * Stream Input Analysis Details
    * 
    * @param encodingId Id of the encoding. (required)
    * @param streamId Id of the stream. (required)
    * @return List&lt;StreamDetails&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<StreamDetails> list(String encodingId, String streamId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, streamId);
    }
}
