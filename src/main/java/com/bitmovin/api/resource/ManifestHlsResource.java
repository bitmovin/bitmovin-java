package com.bitmovin.api.resource;

import com.bitmovin.api.RestClient;
import com.bitmovin.api.constants.ApiUrls;
import com.bitmovin.api.encoding.manifest.hls.*;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.http.RestException;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

/**
 * Created by rkersche on 9/5/16.
 **/
public class ManifestHlsResource extends ManifestResource<HlsManifest>
{
    public ManifestHlsResource(Map<String, String> headers, String url, Class<HlsManifest> type, String status, String start)
    {
        super(headers, url, type, status, start);
    }


    public MediaInfo createMediaInfo(HlsManifest hlsManifest, MediaInfo mediaInfo) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.manifestHlsMediaInfo.replace("{manifestId}", hlsManifest.getId());
        return RestClient.postDetail(newUrl, this.headers, mediaInfo, MediaInfo.class);
    }


    public VideoMediaInfo createVideoMediaInfo(HlsManifest hlsManifest, VideoMediaInfo videoMediaInfo) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.manifestHlsVideoMediaInfo.replace("{manifestId}", hlsManifest.getId());
        return RestClient.postDetail(newUrl, this.headers, videoMediaInfo, VideoMediaInfo.class);
    }

    public List<String> getVideoMediaInfoIdList(HlsManifest hlsManifest) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.manifestHlsVideoMediaInfo.replace("{manifestId}", hlsManifest.getId());
        return RestClient.getListOfIds(newUrl, this.headers);
    }

    public VideoMediaInfo getVideoMediaInfo(HlsManifest hlsManifest, VideoMediaInfo videoMediaInfo) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.manifestHlsVideoMediaInfo.replace("{manifestId}", hlsManifest.getId()) + "/" + videoMediaInfo.getId();
        return RestClient.get(newUrl, this.headers, VideoMediaInfo.class);
    }

    public void deleteVideoMediaInfo(HlsManifest hlsManifest, VideoMediaInfo videoMediaInfo) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.manifestHlsVideoMediaInfo.replace("{manifestId}", hlsManifest.getId()) + "/" + videoMediaInfo.getId();
        RestClient.delete(newUrl, this.headers);
    }


    public AudioMediaInfo createAudioMediaInfo(HlsManifest hlsManifest, AudioMediaInfo audioMediaInfo) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.manifestHlsAudioMediaInfo.replace("{manifestId}", hlsManifest.getId());
        return RestClient.postDetail(newUrl, this.headers, audioMediaInfo, AudioMediaInfo.class);
    }

    public List<String> getAudioMediaInfoIdList(HlsManifest hlsManifest) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.manifestHlsAudioMediaInfo.replace("{manifestId}", hlsManifest.getId());
        return RestClient.getListOfIds(newUrl, this.headers);
    }

    public AudioMediaInfo getAudioMediaInfo(HlsManifest hlsManifest, AudioMediaInfo audioMediaInfo) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.manifestHlsAudioMediaInfo.replace("{manifestId}", hlsManifest.getId()) + "/" + audioMediaInfo.getId();
        return RestClient.get(newUrl, this.headers, AudioMediaInfo.class);
    }

    public void deleteAudioMediaInfo(HlsManifest hlsManifest, AudioMediaInfo audioMediaInfo) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.manifestHlsAudioMediaInfo.replace("{manifestId}", hlsManifest.getId()) + "/" + audioMediaInfo.getId();
        RestClient.delete(newUrl, this.headers);
    }


    public SubtitlesMediaInfo createSubtitlesMediaInfo(HlsManifest hlsManifest, SubtitlesMediaInfo subtitlesMediaInfo) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.manifestHlsSubtitlesMediaInfo.replace("{manifestId}", hlsManifest.getId());
        return RestClient.postDetail(newUrl, this.headers, subtitlesMediaInfo, SubtitlesMediaInfo.class);
    }

    public List<String> getSubtitlesMediaInfoIdList(HlsManifest hlsManifest) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.manifestHlsSubtitlesMediaInfo.replace("{manifestId}", hlsManifest.getId());
        return RestClient.getListOfIds(newUrl, this.headers);
    }

    public SubtitlesMediaInfo getSubtitlesMediaInfo(HlsManifest hlsManifest, SubtitlesMediaInfo subtitlesMediaInfo) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.manifestHlsSubtitlesMediaInfo.replace("{manifestId}", hlsManifest.getId()) + "/" + subtitlesMediaInfo.getId();
        return RestClient.get(newUrl, this.headers, SubtitlesMediaInfo.class);
    }

    public void deleteSubtitlesMediaInfo(HlsManifest hlsManifest, SubtitlesMediaInfo subtitlesMediaInfo) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.manifestHlsSubtitlesMediaInfo.replace("{manifestId}", hlsManifest.getId()) + "/" + subtitlesMediaInfo.getId();
        RestClient.delete(newUrl, this.headers);
    }


    public ClosedCaptionsMediaInfo createClosedCaptionsMediaInfo(HlsManifest hlsManifest, ClosedCaptionsMediaInfo closedCaptionsMediaInfo) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.manifestHlsClosedCaptionsMediaInfo.replace("{manifestId}", hlsManifest.getId());
        return RestClient.postDetail(newUrl, this.headers, closedCaptionsMediaInfo, ClosedCaptionsMediaInfo.class);
    }

    public List<String> getClosedCaptionsMediaInfoIdList(HlsManifest hlsManifest) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.manifestHlsClosedCaptionsMediaInfo.replace("{manifestId}", hlsManifest.getId());
        return RestClient.getListOfIds(newUrl, this.headers);
    }

    public ClosedCaptionsMediaInfo getClosedCaptionsMediaInfo(HlsManifest hlsManifest, ClosedCaptionsMediaInfo closedCaptionsMediaInfo) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.manifestHlsClosedCaptionsMediaInfo.replace("{manifestId}", hlsManifest.getId()) + "/" + closedCaptionsMediaInfo.getId();
        return RestClient.get(newUrl, this.headers, ClosedCaptionsMediaInfo.class);
    }

    public void deleteClosedCaptionsMediaInfo(HlsManifest hlsManifest, ClosedCaptionsMediaInfo closedCaptionsMediaInfo) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.manifestHlsClosedCaptionsMediaInfo.replace("{manifestId}", hlsManifest.getId()) + "/" + closedCaptionsMediaInfo.getId();
        RestClient.delete(newUrl, this.headers);
    }


    public VttMediaInfo createVttMediaInfo(HlsManifest hlsManifest, VttMediaInfo vttMediaInfo) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.manifestHlsVttMediaInfo.replace("{manifestId}", hlsManifest.getId());
        return RestClient.postDetail(newUrl, this.headers, vttMediaInfo, VttMediaInfo.class);
    }

    public List<String> getVttMediaInfoIdList(HlsManifest hlsManifest) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.manifestHlsVttMediaInfo.replace("{manifestId}", hlsManifest.getId());
        return RestClient.getListOfIds(newUrl, this.headers);
    }

    public VttMediaInfo getVttMediaInfo(HlsManifest hlsManifest, VttMediaInfo vttMediaInfo) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.manifestHlsVttMediaInfo.replace("{manifestId}", hlsManifest.getId()) + "/" + vttMediaInfo.getId();
        return RestClient.get(newUrl, this.headers, VttMediaInfo.class);
    }

    public void deleteVttMediaInfo(HlsManifest hlsManifest, VttMediaInfo vttMediaInfo) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.manifestHlsVttMediaInfo.replace("{manifestId}", hlsManifest.getId()) + "/" + vttMediaInfo.getId();
        RestClient.delete(newUrl, this.headers);
    }


    public StreamInfo createStreamInfo(HlsManifest hlsManifest, StreamInfo streamInfo) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.manifestHlsStreamInfo.replace("{manifestId}", hlsManifest.getId());
        return RestClient.postDetail(newUrl, this.headers, streamInfo, StreamInfo.class);
    }

    public List<String> getStreamInfoIdList(HlsManifest hlsManifest) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.manifestHlsStreamInfo.replace("{manifestId}", hlsManifest.getId());
        return RestClient.getListOfIds(newUrl, this.headers);
    }

    public StreamInfo getStreamInfo(HlsManifest hlsManifest, StreamInfo streamInfo) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.manifestHlsStreamInfo.replace("{manifestId}", hlsManifest.getId()) + "/" + streamInfo.getId();
        return RestClient.get(newUrl, this.headers, StreamInfo.class);
    }

    public void deleteStreamInfo(HlsManifest hlsManifest, StreamInfo streamInfo) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.manifestHlsStreamInfo.replace("{manifestId}", hlsManifest.getId()) + "/" + streamInfo.getId();
        RestClient.delete(newUrl, this.headers);
    }
}
