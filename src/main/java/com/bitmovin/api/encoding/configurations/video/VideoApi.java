package com.bitmovin.api.encoding.configurations.video;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.configurations.video.h264.H264Api;
import com.bitmovin.api.encoding.configurations.video.h265.H265Api;
import com.bitmovin.api.encoding.configurations.video.vp8.Vp8Api;
import com.bitmovin.api.encoding.configurations.video.vp9.Vp9Api;
import com.bitmovin.api.encoding.configurations.video.av1.Av1Api;
import com.bitmovin.api.encoding.configurations.video.mjpeg.MjpegApi;


public class VideoApi
{
    public H264Api h264;
    public H265Api h265;
    public Vp8Api vp8;
    public Vp9Api vp9;
    public Av1Api av1;
    public MjpegApi mjpeg;

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

        h264 = new H264Api(clientFactory);
        h265 = new H265Api(clientFactory);
        vp8 = new Vp8Api(clientFactory);
        vp9 = new Vp9Api(clientFactory);
        av1 = new Av1Api(clientFactory);
        mjpeg = new MjpegApi(clientFactory);
    }

}
