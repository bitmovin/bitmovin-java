package com.bitmovin.api.encoding.manifests.dash.periods.customXmlElements;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomXmlElementsApi
{
    private final CustomXmlElementsClient apiClient;

    public CustomXmlElementsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public CustomXmlElementsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public CustomXmlElementsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(CustomXmlElementsClient.class);

    }


    /**
    * Add Custom XML Element to Period
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param customXmlElement Data of the custom XML element to be added to the period (optional)
    * @return CustomXmlElement
    * @throws BitmovinException if fails to make API call
    */
    public CustomXmlElement create(String manifestId, String periodId, CustomXmlElement customXmlElement) throws BitmovinException
    {
        return this.apiClient.create(manifestId, periodId, customXmlElement);
    }

    /**
    * Delete Custom XML Element
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param customXmlElementId Id of the Custom XML Element (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String manifestId, String periodId, String customXmlElementId) throws BitmovinException
    {
        return this.apiClient.delete(manifestId, periodId, customXmlElementId);
    }

    /**
    * Custom XML Element Details
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param customXmlElementId Id of the Custom XML Element (required)
    * @return CustomXmlElement
    * @throws BitmovinException if fails to make API call
    */
    public CustomXmlElement get(String manifestId, String periodId, String customXmlElementId) throws BitmovinException
    {
        return this.apiClient.get(manifestId, periodId, customXmlElementId);
    }
    /**
    * List all Custom XML Elements of Period
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @return List&lt;CustomXmlElement&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<CustomXmlElement> list(String manifestId, String periodId) throws BitmovinException
    {
        return this.apiClient.list(manifestId, periodId, new HashMap<String, Object>());
    }

    /**
    * List all Custom XML Elements of Period
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;CustomXmlElement&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<CustomXmlElement> list(String manifestId, String periodId, CustomXmlElementsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(manifestId, periodId, queryParams);
    }
}
