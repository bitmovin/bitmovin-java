package com.bitmovin.api.examples;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.bitmovin.api.AbstractApiResponse;
import com.bitmovin.api.BitmovinApi;
import com.bitmovin.api.encoding.AclEntry;
import com.bitmovin.api.encoding.AclPermission;
import com.bitmovin.api.encoding.EncodingOutput;
import com.bitmovin.api.encoding.InputStream;
import com.bitmovin.api.encoding.codecConfigurations.AACAudioConfig;
import com.bitmovin.api.encoding.codecConfigurations.H264VideoConfiguration;
import com.bitmovin.api.encoding.codecConfigurations.VideoConfiguration;
import com.bitmovin.api.encoding.codecConfigurations.enums.ConfigType;
import com.bitmovin.api.encoding.codecConfigurations.enums.ProfileH264;
import com.bitmovin.api.encoding.encodings.Encoding;
import com.bitmovin.api.encoding.encodings.muxing.FMP4Muxing;
import com.bitmovin.api.encoding.encodings.muxing.Muxing;
import com.bitmovin.api.encoding.encodings.muxing.MuxingStream;
import com.bitmovin.api.encoding.encodings.muxing.TSMuxing;
import com.bitmovin.api.encoding.encodings.muxing.enums.MuxingType;
import com.bitmovin.api.encoding.encodings.streams.Stream;
import com.bitmovin.api.encoding.enums.CloudRegion;
import com.bitmovin.api.encoding.enums.DashMuxingType;
import com.bitmovin.api.encoding.enums.StreamSelectionMode;
import com.bitmovin.api.encoding.inputs.S3Input;
import com.bitmovin.api.encoding.manifest.Manifest;
import com.bitmovin.api.encoding.manifest.dash.AdaptationSet;
import com.bitmovin.api.encoding.manifest.dash.AudioAdaptationSet;
import com.bitmovin.api.encoding.manifest.dash.DashFmp4Representation;
import com.bitmovin.api.encoding.manifest.dash.DashManifest;
import com.bitmovin.api.encoding.manifest.dash.DashSegmentedRepresentation;
import com.bitmovin.api.encoding.manifest.dash.Period;
import com.bitmovin.api.encoding.manifest.dash.VideoAdaptationSet;
import com.bitmovin.api.encoding.manifest.hls.HlsManifest;
import com.bitmovin.api.encoding.manifest.hls.MediaInfo;
import com.bitmovin.api.encoding.manifest.hls.MediaInfoType;
import com.bitmovin.api.encoding.manifest.hls.StreamInfo;
import com.bitmovin.api.encoding.manifest.smooth.SmoothStreamingManifest;
import com.bitmovin.api.encoding.outputs.AkamaiNetStorageOutput;
import com.bitmovin.api.encoding.outputs.Output;
import com.bitmovin.api.encoding.status.Task;
import com.bitmovin.api.enums.Status;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.http.RestException;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Created by Germano Fronza on 08.01.18.
 *
 */
public class CreateEncodingWithS3InputAndAkamaiNetStorageOutput
{
    private static String S3_INPUT_ACCESSKEY = "<INSERT_YOUR_ACCESS_KEY>";
    private static String S3_INPUT_SECRET_KEY = "<INSERT_YOUR_ACCESS_KEY>";
    private static String S3_INPUT_BUCKET_NAME = "<INSERT_YOUR_BUCKET_NAME>";
    private static String S3_INPUT_PATH = "path/to/input.mp4";

    private static String AKAMAI_NETSTORAGE_HOST = "<INSERT_YOUR_AKAMAI_NETSTORAGE_HOST>";
    private static String AKAMAI_NETSTORAGE_USERNAME = "<INSERT_YOUR_AKAMAI_NETSTORAGE_USERNAME>";
    private static String AKAMAI_NETSTORAGE_PASSWORD = "<INSERT_YOUR_AKAMAI_NETSTORAGE_PASSWORD>";
    private static String OUTPUT_BASE_PATH = "path/to/output/";

    private static final String API_KEY = "<INSERT_YOUR_API_KEY>";
    private static final CloudRegion CLOUD_REGION = CloudRegion.AWS_EU_WEST_1;

