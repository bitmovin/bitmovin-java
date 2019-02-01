package com.bitmovin.api.resource.encoding;

import com.bitmovin.api.RestClient;
import com.bitmovin.api.constants.ApiUrls;
import com.bitmovin.api.customData.CustomData;
import com.bitmovin.api.encoding.encodings.Encoding;
import com.bitmovin.api.encoding.encodings.streams.TimeBasedTrimmingInputStream;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.http.RestException;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class EncodingTimeBasedTrimmingInputStreamResource
{
    private Map<String, String> headers;

    public EncodingTimeBasedTrimmingInputStreamResource(Map<String, String> headers)
    {
        this.headers = headers;
    }

    public TimeBasedTrimmingInputStream getTimeBasedTrimmingInputStream(Encoding encoding, TimeBasedTrimmingInputStream timeBasedTrimmingInputStream) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.timeBasedTrimmingInputStreamsWithId.replace("{encoding_id}", encoding.getId()).replace("{time_based_trimming_input_stream_id}", timeBasedTrimmingInputStream.getId());
        return RestClient.get(newUrl, this.headers, TimeBasedTrimmingInputStream.class);
    }

    public List<TimeBasedTrimmingInputStream> getTimeBasedTrimmingInputStreams(Encoding encoding) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.timeBasedTrimmingInputStreams.replace("{encoding_id}", encoding.getId());
        return RestClient.getAllItemsIterative(newUrl, this.headers, TimeBasedTrimmingInputStream.class);
    }

    public TimeBasedTrimmingInputStream getTimeBasedTrimmingInputStream(Encoding encoding, String timeBasedTrimmingInputStreamId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.timeBasedTrimmingInputStreamsWithId.replace("{encoding_id}", encoding.getId()).replace("{time_based_trimming_input_stream_id}", timeBasedTrimmingInputStreamId);
        return RestClient.get(newUrl, this.headers, TimeBasedTrimmingInputStream.class);
    }

    public List<String> getTimeBasedTrimmingInputStreamIds(Encoding encoding) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.timeBasedTrimmingInputStreams.replace("{encoding_id}", encoding.getId());
        return RestClient.getListOfIds(newUrl, this.headers);
    }

    public CustomData getTimeBasedTrimmingInputStreamCustomData(String encodingId, String timeBasedTrimmingInputStreamId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.timeBasedTrimmingInputStreams.replace("{encoding_id}", encodingId) + "/" + timeBasedTrimmingInputStreamId + ApiUrls.customDataSuffix;
        return RestClient.get(newUrl, this.headers, CustomData.class);
    }

    public TimeBasedTrimmingInputStream addTimeBasedTrimmingInputStreamToEncoding(Encoding encoding, TimeBasedTrimmingInputStream timeBasedTrimmingInputStream) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.timeBasedTrimmingInputStreams.replace("{encoding_id}", encoding.getId());
        return RestClient.post(this.headers, newUrl, timeBasedTrimmingInputStream, TimeBasedTrimmingInputStream.class);
    }

    public TimeBasedTrimmingInputStream addTimeBasedTrimmingInputStream(Encoding encoding, TimeBasedTrimmingInputStream timeBasedTrimmingInputStream) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.timeBasedTrimmingInputStreams.replace("{encoding_id}", encoding.getId());
        return RestClient.post(this.headers, newUrl, timeBasedTrimmingInputStream, TimeBasedTrimmingInputStream.class);
    }

    public void deleteTimeBasedTrimmingInputStream(Encoding encoding, TimeBasedTrimmingInputStream timeBasedTrimmingInputStream) throws BitmovinApiException, URISyntaxException, IOException, RestException, UnirestException
    {
        String newUrl = ApiUrls.timeBasedTrimmingInputStreamsWithId.replace("{encoding_id}", encoding.getId());
        newUrl = newUrl.replace("{time_based_trimming_input_stream_id}", timeBasedTrimmingInputStream.getId());
        RestClient.delete(newUrl, this.headers);
    }

}
