package com.bitmovin.api.player.licenses.thirdPartyLicensing;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThirdPartyLicensingApi
{
    private final ThirdPartyLicensingClient apiClient;

    public ThirdPartyLicensingApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public ThirdPartyLicensingApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public ThirdPartyLicensingApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(ThirdPartyLicensingClient.class);

    }


    /**
    * Enable Third Party Licensing
    * 
    * @param licenseId Id of the Player License (required)
    * @param playerThirdPartyLicensing Third Party Licensing settings to apply to Player License (optional)
    * @return PlayerThirdPartyLicensing
    * @throws BitmovinException if fails to make API call
    */
    public PlayerThirdPartyLicensing create(String licenseId, PlayerThirdPartyLicensing playerThirdPartyLicensing) throws BitmovinException
    {
        return this.apiClient.create(licenseId, playerThirdPartyLicensing);
    }

    /**
    * Delete Third Party Licensing Configuration
    * 
    * @param licenseId Id of the Player License (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String licenseId) throws BitmovinException
    {
        return this.apiClient.delete(licenseId);
    }

    /**
    * Get Third Party Licensing Configuration
    * 
    * @param licenseId Id of the Player License (required)
    * @return PlayerThirdPartyLicensing
    * @throws BitmovinException if fails to make API call
    */
    public PlayerThirdPartyLicensing get(String licenseId) throws BitmovinException
    {
        return this.apiClient.get(licenseId);
    }
}
