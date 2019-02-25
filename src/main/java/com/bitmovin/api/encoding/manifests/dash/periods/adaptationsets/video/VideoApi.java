package com.bitmovin.api.encoding.manifests.dash.periods.adaptationsets.video;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VideoApi
{
    private final VideoClient apiClient;

    public VideoApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public VideoApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public VideoApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(VideoClient.class);

    }


    /**
    * Add Video AdaptationSet
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param videoAdaptationSet The video adaptation set to be added to the period (optional)
    * @return VideoAdaptationSet
    * @throws BitmovinException if fails to make API call
    */
    public VideoAdaptationSet create(String manifestId, String periodId, VideoAdaptationSet videoAdaptationSet) throws BitmovinException
    {
        return this.apiClient.create(manifestId, periodId, videoAdaptationSet);
    }

    /**
    * Delete Video AdaptationSet
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the video adaptation set to be deleted (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String manifestId, String periodId, String adaptationsetId) throws BitmovinException
    {
        return this.apiClient.delete(manifestId, periodId, adaptationsetId);
    }

    /**
    * Video AdaptationSet Details
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param adaptationsetId Id of the video adaptation set (required)
    * @return VideoAdaptationSet
    * @throws BitmovinException if fails to make API call
    */
    public VideoAdaptationSet get(String manifestId, String periodId, String adaptationsetId) throws BitmovinException
    {
        return this.apiClient.get(manifestId, periodId, adaptationsetId);
    }
    /**
    * List all Video AdaptationSets
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @return List&lt;VideoAdaptationSet&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<VideoAdaptationSet> list(String manifestId, String periodId) throws BitmovinException
    {
        return this.apiClient.list(manifestId, periodId, new HashMap<String, Object>());
    }

    /**
    * List all Video AdaptationSets
    * 
    * @param manifestId Id of the manifest (required)
    * @param periodId Id of the period (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;VideoAdaptationSet&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<VideoAdaptationSet> list(String manifestId, String periodId, VideoAdaptationSetsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(manifestId, periodId, queryParams);
    }
}
