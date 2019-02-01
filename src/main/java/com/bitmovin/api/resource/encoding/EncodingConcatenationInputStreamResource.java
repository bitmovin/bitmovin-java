package com.bitmovin.api.resource.encoding;

import com.bitmovin.api.RestClient;
import com.bitmovin.api.constants.ApiUrls;
import com.bitmovin.api.customData.CustomData;
import com.bitmovin.api.encoding.encodings.Encoding;
import com.bitmovin.api.encoding.encodings.streams.ConcatenationInputStream;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.http.RestException;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class EncodingConcatenationInputStreamResource
{
    private Map<String, String> headers;

    public EncodingConcatenationInputStreamResource(Map<String, String> headers)
    {
        this.headers = headers;
    }

    public ConcatenationInputStream getConcatenationInputStream(Encoding encoding, ConcatenationInputStream concatenationInputStream) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.concatenationInputStreamsWithId.replace("{encoding_id}", encoding.getId()).replace("{concatenation_input_stream_id}", concatenationInputStream.getId());
        return RestClient.get(newUrl, this.headers, ConcatenationInputStream.class);
    }

    public List<ConcatenationInputStream> getConcatenationInputStreams(Encoding encoding) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.concatenationInputStreams.replace("{encoding_id}", encoding.getId());
        return RestClient.getAllItemsIterative(newUrl, this.headers, ConcatenationInputStream.class);
    }

    public ConcatenationInputStream getConcatenationInputStream(Encoding encoding, String concatenationInputStreamId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.concatenationInputStreamsWithId.replace("{encoding_id}", encoding.getId()).replace("{concatenation_input_stream_id}", concatenationInputStreamId);
        return RestClient.get(newUrl, this.headers, ConcatenationInputStream.class);
    }

    public List<String> getConcatenationInputStreamIds(Encoding encoding) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.concatenationInputStreams.replace("{encoding_id}", encoding.getId());
        return RestClient.getListOfIds(newUrl, this.headers);
    }

    public CustomData getConcatenationInputStreamCustomData(String encodingId, String concatenationInputStreamId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.concatenationInputStreams.replace("{encoding_id}", encodingId) + "/" + concatenationInputStreamId + ApiUrls.customDataSuffix;
        return RestClient.get(newUrl, this.headers, CustomData.class);
    }

    public ConcatenationInputStream addConcatenationInputStreamToEncoding(Encoding encoding, ConcatenationInputStream concatenationInputStream) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.concatenationInputStreams.replace("{encoding_id}", encoding.getId());
        return RestClient.post(this.headers, newUrl, concatenationInputStream, ConcatenationInputStream.class);
    }

    public ConcatenationInputStream addConcatenationInputStream(Encoding encoding, ConcatenationInputStream concatenationInputStream) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.concatenationInputStreams.replace("{encoding_id}", encoding.getId());
        return RestClient.post(this.headers, newUrl, concatenationInputStream, ConcatenationInputStream.class);
    }

    public void deleteConcatenationInputStream(Encoding encoding, ConcatenationInputStream concatenationInputStream) throws BitmovinApiException, URISyntaxException, IOException, RestException, UnirestException
    {
        String newUrl = ApiUrls.concatenationInputStreamsWithId.replace("{encoding_id}", encoding.getId());
        newUrl = newUrl.replace("{concatenation_input_stream_id}", concatenationInputStream.getId());
        RestClient.delete(newUrl, this.headers);
    }

}
