package com.bitmovin.api.resource.encoding;

import com.bitmovin.api.RestClient;
import com.bitmovin.api.constants.ApiUrls;
import com.bitmovin.api.customData.CustomData;
import com.bitmovin.api.encoding.encodings.Encoding;
import com.bitmovin.api.encoding.encodings.drms.CencDrm;
import com.bitmovin.api.encoding.encodings.muxing.FMP4Muxing;
import com.bitmovin.api.encoding.encodings.streams.Stream;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.http.RestException;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

/**
 * Created by rkersche on 9/5/16.
 */
public class EncodingStreamResource
{
    private Map<String, String> headers;

    public EncodingStreamResource(Map<String, String> headers)
    {
        this.headers = headers;
    }

    public Stream getStream(Encoding encoding, Stream stream) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.streamsWithId.replace("{encoding_id}", encoding.getId()).replace("{stream_id}", stream.getId());
        return RestClient.get(newUrl, this.headers, Stream.class);
    }

    public Stream getStream(Encoding encoding, String streamId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.streamsWithId.replace("{encoding_id}", encoding.getId()).replace("{stream_id}", streamId);
        return RestClient.get(newUrl, this.headers, Stream.class);
    }

    public List<String> getStreamIds(Encoding encoding) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.streams.replace("{encoding_id}", encoding.getId());
        return RestClient.getListOfIds(newUrl, this.headers);
    }

    public CustomData getStreamCustomData(String encodingId, String streamId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.streams.replace("{encoding_id}", encodingId) + "/" + streamId + ApiUrls.customDataSuffix;
        return RestClient.get(newUrl, this.headers, CustomData.class);
    }

    public Stream addStreamToEncoding(Encoding encoding, Stream stream) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.streams.replace("{encoding_id}", encoding.getId());
        return RestClient.post(this.headers, newUrl, stream, Stream.class);
    }

    public Stream addStream(Encoding encoding, Stream stream) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.streams.replace("{encoding_id}", encoding.getId());
        return RestClient.post(this.headers, newUrl, stream, Stream.class);
    }

    public CencDrm getCencDrm(Encoding encoding, Stream stream, FMP4Muxing fmp4Muxing, String cencDrmId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.getCencDrmToFmp4Muxing.replace("{encoding_id}", encoding.getId());
        newUrl = newUrl.replace("{stream_id}", stream.getId());
        newUrl = newUrl.replace("{muxing_id}", fmp4Muxing.getId());
        newUrl = newUrl.replace("{cencDrmId}", cencDrmId);
        return RestClient.get(newUrl, this.headers, CencDrm.class);
    }

    public void deleteStream(Encoding encoding, Stream stream) throws BitmovinApiException, URISyntaxException, IOException, RestException, UnirestException
    {
        String newUrl = ApiUrls.streamsWithId.replace("{encoding_id}", encoding.getId());
        newUrl = newUrl.replace("{stream_id}", stream.getId());
        RestClient.delete(newUrl, this.headers);
    }

}
