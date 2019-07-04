package com.bitmovin.api.resource.encoding;

import com.bitmovin.api.RestClient;
import com.bitmovin.api.constants.ApiUrls;
import com.bitmovin.api.customData.CustomData;
import com.bitmovin.api.encoding.encodings.Encoding;
import com.bitmovin.api.encoding.encodings.streams.Cea608CaptionInputStream;
import com.bitmovin.api.encoding.encodings.streams.TimecodeTrackTrimmingInputStream;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.http.RestException;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class EncodingCea608CaptionInputStreamResource
{
    private Map<String, String> headers;

    public EncodingCea608CaptionInputStreamResource(Map<String, String> headers)
    {
        this.headers = headers;
    }

    public Cea608CaptionInputStream getCea608CaptionInputStream(Encoding encoding, Cea608CaptionInputStream cea608CaptionInputStream) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.cea608CaptionInputStreamWithId.replace("{encoding_id}", encoding.getId()).replace("{input_stream_id}", cea608CaptionInputStream.getId());
        return RestClient.get(newUrl, this.headers, Cea608CaptionInputStream.class);
    }

    public List<Cea608CaptionInputStream> getCea608CaptionInputStreams(Encoding encoding) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.cea608CaptionInputStreams.replace("{encoding_id}", encoding.getId());
        return RestClient.getAllItemsIterative(newUrl, this.headers, Cea608CaptionInputStream.class);
    }

    public Cea608CaptionInputStream addCea608CaptionInputStreamToEncoding(Encoding encoding, Cea608CaptionInputStream cea608CaptionInputStream) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.cea608CaptionInputStreams.replace("{encoding_id}", encoding.getId());
        return RestClient.post(this.headers, newUrl, cea608CaptionInputStream, Cea608CaptionInputStream.class);
    }

    public void deleteCea608CaptionInputStreamToEncoding(Encoding encoding, Cea608CaptionInputStream cea608CaptionInputStream) throws BitmovinApiException, URISyntaxException, IOException, RestException, UnirestException
    {
        String newUrl = ApiUrls.cea608CaptionInputStreamWithId.replace("{encoding_id}", encoding.getId());
        newUrl = newUrl.replace("{input_stream_id}", cea608CaptionInputStream.getId());
        RestClient.delete(newUrl, this.headers);
    }

}
