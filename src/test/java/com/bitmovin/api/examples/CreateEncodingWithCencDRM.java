package com.bitmovin.api.examples;

import com.bitmovin.api.BitmovinApi;
import com.bitmovin.api.encoding.AclEntry;
import com.bitmovin.api.encoding.AclPermission;
import com.bitmovin.api.encoding.EncodingOutput;
import com.bitmovin.api.encoding.InputStream;
import com.bitmovin.api.encoding.codecConfigurations.AACAudioConfig;
import com.bitmovin.api.encoding.codecConfigurations.H264VideoConfiguration;
import com.bitmovin.api.encoding.codecConfigurations.enums.ProfileH264;
import com.bitmovin.api.encoding.encodings.Encoding;
import com.bitmovin.api.encoding.encodings.drms.CencDrm;
import com.bitmovin.api.encoding.encodings.drms.Drm;
import com.bitmovin.api.encoding.encodings.drms.FairPlayDrm;
import com.bitmovin.api.encoding.encodings.drms.cencSystems.CencPlayReady;
import com.bitmovin.api.encoding.encodings.drms.cencSystems.CencWidevine;
import com.bitmovin.api.encoding.encodings.muxing.FMP4Muxing;
import com.bitmovin.api.encoding.encodings.muxing.MuxingStream;
import com.bitmovin.api.encoding.encodings.muxing.TSMuxing;
import com.bitmovin.api.encoding.encodings.streams.Stream;
import com.bitmovin.api.encoding.enums.CloudRegion;
import com.bitmovin.api.encoding.enums.DashMuxingType;
import com.bitmovin.api.encoding.enums.StreamSelectionMode;
import com.bitmovin.api.encoding.inputs.HttpsInput;
import com.bitmovin.api.encoding.manifest.dash.AdaptationSet;
import com.bitmovin.api.encoding.manifest.dash.AudioAdaptationSet;
import com.bitmovin.api.encoding.manifest.dash.ContentProtection;
import com.bitmovin.api.encoding.manifest.dash.DashDRMRepresentation;
import com.bitmovin.api.encoding.manifest.dash.DashFmp4Representation;
import com.bitmovin.api.encoding.manifest.dash.DashManifest;
import com.bitmovin.api.encoding.manifest.dash.Period;
import com.bitmovin.api.encoding.manifest.dash.VideoAdaptationSet;
import com.bitmovin.api.encoding.manifest.hls.HlsManifest;
import com.bitmovin.api.encoding.manifest.hls.MediaInfo;
import com.bitmovin.api.encoding.manifest.hls.MediaInfoType;
import com.bitmovin.api.encoding.manifest.hls.StreamInfo;
import com.bitmovin.api.encoding.outputs.Output;
import com.bitmovin.api.encoding.outputs.S3Output;
import com.bitmovin.api.encoding.status.Task;
import com.bitmovin.api.enums.Status;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.http.RestException;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by Andreas Rudich on 25.07.17.
 **/
public class CreateEncodingWithCencDRM
{
    private static String ApiKey = "<INSERT_YOUR_APIKEY>";

    private static CloudRegion cloudRegion = CloudRegion.AUTO;
    private static String HTTPS_INPUT_HOST = "<INSERT_YOUR_HTTP_HOST>"; // ex.: storage.googleapis.com/
    private static String HTTPS_INPUT_PATH = "<INSERT_YOUR_PATH_TO_INPUT_FILE>";
    private static String S3_OUTPUT_ACCESSKEY = "<INSERT_YOUR_ACCESSKEY>";
    private static String S3_OUTPUT_SECRET_KEY = "<INSERT_YOUR_SECRETKEY>";
    private static String S3_OUTPUT_BUCKET_NAME = "BUCKET_NAME";
    private static String OUTPUT_BASE_PATH = "path/to/your/outputs/" + new Date().getTime();

    private static String CENC_KEY = "<INSERT_YOUR_CENC_KEY>";
    private static String CENC_KID = "<INSERT_YOUR_CENC_KID>";
    private static String PLAYREADY_LAURL = "http://playready.directtaps.net/pr/svc/rightsmanager.asmx?UseSimpleNonPersistentLicense=1";
    private static String WIDEVINE_PSSH = "<INSERT_YOUR_WIDEVINE_PSSH>";

