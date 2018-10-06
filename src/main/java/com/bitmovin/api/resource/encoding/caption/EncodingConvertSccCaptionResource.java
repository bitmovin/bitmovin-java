package com.bitmovin.api.resource.encoding.caption;

import com.bitmovin.api.RestClient;
import com.bitmovin.api.constants.ApiUrls;
import com.bitmovin.api.customData.CustomData;
import com.bitmovin.api.encoding.captions.ConvertSccCaption;
import com.bitmovin.api.encoding.captions.SccCaption;
import com.bitmovin.api.encoding.encodings.Encoding;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.resource.AbstractResource;
import com.bitmovin.api.http.RestException;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class EncodingConvertSccCaptionResource extends AbstractResource
{
    private Map<String, String> headers;

    public EncodingConvertSccCaptionResource(Map<String, String> headers)
    {
        super(headers, ApiUrls.convertSccCaptions, SccCaption.class);
        this.headers = headers;
    }

    public ConvertSccCaption get(Encoding encoding, String convertSccCaptionId)
            throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        return this.get(encoding.getId(), convertSccCaptionId);
    }

    public ConvertSccCaption get(String encodingId, String convertSccCaptionId)
            throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.convertSccCaptions
                .replace("{encoding_id}", encodingId) + "/" + convertSccCaptionId;

        return RestClient.get(newUrl, this.headers, ConvertSccCaption.class);
    }

    public CustomData getCustomData(Encoding encoding, String convertSccCaptionId)
            throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        return this.getCustomData(encoding.getId(), convertSccCaptionId);
    }

    public CustomData getCustomData(String encodingId, String convertSccCaptionId)
            throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.convertSccCaptionsCustomData
                .replace("{encoding_id}", encodingId).replace("{caption_id}", convertSccCaptionId);

        return RestClient.get(newUrl, this.headers, CustomData.class);
    }

    public ConvertSccCaption create(Encoding encoding, ConvertSccCaption convertSccCaption)
            throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        return this.create(encoding.getId(), convertSccCaption);
    }

    public ConvertSccCaption create(String encodingId, ConvertSccCaption convertSccCaption)
            throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.convertSccCaptions.replace("{encoding_id}", encodingId);
        return RestClient.post(this.headers, newUrl, convertSccCaption, ConvertSccCaption.class);
    }

    public void delete(Encoding encoding, ConvertSccCaption convertSccCaption)
            throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        this.delete(encoding.getId(), convertSccCaption.getId());
    }

    public void delete(String encodingId, String convertSccCaption)
            throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.convertSccCaptions
                .replace("{encoding_id}", encodingId) + "/" + convertSccCaption;

        RestClient.delete(newUrl, this.headers);
    }
}