    private static final double MUXING_SEGMENT_DURATION = 4.0;

    // please set here the encoding profiles. You can modify height, width, bitrate and fps.
    private static final VideoProfile[] VIDEO_ENCODING_PROFILES = new VideoProfile[]
    {
            new H264VideoProfile(640, 360, 1200, 30.0f, ProfileH264.MAIN),
            new H264VideoProfile(854, 480, 1750, 30.0f, ProfileH264.MAIN),
            new H264VideoProfile(1280, 720, 2350, 30.0f, ProfileH264.MAIN),
    };

    // please set here the encoding profiles. You can modify bitrate and rate.
    private static final AACAudioProfile[] AUDIO_ENCODING_PROFILES = new AACAudioProfile[]
    {
            new AACAudioProfile(128, 48000f, "en"),
    };

    // please set set here the manifests to be generated.
    private static final ManifestType[] MANIFESTS = new ManifestType[]
    {
            ManifestType.DASH,
            ManifestType.HLS,
    };

    private static BitmovinApi bitmovinApi;

    @Test
    public void testCreateMultiCodecEncoding() throws IOException, BitmovinApiException, UnirestException,
            URISyntaxException, RestException, InterruptedException
    {
        bitmovinApi = new BitmovinApi(API_KEY);

        Encoding encoding = new Encoding();
        encoding.setName("Java Akamai NetStorage Output example");
        encoding.setCloudRegion(CLOUD_REGION);
        encoding = bitmovinApi.encoding.create(encoding);

        S3Input input = new S3Input();
        input.setAccessKey(S3_INPUT_ACCESSKEY);
        input.setSecretKey(S3_INPUT_SECRET_KEY);
        input.setBucketName(S3_INPUT_BUCKET_NAME);
        input = bitmovinApi.input.s3.create(input);

        AkamaiNetStorageOutput output = new AkamaiNetStorageOutput();
        output.setHost(AKAMAI_NETSTORAGE_HOST);
        output.setUsername(AKAMAI_NETSTORAGE_USERNAME);
        output.setPassword(AKAMAI_NETSTORAGE_PASSWORD);
        output = bitmovinApi.output.akamaiNetStorage.create(output);

        InputStream inputStreamVideo = new InputStream();
        inputStreamVideo.setInputPath(S3_INPUT_PATH);
        inputStreamVideo.setInputId(input.getId());
        inputStreamVideo.setSelectionMode(StreamSelectionMode.AUTO);
        inputStreamVideo.setPosition(0);

        InputStream inputStreamAudio = new InputStream();
        inputStreamAudio.setInputPath(S3_INPUT_PATH);
        inputStreamAudio.setInputId(input.getId());
        inputStreamAudio.setSelectionMode(StreamSelectionMode.AUTO);
        inputStreamAudio.setPosition(1);

        MuxingType[] muxingTypes = new MuxingType[] { MuxingType.TS, MuxingType.FMP4 };

        // create videoConfig, stream and muxings for each of the video encoding
        // profies.
        for (VideoProfile videoProfile : VIDEO_ENCODING_PROFILES)
        {
            // create video configuration accordingly.
            VideoConfiguration videoConfig = createVideoConfiguration(videoProfile);

            // create a video stream to map the video config and the video input stream.
            Stream videoStream = createStream(encoding, inputStreamVideo, videoConfig.getId());
            videoProfile.stream = videoStream;

            for (MuxingType type : muxingTypes)
            {
                Muxing muxing = this.createMuxing(type, "video/%d_%s_%s", encoding, output, videoProfile, videoStream);
                videoProfile.muxings.add(muxing);
            }
        }

        // create audioConfig, stream and muxings for each of the audio encoding
        // profies.
        for (AACAudioProfile audioProfile : AUDIO_ENCODING_PROFILES)
        {
            AACAudioConfig audioConfig = createAACAudioConfig(audioProfile);
            Stream audioStream = createStream(encoding, inputStreamAudio, audioConfig.getId());

            audioProfile.stream = audioStream;

            for (MuxingType type : muxingTypes)
            {
                Muxing muxing = this.createMuxing(type, "audio/%d_%s_%s", encoding, output, audioProfile, audioStream);
                audioProfile.muxings.add(muxing);
            }
        }

        // start encoding with dash manifest
        bitmovinApi.encoding.start(encoding);

        // wait until live encoding is running
        Assert.assertTrue(waitUntilFinished(encoding));

        List<Manifest> manifestsToStart = new ArrayList<>();

        // create all manifests
        for (ManifestType manifestType : MANIFESTS)
        {
            switch (manifestType)
            {
                case DASH:
                    manifestsToStart.add(createDashManifest(encoding, output));
                    break;
                case HLS:
                    manifestsToStart.add(createHlsManifest(encoding, output));
                    break;
            }
        }

        // start all manifests
        for (Manifest manifest : manifestsToStart)
        {
            startManifestGeneration(manifest);
        }

        // wait until all manifest are generated.
        for (Manifest manifest : manifestsToStart)
        {
            Status manifestStatus = waitUnilManifesStatusFinished(manifest);

            System.out.println(String.format("%s generation finished with status %s",
                    manifest.getClass().getName().toString(), manifestStatus.toString()));
            Assert.assertEquals(Status.FINISHED, manifestStatus);
        }

        System.out.println("Encoding completed successfully");
    }

