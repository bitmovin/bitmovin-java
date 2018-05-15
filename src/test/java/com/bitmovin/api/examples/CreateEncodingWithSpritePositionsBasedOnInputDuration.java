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
import com.bitmovin.api.encoding.encodings.conditions.AbstractCondition;
import com.bitmovin.api.encoding.encodings.conditions.AndConjunction;
import com.bitmovin.api.encoding.encodings.conditions.Condition;
import com.bitmovin.api.encoding.encodings.conditions.ConditionAttribute;
import com.bitmovin.api.encoding.encodings.muxing.FMP4Muxing;
import com.bitmovin.api.encoding.encodings.muxing.MuxingStream;
import com.bitmovin.api.encoding.encodings.muxing.TSMuxing;
import com.bitmovin.api.encoding.encodings.streams.Stream;
import com.bitmovin.api.encoding.encodings.thumbnails.Sprite;
import com.bitmovin.api.encoding.enums.CloudRegion;
import com.bitmovin.api.encoding.enums.DashMuxingType;
import com.bitmovin.api.encoding.enums.StreamSelectionMode;
import com.bitmovin.api.encoding.inputs.HttpsInput;
import com.bitmovin.api.encoding.manifest.dash.AdaptationSet;
import com.bitmovin.api.encoding.manifest.dash.AudioAdaptationSet;
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
import com.bitmovin.api.examples.util.MultiStreamRepresentation;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.http.RestException;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CreateEncodingWithSpritePositionsBasedOnInputDuration
{
    private static String ApiKey = "<INSERT YOUR API KEY>";

    private static CloudRegion cloudRegion = CloudRegion.AWS_EU_WEST_1;
    private static String HTTPS_INPUT_HOST = "input.host.com";
    private static String HTTPS_INPUT_PATH = "path/to/your/input/file.mkv";

    private static String S3_OUTPUT_ACCESSKEY = "<YOUR S3 OUTPUT ACCESS KEY>";
    private static String S3_OUTPUT_SECRET_KEY = "<YOUR S3 OUTPUT SECRET KEY>";
    private static String S3_OUTPUT_BUCKET_NAME = "<YOUR OUTPUT BUCKET>";
    private static String OUTPUT_BASE_PATH = "/your/output/base/path";

    private List<MultiStreamRepresentation> representations = Arrays.asList(
            new MultiStreamRepresentation(426, null, null, 400000L , ProfileH264.HIGH, OUTPUT_BASE_PATH, "video/400kbps"),
            new MultiStreamRepresentation(640, null, null, 800000L, ProfileH264.HIGH, OUTPUT_BASE_PATH, "video/800kbps"),
            new MultiStreamRepresentation(852, null, null, 1200000L, ProfileH264.HIGH, OUTPUT_BASE_PATH, "video/1200kbps"),
            new MultiStreamRepresentation(1280, null, null, 2400000L, ProfileH264.HIGH, OUTPUT_BASE_PATH, "video/2400kbps"),
            new MultiStreamRepresentation(1920, null, null, 4800000L, ProfileH264.HIGH, OUTPUT_BASE_PATH, "video/4800kbps")
    );

    private static BitmovinApi bitmovinApi;

    @Test
    public void testEncoding() throws IOException, BitmovinApiException, UnirestException, URISyntaxException, RestException, InterruptedException
    {
        bitmovinApi = new BitmovinApi(ApiKey);

        Encoding encoding = new Encoding();
        encoding.setName("Encoding sprites based on input duration");
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

        for (MultiStreamRepresentation representation : representations)
        {
            H264VideoConfiguration videoConfiguration = new H264VideoConfiguration();
            videoConfiguration.setHeight(representation.getHeight());
            videoConfiguration.setWidth(representation.getWidth());
            videoConfiguration.setBitrate(representation.getBitrate());
            videoConfiguration.setRate(representation.getRate());
            videoConfiguration.setProfile(ProfileH264.HIGH);
            videoConfiguration = bitmovinApi.configuration.videoH264.create(videoConfiguration);

            representation.setConfiguration(videoConfiguration);
        }

        InputStream inputStreamAudio = new InputStream();
        inputStreamAudio.setInputPath(HTTPS_INPUT_PATH);
        inputStreamAudio.setInputId(input.getId());
        inputStreamAudio.setSelectionMode(StreamSelectionMode.AUTO);
        inputStreamAudio.setPosition(0);

        Stream audioStream = new Stream();
        audioStream.setCodecConfigId(aacConfiguration.getId());
        audioStream.setInputStreams(Collections.singleton(inputStreamAudio));
        audioStream = bitmovinApi.encoding.stream.addStream(encoding, audioStream);

        InputStream inputStreamVideo = new InputStream();
        inputStreamVideo.setInputPath(HTTPS_INPUT_PATH);
        inputStreamVideo.setInputId(input.getId());
        inputStreamVideo.setSelectionMode(StreamSelectionMode.AUTO);
        inputStreamVideo.setPosition(0);

        /*
        Add encoding stream and conditional sprite streams to encoding
         */
        EncodingOutput spriteOutput = new EncodingOutput();
        spriteOutput.setOutputId(output.getId());
        spriteOutput.setOutputPath(OUTPUT_BASE_PATH + "/sprites/");
        spriteOutput.setAcl(Collections.singletonList(new AclEntry(AclPermission.PUBLIC_READ)));

        for (MultiStreamRepresentation representation : representations)
        {
            /*
            0 to 30 seconds
             */
            Stream spriteStream0To30s = new Stream();
            spriteStream0To30s.setCodecConfigId(representation.getConfiguration().getId());
            spriteStream0To30s.setInputStreams(Collections.singleton(inputStreamVideo));

            AndConjunction andConjunction = new AndConjunction();
            andConjunction.setConditions(new ArrayList<AbstractCondition>()
            {{
                add(new Condition(ConditionAttribute.DURATION, "<=", "30"));
            }});
            spriteStream0To30s.setConditions(andConjunction);

            spriteStream0To30s = bitmovinApi.encoding.stream.addStream(encoding, spriteStream0To30s);
            bitmovinApi.encoding.sprite.create(encoding, spriteStream0To30s, new Sprite(
                    240,
                    320,
                    1.0D,
                    "mySprite.jpeg",
                    "mySprite.vtt",
                    Collections.singleton(spriteOutput)
            ));

            /*
            30 seconds to 60 seconds (1min)
             */
            Stream spriteStream30To60s = new Stream();
            spriteStream30To60s.setCodecConfigId(representation.getConfiguration().getId());
            spriteStream30To60s.setInputStreams(Collections.singleton(inputStreamVideo));

            andConjunction.setConditions(new ArrayList<AbstractCondition>() {{
                add(new Condition(ConditionAttribute.DURATION, ">", "30"));
                add(new Condition(ConditionAttribute.DURATION, "<=", "60"));
            }});
            spriteStream30To60s.setConditions(andConjunction);
            spriteStream30To60s = bitmovinApi.encoding.stream.addStream(encoding, spriteStream30To60s);
            bitmovinApi.encoding.sprite.create(encoding, spriteStream30To60s, new Sprite(
                            240,
                            320,
                            2.0D,
                            "mySprite.jpeg",
                            "mySprite.vtt",
                            Collections.singleton(spriteOutput)
                    )
            );

            /*
            60 seconds (1min) to 120 seconds (2min)
             */
            Stream spriteStream60To120s = new Stream();
            spriteStream60To120s.setCodecConfigId(representation.getConfiguration().getId());
            spriteStream60To120s.setInputStreams(Collections.singleton(inputStreamVideo));

            andConjunction.setConditions(new ArrayList<AbstractCondition>() {{
                add(new Condition(ConditionAttribute.DURATION, ">", "60"));
                add(new Condition(ConditionAttribute.DURATION, "<=", "120"));
            }});
            spriteStream60To120s.setConditions(andConjunction);

            spriteStream60To120s = bitmovinApi.encoding.stream.addStream(encoding, spriteStream60To120s);
            bitmovinApi.encoding.sprite.create(encoding, spriteStream60To120s, new Sprite(
                            240,
                            320,
                            4.0D,
                            "mySprite.jpeg",
                            "mySprite.vtt",
                            Collections.singleton(spriteOutput)
                    )
            );

            /*
            120 seconds(2min) to 1800 seconds (30min)
             */
            Stream spriteStream120To1800s = new Stream();
            spriteStream120To1800s.setCodecConfigId(representation.getConfiguration().getId());
            spriteStream120To1800s.setInputStreams(Collections.singleton(inputStreamVideo));

            andConjunction.setConditions(new ArrayList<AbstractCondition>() {{
                add(new Condition(ConditionAttribute.DURATION, ">", "120"));
                add(new Condition(ConditionAttribute.DURATION, "<=", "1800"));
            }});
            spriteStream120To1800s.setConditions(andConjunction);
            spriteStream120To1800s = bitmovinApi.encoding.stream.addStream(encoding, spriteStream120To1800s);
            bitmovinApi.encoding.sprite.create(encoding, spriteStream120To1800s, new Sprite(
                    240,
                    320,
                    10.0D,
                    "mySprite.jpeg",
                    "mySprite.vtt",
                    Collections.singleton(spriteOutput)
            ));

            representation.setStreams(
                    Arrays.asList(
                            spriteStream0To30s,
                            spriteStream30To60s,
                            spriteStream60To120s,
                            spriteStream120To1800s
                    )
            );
        }

        EncodingOutput encodingOutput = new EncodingOutput();
        encodingOutput.setOutputId(output.getId());
        encodingOutput.setOutputPath(OUTPUT_BASE_PATH);

        /*
         * Create fmp4 muxings
         */
        for (MultiStreamRepresentation representation : representations)
        {
            for (Stream stream : representation.getStreams())
            {
                FMP4Muxing muxing = this.createFMP4Muxing(
                        encoding,
                        stream,
                        output,
                        representation.getOutputBasePath() + "/" + representation.getRelativeOutputPath() + "_dash",
                        AclPermission.PUBLIC_READ
                );

                representation.addFmp4Muxing(stream.getId(), muxing);
            }
        }
        FMP4Muxing audioFmp4Muxing = this.createFMP4Muxing(encoding, audioStream, output, OUTPUT_BASE_PATH + "/audio/128kbps_dash", AclPermission.PUBLIC_READ);

        for (MultiStreamRepresentation representation : representations)
        {
            for (Stream stream : representation.getStreams())
            {
                TSMuxing tsMuxing = this.createTSMuxing(
                        encoding,
                        stream,
                        output,
                        representation.getOutputBasePath() + "/" + representation.getRelativeOutputPath() + "_hls",
                        AclPermission.PUBLIC_READ
                );

                representation.addTsMuxing(stream.getId(), tsMuxing);
            }
        }
        TSMuxing audioTsMuxing = this.createTSMuxing(encoding, audioStream, output, OUTPUT_BASE_PATH + "/audio/128kbps_hls", AclPermission.PUBLIC_READ);

        System.out.println(String.format("Starting Encoding with id %s", encoding.getId()));
        bitmovinApi.encoding.start(encoding);
        System.out.println("Waiting for Encoding to finish...");

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
            return;
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

        for (MultiStreamRepresentation representation : representations)
        {
            for (Stream stream : representation.getStreams())
            {
                this.addDashRepresentationToAdaptationSet(
                        DashMuxingType.TEMPLATE,
                        encoding.getId(),
                        representation.getFmp4MuxingIdFromStreamId(stream.getId()),
                        representation.getRelativeOutputPath() + "_dash",
                        manifest,
                        period,
                        videoAdaptationSet
                );
            }

        }
        this.addDashRepresentationToAdaptationSet(
                DashMuxingType.TEMPLATE,
                encoding.getId(),
                audioFmp4Muxing.getId(),
                "audio/128kbps_dash",
                manifest,
                period,
                audioAdaptationSet
        );

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
            return;
        }
        System.out.println("Creating HLS manifest");

        HlsManifest manifestHls = this.createHlsManifest("manifest.m3u8", manifestDestination);

        MediaInfo audioMediaInfo = new MediaInfo();
        audioMediaInfo.setName("audio");
        audioMediaInfo.setUri("audio.m3u8");
        audioMediaInfo.setGroupId("audio");
        audioMediaInfo.setType(MediaInfoType.AUDIO);
        audioMediaInfo.setEncodingId(encoding.getId());
        audioMediaInfo.setStreamId(audioStream.getId());
        audioMediaInfo.setMuxingId(audioTsMuxing.getId());
        audioMediaInfo.setLanguage("en");
        audioMediaInfo.setAssocLanguage("en");
        audioMediaInfo.setAutoselect(false);
        audioMediaInfo.setIsDefault(false);
        audioMediaInfo.setForced(false);
        audioMediaInfo.setSegmentPath("audio/128kbps_hls");
        bitmovinApi.manifest.hls.createMediaInfo(manifestHls, audioMediaInfo);

        for (MultiStreamRepresentation representation : representations)
        {
            for (Stream stream : representation.getStreams())
            {
                this.addStreamInfoToHlsManifest(
                        "video_" + representation.getBitrate() + ".m3u8",
                        encoding.getId(),
                        stream.getId(),
                        representation.getTsMuxingIdFromStreamId(stream.getId()),
                        "audio",
                        representation.getRelativeOutputPath() + "_hls",
                        manifestHls
                );
            }
        }

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
            return;
        }
        System.out.println("Encoding completed successfully");

    }

    private StreamInfo addStreamInfoToHlsManifest(String uri,
                                                  String encodingId,
                                                  String streamId,
                                                  String muxingId,
                                                  String audioGroupId,
                                                  String segmentPath,
                                                  HlsManifest manifest) throws URISyntaxException, BitmovinApiException, RestException, UnirestException, IOException
    {
        StreamInfo s = new StreamInfo();
        s.setUri(uri);
        s.setEncodingId(encodingId);
        s.setStreamId(streamId);
        s.setMuxingId(muxingId);
        s.setAudio(audioGroupId);
        s.setSegmentPath(segmentPath);
        s = bitmovinApi.manifest.hls.createStreamInfo(manifest, s);
        return s;
    }

    private HlsManifest createHlsManifest(String name, EncodingOutput output) throws URISyntaxException, BitmovinApiException, UnirestException, IOException
    {
        HlsManifest m = new HlsManifest();
        m.setName(name);
        m.addOutput(output);
        return bitmovinApi.manifest.hls.create(m);
    }

    private void addDashRepresentationToAdaptationSet(DashMuxingType type,
                                                      String encodingId,
                                                      String muxingId,
                                                      String segmentPath,
                                                      DashManifest manifest,
                                                      Period period,
                                                      AdaptationSet adaptationSet) throws BitmovinApiException, URISyntaxException, RestException, UnirestException, IOException
    {
        DashFmp4Representation r = new DashFmp4Representation();
        r.setType(type);
        r.setEncodingId(encodingId);
        r.setMuxingId(muxingId);
        r.setSegmentPath(segmentPath);
        bitmovinApi.manifest.dash.addRepresentationToAdaptationSet(manifest, period, adaptationSet, r);
    }

    private AudioAdaptationSet addAudioAdaptationSetToPeriodWithRoles(DashManifest manifest,
                                                                      Period period,
                                                                      String lang) throws URISyntaxException, BitmovinApiException, RestException, UnirestException, IOException
    {
        AudioAdaptationSet a = new AudioAdaptationSet();
        a.setLang(lang);
        a = bitmovinApi.manifest.dash.addAudioAdaptationSetToPeriod(manifest, period, a);
        return a;
    }

    private VideoAdaptationSet addVideoAdaptationSetToPeriod(DashManifest manifest, Period period) throws URISyntaxException, BitmovinApiException, RestException, UnirestException, IOException
    {
        VideoAdaptationSet adaptationSet = new VideoAdaptationSet();
        adaptationSet = bitmovinApi.manifest.dash.addVideoAdaptationSetToPeriod(manifest, period, adaptationSet);
        return adaptationSet;
    }

    private DashManifest createDashManifest(String name, EncodingOutput output) throws URISyntaxException, BitmovinApiException, UnirestException, IOException
    {
        DashManifest manifest = new DashManifest();
        manifest.setName(name);
        manifest.addOutput(output);
        manifest = bitmovinApi.manifest.dash.create(manifest);
        return manifest;
    }

    private Period addPeriodToDashManifest(DashManifest manifest) throws URISyntaxException, BitmovinApiException, RestException, UnirestException, IOException
    {
        Period period = new Period();
        period = bitmovinApi.manifest.dash.createPeriod(manifest, period);
        return period;
    }

    private EncodingOutput createEncodingOutput(Output output, String outputPath, AclPermission defaultAclPermission)
    {
        EncodingOutput encodingOutput = new EncodingOutput();
        encodingOutput.setOutputPath(outputPath);
        encodingOutput.setOutputId(output.getId());

        if (output.getAcl() != null && output.getAcl().size() > 0)
        {
            encodingOutput.setAcl(output.getAcl());
        }
        else
        {
            ArrayList<AclEntry> aclEntries = new ArrayList<>();
            aclEntries.add(new AclEntry(defaultAclPermission));
            encodingOutput.setAcl(aclEntries);
        }

        return encodingOutput;
    }

    private FMP4Muxing createFMP4Muxing(Encoding encoding,
                                        Stream stream,
                                        Output output,
                                        String outputPath,
                                        AclPermission defaultAclPermission) throws URISyntaxException, BitmovinApiException, RestException, UnirestException, IOException
    {
        EncodingOutput encodingOutput = this.createEncodingOutput(output, outputPath, defaultAclPermission);
        FMP4Muxing muxing = new FMP4Muxing();
        muxing.addOutput(encodingOutput);
        MuxingStream list = new MuxingStream();
        list.setStreamId(stream.getId());
        muxing.addStream(list);
        muxing.setSegmentLength(4.0);
        muxing = bitmovinApi.encoding.muxing.addFmp4MuxingToEncoding(encoding, muxing);
        return muxing;
    }

    private TSMuxing createTSMuxing(Encoding encoding,
                                    Stream stream,
                                    Output output,
                                    String outputPath,
                                    AclPermission defaultAclPermission) throws URISyntaxException, BitmovinApiException, RestException, UnirestException, IOException
    {
        EncodingOutput encodingOutput = this.createEncodingOutput(output, outputPath, defaultAclPermission);
        TSMuxing muxing = new TSMuxing();
        muxing.addOutput(encodingOutput);
        MuxingStream list = new MuxingStream();
        list.setStreamId(stream.getId());
        muxing.addStream(list);
        muxing.setSegmentLength(4.0);
        muxing = bitmovinApi.encoding.muxing.addTSMuxingToEncoding(encoding, muxing);
        return muxing;
    }
}
