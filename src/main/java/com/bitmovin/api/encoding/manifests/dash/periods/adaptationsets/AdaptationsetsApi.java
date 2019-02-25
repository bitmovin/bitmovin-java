package com.bitmovin.api.encoding.manifests.dash.periods.adaptationsets;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.manifests.dash.periods.adaptationsets.audio.AudioApi;
import com.bitmovin.api.encoding.manifests.dash.periods.adaptationsets.video.VideoApi;
import com.bitmovin.api.encoding.manifests.dash.periods.adaptationsets.subtitle.SubtitleApi;
import com.bitmovin.api.encoding.manifests.dash.periods.adaptationsets.custom.CustomApi;
import com.bitmovin.api.encoding.manifests.dash.periods.adaptationsets.representations.RepresentationsApi;
import com.bitmovin.api.encoding.manifests.dash.periods.adaptationsets.contentprotection.ContentprotectionApi;


public class AdaptationsetsApi
{
    public AudioApi audio;
    public VideoApi video;
    public SubtitleApi subtitle;
    public CustomApi custom;
    public RepresentationsApi representations;
    public ContentprotectionApi contentprotection;

    public AdaptationsetsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public AdaptationsetsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public AdaptationsetsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        audio = new AudioApi(clientFactory);
        video = new VideoApi(clientFactory);
        subtitle = new SubtitleApi(clientFactory);
        custom = new CustomApi(clientFactory);
        representations = new RepresentationsApi(clientFactory);
        contentprotection = new ContentprotectionApi(clientFactory);
    }

}