    private static String FAIRPLAY_KEY = "<INSERT_YOUR_FAIRPLAY_KEY>";
    private static String FAIRPLAY_IV = "<INSERT_YOUR_FAIRPLAY_IV>";
    private static String FAIRPLAY_URI = "skd://userspecifc?custom=information";

    private static BitmovinApi bitmovinApi;

    @Test
    public void testDrmEncoding() throws IOException, BitmovinApiException, UnirestException, URISyntaxException, RestException, InterruptedException
    {
        bitmovinApi = new BitmovinApi(ApiKey);

        Encoding encoding = new Encoding();
        encoding.setName("Encoding JAVA with Cenc DRM");
        encoding.setCloudRegion(cloudRegion);
        encoding = bitmovinApi.encoding.create(encoding);

        HttpsInput input = new HttpsInput();
        input.setHost(HTTPS_INPUT_HOST);
        input = bitmovinApi.input.https.create(input);

        S3Output output = new S3Output();
        output.setAccessKey(S3_OUTPUT_ACCESSKEY);
        output.setSecretKey(S3_OUTPUT_SECRET_KEY);
        output.setBucketName(S3_OUTPUT_BUCKET_NAME);
        output = bitmovinApi.output.s3.create(output);

        AACAudioConfig aacConfiguration = new AACAudioConfig();
        aacConfiguration.setBitrate(128000L);
        aacConfiguration.setRate(48000f);
        aacConfiguration = bitmovinApi.configuration.audioAAC.create(aacConfiguration);

        H264VideoConfiguration videoConfiguration240p = new H264VideoConfiguration();
        videoConfiguration240p.setHeight(240);
        videoConfiguration240p.setBitrate(400000L);
        videoConfiguration240p.setProfile(ProfileH264.HIGH);
        videoConfiguration240p = bitmovinApi.configuration.videoH264.create(videoConfiguration240p);

        H264VideoConfiguration videoConfiguration360p = new H264VideoConfiguration();
        videoConfiguration360p.setHeight(360);
        videoConfiguration360p.setBitrate(800000L);
        videoConfiguration360p.setProfile(ProfileH264.HIGH);
        videoConfiguration360p = bitmovinApi.configuration.videoH264.create(videoConfiguration360p);

        H264VideoConfiguration videoConfiguration480p = new H264VideoConfiguration();
        videoConfiguration480p.setHeight(480);
        videoConfiguration480p.setBitrate(1200000L);
        videoConfiguration480p.setProfile(ProfileH264.HIGH);
        videoConfiguration480p = bitmovinApi.configuration.videoH264.create(videoConfiguration480p);

        H264VideoConfiguration videoConfiguration720p = new H264VideoConfiguration();
        videoConfiguration720p.setHeight(720);
        videoConfiguration720p.setBitrate(2400000L);
        videoConfiguration720p.setProfile(ProfileH264.HIGH);
        videoConfiguration720p = bitmovinApi.configuration.videoH264.create(videoConfiguration720p);

        H264VideoConfiguration videoConfiguration1080p = new H264VideoConfiguration();
        videoConfiguration1080p.setHeight(1080);
        videoConfiguration1080p.setBitrate(4800000L);
        videoConfiguration1080p.setProfile(ProfileH264.HIGH);
        videoConfiguration1080p = bitmovinApi.configuration.videoH264.create(videoConfiguration1080p);

        InputStream inputStreamAudio = new InputStream();
        inputStreamAudio.setInputPath(HTTPS_INPUT_PATH);
        inputStreamAudio.setInputId(input.getId());
        inputStreamAudio.setSelectionMode(StreamSelectionMode.AUTO);
        inputStreamAudio.setPosition(0);

        InputStream inputStreamVideo = new InputStream();
        inputStreamVideo.setInputPath(HTTPS_INPUT_PATH);
        inputStreamVideo.setInputId(input.getId());
        inputStreamVideo.setSelectionMode(StreamSelectionMode.AUTO);
        inputStreamVideo.setPosition(0);

        Stream audioStream = new Stream();
        audioStream.setCodecConfigId(aacConfiguration.getId());
        audioStream.setInputStreams(Collections.singleton(inputStreamAudio));
        audioStream = bitmovinApi.encoding.stream.addStream(encoding, audioStream);

        Stream videoStream240p = new Stream();
        videoStream240p.setCodecConfigId(videoConfiguration240p.getId());
        videoStream240p.setInputStreams(Collections.singleton(inputStreamVideo));
        videoStream240p = bitmovinApi.encoding.stream.addStream(encoding, videoStream240p);

        Stream videoStream360p = new Stream();
        videoStream360p.setCodecConfigId(videoConfiguration360p.getId());
        videoStream360p.setInputStreams(Collections.singleton(inputStreamVideo));
        videoStream360p = bitmovinApi.encoding.stream.addStream(encoding, videoStream360p);

        Stream videoStream480p = new Stream();
        videoStream480p.setCodecConfigId(videoConfiguration480p.getId());
        videoStream480p.setInputStreams(Collections.singleton(inputStreamVideo));
        videoStream480p = bitmovinApi.encoding.stream.addStream(encoding, videoStream480p);

        Stream videoStream720p = new Stream();
        videoStream720p.setCodecConfigId(videoConfiguration720p.getId());
        videoStream720p.setInputStreams(Collections.singleton(inputStreamVideo));
        videoStream720p = bitmovinApi.encoding.stream.addStream(encoding, videoStream720p);

        Stream videoStream1080p = new Stream();
        videoStream1080p.setCodecConfigId(videoConfiguration1080p.getId());
        videoStream1080p.setInputStreams(Collections.singleton(inputStreamVideo));
        videoStream1080p = bitmovinApi.encoding.stream.addStream(encoding, videoStream1080p);

        EncodingOutput encodingOutput = new EncodingOutput();
        encodingOutput.setOutputId(output.getId());
        encodingOutput.setOutputPath(OUTPUT_BASE_PATH);

        FMP4Muxing fmp4Muxing240 = this.createFMP4MuxingNoOutput(encoding, videoStream240p);
        FMP4Muxing fmp4Muxing360 = this.createFMP4MuxingNoOutput(encoding, videoStream360p);
        FMP4Muxing fmp4Muxing480 = this.createFMP4MuxingNoOutput(encoding, videoStream480p);
        FMP4Muxing fmp4Muxing720 = this.createFMP4MuxingNoOutput(encoding, videoStream720p);
        FMP4Muxing fmp4Muxing1080 = this.createFMP4MuxingNoOutput(encoding, videoStream1080p);
        FMP4Muxing fmp4Audio = this.createFMP4MuxingNoOutput(encoding, audioStream);

        CencDrm videoDRM240p = this.getCencDRMWithWidevineAndPlayready();
        CencDrm videoDRM360p = this.getCencDRMWithWidevineAndPlayready();
        CencDrm videoDRM480p = this.getCencDRMWithWidevineAndPlayready();
        CencDrm videoDRM720p = this.getCencDRMWithWidevineAndPlayready();
        CencDrm videoDRM1080p = this.getCencDRMWithWidevineAndPlayready();
        CencDrm audioDRM = this.getCencDRMWithWidevineAndPlayready();

        this.addOutputToDRM(videoDRM240p, output, OUTPUT_BASE_PATH + "/video/240p_dash/drm");
        this.addOutputToDRM(videoDRM360p, output, OUTPUT_BASE_PATH + "/video/360p_dash/drm");
        this.addOutputToDRM(videoDRM480p, output, OUTPUT_BASE_PATH + "/video/480p_dash/drm");
        this.addOutputToDRM(videoDRM720p, output, OUTPUT_BASE_PATH + "/video/720p_dash/drm");
        this.addOutputToDRM(videoDRM1080p, output, OUTPUT_BASE_PATH + "/video/1080p_dash/drm");
        this.addOutputToDRM(audioDRM, output, OUTPUT_BASE_PATH + "/audio/128kbps_dash/drm");

        videoDRM240p = this.addCencDrmToFmp4Muxing(encoding, fmp4Muxing240, videoDRM240p);
        videoDRM360p = this.addCencDrmToFmp4Muxing(encoding, fmp4Muxing360, videoDRM360p);
        videoDRM480p = this.addCencDrmToFmp4Muxing(encoding, fmp4Muxing480, videoDRM480p);
        videoDRM720p = this.addCencDrmToFmp4Muxing(encoding, fmp4Muxing720, videoDRM720p);
        videoDRM1080p = this.addCencDrmToFmp4Muxing(encoding, fmp4Muxing1080, videoDRM1080p);
        audioDRM = this.addCencDrmToFmp4Muxing(encoding, fmp4Audio, audioDRM);

        TSMuxing tsMuxing240 = this.createTSMuxingNoOutput(encoding, videoStream240p);
        TSMuxing tsMuxing360 = this.createTSMuxingNoOutput(encoding, videoStream360p);
        TSMuxing tsMuxing480 = this.createTSMuxingNoOutput(encoding, videoStream480p);
        TSMuxing tsMuxing720 = this.createTSMuxingNoOutput(encoding, videoStream720p);
        TSMuxing tsMuxing1080 = this.createTSMuxingNoOutput(encoding, videoStream1080p);
        TSMuxing tsAudio = this.createTSMuxingNoOutput(encoding, audioStream);

        FairPlayDrm videoFairPlayDRM240p = this.getFairPlayDRM();
        FairPlayDrm videoFairPlayDRM360p = this.getFairPlayDRM();
        FairPlayDrm videoFairPlayDRM480p = this.getFairPlayDRM();
        FairPlayDrm videoFairPlayDRM720p = this.getFairPlayDRM();
        FairPlayDrm videoFairPlayDRM1080p = this.getFairPlayDRM();
        FairPlayDrm audioFairPlayDRM = this.getFairPlayDRM();

        this.addOutputToDRM(videoFairPlayDRM240p, output, OUTPUT_BASE_PATH + "/video/240p_hls/fairplay_drm");
        this.addOutputToDRM(videoFairPlayDRM360p, output, OUTPUT_BASE_PATH + "/video/360p_hls/fairplay_drm");
        this.addOutputToDRM(videoFairPlayDRM480p, output, OUTPUT_BASE_PATH + "/video/480p_hls/fairplay_drm");
        this.addOutputToDRM(videoFairPlayDRM720p, output, OUTPUT_BASE_PATH + "/video/720p_hls/fairplay_drm");
        this.addOutputToDRM(videoFairPlayDRM1080p, output, OUTPUT_BASE_PATH + "/video/1080p_hls/fairplay_drm");
        this.addOutputToDRM(audioFairPlayDRM, output, OUTPUT_BASE_PATH + "/audio/128kbps_hls/fairplay_drm");

        videoFairPlayDRM240p = this.addFairPlayDrmToTssMuxing(encoding, tsMuxing240, videoFairPlayDRM240p);
        videoFairPlayDRM360p = this.addFairPlayDrmToTssMuxing(encoding, tsMuxing360, videoFairPlayDRM360p);
        videoFairPlayDRM480p = this.addFairPlayDrmToTssMuxing(encoding, tsMuxing480, videoFairPlayDRM480p);
        videoFairPlayDRM720p = this.addFairPlayDrmToTssMuxing(encoding, tsMuxing720, videoFairPlayDRM720p);
        videoFairPlayDRM1080p = this.addFairPlayDrmToTssMuxing(encoding, tsMuxing1080, videoFairPlayDRM1080p);
        audioFairPlayDRM = this.addFairPlayDrmToTssMuxing(encoding, tsAudio, audioFairPlayDRM);

        bitmovinApi.encoding.start(encoding);

        Task status = bitmovinApi.encoding.getStatus(encoding);

        while (status.getStatus() != Status.FINISHED && status.getStatus() != Status.ERROR)
        {
            status = bitmovinApi.encoding.getStatus(encoding);
            Thread.sleep(2500);
        }

        System.out.println(String.format("Encoding finished with status %s", status.getStatus().toString()));

        if (status.getStatus() != Status.FINISHED)
        {
            System.out.println("Encoding has status error ... can not create manifest");
            Assert.fail("Encoding has status error ... can not create manifest");
        }

        System.out.println("Creating DASH manifest");

        EncodingOutput manifestDestination = new EncodingOutput();
        manifestDestination.setOutputId(output.getId());
        manifestDestination.setOutputPath(OUTPUT_BASE_PATH);
        manifestDestination.setAcl(Collections.singletonList(new AclEntry(AclPermission.PUBLIC_READ)));

        DashManifest manifest = this.createDashManifest("manifest.mpd", manifestDestination);
        Period period = this.addPeriodToDashManifest(manifest);
        VideoAdaptationSet videoAdaptationSet = this.addVideoAdaptationSetToPeriod(manifest, period);
        AudioAdaptationSet audioAdaptationSet = this.addAudioAdaptationSetToPeriodWithRoles(manifest, period, "en");

        DashDRMRepresentation playReadyDrmRepresentationVideo240 = this.addDashDRMRepresentationToAdaptationSet(DashMuxingType.TEMPLATE, encoding.getId(), videoStream240p.getId(), fmp4Muxing240.getId(), videoDRM240p.getId(), "video/240p_dash/drm/", manifest, period, videoAdaptationSet);
        DashDRMRepresentation playReadyDrmRepresentationVideo360 = this.addDashDRMRepresentationToAdaptationSet(DashMuxingType.TEMPLATE, encoding.getId(), videoStream360p.getId(), fmp4Muxing360.getId(), videoDRM360p.getId(), "video/360p_dash/drm/", manifest, period, videoAdaptationSet);
        DashDRMRepresentation playReadyDrmRepresentationVideo480 = this.addDashDRMRepresentationToAdaptationSet(DashMuxingType.TEMPLATE, encoding.getId(), videoStream480p.getId(), fmp4Muxing480.getId(), videoDRM480p.getId(), "video/480p_dash/drm/", manifest, period, videoAdaptationSet);
        DashDRMRepresentation playReadyDrmRepresentationVideo720 = this.addDashDRMRepresentationToAdaptationSet(DashMuxingType.TEMPLATE, encoding.getId(), videoStream720p.getId(), fmp4Muxing720.getId(), videoDRM720p.getId(), "video/720p_dash/drm/", manifest, period, videoAdaptationSet);
        DashDRMRepresentation playReadyDrmRepresentationVideo1080 = this.addDashDRMRepresentationToAdaptationSet(DashMuxingType.TEMPLATE, encoding.getId(), videoStream1080p.getId(), fmp4Muxing1080.getId(), videoDRM1080p.getId(), "video/1080p_dash/drm/", manifest, period, videoAdaptationSet);
        DashDRMRepresentation playReadyDrmRepresentationAudio = this.addDashDRMRepresentationToAdaptationSet(DashMuxingType.TEMPLATE, encoding.getId(), audioStream.getId(), fmp4Audio.getId(), audioDRM.getId(), "audio/128kbps_dash/drm/", manifest, period, audioAdaptationSet);

        this.addContentProtectionToDRMfMP4Representation(manifest, period, videoAdaptationSet, playReadyDrmRepresentationVideo240, this.getContentProtection(encoding.getId(), videoStream240p.getId(), fmp4Muxing240.getId(), videoDRM240p.getId()));
        this.addContentProtectionToDRMfMP4Representation(manifest, period, videoAdaptationSet, playReadyDrmRepresentationVideo360, this.getContentProtection(encoding.getId(), videoStream360p.getId(), fmp4Muxing360.getId(), videoDRM360p.getId()));
        this.addContentProtectionToDRMfMP4Representation(manifest, period, videoAdaptationSet, playReadyDrmRepresentationVideo480, this.getContentProtection(encoding.getId(), videoStream480p.getId(), fmp4Muxing480.getId(), videoDRM480p.getId()));
        this.addContentProtectionToDRMfMP4Representation(manifest, period, videoAdaptationSet, playReadyDrmRepresentationVideo720, this.getContentProtection(encoding.getId(), videoStream720p.getId(), fmp4Muxing720.getId(), videoDRM720p.getId()));
        this.addContentProtectionToDRMfMP4Representation(manifest, period, videoAdaptationSet, playReadyDrmRepresentationVideo1080, this.getContentProtection(encoding.getId(), videoStream1080p.getId(), fmp4Muxing1080.getId(), videoDRM1080p.getId()));
        this.addContentProtectionToDRMfMP4Representation(manifest, period, audioAdaptationSet, playReadyDrmRepresentationAudio, this.getContentProtection(encoding.getId(), audioStream.getId(), fmp4Audio.getId(), audioDRM.getId()));

        bitmovinApi.manifest.dash.startGeneration(manifest);
        Status dashStatus = bitmovinApi.manifest.dash.getGenerationStatus(manifest);
        while (dashStatus != Status.FINISHED && dashStatus != Status.ERROR)
        {
            dashStatus = bitmovinApi.manifest.dash.getGenerationStatus(manifest);
            Thread.sleep(2500);
        }
        if (dashStatus != Status.FINISHED)
        {
            System.out.println("Could not create DASH manifest");
            Assert.fail("Could not create DASH manifest");
        }
        System.out.println("Creating HLS manifest");
        HlsManifest manifestHls = this.createHlsManifest("manifest.m3u8", manifestDestination);

        MediaInfo audioMediaInfo = new MediaInfo();
        audioMediaInfo.setName("audio.m3u8");
        audioMediaInfo.setUri("audio.m3u8");
        audioMediaInfo.setGroupId("audio");
        audioMediaInfo.setType(MediaInfoType.AUDIO);
        audioMediaInfo.setEncodingId(encoding.getId());
        audioMediaInfo.setStreamId(audioStream.getId());
        audioMediaInfo.setMuxingId(tsAudio.getId());
        audioMediaInfo.setDrmId(audioFairPlayDRM.getId());
        audioMediaInfo.setLanguage("en");
        audioMediaInfo.setAssocLanguage("en");
        audioMediaInfo.setAutoselect(true);
        audioMediaInfo.setIsDefault(true);
        audioMediaInfo.setForced(false);
        audioMediaInfo.setSegmentPath("audio/128kbps_hls/fairplay_drm");
        audioMediaInfo = bitmovinApi.manifest.hls.createMediaInfo(manifestHls, audioMediaInfo);

        this.addStreamInfoToHlsManifest("video_240p.m3u8", encoding.getId(), videoStream240p.getId(), tsMuxing240.getId(), videoFairPlayDRM240p.getId(), audioMediaInfo.getGroupId(), "video/240p_hls/fairplay_drm", manifestHls);
        this.addStreamInfoToHlsManifest("video_360p.m3u8", encoding.getId(), videoStream360p.getId(), tsMuxing360.getId(), videoFairPlayDRM360p.getId(), audioMediaInfo.getGroupId(),"video/360p_hls/fairplay_drm", manifestHls);
        this.addStreamInfoToHlsManifest("video_480p.m3u8", encoding.getId(), videoStream480p.getId(), tsMuxing480.getId(), videoFairPlayDRM480p.getId(), audioMediaInfo.getGroupId(),"video/480p_hls/fairplay_drm", manifestHls);
        this.addStreamInfoToHlsManifest("video_720p.m3u8", encoding.getId(), videoStream720p.getId(), tsMuxing720.getId(), videoFairPlayDRM720p.getId(), audioMediaInfo.getGroupId(),"video/720p_hls/fairplay_drm", manifestHls);
        this.addStreamInfoToHlsManifest("video_1080p.m3u8", encoding.getId(), videoStream1080p.getId(), tsMuxing1080.getId(), videoFairPlayDRM1080p.getId(), audioMediaInfo.getGroupId(), "video/1080p_hls/fairplay_drm", manifestHls);

        bitmovinApi.manifest.hls.startGeneration(manifestHls);
        Status hlsStatus = bitmovinApi.manifest.hls.getGenerationStatus(manifestHls);
        while (hlsStatus != Status.FINISHED && hlsStatus != Status.ERROR)
        {
            hlsStatus = bitmovinApi.manifest.hls.getGenerationStatus(manifestHls);
            Thread.sleep(2500);
        }
        if (hlsStatus != Status.FINISHED)
        {
            System.out.println("Could not create HLS manifest");
            Assert.fail("Could not create HLS manifest");
        }

        System.out.println("Encoding completed successfully");
    }

