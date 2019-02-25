package com.bitmovin.api.player.licenses;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.player.licenses.domains.DomainsApi;
import com.bitmovin.api.player.licenses.thirdPartyLicensing.ThirdPartyLicensingApi;

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
    public ThirdPartyLicensingApi thirdPartyLicensing;

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
        thirdPartyLicensing = new ThirdPartyLicensingApi(clientFactory);
    }


    /**
    * Get License
    * 
    * @param licenseId ID of the License (required)
    * @return PlayerLicense
    * @throws BitmovinException if fails to make API call
    */
    public PlayerLicense get(String licenseId) throws BitmovinException
    {
        return this.apiClient.get(licenseId);
    }
    /**
    * List Player Licenses
    * 
    * @return List&lt;PlayerLicense&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<PlayerLicense> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List Player Licenses
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;PlayerLicense&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<PlayerLicense> list(PlayerLicensesListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
