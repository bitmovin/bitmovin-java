package com.bitmovin.api.resource;

import com.bitmovin.api.RestClient;
import com.bitmovin.api.constants.ApiUrls;
import com.bitmovin.api.encoding.status.Message;
import com.bitmovin.api.encoding.status.Task;
import com.bitmovin.api.encoding.encodings.Encoding;
import com.bitmovin.api.encoding.encodings.EncodingReport;
import com.bitmovin.api.encoding.encodings.StartEncodingRequest;
import com.bitmovin.api.encoding.encodings.Trimming;
import com.bitmovin.api.encoding.encodings.live.LiveDetailsResponse;
import com.bitmovin.api.encoding.encodings.live.StartLiveEncodingRequest;
import com.bitmovin.api.encoding.encodings.live.StartLiveEncodingResponse;
import com.bitmovin.api.encoding.encodings.live.StopEncodingResponse;
import com.bitmovin.api.encoding.encodings.live.StopLiveEncodingResponse;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.resource.encoding.EncodingDrmResource;
import com.bitmovin.api.resource.encoding.EncodingMuxingResource;
import com.bitmovin.api.resource.encoding.EncodingSpriteResource;
import com.bitmovin.api.resource.encoding.EncodingStreamResource;
import com.bitmovin.api.resource.encoding.EncodingThumbnailResource;
import com.bitmovin.api.rest.ResponseEnvelope;
import com.bitmovin.api.http.RestException;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by rkersche on 9/5/16.
 **/
public class EncodingResource extends AbstractResource<Encoding>
{
    public EncodingDrmResource drm;
    public EncodingMuxingResource muxing;
    public EncodingThumbnailResource thumbnail;
    public EncodingStreamResource stream;
    public EncodingSpriteResource sprite;

    public EncodingResource(Map<String, String> headers, String url, Class<Encoding> type)
    {
        super(headers, url, type);
        this.drm = new EncodingDrmResource(headers);
        this.muxing = new EncodingMuxingResource(headers);
        this.thumbnail = new EncodingThumbnailResource(headers);
        this.stream = new EncodingStreamResource(headers);
        this.sprite = new EncodingSpriteResource(headers);
    }