    private StreamInfo addStreamInfoToHlsManifest(String uri, String encodingId, String streamId, String muxingId,
                                                  String drmId, String audioGroupId, String segmentPath,
                                                  HlsManifest manifest)
            throws URISyntaxException, BitmovinApiException, RestException, UnirestException, IOException
    {
        StreamInfo s = new StreamInfo();
        s.setUri(uri);
        s.setEncodingId(encodingId);
        s.setStreamId(streamId);
        s.setMuxingId(muxingId);
        s.setDrmId(drmId);
        s.setAudio(audioGroupId);
        s.setSegmentPath(segmentPath);
        s = bitmovinApi.manifest.hls.createStreamInfo(manifest, s);
        return s;
    }


    private HlsManifest createHlsManifest(String name, EncodingOutput output)
            throws URISyntaxException, BitmovinApiException, UnirestException, IOException
    {
        HlsManifest m = new HlsManifest();
        m.setName(name);
        m.addOutput(output);
        return bitmovinApi.manifest.hls.create(m);
    }

    private DashDRMRepresentation addDashDRMRepresentationToAdaptationSet(DashMuxingType type, String encodingId,
                                                                          String streamId, String muxingId, String drmId,
                                                                          String segmentPath, DashManifest manifest,
                                                                          Period period, AdaptationSet adaptationSet)
            throws BitmovinApiException, URISyntaxException, RestException, UnirestException, IOException
    {
        DashDRMRepresentation r = this.getDashDRMRepresentation(type, encodingId, streamId, muxingId, drmId, segmentPath);
        return bitmovinApi.manifest.dash.addDrmRepresentationToAdaptationSet(manifest, period, adaptationSet, r);
    }

