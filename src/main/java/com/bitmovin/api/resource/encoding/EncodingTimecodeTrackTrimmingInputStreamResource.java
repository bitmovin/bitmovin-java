package com.bitmovin.api.resource.encoding;

import com.bitmovin.api.RestClient;
import com.bitmovin.api.constants.ApiUrls;
import com.bitmovin.api.customData.CustomData;
import com.bitmovin.api.encoding.encodings.Encoding;
import com.bitmovin.api.encoding.encodings.streams.TimecodeTrackTrimmingInputStream;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.http.RestException;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class EncodingTimecodeTrackTrimmingInputStreamResource
{
    private Map<String, String> headers;

    public EncodingTimecodeTrackTrimmingInputStreamResource(Map<String, String> headers)
    {
        this.headers = headers;
    }

    public TimecodeTrackTrimmingInputStream getTimecodeTrackTrimmingInputStream(Encoding encoding, TimecodeTrackTrimmingInputStream timecodeTrackTrimmingInputStream) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.timecodeTrackTrimmingInputStreamsWithId.replace("{encoding_id}", encoding.getId()).replace("{timecode_track_trimming_input_stream_id}", timecodeTrackTrimmingInputStream.getId());
        return RestClient.get(newUrl, this.headers, TimecodeTrackTrimmingInputStream.class);
    }

    public List<TimecodeTrackTrimmingInputStream> getTimecodeTrackTrimmingInputStreams(Encoding encoding) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.timecodeTrackTrimmingInputStreams.replace("{encoding_id}", encoding.getId());
        return RestClient.getAllItemsIterative(newUrl, this.headers, TimecodeTrackTrimmingInputStream.class);
    }

    public TimecodeTrackTrimmingInputStream getTimecodeTrackTrimmingInputStream(Encoding encoding, String timecodeTrackTrimmingInputStreamId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.timecodeTrackTrimmingInputStreamsWithId.replace("{encoding_id}", encoding.getId()).replace("{timecode_track_trimming_input_stream_id}", timecodeTrackTrimmingInputStreamId);
        return RestClient.get(newUrl, this.headers, TimecodeTrackTrimmingInputStream.class);
    }

    public List<String> getTimecodeTrackTrimmingInputStreamIds(Encoding encoding) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.timecodeTrackTrimmingInputStreams.replace("{encoding_id}", encoding.getId());
        return RestClient.getListOfIds(newUrl, this.headers);
    }

    public CustomData getTimecodeTrackTrimmingInputStreamCustomData(String encodingId, String timecodeTrackTrimmingInputStreamId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.timecodeTrackTrimmingInputStreams.replace("{encoding_id}", encodingId) + "/" + timecodeTrackTrimmingInputStreamId + ApiUrls.customDataSuffix;
        return RestClient.get(newUrl, this.headers, CustomData.class);
    }

    public TimecodeTrackTrimmingInputStream addTimecodeTrackTrimmingInputStreamToEncoding(Encoding encoding, TimecodeTrackTrimmingInputStream timecodeTrackTrimmingInputStream) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.timecodeTrackTrimmingInputStreams.replace("{encoding_id}", encoding.getId());
        return RestClient.post(this.headers, newUrl, timecodeTrackTrimmingInputStream, TimecodeTrackTrimmingInputStream.class);
    }

    public TimecodeTrackTrimmingInputStream addTimecodeTrackTrimmingInputStream(Encoding encoding, TimecodeTrackTrimmingInputStream timecodeTrackTrimmingInputStream) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.timecodeTrackTrimmingInputStreams.replace("{encoding_id}", encoding.getId());
        return RestClient.post(this.headers, newUrl, timecodeTrackTrimmingInputStream, TimecodeTrackTrimmingInputStream.class);
    }

    public void deleteTimecodeTrackTrimmingInputStream(Encoding encoding, TimecodeTrackTrimmingInputStream timecodeTrackTrimmingInputStream) throws BitmovinApiException, URISyntaxException, IOException, RestException, UnirestException
    {
        String newUrl = ApiUrls.timecodeTrackTrimmingInputStreamsWithId.replace("{encoding_id}", encoding.getId());
        newUrl = newUrl.replace("{timecode_track_trimming_input_stream_id}", timecodeTrackTrimmingInputStream.getId());
        RestClient.delete(newUrl, this.headers);
    }

}
