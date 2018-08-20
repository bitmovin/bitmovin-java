package com.bitmovin.api.container;

import com.bitmovin.api.RestClient;
import com.bitmovin.api.constants.ApiUrls;
import com.bitmovin.api.encoding.codecConfigurations.AACAudioConfig;
import com.bitmovin.api.encoding.codecConfigurations.AC3AudioConfig;
import com.bitmovin.api.encoding.codecConfigurations.CodecConfig;
import com.bitmovin.api.encoding.codecConfigurations.EAC3AudioConfig;
import com.bitmovin.api.encoding.codecConfigurations.H264VideoConfiguration;
import com.bitmovin.api.encoding.codecConfigurations.H265VideoConfiguration;
import com.bitmovin.api.encoding.codecConfigurations.AV1VideoConfiguration;
import com.bitmovin.api.encoding.codecConfigurations.HeAACv1AudioConfig;
import com.bitmovin.api.encoding.codecConfigurations.HeAACv2AudioConfig;
import com.bitmovin.api.encoding.codecConfigurations.MJPEGCodecConfiguration;
import com.bitmovin.api.encoding.codecConfigurations.MP2AudioConfig;
import com.bitmovin.api.encoding.codecConfigurations.MP3AudioConfig;
import com.bitmovin.api.encoding.codecConfigurations.OpusAudioConfig;
import com.bitmovin.api.encoding.codecConfigurations.VP8VideoConfiguration;
import com.bitmovin.api.encoding.codecConfigurations.VP9VideoConfiguration;
import com.bitmovin.api.encoding.codecConfigurations.VorbisAudioConfig;
import com.bitmovin.api.encoding.codecConfigurations.enums.ConfigType;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.resource.ConfigurationResource;
import com.bitmovin.api.rest.ResponseEnvelope;
import com.bitmovin.api.http.RestException;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * Created by rkersche on 9/2/16.
 */
public class ConfigurationContainer
{

    public ConfigurationResource<AACAudioConfig> audioAAC;
    public ConfigurationResource<HeAACv1AudioConfig> heAACv1;
    public ConfigurationResource<HeAACv2AudioConfig> heAACv2;
    public ConfigurationResource<H264VideoConfiguration> videoH264;
    public ConfigurationResource<H265VideoConfiguration> videoH265;
    public ConfigurationResource<AV1VideoConfiguration> videoAV1;
    public ConfigurationResource<VP9VideoConfiguration> videoVP9;
    public ConfigurationResource<VP8VideoConfiguration> videoVP8;
    public ConfigurationResource<MJPEGCodecConfiguration> mjpeg;
    public ConfigurationResource<AC3AudioConfig> audioAC3;
    public ConfigurationResource<EAC3AudioConfig> audioEAC3;
    public ConfigurationResource<MP2AudioConfig> audioMP2;
    public ConfigurationResource<MP3AudioConfig> audioMP3;
    public ConfigurationResource<OpusAudioConfig> audioOpus;
    public ConfigurationResource<VorbisAudioConfig> audioVorbis;
    public ConfigurationResource<CodecConfig> all;
    private Map<String, String> headers;

    public ConfigurationContainer(Map<String, String> headers)
    {
        this.headers = headers;
        this.videoH264 = new ConfigurationResource<>(headers, ApiUrls.codecConfigH264, H264VideoConfiguration.class);
        this.videoH265 = new ConfigurationResource<>(headers, ApiUrls.codecConfigH265, H265VideoConfiguration.class);
        this.videoAV1 = new ConfigurationResource<>(headers,ApiUrls.codecConfigAV1, AV1VideoConfiguration.class);
        this.videoVP9 = new ConfigurationResource<>(headers, ApiUrls.codecConfigVP9, VP9VideoConfiguration.class);
        this.videoVP8 = new ConfigurationResource<>(headers, ApiUrls.codecConfigVP8, VP8VideoConfiguration.class);
        this.mjpeg = new ConfigurationResource<>(headers, ApiUrls.codecConfigMjpeg, MJPEGCodecConfiguration.class);
        this.audioAAC = new ConfigurationResource<>(headers, ApiUrls.codecConfigAAc, AACAudioConfig.class);
        this.heAACv1 = new ConfigurationResource<>(headers, ApiUrls.codecConfigHeAACv1, HeAACv1AudioConfig.class);
        this.heAACv2 = new ConfigurationResource<>(headers, ApiUrls.codecConfigHeAACv2, HeAACv2AudioConfig.class);
        this.audioAC3 = new ConfigurationResource<>(headers, ApiUrls.codecConfigAC3, AC3AudioConfig.class);
        this.audioEAC3 = new ConfigurationResource<>(headers, ApiUrls.codecConfigEAC3, EAC3AudioConfig.class);
        this.audioMP2 = new ConfigurationResource<>(headers, ApiUrls.codecConfigMP2, MP2AudioConfig.class);
        this.audioMP3 = new ConfigurationResource<>(headers, ApiUrls.codecConfigMP3, MP3AudioConfig.class);
        this.audioOpus = new ConfigurationResource<>(headers, ApiUrls.codecConfigOpus, OpusAudioConfig.class);
        this.audioVorbis = new ConfigurationResource<>(headers, ApiUrls.codecConfigVorbis, VorbisAudioConfig.class);
        this.all = new ConfigurationResource<>(headers, ApiUrls.codecConfig, CodecConfig.class);
    }

    public ConfigType getType(String codecConfigurationId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        ResponseEnvelope responseEnvelope = RestClient.getRaw(ApiUrls.codecConfig + "/" + codecConfigurationId + "/type", this.headers, ResponseEnvelope.class);
        JSONObject responseObject = RestClient.convertToJsonObject(responseEnvelope);
        return ConfigType.valueOf(responseObject.getJSONObject("data").getJSONObject("result").getString("type"));
    }

}