    private DashDRMRepresentation getDashDRMRepresentation(DashMuxingType type, String encodingId, String streamId,
                                                           String muxingId, String drmId, String segmentPath)
    {
        DashDRMRepresentation r = new DashDRMRepresentation();
        r.setType(type);
        r.setEncodingId(encodingId);
        r.setStreamId(streamId);
        r.setMuxingId(muxingId);
        r.setDrmId(drmId);
        r.setSegmentPath(segmentPath);
        return r;
    }

    private AudioAdaptationSet addAudioAdaptationSetToPeriodWithRoles(DashManifest manifest, Period period, String lang)
            throws URISyntaxException, BitmovinApiException, RestException, UnirestException, IOException
    {
        AudioAdaptationSet a = new AudioAdaptationSet();
        a.setLang(lang);
        a = bitmovinApi.manifest.dash.addAudioAdaptationSetToPeriod(manifest, period, a);
        return a;
    }

    private VideoAdaptationSet addVideoAdaptationSetToPeriod(DashManifest manifest, Period period)
            throws URISyntaxException, BitmovinApiException, RestException, UnirestException, IOException
    {
        VideoAdaptationSet adaptationSet = new VideoAdaptationSet();
        adaptationSet = bitmovinApi.manifest.dash.addVideoAdaptationSetToPeriod(manifest, period, adaptationSet);
        return adaptationSet;
    }

