package com.bitmovin.api.encoding.encodings.muxings.fmp4.drm.primetime;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.muxings.fmp4.drm.primetime.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimetimeApi
{
    private final PrimetimeClient apiClient;
    public CustomdataApi customdata;

    public PrimetimeApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public PrimetimeApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public PrimetimeApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(PrimetimeClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Add PrimeTime DRM to fMP4
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the fMP4 muxing. (required)
    * @param primeTimeDrm TODO Add Description (optional)
    * @return PrimeTimeDrm
    * @throws BitmovinException if fails to make API call
    */
    public PrimeTimeDrm create(String encodingId, String muxingId, PrimeTimeDrm primeTimeDrm) throws BitmovinException
    {
        return this.apiClient.create(encodingId, muxingId, primeTimeDrm);
    }

    /**
    * Delete PrimeTime DRM from fMP4
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the fmp4 fragment. (required)
    * @param drmId Id of the PrimeTime DRM configuration. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String encodingId, String muxingId, String drmId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, muxingId, drmId);
    }

    /**
    * PrimeTime DRM Details of fMP4
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the fmp4 fragment. (required)
    * @param drmId Id of the PrimeTime DRM configuration. (required)
    * @return PrimeTimeDrm
    * @throws BitmovinException if fails to make API call
    */
    public PrimeTimeDrm get(String encodingId, String muxingId, String drmId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, muxingId, drmId);
    }
    /**
    * List PrimeTime DRMs of fMP4
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the fmp4 fragment. (required)
    * @return List&lt;PrimeTimeDrm&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<PrimeTimeDrm> list(String encodingId, String muxingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, muxingId, new HashMap<String, Object>());
    }

    /**
    * List PrimeTime DRMs of fMP4
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the fmp4 fragment. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;PrimeTimeDrm&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<PrimeTimeDrm> list(String encodingId, String muxingId, PrimeTimeDrmsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, muxingId, queryParams);
    }
}
