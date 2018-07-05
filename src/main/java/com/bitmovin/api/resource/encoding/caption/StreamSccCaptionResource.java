package com.bitmovin.api.resource.encoding.caption;

import com.bitmovin.api.RestClient;
import com.bitmovin.api.constants.ApiUrls;
import com.bitmovin.api.encoding.captions.SccCaption;
import com.bitmovin.api.encoding.encodings.Encoding;
import com.bitmovin.api.encoding.encodings.streams.Stream;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.resource.AbstractResource;
import com.bitmovin.api.http.RestException;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class StreamSccCaptionResource extends AbstractResource
{
    private Map<String, String> headers;

    public StreamSccCaptionResource(Map<String, String> headers)
    {
        super(headers, ApiUrls.sccCaptions, SccCaption.class);
        this.headers = headers;
    }

    public SccCaption get(Encoding encoding, Stream stream, String sccCaptionId)
            throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        return this.get(encoding.getId(), stream.getId(), sccCaptionId);
    }

    public SccCaption get(String encodingId, String streamId, String sccCaptionId)
            throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.sccCaptions
                .replace("{encoding_id}", encodingId)
                .replace("{stream_id}", streamId) + "/" + sccCaptionId;

        return RestClient.get(newUrl, this.headers, SccCaption.class);
    }

    public SccCaption create(Encoding encoding, Stream stream, SccCaption sccCaption)
            throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        return this.create(encoding.getId(), stream.getId(), sccCaption);
    }

    public SccCaption create(String encodingId, String streamId, SccCaption sccCaption)
            throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.sccCaptions.replace("{encoding_id}", encodingId).replace("{stream_id}", streamId);
        return RestClient.post(this.headers, newUrl, sccCaption, SccCaption.class);
    }

    public void delete(Encoding encoding, Stream stream, SccCaption sccCaption)
            throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        this.delete(encoding.getId(), stream.getId(), sccCaption.getId());
    }

    public void delete(String encodingId, String streamId, String sccCaptionId)
            throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.sccCaptions
                .replace("{encoding_id}", encodingId)
                .replace("{stream_id}", streamId) + "/" + sccCaptionId;

        RestClient.delete(newUrl, this.headers);
    }
}
