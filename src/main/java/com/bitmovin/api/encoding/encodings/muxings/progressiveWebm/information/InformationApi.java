package com.bitmovin.api.encoding.encodings.muxings.progressiveWebm.information;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InformationApi
{
    private final InformationClient apiClient;

    public InformationApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public InformationApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public InformationApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(InformationClient.class);

    }


    /**
    * Progressive WebM Muxing Information
    * 
    * @param encodingId ID of the Encoding. (required)
    * @param muxingId ID of the Progressive WebM muxing (required)
    * @return ProgressiveWebmMuxingInformation
    * @throws BitmovinException if fails to make API call
    */
    public ProgressiveWebmMuxingInformation get(String encodingId, String muxingId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, muxingId);
    }
}
