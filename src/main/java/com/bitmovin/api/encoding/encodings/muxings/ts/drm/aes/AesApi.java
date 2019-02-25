package com.bitmovin.api.encoding.encodings.muxings.ts.drm.aes;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.muxings.ts.drm.aes.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AesApi
{
    private final AesClient apiClient;
    public CustomdataApi customdata;

    public AesApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public AesApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public AesApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(AesClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Add AES Encryption to TS Segment
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the TS muxing. (required)
    * @param aesEncryptionDrm TODO Add Description (optional)
    * @return AesEncryptionDrm
    * @throws BitmovinException if fails to make API call
    */
    public AesEncryptionDrm create(String encodingId, String muxingId, AesEncryptionDrm aesEncryptionDrm) throws BitmovinException
    {
        return this.apiClient.create(encodingId, muxingId, aesEncryptionDrm);
    }

    /**
    * Delete AES Encryption from TS Segment
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the transport stream segment. (required)
    * @param drmId Id of the PlayReady DRM configuration. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String encodingId, String muxingId, String drmId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, muxingId, drmId);
    }

    /**
    * AES Encryption Details of TS Segment
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the transport stream segment. (required)
    * @param drmId Id of the AESEncryption configuration. (required)
    * @return AesEncryptionDrm
    * @throws BitmovinException if fails to make API call
    */
    public AesEncryptionDrm get(String encodingId, String muxingId, String drmId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, muxingId, drmId);
    }
    /**
    * List AES Encryption of TS Segment
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the transport stream segment. (required)
    * @return List&lt;AesEncryptionDrm&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<AesEncryptionDrm> list(String encodingId, String muxingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, muxingId, new HashMap<String, Object>());
    }

    /**
    * List AES Encryption of TS Segment
    * 
    * @param encodingId Id of the encoding. (required)
    * @param muxingId Id of the transport stream segment. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;AesEncryptionDrm&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<AesEncryptionDrm> list(String encodingId, String muxingId, AesEncryptionDrmsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, muxingId, queryParams);
    }
}
