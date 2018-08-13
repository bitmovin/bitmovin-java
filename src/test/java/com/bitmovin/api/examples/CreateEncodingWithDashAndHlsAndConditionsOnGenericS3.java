package com.bitmovin.api.examples;

import com.bitmovin.api.BitmovinApi;
import com.bitmovin.api.encoding.*;
import com.bitmovin.api.encoding.codecConfigurations.AACAudioConfig;
import com.bitmovin.api.encoding.codecConfigurations.H264VideoConfiguration;
import com.bitmovin.api.encoding.codecConfigurations.enums.ProfileH264;
import com.bitmovin.api.encoding.encodings.Encoding;
import com.bitmovin.api.encoding.encodings.conditions.AbstractCondition;
import com.bitmovin.api.encoding.encodings.conditions.AndConjunction;
import com.bitmovin.api.encoding.encodings.conditions.Condition;
import com.bitmovin.api.encoding.encodings.conditions.ConditionAttribute;
import com.bitmovin.api.encoding.encodings.muxing.FMP4Muxing;
import com.bitmovin.api.encoding.encodings.muxing.MuxingStream;
import com.bitmovin.api.encoding.encodings.muxing.TSMuxing;
import com.bitmovin.api.encoding.encodings.streams.Stream;
import com.bitmovin.api.encoding.encodings.thumbnails.Sprite;
import com.bitmovin.api.encoding.encodings.thumbnails.Thumbnail;
import com.bitmovin.api.encoding.encodings.thumbnails.ThumbnailUnit;
import com.bitmovin.api.encoding.enums.CloudRegion;
import com.bitmovin.api.encoding.enums.DashMuxingType;
import com.bitmovin.api.encoding.enums.StreamSelectionMode;
import com.bitmovin.api.encoding.inputs.GenericS3Input;
import com.bitmovin.api.encoding.manifest.dash.*;
import com.bitmovin.api.encoding.manifest.hls.HlsManifest;
import com.bitmovin.api.encoding.manifest.hls.MediaInfo;
import com.bitmovin.api.encoding.manifest.hls.MediaInfoType;
import com.bitmovin.api.encoding.manifest.hls.StreamInfo;
import com.bitmovin.api.encoding.outputs.GenericS3Output;
import com.bitmovin.api.encoding.outputs.Output;
import com.bitmovin.api.encoding.status.Task;
import com.bitmovin.api.enums.Status;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.http.RestException;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class CreateEncodingWithDashAndHlsAndConditionsOnGenericS3
{
    private static String API_KEY = "<INSERT_YOUR_APIKEY>";

    private static CloudRegion CLOUD_REGION = CloudRegion.AWS_EU_WEST_1;

    private static String GENERIC_S3_INPUT_HOST = "<INSERT_YOUR_HOST>";
    private static String GENERIC_S3_INPUT_ACCESSKEY = "<INSERT_YOUR_ACCESSKEY>";
    private static String GENERIC_S3_INPUT_SECRET_KEY = "<INSERT_YOUR_SECRETKEY>";
    private static String GENERIC_S3_INPUT_BUCKET_NAME = "BUCKET_NAME";
    private static String GENERIC_S3_INPUT_PATH = "<INSERT_YOUR_PATH_TO_INPUT_FILE>";
    private static S3SignatureVersion GENERIC_S3_INPUT_SIGNATURE_VERSION = S3SignatureVersion.S3_V2;
    private static boolean GENERIC_S3_INPUT_SSL = false;

    private static String GENERIC_S3_OUTPUT_HOST = "<INSERT_YOUR_HOST>";
    private static String GENERIC_S3_OUTPUT_ACCESSKEY = "<INSERT_YOUR_ACCESSKEY>";
    private static String GENERIC_S3_OUTPUT_SECRET_KEY = "<INSERT_YOUR_SECRETKEY>";
    private static String GENERIC_S3_OUTPUT_BUCKET_NAME = "BUCKET_NAME";
    private static String OUTPUT_BASE_PATH = "path/to/your/outputs/" + new Date().getTime();
    private static S3SignatureVersion GENERIC_S3_OUTPUT_SIGNATURE_VERSION = S3SignatureVersion.S3_V2;
    private static boolean GENERIC_S3_OUTPUT_SSL = false;

    private static BitmovinApi bitmovinApi;

    @Test
    public void testEncoding() throws IOException, BitmovinApiException, UnirestException, URISyntaxException, RestException, InterruptedException
    {
        bitmovinApi = new BitmovinApi(API_KEY);
        Encoding encoding = new Encoding();
        encoding.setName("Encoding JAVA with Generic S3 Input/Output");
        encoding.setCloudRegion(CLOUD_REGION);
        encoding = bitmovinApi.encoding.create(encoding);

        GenericS3Input input = new GenericS3Input();
        input.setHost(GENERIC_S3_INPUT_HOST);
        input.setAccessKey(GENERIC_S3_INPUT_ACCESSKEY);
        input.setSecretKey(GENERIC_S3_INPUT_SECRET_KEY);
        input.setBucketName(GENERIC_S3_INPUT_BUCKET_NAME);
        input.setSignatureVersion(GENERIC_S3_INPUT_SIGNATURE_VERSION);
        input.setSsl(GENERIC_S3_INPUT_SSL);
        input = bitmovinApi.input.genericS3.create(input);

        GenericS3Output output = new GenericS3Output();
        output.setHost(GENERIC_S3_OUTPUT_HOST);
        output.setAccessKey(GENERIC_S3_OUTPUT_ACCESSKEY);
        output.setSecretKey(GENERIC_S3_OUTPUT_SECRET_KEY);
        output.setBucketName(GENERIC_S3_OUTPUT_BUCKET_NAME);
        output.setSignatureVersion(GENERIC_S3_OUTPUT_SIGNATURE_VERSION);
        output.setSsl(GENERIC_S3_OUTPUT_SSL);
        output = bitmovinApi.output.genericS3.create(output);

        AACAudioConfig aacConfiguration = new AACAudioConfig();
        aacConfiguration.setBitrate(128000L);
        aacConfiguration.setRate(48000f);
        aacConfiguration = bitmovinApi.configuration.audioAAC.create(aacConfiguration);

        // Add H264 configuration for encoding
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

        InputStream inputStreamVideo = new InputStream();
        inputStreamVideo.setInputPath(GENERIC_S3_INPUT_PATH);
        inputStreamVideo.setInputId(input.getId());
        inputStreamVideo.setSelectionMode(StreamSelectionMode.VIDEO_RELATIVE);
        inputStreamVideo.setPosition(0);

        InputStream inputStreamAudio = new InputStream();
        inputStreamAudio.setInputPath(GENERIC_S3_INPUT_PATH);
        inputStreamAudio.setInputId(input.getId());
        inputStreamAudio.setSelectionMode(StreamSelectionMode.AUDIO_RELATIVE);
        inputStreamAudio.setPosition(0);

        // Add streams and add the condition for every stream that the input height must be >= than the height for the specific representation
        Stream videoStream240p = new Stream();
        videoStream240p.setCodecConfigId(videoConfiguration240p.getId());
        videoStream240p.setInputStreams(Collections.singleton(inputStreamVideo));
        AndConjunction andConjunction240 = new AndConjunction();
        andConjunction240.setConditions(new ArrayList<AbstractCondition>() {{ new Condition(ConditionAttribute.HEIGHT, ">=", "240"); }});
        videoStream240p.setConditions(andConjunction240);
        videoStream240p = bitmovinApi.encoding.stream.addStream(encoding, videoStream240p);

        Stream videoStream360p = new Stream();
        videoStream360p.setCodecConfigId(videoConfiguration360p.getId());
        videoStream360p.setInputStreams(Collections.singleton(inputStreamVideo));
        AndConjunction andConjunction360 = new AndConjunction();
        andConjunction360.setConditions(new ArrayList<AbstractCondition>() {{ new Condition(ConditionAttribute.HEIGHT, ">=", "360"); }});
        videoStream360p.setConditions(andConjunction360);
        videoStream360p = bitmovinApi.encoding.stream.addStream(encoding, videoStream360p);

        Stream videoStream480p = new Stream();
        videoStream480p.setCodecConfigId(videoConfiguration480p.getId());
        videoStream480p.setInputStreams(Collections.singleton(inputStreamVideo));
        AndConjunction andConjunction480 = new AndConjunction();
        andConjunction480.setConditions(new ArrayList<AbstractCondition>() {{ new Condition(ConditionAttribute.HEIGHT, ">=", "480"); }});
        videoStream480p.setConditions(andConjunction480);
        videoStream480p = bitmovinApi.encoding.stream.addStream(encoding, videoStream480p);

        Stream videoStream720p = new Stream();
        videoStream720p.setCodecConfigId(videoConfiguration720p.getId());
        videoStream720p.setInputStreams(Collections.singleton(inputStreamVideo));
        AndConjunction andConjunction720 = new AndConjunction();
        andConjunction720.setConditions(new ArrayList<AbstractCondition>() {{ new Condition(ConditionAttribute.HEIGHT, ">=", "720"); }});
        videoStream720p.setConditions(andConjunction720);
        videoStream720p = bitmovinApi.encoding.stream.addStream(encoding, videoStream720p);

        Stream videoStream1080p = new Stream();
        videoStream1080p.setCodecConfigId(videoConfiguration1080p.getId());
        videoStream1080p.setInputStreams(Collections.singleton(inputStreamVideo));
        AndConjunction andConjunction1080 = new AndConjunction();
        andConjunction1080.setConditions(new ArrayList<AbstractCondition>() {{ new Condition(ConditionAttribute.HEIGHT, ">=", "1080"); }});
        videoStream1080p.setConditions(andConjunction1080);
        videoStream1080p = bitmovinApi.encoding.stream.addStream(encoding, videoStream1080p);

        Stream audioStream = new Stream();
        audioStream.setCodecConfigId(aacConfiguration.getId());
        audioStream.setInputStreams(Collections.singleton(inputStreamAudio));
        audioStream = bitmovinApi.encoding.stream.addStream(encoding, audioStream);

        FMP4Muxing muxingFmp4_240p = this.createFMP4Muxing(encoding, output, "/video/dash/240p/", videoStream240p);
        FMP4Muxing muxingFmp4_360p = this.createFMP4Muxing(encoding, output, "/video/dash/360p/", videoStream360p);
        FMP4Muxing muxingFmp4_480p = this.createFMP4Muxing(encoding, output, "/video/dash/480p/", videoStream480p);
        FMP4Muxing muxingFmp4_720p = this.createFMP4Muxing(encoding, output, "/video/dash/720p/", videoStream720p);
        FMP4Muxing muxingFmp4_1080p = this.createFMP4Muxing(encoding, output, "/video/dash/1080p/", videoStream1080p);
        FMP4Muxing muxingFmp4_Audio = this.createFMP4Muxing(encoding, output, "/audio/dash/", audioStream);

        TSMuxing muxingTS_240p = this.createTSMuxing(encoding, output, "/video/hls/240p/", videoStream240p);
        TSMuxing muxingTS_360p = this.createTSMuxing(encoding, output, "/video/hls/360p/", videoStream360p);
        TSMuxing muxingTS_480p = this.createTSMuxing(encoding, output, "/video/hls/480p/", videoStream480p);
        TSMuxing muxingTS_720p = this.createTSMuxing(encoding, output, "/video/hls/720p/", videoStream720p);
        TSMuxing muxingTS_1080p = this.createTSMuxing(encoding, output, "/video/hls/1080p/", videoStream1080p);
        TSMuxing muxingTS_Audio = this.createTSMuxing(encoding, output, "/audio/hls/", audioStream);

        // Create the thumbnail at position 10%, 20% and 30% of the input file
        EncodingOutput thumbnailOutput = new EncodingOutput();
        thumbnailOutput.setOutputId(output.getId());
        thumbnailOutput.setOutputPath(OUTPUT_BASE_PATH + "/thumbnails");
        thumbnailOutput.setAcl(new ArrayList<AclEntry>()
        {{
            this.add(new AclEntry(AclPermission.PUBLIC_READ));
        }});
        Thumbnail thumbnail = new Thumbnail();
        thumbnail.setHeight(360);
        thumbnail.setOutputs(Collections.singleton(thumbnailOutput));
        thumbnail.setUnit(ThumbnailUnit.PERCENTS);
        Set<Double> thumbnailPositions = new HashSet<>();
        thumbnailPositions.add(10.0);
        thumbnailPositions.add(20.0);
        thumbnailPositions.add(30.0);
        thumbnail.setPositions(thumbnailPositions);
        thumbnail.setPattern("thumbnail_%number%.jpg");
        bitmovinApi.encoding.thumbnail.create(encoding, videoStream240p, thumbnail);

        // Create the sprite with an image every 10 seconds
        EncodingOutput spriteOutput = new EncodingOutput();
        spriteOutput.setOutputId(output.getId());
        spriteOutput.setOutputPath(OUTPUT_BASE_PATH + "/sprites");
        spriteOutput.setAcl(new ArrayList<AclEntry>()
        {{
            this.add(new AclEntry(AclPermission.PUBLIC_READ));
        }});
        Sprite sprite = new Sprite();
        sprite.setDistance(10.0);
        sprite.setWidth(640);
        sprite.setHeight(360);
        sprite.setOutputs(Collections.singleton(spriteOutput));
        sprite.setSpriteName("sprite.jpg");
        sprite.setVttName("sprite.vtt");
        bitmovinApi.encoding.sprite.create(encoding, videoStream360p, sprite);


        bitmovinApi.encoding.start(encoding);

        Task status = bitmovinApi.encoding.getStatus(encoding);
        while (status.getStatus() != Status.FINISHED && status.getStatus() != Status.ERROR)
        {
            status = bitmovinApi.encoding.getStatus(encoding);
            Thread.sleep(2500);
        }

        System.out.println(String.format("Encoding finished with status %s", status.getStatus().toString()));

        Assert.assertEquals(Status.FINISHED, status.getStatus());
        EncodingOutput manifestOutput = new EncodingOutput();
        manifestOutput.setOutputId(output.getId());
        manifestOutput.setOutputPath(OUTPUT_BASE_PATH);
        manifestOutput.setAcl(new ArrayList<AclEntry>()
        {{
            this.add(new AclEntry(AclPermission.PUBLIC_READ));
        }});

        // Create DASH manifest
        DashManifest dashManifest = new DashManifest();
        dashManifest.setName("stream.mpd");
        dashManifest.setOutputs(Collections.singletonList(manifestOutput));
        dashManifest = bitmovinApi.manifest.dash.create(dashManifest);
        Period period = bitmovinApi.manifest.dash.createPeriod(dashManifest, new Period());
        VideoAdaptationSet videoAdaptationSet = bitmovinApi.manifest.dash.addVideoAdaptationSetToPeriod(dashManifest, period, new VideoAdaptationSet());
        AudioAdaptationSet audioAdaptationSet = new AudioAdaptationSet();
        audioAdaptationSet.setLang("en");
        audioAdaptationSet = bitmovinApi.manifest.dash.addAudioAdaptationSetToPeriod(dashManifest, period, audioAdaptationSet);

        this.addDashRepresentationToAdaptationSet(DashMuxingType.TEMPLATE, encoding.getId(),
                audioStream.getId(), muxingFmp4_Audio.getId(), "audio/dash", dashManifest, period, audioAdaptationSet);

        this.addDashRepresentationToAdaptationSet(DashMuxingType.TEMPLATE, encoding.getId(),
                videoStream240p.getId(), muxingFmp4_240p.getId(), "video/dash/240p", dashManifest, period, videoAdaptationSet);
        this.addDashRepresentationToAdaptationSet(DashMuxingType.TEMPLATE, encoding.getId(),
                videoStream360p.getId(), muxingFmp4_360p.getId(), "video/dash/360p", dashManifest, period, videoAdaptationSet);
        this.addDashRepresentationToAdaptationSet(DashMuxingType.TEMPLATE, encoding.getId(),
                videoStream480p.getId(), muxingFmp4_480p.getId(), "video/dash/480p", dashManifest, period, videoAdaptationSet);
        this.addDashRepresentationToAdaptationSet(DashMuxingType.TEMPLATE, encoding.getId(),
                videoStream720p.getId(), muxingFmp4_720p.getId(), "video/dash/720p", dashManifest, period, videoAdaptationSet);
        this.addDashRepresentationToAdaptationSet(DashMuxingType.TEMPLATE, encoding.getId(),
                videoStream1080p.getId(), muxingFmp4_1080p.getId(), "video/dash/1080p", dashManifest, period, videoAdaptationSet);

        bitmovinApi.manifest.dash.startGeneration(dashManifest);

        Status dashStatus = bitmovinApi.manifest.dash.getGenerationStatus(dashManifest);
        while (dashStatus != Status.FINISHED && dashStatus != Status.ERROR)
        {
            dashStatus = bitmovinApi.manifest.dash.getGenerationStatus(dashManifest);
            Thread.sleep(2500);
        }

        System.out.println(String.format("DASH Manifest generation finished with status %s", dashStatus.toString()));
        Assert.assertEquals(Status.FINISHED, dashStatus);

        // Create HLS Manifest
        HlsManifest hlsManifest = new HlsManifest();
        hlsManifest.setName("stream.m3u8");
        hlsManifest.setOutputs(Collections.singletonList(manifestOutput));
        hlsManifest = bitmovinApi.manifest.hls.create(hlsManifest);

        MediaInfo audioMediaInfo = new MediaInfo();
        audioMediaInfo.setGroupId("audio");
        audioMediaInfo.setName("audio.m3u8");
        audioMediaInfo.setUri("audio.m3u8");
        audioMediaInfo.setType(MediaInfoType.AUDIO);
        audioMediaInfo.setEncodingId(encoding.getId());
        audioMediaInfo.setStreamId(audioStream.getId());
        audioMediaInfo.setMuxingId(muxingTS_Audio.getId());
        audioMediaInfo.setLanguage("en");
        audioMediaInfo.setAssocLanguage("en");
        audioMediaInfo.setAutoselect(true);
        audioMediaInfo.setIsDefault(true);
        audioMediaInfo.setForced(false);
        audioMediaInfo.addCharacteristic("public.accessibility.describes-audio");
        audioMediaInfo.setSegmentPath("audio/hls/");
        audioMediaInfo = bitmovinApi.manifest.hls.createMediaInfo(hlsManifest, audioMediaInfo);

        this.addStreamInfo("video_240.m3u8", encoding.getId(), videoStream240p.getId(), muxingTS_240p.getId(), audioMediaInfo.getGroupId(), "video/hls/240p/", hlsManifest);
        this.addStreamInfo("video_360.m3u8", encoding.getId(), videoStream360p.getId(), muxingTS_360p.getId(), audioMediaInfo.getGroupId(), "video/hls/360p/", hlsManifest);
        this.addStreamInfo("video_480.m3u8", encoding.getId(), videoStream480p.getId(), muxingTS_480p.getId(), audioMediaInfo.getGroupId(), "video/hls/480p/", hlsManifest);
        this.addStreamInfo("video_720.m3u8", encoding.getId(), videoStream720p.getId(), muxingTS_720p.getId(), audioMediaInfo.getGroupId(), "video/hls/720p/", hlsManifest);
        this.addStreamInfo("video_1080.m3u8", encoding.getId(), videoStream1080p.getId(), muxingTS_1080p.getId(), audioMediaInfo.getGroupId(), "video/hls/1080p/", hlsManifest);

        bitmovinApi.manifest.hls.startGeneration(hlsManifest);

        Status hlsStatus = bitmovinApi.manifest.hls.getGenerationStatus(hlsManifest);
        while (hlsStatus != Status.FINISHED && hlsStatus != Status.ERROR)
        {
            hlsStatus = bitmovinApi.manifest.hls.getGenerationStatus(hlsManifest);
            Thread.sleep(2500);
        }

        System.out.println(String.format("HLS Manifest generation finished with status %s", hlsStatus.toString()));
        Assert.assertEquals(Status.FINISHED, hlsStatus);

    }

    private void addDashRepresentationToAdaptationSet(DashMuxingType type, String encodingId, String streamId,
                                                      String muxingId, String segmentPath, DashManifest manifest,
                                                      Period period, AdaptationSet adaptationSet) throws BitmovinApiException, URISyntaxException, RestException, UnirestException, IOException
    {
        DashFmp4Representation r = new DashFmp4Representation();
        r.setType(type);
        r.setEncodingId(encodingId);
        r.setStreamId(streamId);
        r.setMuxingId(muxingId);
        r.setSegmentPath(segmentPath);
        bitmovinApi.manifest.dash.addRepresentationToAdaptationSet(manifest, period, adaptationSet, r);
    }

    private void addStreamInfo(String uri, String encodingId, String streamId, String muxingId, String audioGroupId, String segmentPath, HlsManifest manifest)
            throws URISyntaxException, BitmovinApiException, RestException, UnirestException, IOException
    {
        StreamInfo s = new StreamInfo();
        s.setUri(uri);
        s.setEncodingId(encodingId);
        s.setStreamId(streamId);
        s.setMuxingId(muxingId);
        s.setAudio(audioGroupId);
        s.setSegmentPath(segmentPath);
        bitmovinApi.manifest.hls.createStreamInfo(manifest, s);
    }

    private FMP4Muxing createFMP4Muxing(Encoding encoding, Output output, String path, Stream videoStream) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        EncodingOutput encodingOutput = new EncodingOutput();
        encodingOutput.setOutputId(output.getId());
        encodingOutput.setOutputPath(OUTPUT_BASE_PATH + path);
        encodingOutput.setAcl(new ArrayList<AclEntry>()
        {{
            this.add(new AclEntry(AclPermission.PUBLIC_READ));
        }});
        FMP4Muxing fmp4Muxing = new FMP4Muxing();
        fmp4Muxing.setSegmentLength(4.0);
        fmp4Muxing.setOutputs(Collections.singletonList(encodingOutput));
        List<MuxingStream> muxingStreams = new ArrayList<>();
        MuxingStream muxingStreamVideo = new MuxingStream();
        muxingStreamVideo.setStreamId(videoStream.getId());
        muxingStreams.add(muxingStreamVideo);
        fmp4Muxing.setStreams(muxingStreams);
        return bitmovinApi.encoding.muxing.addFmp4MuxingToEncoding(encoding, fmp4Muxing);
    }

    private TSMuxing createTSMuxing(Encoding encoding, Output output, String path, Stream videoStream) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        EncodingOutput encodingOutput = new EncodingOutput();
        encodingOutput.setOutputId(output.getId());
        encodingOutput.setOutputPath(OUTPUT_BASE_PATH + path);
        encodingOutput.setAcl(new ArrayList<AclEntry>()
        {{
            this.add(new AclEntry(AclPermission.PUBLIC_READ));
        }});
        TSMuxing tsMuxing = new TSMuxing();
        tsMuxing.setSegmentLength(4.0);
        tsMuxing.setOutputs(Collections.singletonList(encodingOutput));
        List<MuxingStream> muxingStreams = new ArrayList<>();
        MuxingStream muxingStreamVideo = new MuxingStream();
        muxingStreamVideo.setStreamId(videoStream.getId());
        muxingStreams.add(muxingStreamVideo);
        tsMuxing.setStreams(muxingStreams);
        return bitmovinApi.encoding.muxing.addTSMuxingToEncoding(encoding, tsMuxing);
    }

}