    private DashManifest createDashManifest(String name, EncodingOutput output)
            throws URISyntaxException, BitmovinApiException, UnirestException, IOException
    {
        DashManifest manifest = new DashManifest();
        manifest.setName(name);
        manifest.addOutput(output);
        manifest = bitmovinApi.manifest.dash.create(manifest);
        return manifest;
    }

    private Period addPeriodToDashManifest(DashManifest manifest)
            throws URISyntaxException, BitmovinApiException, RestException, UnirestException, IOException
    {
        Period period = new Period();
        period = bitmovinApi.manifest.dash.createPeriod(manifest, period);
        return period;
    }

    private FMP4Muxing createFMP4MuxingNoOutput(Encoding encoding, Stream stream)
            throws URISyntaxException, BitmovinApiException, RestException, UnirestException, IOException
    {
        FMP4Muxing muxing = new FMP4Muxing();
        MuxingStream list = new MuxingStream();
        list.setStreamId(stream.getId());
        muxing.addStream(list);
        muxing.setSegmentLength(4.0);
        muxing = bitmovinApi.encoding.muxing.addFmp4MuxingToEncoding(encoding, muxing);
        return muxing;
    }

    private TSMuxing createTSMuxingNoOutput(Encoding encoding, Stream stream)
            throws URISyntaxException, BitmovinApiException, RestException, UnirestException, IOException
    {
        TSMuxing muxing = new TSMuxing();
        MuxingStream list = new MuxingStream();
        list.setStreamId(stream.getId());
        muxing.addStream(list);
        muxing.setSegmentLength(4.0);
        muxing = bitmovinApi.encoding.muxing.addTSMuxingToEncoding(encoding, muxing);
        return muxing;
    }