    //////////////////////// Auxiliary methods ////////////////////////

    private HlsManifest createHlsManifest(Encoding encoding, Output output)
            throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        EncodingOutput manifestDestination = new EncodingOutput();
        manifestDestination.setOutputId(output.getId());
        manifestDestination.setOutputPath(OUTPUT_BASE_PATH);
        manifestDestination.setAcl(Collections.singletonList(new AclEntry(AclPermission.PUBLIC_READ)));

        HlsManifest hlsManifest = new HlsManifest();
        hlsManifest.setName("master.m3u8");
        hlsManifest.addOutput(manifestDestination);
        hlsManifest = bitmovinApi.manifest.hls.create(hlsManifest);

        List<String> audioGroupIds = new ArrayList<>();

        for (AACAudioProfile audioProfile : AUDIO_ENCODING_PROFILES)
        {
            for (Muxing muxing : audioProfile.muxings)
            {
                if (muxing.getType() == MuxingType.TS)
                {
                    String path = muxing.getOutputs().get(0).getOutputPath().replaceAll(OUTPUT_BASE_PATH, "");
                    String audioGroupId = String.format("audio_%d", audioProfile.bitrate);

                    audioGroupIds.add(audioGroupId);

                    MediaInfo audioMediaInfo = new MediaInfo();
                    audioMediaInfo.setName(audioProfile.language);
                    audioMediaInfo.setUri(String.format("audio_%s_%d.m3u8",
                            audioProfile.getCodecType().toString().toLowerCase(), audioProfile.bitrate));
                    audioMediaInfo.setGroupId(audioGroupId);
                    audioMediaInfo.setType(MediaInfoType.AUDIO);
                    audioMediaInfo.setEncodingId(encoding.getId());
                    audioMediaInfo.setStreamId(audioProfile.stream.getId());
                    audioMediaInfo.setMuxingId(muxing.getId());
                    audioMediaInfo.setLanguage(audioProfile.language);
                    audioMediaInfo.setAssocLanguage(audioProfile.language);
                    audioMediaInfo.setAutoselect(false);
                    audioMediaInfo.setIsDefault(false);
                    audioMediaInfo.setForced(false);
                    audioMediaInfo.setSegmentPath(path);
                    bitmovinApi.manifest.hls.createMediaInfo(hlsManifest, audioMediaInfo);
                }
            }
        }

