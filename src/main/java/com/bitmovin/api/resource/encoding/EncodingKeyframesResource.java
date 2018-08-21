package com.bitmovin.api.resource.encoding;

import com.bitmovin.api.RestClient;
import com.bitmovin.api.constants.ApiUrls;
import com.bitmovin.api.encoding.encodings.Keyframe;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class EncodingKeyframesResource
{
    private Map<String, String> headers;

    public EncodingKeyframesResource(Map<String, String> headers)
    {
        this.headers = headers;
    }

    public Keyframe addKeyframeToEncoding(String encodingId, Keyframe keyframe) throws BitmovinApiException, UnirestException, IOException, URISyntaxException
    {
        String newUrl = ApiUrls.keyframes.replace("{encoding_id}", encodingId);
        return RestClient.postDetail(newUrl, this.headers, keyframe, Keyframe.class);
    }
}