    private CencDrm getCencDRMWithWidevineAndPlayready() {
        CencPlayReady cencPlayReady = this.getCencPlayReady();
        CencWidevine cencWidevine = this.getCencWidevine();
        CencDrm cencDrm = new CencDrm();

        cencDrm.setKey(CENC_KEY);
        cencDrm.setKid(CENC_KID);
        cencDrm.setWidevine(cencWidevine);
        cencDrm.setPlayReady(cencPlayReady);
        return cencDrm;
    }

    private CencWidevine getCencWidevine() {
        CencWidevine cencWidevine = new CencWidevine();
        cencWidevine.setPssh(WIDEVINE_PSSH);
        return cencWidevine;
    }

    private CencPlayReady getCencPlayReady() {
        CencPlayReady cencPlayReady = new CencPlayReady();
        cencPlayReady.setLaUrl(PLAYREADY_LAURL);
        return cencPlayReady;
    }

    private FairPlayDrm getFairPlayDRM()
    {
        FairPlayDrm fairPlayDrm = new FairPlayDrm();
        fairPlayDrm.setKey(FAIRPLAY_KEY);
        fairPlayDrm.setIv(FAIRPLAY_IV);
        fairPlayDrm.setUri(FAIRPLAY_URI);
        return fairPlayDrm;
    }

