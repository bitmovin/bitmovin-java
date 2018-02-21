package com.bitmovin.api.container;

import com.bitmovin.api.RestClient;
import com.bitmovin.api.constants.ApiUrls;
import com.bitmovin.api.encoding.codecConfigurations.AACAudioConfig;
import com.bitmovin.api.encoding.codecConfigurations.CodecConfig;
import com.bitmovin.api.encoding.codecConfigurations.H264VideoConfiguration;
import com.bitmovin.api.encoding.codecConfigurations.H265VideoConfiguration;
import com.bitmovin.api.encoding.codecConfigurations.MJPEGCodecConfiguration;
import com.bitmovin.api.encoding.codecConfigurations.VP9VideoConfiguration;
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
    public ConfigurationResource<H264VideoConfiguration> videoH264;
    public ConfigurationResource<H265VideoConfiguration> videoH265;
    public ConfigurationResource<VP9VideoConfiguration> videoVP9;
    public ConfigurationResource<MJPEGCodecConfiguration> mjpeg;
    public ConfigurationResource<CodecConfig> all;
    private Map<String, String> headers;

    public ConfigurationContainer(Map<String, String> headers)
    {
        this.headers = headers;
        this.audioAAC = new ConfigurationResource<>(headers, ApiUrls.codecConfigAAc, AACAudioConfig.class);
        this.videoH264 = new ConfigurationResource<>(headers, ApiUrls.codecConfigH264, H264VideoConfiguration.class);
        this.videoH265 = new ConfigurationResource<>(headers, ApiUrls.codecConfigH265, H265VideoConfiguration.class);
        this.videoVP9 = new ConfigurationResource<>(headers, ApiUrls.codecConfigVP9, VP9VideoConfiguration.class);
        this.mjpeg = new ConfigurationResource<>(headers, ApiUrls.codecConfigMjpeg, MJPEGCodecConfiguration.class);
        this.all = new ConfigurationResource<>(headers, ApiUrls.codecConfig, CodecConfig.class);
    }

    public ConfigType getType(String codecConfigurationId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        ResponseEnvelope responseEnvelope = RestClient.getRaw(ApiUrls.codecConfig + "/" + codecConfigurationId + "/type", this.headers, ResponseEnvelope.class);
        JSONObject responseObject = RestClient.convertToJsonObject(responseEnvelope);
        return ConfigType.valueOf(responseObject.getJSONObject("data").getJSONObject("result").getString("type"));
    }

}
