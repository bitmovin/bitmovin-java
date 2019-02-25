package com.bitmovin.api.encoding.encodings.subtitles.dvbsub;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.subtitles.dvbsub.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DvbsubApi
{
    private final DvbsubClient apiClient;
    public CustomdataApi customdata;

    public DvbsubApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public DvbsubApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public DvbsubApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(DvbsubClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Extract DVB-SUB Subtitle
    * 
    * @param encodingId Id of the encoding. (required)
    * @param dvbSubtitleSidecarDetails  (optional)
    * @return DvbSubtitleSidecarDetails
    * @throws BitmovinException if fails to make API call
    */
    public DvbSubtitleSidecarDetails create(String encodingId, DvbSubtitleSidecarDetails dvbSubtitleSidecarDetails) throws BitmovinException
    {
        return this.apiClient.create(encodingId, dvbSubtitleSidecarDetails);
    }

    /**
    * Delete DVB-SUB Subtitle
    * 
    * @param encodingId Id of the encoding. (required)
    * @param subtitleId Id of the subtitle. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String encodingId, String subtitleId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, subtitleId);
    }

    /**
    * Subtitle DVB-SUB Details
    * 
    * @param encodingId Id of the encoding. (required)
    * @param subtitleId Id of the subtitle. (required)
    * @return DvbSubtitleSidecarDetails
    * @throws BitmovinException if fails to make API call
    */
    public DvbSubtitleSidecarDetails get(String encodingId, String subtitleId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, subtitleId);
    }
    /**
    * List DVB-SUB Subtitle
    * 
    * @param encodingId Id of the encoding. (required)
    * @return List&lt;DvbSubtitleSidecarDetails&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<DvbSubtitleSidecarDetails> list(String encodingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, new HashMap<String, Object>());
    }

    /**
    * List DVB-SUB Subtitle
    * 
    * @param encodingId Id of the encoding. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;DvbSubtitleSidecarDetails&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<DvbSubtitleSidecarDetails> list(String encodingId, DvbSubtitleSidecarDetailssListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, queryParams);
    }
}
