package com.bitmovin.api.encoding.encodings.inputStreams.trimming.h264PictureTiming;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class H264PictureTimingApi
{
    private final H264PictureTimingClient apiClient;

    public H264PictureTimingApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public H264PictureTimingApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public H264PictureTimingApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(H264PictureTimingClient.class);

    }


    /**
    * Add H264 Picture Timing Trimming Input Stream
    * 
    * @param encodingId Id of the encoding. (required)
    * @param h264PictureTimingTrimmingInputStream  (optional)
    * @return H264PictureTimingTrimmingInputStream
    * @throws BitmovinException if fails to make API call
    */
    public H264PictureTimingTrimmingInputStream create(String encodingId, H264PictureTimingTrimmingInputStream h264PictureTimingTrimmingInputStream) throws BitmovinException
    {
        return this.apiClient.create(encodingId, h264PictureTimingTrimmingInputStream);
    }

    /**
    * Delete H264 Picture Timing Trimming Input Stream
    * 
    * @param encodingId Id of the encoding. (required)
    * @param inputStreamId Id of the H264 Picture Timing Trimming Input Stream. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String encodingId, String inputStreamId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, inputStreamId);
    }

    /**
    * H264 Picture Timing Trimming Input Stream Details
    * 
    * @param encodingId Id of the encoding. (required)
    * @param inputStreamId Id of the H264 Picture Timing Trimming Input Stream. (required)
    * @return H264PictureTimingTrimmingInputStream
    * @throws BitmovinException if fails to make API call
    */
    public H264PictureTimingTrimmingInputStream get(String encodingId, String inputStreamId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, inputStreamId);
    }
    /**
    * List H264 Picture Timing Trimming Input Streams
    * 
    * @param encodingId Id of the encoding. (required)
    * @return List&lt;H264PictureTimingTrimmingInputStream&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<H264PictureTimingTrimmingInputStream> list(String encodingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, new HashMap<String, Object>());
    }

    /**
    * List H264 Picture Timing Trimming Input Streams
    * 
    * @param encodingId Id of the encoding. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;H264PictureTimingTrimmingInputStream&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<H264PictureTimingTrimmingInputStream> list(String encodingId, H264PictureTimingTrimmingInputStreamsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, queryParams);
    }
}
