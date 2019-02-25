package com.bitmovin.api.encoding.configurations.audio;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.configurations.audio.aac.AacApi;
import com.bitmovin.api.encoding.configurations.audio.heAacV1.HeAacV1Api;
import com.bitmovin.api.encoding.configurations.audio.heAacV2.HeAacV2Api;
import com.bitmovin.api.encoding.configurations.audio.vorbis.VorbisApi;
import com.bitmovin.api.encoding.configurations.audio.opus.OpusApi;
import com.bitmovin.api.encoding.configurations.audio.ac3.Ac3Api;
import com.bitmovin.api.encoding.configurations.audio.eac3.Eac3Api;
import com.bitmovin.api.encoding.configurations.audio.mp2.Mp2Api;
import com.bitmovin.api.encoding.configurations.audio.mp3.Mp3Api;


public class AudioApi
{
    public AacApi aac;
    public HeAacV1Api heAacV1;
    public HeAacV2Api heAacV2;
    public VorbisApi vorbis;
    public OpusApi opus;
    public Ac3Api ac3;
    public Eac3Api eac3;
    public Mp2Api mp2;
    public Mp3Api mp3;

    public AudioApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public AudioApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public AudioApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        aac = new AacApi(clientFactory);
        heAacV1 = new HeAacV1Api(clientFactory);
        heAacV2 = new HeAacV2Api(clientFactory);
        vorbis = new VorbisApi(clientFactory);
        opus = new OpusApi(clientFactory);
        ac3 = new Ac3Api(clientFactory);
        eac3 = new Eac3Api(clientFactory);
        mp2 = new Mp2Api(clientFactory);
        mp3 = new Mp3Api(clientFactory);
    }

}