        for (String audioGroupId : audioGroupIds)
        {
            for (VideoProfile videoProfile : reverseList(VIDEO_ENCODING_PROFILES))
            {
                for (Muxing muxing : videoProfile.muxings)
                {
                    if (muxing.getType() == MuxingType.TS
                            || (muxing.getType() == MuxingType.FMP4 && videoProfile.getCodecType() == ConfigType.H265))
                    {
                        String path = muxing.getOutputs().get(0).getOutputPath().replaceAll(OUTPUT_BASE_PATH, "");

                        this.addStreamInfoToHlsManifest(
                                String.format("video_%s_%dp_%d.m3u8",
                                        videoProfile.getCodecType().toString().toLowerCase(), videoProfile.height,
                                        videoProfile.bitrate),
                                encoding.getId(), videoProfile.stream.getId(), muxing.getId(), audioGroupId, path,
                                hlsManifest);
                    }
                }
            }
        }

        return hlsManifest;
    }

    private VideoProfile[] reverseList(VideoProfile[] videoEncodingProfiles)
    {
        List<VideoProfile> list = Arrays.asList(videoEncodingProfiles);
        Collections.reverse(list);
        return list.toArray(new VideoProfile[videoEncodingProfiles.length]);
    }

    private DashManifest createDashManifest(Encoding encoding, Output output)
            throws BitmovinApiException, UnirestException, IOException, URISyntaxException, RestException
    {
        EncodingOutput manifestOutput = new EncodingOutput();
        manifestOutput.setOutputId(output.getId());
        manifestOutput.setOutputPath(OUTPUT_BASE_PATH);
        manifestOutput.setAcl(Collections.singletonList(new AclEntry(AclPermission.PUBLIC_READ)));

        DashManifest dashManifest = new DashManifest();
        dashManifest.setName("stream.mpd");
        dashManifest.setOutputs(Collections.singletonList(manifestOutput));
        dashManifest = bitmovinApi.manifest.dash.create(dashManifest);

        Period period = bitmovinApi.manifest.dash.createPeriod(dashManifest, new Period());

        Set<ConfigType> codecsForDash = this.getVideoCodecs();
        for (ConfigType codec : codecsForDash)
        {
            VideoAdaptationSet videoAdaptationSet = bitmovinApi.manifest.dash
                    .addVideoAdaptationSetToPeriod(dashManifest, period, new VideoAdaptationSet());

            for (VideoProfile videoProfile : VIDEO_ENCODING_PROFILES)
            {
                if (videoProfile.getCodecType() == codec)
                {
                    for (Muxing muxing : videoProfile.muxings)
                    {
                        if (muxing.getType() == MuxingType.FMP4)
                        {
                            String path = muxing.getOutputs().get(0).getOutputPath().replaceAll(OUTPUT_BASE_PATH, "");

                            this.addDashRepresentationToAdaptationSet(DashMuxingType.TEMPLATE, encoding.getId(),
                                    videoProfile.stream.getId(), muxing, path, dashManifest, period,
                                    videoAdaptationSet);
                        }
                    }
                }
            }
        }

        for (AACAudioProfile audioProfile : AUDIO_ENCODING_PROFILES)
        {
            AudioAdaptationSet audioAdaptationSet = new AudioAdaptationSet();
            audioAdaptationSet.setLang(audioProfile.language);

            audioAdaptationSet = bitmovinApi.manifest.dash.addAudioAdaptationSetToPeriod(dashManifest, period,
                    audioAdaptationSet);

            for (Muxing muxing : audioProfile.muxings)
            {
                if (muxing.getType() == MuxingType.FMP4)
                {
                    String path = muxing.getOutputs().get(0).getOutputPath().replaceAll(OUTPUT_BASE_PATH, "");

                    this.addDashRepresentationToAdaptationSet(DashMuxingType.TEMPLATE, encoding.getId(),
                            audioProfile.stream.getId(), muxing, path, dashManifest, period, audioAdaptationSet);
                }
            }
        }

        return dashManifest;
    }

    private void startManifestGeneration(AbstractApiResponse manifest)
            throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        if (manifest instanceof DashManifest)
        {
            bitmovinApi.manifest.dash.startGeneration((DashManifest) manifest);
        }
        else if (manifest instanceof HlsManifest)
        {
            bitmovinApi.manifest.hls.startGeneration((HlsManifest) manifest);
        }
        else if (manifest instanceof SmoothStreamingManifest)
        {
            bitmovinApi.manifest.smooth.startGeneration((SmoothStreamingManifest) manifest);
        }
    }

    private Status waitUnilManifesStatusFinished(AbstractApiResponse manifest) throws InterruptedException,
            BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        Status manifestStatus = null;

        do
        {
            Thread.sleep(2500);

            if (manifest instanceof DashManifest)
            {
                manifestStatus = bitmovinApi.manifest.dash.getGenerationStatus((DashManifest) manifest);
            }
            else if (manifest instanceof HlsManifest)
            {
                manifestStatus = bitmovinApi.manifest.hls.getGenerationStatus((HlsManifest) manifest);
            }
            else if (manifest instanceof SmoothStreamingManifest)
            {
                manifestStatus = bitmovinApi.manifest.smooth.getGenerationStatus((SmoothStreamingManifest) manifest);
            }
        }
        while (manifestStatus != Status.FINISHED && manifestStatus != Status.ERROR);
        return manifestStatus;
    }

    private StreamInfo addStreamInfoToHlsManifest(String uri, String encodingId, String streamId, String muxingId,
            String audioGroupId, String segmentPath, HlsManifest manifest)
            throws URISyntaxException, BitmovinApiException, RestException, UnirestException, IOException
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

    private boolean waitUntilFinished(Encoding encoding) throws BitmovinApiException, IOException, RestException,
            URISyntaxException, UnirestException, InterruptedException
    {
        Task status = bitmovinApi.encoding.getStatus(encoding);

        while (status.getStatus() != Status.FINISHED && status.getStatus() != Status.ERROR)
        {
            status = bitmovinApi.encoding.getStatus(encoding);
            Thread.sleep(2500);
        }

        return status.getStatus() == Status.FINISHED;
    }

    private AACAudioConfig createAACAudioConfig(AACAudioProfile audioProfile)
            throws BitmovinApiException, UnirestException, IOException, URISyntaxException
    {
        AACAudioConfig audioConfig = new AACAudioConfig();
        audioConfig.setBitrate(audioProfile.bitrate * 1000);
        audioConfig.setRate(audioProfile.rate);
        audioConfig = bitmovinApi.configuration.audioAAC.create(audioConfig);
        return audioConfig;
    }

    private Stream createStream(Encoding encoding, InputStream inputStream, String codecConfigId)
            throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        Stream stream = new Stream();
        stream.setCodecConfigId(codecConfigId);
        stream.setInputStreams(Collections.singleton(inputStream));
        stream = bitmovinApi.encoding.stream.addStream(encoding, stream);
        return stream;
    }

    private Set<ConfigType> getVideoCodecs()
    {
        Set<ConfigType> setOfCodecs = new LinkedHashSet<>();
        for (VideoProfile videoProfile : VIDEO_ENCODING_PROFILES)
        {
            setOfCodecs.add(videoProfile.getCodecType());
        }

        return setOfCodecs;
    }

    private VideoConfiguration createVideoConfiguration(VideoProfile videoProfile)
            throws BitmovinApiException, UnirestException, IOException, URISyntaxException
    {
        return createH264VideoConfiguration((H264VideoProfile) videoProfile);
    }

    private H264VideoConfiguration createH264VideoConfiguration(H264VideoProfile videoProfile)
            throws BitmovinApiException, UnirestException, IOException, URISyntaxException
    {
        H264VideoConfiguration videoConfig = new H264VideoConfiguration();
        videoConfig.setName(String.format("StreamDemoH264%dp", videoProfile.height));
        videoConfig.setBitrate(videoProfile.bitrate * 1000);
        videoConfig.setRate(videoProfile.fps);
        videoConfig.setWidth(videoProfile.width);
        videoConfig.setHeight(videoProfile.height);
        videoConfig.setProfile(videoProfile.profile);
        videoConfig = bitmovinApi.configuration.videoH264.create(videoConfig);
        return videoConfig;
    }

    private Muxing createMuxing(MuxingType type, String format, Encoding encoding, Output output,
            MediaProfile profile, Stream stream)
            throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String path = String.format(format, profile.bitrate, profile.getCodecType().toString().toLowerCase(),
                type.toString().toLowerCase());

        if (type == MuxingType.FMP4)
        {
            return this.createFMP4Muxing(encoding, output, path, stream);
        }
        else
        {
            return this.createTSMuxing(encoding, output, path, stream);
        }
    }

    private FMP4Muxing createFMP4Muxing(Encoding encoding, Output output, String path, Stream stream)
            throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        EncodingOutput encodingOutput = new EncodingOutput();
        encodingOutput.setOutputId(output.getId());
        encodingOutput.setOutputPath(OUTPUT_BASE_PATH + path);
        encodingOutput.setAcl(Arrays.asList(new AclEntry(AclPermission.PUBLIC_READ)));

        FMP4Muxing muxing = new FMP4Muxing();
        MuxingStream list = new MuxingStream();
        list.setStreamId(stream.getId());
        muxing.addStream(list);
        muxing.setSegmentLength(MUXING_SEGMENT_DURATION);
        muxing.setOutputs(Collections.singletonList(encodingOutput));
        muxing = bitmovinApi.encoding.muxing.addFmp4MuxingToEncoding(encoding, muxing);
        return muxing;
    }

    private TSMuxing createTSMuxing(Encoding encoding, Output output, String path, Stream stream)
            throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        EncodingOutput encodingOutput = new EncodingOutput();
        encodingOutput.setOutputId(output.getId());
        encodingOutput.setOutputPath(OUTPUT_BASE_PATH + path);
        encodingOutput.setAcl(Arrays.asList(new AclEntry(AclPermission.PUBLIC_READ)));

        TSMuxing muxing = new TSMuxing();
        MuxingStream list = new MuxingStream();
        list.setStreamId(stream.getId());
        muxing.addStream(list);
        muxing.setSegmentLength(MUXING_SEGMENT_DURATION);
        muxing.setOutputs(Collections.singletonList(encodingOutput));
        muxing = bitmovinApi.encoding.muxing.addTSMuxingToEncoding(encoding, muxing);
        return muxing;
    }

    private void addDashRepresentationToAdaptationSet(DashMuxingType type, String encodingId, String streamId,
            Muxing muxing, String segmentPath, DashManifest manifest, Period period, AdaptationSet adaptationSet)
            throws BitmovinApiException, URISyntaxException, RestException, UnirestException, IOException
    {

        DashSegmentedRepresentation r = new DashFmp4Representation();
        r.setType(type);
        r.setEncodingId(encodingId);
        r.setStreamId(streamId);
        r.setMuxingId(muxing.getId());
        r.setSegmentPath(segmentPath);
        bitmovinApi.manifest.dash.addRepresentationToAdaptationSet(manifest, period, adaptationSet, r);
    }

    private static enum ManifestType
    {
        DASH, HLS,
    }

    private static abstract class MediaProfile
    {
        protected long bitrate;
        protected Stream stream;
        protected List<Muxing> muxings;

        public MediaProfile(long bitrate)
        {
            this.bitrate = bitrate;
            this.muxings = new ArrayList<>();
        }

        protected abstract ConfigType getCodecType();
    }

    private static class AACAudioProfile extends MediaProfile
    {
        protected float rate;
        protected String language;

        public AACAudioProfile(long bitrate, float rate, String language)
        {
            super(bitrate);
            this.rate = rate;
            this.language = language;
        }

        @Override
        protected ConfigType getCodecType()
        {
            return ConfigType.AAC;
        }
    }

    private abstract static class VideoProfile extends MediaProfile
    {
        protected int width;
        protected int height;
        protected float fps;

        public VideoProfile(int width, int height, long bitrate, float fps)
        {
            super(bitrate);
            this.width = width;
            this.height = height;
            this.fps = fps;
        }
    }

    private static class H264VideoProfile extends VideoProfile
    {
        protected ProfileH264 profile;

        public H264VideoProfile(int width, int height, long bitrate, float fps, ProfileH264 profile)
        {
            super(width, height, bitrate, fps);
            this.profile = profile;
        }

        @Override
        protected ConfigType getCodecType()
        {
            return ConfigType.H264;
        }
    }
}
