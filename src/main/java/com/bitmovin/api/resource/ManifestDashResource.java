package com.bitmovin.api.resource;

import com.bitmovin.api.RestClient;
import com.bitmovin.api.constants.ApiUrls;
import com.bitmovin.api.encoding.manifest.dash.*;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.http.RestException;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * Created by rkersche on 9/5/16.
 **/
public class ManifestDashResource extends ManifestResource<DashManifest>
{
    public ManifestDashResource(Map<String, String> headers, String url, Class<DashManifest> type, String status, String start)
    {
        super(headers, url, type, status, start);
    }


    public Period createPeriod(DashManifest manifestDash, Period period) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.manifestDashAddPeriod.replace("{manifestId}", manifestDash.getId());
        return RestClient.postDetail(newUrl, this.headers, period, Period.class);
    }


    public VideoAdaptationSet addVideoAdaptationSetToPeriod(DashManifest manifestDash, Period period, VideoAdaptationSet adaptationSet) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.manifestDashAddVideoAdaptionSet.replace("{manifestId}", manifestDash.getId());
        newUrl = newUrl.replace("{periodId}", period.getId());
        return RestClient.postDetail(newUrl, this.headers, adaptationSet, VideoAdaptationSet.class);
    }

    public AudioAdaptationSet addAudioAdaptationSetToPeriod(DashManifest manifestDash, Period period, AudioAdaptationSet adaptationSet) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.manifestDashAddAudioAdaptionSet.replace("{manifestId}", manifestDash.getId());
        newUrl = newUrl.replace("{periodId}", period.getId());
        return RestClient.postDetail(newUrl, this.headers, adaptationSet, AudioAdaptationSet.class);
    }

    public SubtitleAdaptationSet addSubtitleAdaptationSetToPeriod(DashManifest manifestDash, Period period, SubtitleAdaptationSet adaptationSet) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.manifestDashAddSubtitleAdaptionSet.replace("{manifestId}", manifestDash.getId());
        newUrl = newUrl.replace("{periodId}", period.getId());
        return RestClient.postDetail(newUrl, this.headers, adaptationSet, SubtitleAdaptationSet.class);
    }

    public DashSegmentedRepresentation addRepresentationToAdaptationSet(DashManifest manifestDash, Period period, AdaptationSet adaptationSet,
                                                                        DashSegmentedRepresentation dashRepresentation) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = null;

        if (dashRepresentation instanceof DashFmp4Representation)
            newUrl = ApiUrls.manifestDashAddFmp4Representation;

        if (dashRepresentation instanceof DashWebmRepresentation)
            newUrl = ApiUrls.manifestDashAddWebmRepresentation;

        if (newUrl == null)
            throw new BitmovinApiException(String.format("No route available for class %s.", dashRepresentation.getClass().getSimpleName()));

        newUrl = newUrl.replace("{manifestId}", manifestDash.getId());
        newUrl = newUrl.replace("{periodId}", period.getId());
        newUrl = newUrl.replace("{adaptionsetId}", adaptationSet.getId());

        return RestClient.postDetail(newUrl, this.headers, dashRepresentation, dashRepresentation.getClass());
    }

    public DashDRMRepresentation addDrmRepresentationToAdaptationSet(DashManifest manifestDash, Period period, AdaptationSet adaptationSet, DashDRMRepresentation muxing) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.manifestDashAddFmp4Representation.replace("{manifestId}", manifestDash.getId()) + "/drm";
        newUrl = newUrl.replace("{periodId}", period.getId());
        newUrl = newUrl.replace("{adaptionsetId}", adaptationSet.getId());
        return RestClient.postDetail(newUrl, this.headers, muxing, DashDRMRepresentation.class);
    }

    public DashVttRepresentation addVttRepresentationToAdaptationSet(DashManifest manifestDash, Period period, AdaptationSet adaptationSet, DashVttRepresentation vttRepresentation) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.manifestDashAddVttRepresentation.replace("{manifestId}", manifestDash.getId());
        newUrl = newUrl.replace("{periodId}", period.getId());
        newUrl = newUrl.replace("{adaptionsetId}", adaptationSet.getId());
        return RestClient.postDetail(newUrl, this.headers, vttRepresentation, DashVttRepresentation.class);
    }

    public ContentProtection addContentProtectionToAdaptationSet(DashManifest manifestDash, Period period, AdaptationSet adaptationSet, ContentProtection contentProtection) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.manifestDashAddContentProtectionToAdaptationSet.replace("{manifestId}", manifestDash.getId());
        newUrl = newUrl.replace("{periodId}", period.getId());
        newUrl = newUrl.replace("{adaptionsetId}", adaptationSet.getId());
        return RestClient.postDetail(newUrl, this.headers, contentProtection, ContentProtection.class);
    }

    public ContentProtection addContentProtectionTofMP4Representation(DashManifest manifestDash, Period period, AdaptationSet adaptationSet, DashFmp4Representation representation, ContentProtection contentProtection) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.manifestDashAddContentProtectionTofMP4Representation.replace("{manifestId}", manifestDash.getId());
        newUrl = newUrl.replace("{periodId}", period.getId());
        newUrl = newUrl.replace("{adaptionsetId}", adaptationSet.getId());
        newUrl = newUrl.replace("{representationId}", representation.getId());
        return RestClient.postDetail(newUrl, this.headers, contentProtection, ContentProtection.class);
    }

    public ContentProtection addContentProtectionToDRMfMP4Representation(DashManifest manifestDash, Period period, AdaptationSet adaptationSet, DashFmp4Representation representation, ContentProtection contentProtection) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.manifestDashAddContentProtectionToDRMfMP4Representation.replace("{manifestId}", manifestDash.getId());
        newUrl = newUrl.replace("{periodId}", period.getId());
        newUrl = newUrl.replace("{adaptionsetId}", adaptationSet.getId());
        newUrl = newUrl.replace("{representationId}", representation.getId());
        return RestClient.postDetail(newUrl, this.headers, contentProtection, ContentProtection.class);
    }
}
