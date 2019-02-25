package com.bitmovin.api.encoding.encodings.live;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LiveApi
{
    private final LiveClient apiClient;

    public LiveApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public LiveApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public LiveApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(LiveClient.class);

    }


    /**
    * Live Encoding Details
    * 
    * @param encodingId Id of the encoding. (required)
    * @return LiveEncoding
    * @throws BitmovinException if fails to make API call
    */
    public LiveEncoding get(String encodingId) throws BitmovinException
    {
        return this.apiClient.get(encodingId);
    }

    /**
    * Live Encoding Start Details
    * 
    * @param encodingId Id of the encoding (required)
    * @return StartLiveEncodingRequest
    * @throws BitmovinException if fails to make API call
    */
    public StartLiveEncodingRequest getStartRequest(String encodingId) throws BitmovinException
    {
        return this.apiClient.getStartRequest(encodingId);
    }

    /**
    * Re-Start Live Encoding
    * 
    * @param encodingId Id of the encoding (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse restart(String encodingId) throws BitmovinException
    {
        return this.apiClient.restart(encodingId);
    }

    /**
    * Start Live Encoding
    * 
    * @param encodingId Id of the encoding (required)
    * @param startLiveEncodingRequest  (optional)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse start(String encodingId, StartLiveEncodingRequest startLiveEncodingRequest) throws BitmovinException
    {
        return this.apiClient.start(encodingId, startLiveEncodingRequest);
    }

    /**
    * Stop Live Encoding
    * 
    * @param encodingId Id of the encoding (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse stop(String encodingId) throws BitmovinException
    {
        return this.apiClient.stop(encodingId);
    }
}
