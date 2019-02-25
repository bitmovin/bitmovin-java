package com.bitmovin.api.encoding.manifests.hls.media;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.manifests.hls.media.customTag.CustomTagApi;
import com.bitmovin.api.encoding.manifests.hls.media.type.TypeApi;
import com.bitmovin.api.encoding.manifests.hls.media.video.VideoApi;
import com.bitmovin.api.encoding.manifests.hls.media.audio.AudioApi;
import com.bitmovin.api.encoding.manifests.hls.media.subtitles.SubtitlesApi;
import com.bitmovin.api.encoding.manifests.hls.media.vtt.VttApi;
import com.bitmovin.api.encoding.manifests.hls.media.closedCaptions.ClosedCaptionsApi;


public class MediaApi
{
    public CustomTagApi customTag;
    public TypeApi type;
    public VideoApi video;
    public AudioApi audio;
    public SubtitlesApi subtitles;
    public VttApi vtt;
    public ClosedCaptionsApi closedCaptions;

    public MediaApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public MediaApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public MediaApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        customTag = new CustomTagApi(clientFactory);
        type = new TypeApi(clientFactory);
        video = new VideoApi(clientFactory);
        audio = new AudioApi(clientFactory);
        subtitles = new SubtitlesApi(clientFactory);
        vtt = new VttApi(clientFactory);
        closedCaptions = new ClosedCaptionsApi(clientFactory);
    }

}