    public List<Encoding> getAllEncodings(int limit, int offset) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String url = ApiUrls.encodingsLimitOffset.replace("{limit}", String.valueOf(limit));
        url = url.replace("{offset}", String.valueOf(offset));
        return this.getAllEncodings(url);
    }

    public List<Encoding> getAllEncodings() throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        return this.getAllEncodings(ApiUrls.encodings);
    }

    public List<Encoding> getAllEncodings(String url) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        ResponseEnvelope responseEnvelope = RestClient.getRaw(url, this.headers, ResponseEnvelope.class);
        JSONObject responseObject = RestClient.convertToJsonObject(responseEnvelope);

        JSONArray encodings = responseObject.getJSONObject("data").getJSONObject("result").getJSONArray("items");

        List<Encoding> allEncodings = new ArrayList<>();

        for (int i = 0; i < encodings.length(); i++)
        {
            JSONObject idObject = encodings.getJSONObject(i);
            allEncodings.add(RestClient.convertFromJsonObjectToPojo(idObject, Encoding.class));
        }

        return allEncodings;
    }

    public int getTotalEncodingsCount() throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        ResponseEnvelope responseEnvelope = RestClient.getRaw(ApiUrls.encodings, this.headers, ResponseEnvelope.class);
        JSONObject responseObject = RestClient.convertToJsonObject(responseEnvelope);
        return responseObject.getJSONObject("data").getJSONObject("result").getInt("totalCount");
    }

    public EncodingReport getReport(String encodingId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        return RestClient.get(ApiUrls.encodingReport.replace("{encoding_id}", encodingId), this.headers, EncodingReport.class);
    }

    public EncodingReport getReport(Encoding encoding) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        return this.getReport(encoding.getId());
    }

    public Encoding getDetails(String encodingId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        return RestClient.get(ApiUrls.encodings + "/" + encodingId, this.headers, Encoding.class);
    }

    public Task getStatus(Encoding encoding) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.encodingStatus.replace("{encoding_id}", encoding.getId());
        ResponseEnvelope responseEnvelope = RestClient.getRaw(newUrl, this.headers, ResponseEnvelope.class);
        return RestClient.getAnalysisTaskFromResponse(responseEnvelope);
    }

    public LiveDetailsResponse getLiveDetails(String encodingId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.encodingDetailsLive.replace("{encoding_id}", encodingId);
        return RestClient.getDetailsFromResponse(newUrl, this.headers, LiveDetailsResponse.class);
    }

    public StartLiveEncodingResponse startLive(Encoding encoding, String streamKey) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        StartLiveEncodingRequest request = new StartLiveEncodingRequest();
        request.setStreamKey(streamKey);

        String newUrl = ApiUrls.encodingStartLive.replace("{encoding_id}", encoding.getId());
        return RestClient.postDetail(newUrl, this.headers, request, StartLiveEncodingResponse.class);
    }

    public StartLiveEncodingResponse startLive(Encoding encoding, StartLiveEncodingRequest request) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.encodingStartLive.replace("{encoding_id}", encoding.getId());
        return RestClient.postDetail(newUrl, this.headers, request, StartLiveEncodingResponse.class);
    }

    public StopLiveEncodingResponse stopLive(String encodingId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String stopUrl = ApiUrls.encodingStopLive.replace("{encoding_id}", encodingId);
        return RestClient.postDetail(stopUrl, this.headers, null, StopLiveEncodingResponse.class);
    }

    public StopEncodingResponse stop(String encodingId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String stopUrl = ApiUrls.encodingStop.replace("{encoding_id}", encodingId);
        return RestClient.postDetail(stopUrl, this.headers, null, StopEncodingResponse.class);
    }

    public List<Message> start(Encoding encoding) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.encodingStart.replace("{encoding_id}", encoding.getId());
        return RestClient.post(this.headers, newUrl, encoding, Encoding.class).getMessages();
    }

    public void startRaw(Encoding encoding) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.encodingStart.replace("{encoding_id}", encoding.getId());
        RestClient.postRaw(newUrl, this.headers, encoding, Encoding.class);
    }

    public void start(Encoding encoding, Double offset, Double duration) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        StartEncodingRequest startEncoding = new StartEncodingRequest();

        Trimming trimming = new Trimming();
        trimming.setDuration(duration);
        trimming.setOffset(offset);

        startEncoding.setTrimming(trimming);

        String newUrl = ApiUrls.encodingStart.replace("{encoding_id}", encoding.getId());
        RestClient.postDetail(newUrl, this.headers, startEncoding, StartEncodingRequest.class);
    }

    public void start(Encoding encoding, String startPicTiming, String endPicTiming) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        StartEncodingRequest startEncodingRequest = new StartEncodingRequest();

        Trimming trimming = new Trimming();
        trimming.setStartPicTiming(startPicTiming);
        trimming.setEndPicTiming(endPicTiming);

        startEncodingRequest.setTrimming(trimming);

        String newUrl = ApiUrls.encodingStart.replace("{encoding_id}", encoding.getId());
        RestClient.postDetail(newUrl, this.headers, startEncodingRequest, StartEncodingRequest.class);
    }

    public void start(Encoding encoding, Trimming trimming) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        StartEncodingRequest startEncodingRequest = new StartEncodingRequest();
        startEncodingRequest.setTrimming(trimming);

        String newUrl = ApiUrls.encodingStart.replace("{encoding_id}", encoding.getId());
        RestClient.postDetail(newUrl, this.headers, startEncodingRequest, StartEncodingRequest.class);
    }

    public void start(Encoding encoding, StartEncodingRequest startEncodingRequest) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.encodingStart.replace("{encoding_id}", encoding.getId());
        RestClient.postDetail(newUrl, this.headers, startEncodingRequest, StartEncodingRequest.class);
    }

    public void delete(Encoding encoding) throws BitmovinApiException, URISyntaxException, IOException, RestException, UnirestException
    {
        String newUrl = ApiUrls.encodingDelete.replace("{encoding_id}", encoding.getId());
        RestClient.delete(newUrl, this.headers);
    }

}
