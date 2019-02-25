package com.bitmovin.api.encoding.encodings.muxings.progressiveTs;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.muxings.progressiveTs.customdata.CustomdataApi;
import com.bitmovin.api.encoding.encodings.muxings.progressiveTs.information.InformationApi;
import com.bitmovin.api.encoding.encodings.muxings.progressiveTs.id3.Id3Api;
import com.bitmovin.api.encoding.encodings.muxings.progressiveTs.drm.DrmApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProgressiveTsApi
{
    private final ProgressiveTsClient apiClient;
    public CustomdataApi customdata;
    public InformationApi information;
    public Id3Api id3;
    public DrmApi drm;

    public ProgressiveTsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public ProgressiveTsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public ProgressiveTsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(ProgressiveTsClient.class);

        customdata = new CustomdataApi(clientFactory);
        information = new InformationApi(clientFactory);
        id3 = new Id3Api(clientFactory);
        drm = new DrmApi(clientFactory);
    }


    /**
    * Add Progressive TS Muxing
    * 
    * @param encodingId ID of the encoding. (required)
    * @param progressiveTsMuxing  (optional)
    * @return ProgressiveTsMuxing
    * @throws BitmovinException if fails to make API call
    */
    public ProgressiveTsMuxing create(String encodingId, ProgressiveTsMuxing progressiveTsMuxing) throws BitmovinException
    {
        return this.apiClient.create(encodingId, progressiveTsMuxing);
    }

    /**
    * Delete Progressive TS Muxing
    * 
    * @param encodingId ID of the Encoding. (required)
    * @param muxingId ID of the Progressive TS muxing (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String encodingId, String muxingId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, muxingId);
    }

    /**
    * Progressive TS Muxing Details
    * 
    * @param encodingId ID of the Encoding. (required)
    * @param muxingId ID of the Progressive TS Muxing (required)
    * @return ProgressiveTsMuxing
    * @throws BitmovinException if fails to make API call
    */
    public ProgressiveTsMuxing get(String encodingId, String muxingId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, muxingId);
    }
    /**
    * List Progressive TS Muxings
    * 
    * @param encodingId ID of the Encoding. (required)
    * @return List&lt;ProgressiveTsMuxing&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<ProgressiveTsMuxing> list(String encodingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, new HashMap<String, Object>());
    }

    /**
    * List Progressive TS Muxings
    * 
    * @param encodingId ID of the Encoding. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;ProgressiveTsMuxing&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<ProgressiveTsMuxing> list(String encodingId, ProgressiveTsMuxingsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, queryParams);
    }
}
