package com.bitmovin.api.encoding.encodings.inputStreams.trimming;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.inputStreams.trimming.timeBased.TimeBasedApi;
import com.bitmovin.api.encoding.encodings.inputStreams.trimming.timecodeTrack.TimecodeTrackApi;
import com.bitmovin.api.encoding.encodings.inputStreams.trimming.h264PictureTiming.H264PictureTimingApi;


public class TrimmingApi
{
    public TimeBasedApi timeBased;
    public TimecodeTrackApi timecodeTrack;
    public H264PictureTimingApi h264PictureTiming;

    public TrimmingApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public TrimmingApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public TrimmingApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        timeBased = new TimeBasedApi(clientFactory);
        timecodeTrack = new TimecodeTrackApi(clientFactory);
        h264PictureTiming = new H264PictureTimingApi(clientFactory);
    }

}
