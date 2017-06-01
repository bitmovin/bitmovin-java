package com.bitmovin.api.resource;

import com.bitmovin.api.RestClient;
import com.bitmovin.api.encoding.codecConfigurations.CodecConfig;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.rest.ResponseEnvelope;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * Created by rkersche on 9/2/16.
 */
public class ConfigurationResource<T extends CodecConfig> extends AbstractResource<T>
{

    public ConfigurationResource(Map<String, String> headers, String url, Class<T> type)
    {
        super(headers, url, type);
    }

    @Override
    public T get(String id) throws BitmovinApiException, UnirestException, URISyntaxException, IOException
    {
        ResponseEnvelope responseEnvelope = RestClient.getRaw(String.format("%s/%s", this.url, id), this.headers, ResponseEnvelope.class);
        JSONObject responseObject = RestClient.convertToJsonObject(responseEnvelope);
        return RestClient.convertFromJsonObjectToPojo(responseObject.getJSONObject("data").getJSONObject("result"), this.type);
    }
}