    private void addOutputToDRM(Drm drm, Output output, String outputPath)
    {
        List<EncodingOutput> drmOutputs = drm.getOutputs();

        if (drmOutputs == null)
        {
            drmOutputs = new ArrayList<>();
            drm.setOutputs(drmOutputs);
        }

        EncodingOutput drmOutput = new EncodingOutput();
        drmOutput.setOutputId(output.getId());
        drmOutput.setOutputPath(outputPath);
        drmOutputs.add(drmOutput);
    }

    private CencDrm addCencDrmToFmp4Muxing(Encoding encoding, FMP4Muxing fmp4Muxing, CencDrm cencDrm)
            throws BitmovinApiException, IOException, RestException, UnirestException, URISyntaxException
    {
        CencDrm result = bitmovinApi.encoding.muxing.addCencDrmToFmp4Muxing(encoding, fmp4Muxing, cencDrm);
        Assert.assertNotNull(result.getId());
        fmp4Muxing.getDrmConfigs().add(result);
        return result;
    }

    private FairPlayDrm addFairPlayDrmToTssMuxing(Encoding encoding, TSMuxing tsMuxing, FairPlayDrm fairplayDrm)
            throws BitmovinApiException, IOException, RestException, UnirestException, URISyntaxException
    {
        FairPlayDrm result = bitmovinApi.encoding.muxing.addFairPlayDrmToTssMuxing(encoding, tsMuxing, fairplayDrm);
        Assert.assertNotNull(result.getId());
        tsMuxing.getDrmConfigs().add(result);
        return result;
    }

    private ContentProtection addContentProtectionToDRMfMP4Representation(DashManifest manifestDash,
                                                                          Period period,
                                                                          AdaptationSet adaptationSet,
                                                                          DashFmp4Representation representation,
                                                                          ContentProtection contentProtection)
            throws BitmovinApiException, IOException, RestException, UnirestException, URISyntaxException
    {
        return bitmovinApi.manifest.dash.addContentProtectionToDRMfMP4Representation(manifestDash,
                period,
                adaptationSet,
                representation,
                contentProtection);
    }

    private ContentProtection getContentProtection(String encodingId, String streamId, String muxingId, String drmId)
    {
        ContentProtection contentProtection = new ContentProtection();
        contentProtection.setEncodingId(encodingId);
        contentProtection.setStreamId(streamId);
        contentProtection.setMuxingId(muxingId);
        contentProtection.setDrmId(drmId);
        return contentProtection;
    }
}
