package com.bitmovin.api.analytics.licenses;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.analytics.licenses.domains.DomainsApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LicensesApi
{
    private final LicensesClient apiClient;
    public DomainsApi domains;

    public LicensesApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public LicensesApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public LicensesApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(LicensesClient.class);

        domains = new DomainsApi(clientFactory);
    }


    /**
    * Get License
    * 
    * @param licenseId License id (required)
    * @return AnalyticsLicense
    * @throws BitmovinException if fails to make API call
    */
    public AnalyticsLicense get(String licenseId) throws BitmovinException
    {
        return this.apiClient.get(licenseId);
    }

    /**
    * List Analytics Licenses
    * 
    * @return List&lt;AnalyticsLicense&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<AnalyticsLicense> list() throws BitmovinException
    {
        return this.apiClient.list();
    }
}
