package com.bitmovin.api.encoding.encodings.sidecars.customdata;

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
    * Sidecar Custom Data
    * 
    * @param encodingId Id of the encoding. (required)
    * @param sidecarId Id of the sidecar. (required)
    * @return CustomData
    * @throws BitmovinException if fails to make API call
    */
    public CustomData getCustomData(String encodingId, String sidecarId) throws BitmovinException
    {
        return this.apiClient.getCustomData(encodingId, sidecarId);
    }
}
