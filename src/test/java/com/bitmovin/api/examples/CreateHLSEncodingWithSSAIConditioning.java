package com.bitmovin.api.examples;

import com.bitmovin.api.BitmovinApi;
import com.bitmovin.api.encoding.AclEntry;
import com.bitmovin.api.encoding.AclPermission;
import com.bitmovin.api.encoding.EncodingOutput;
import com.bitmovin.api.encoding.InputStream;
import com.bitmovin.api.encoding.codecConfigurations.AACAudioConfig;
import com.bitmovin.api.encoding.codecConfigurations.AudioConfiguration;
import com.bitmovin.api.encoding.codecConfigurations.H264VideoConfiguration;
import com.bitmovin.api.encoding.codecConfigurations.VideoConfiguration;
import com.bitmovin.api.encoding.codecConfigurations.enums.ProfileH264;
import com.bitmovin.api.encoding.encodings.Encoding;
import com.bitmovin.api.encoding.encodings.Keyframe;
import com.bitmovin.api.encoding.encodings.muxing.FMP4Muxing;
import com.bitmovin.api.encoding.encodings.muxing.Muxing;
import com.bitmovin.api.encoding.encodings.muxing.MuxingStream;
import com.bitmovin.api.encoding.encodings.streams.Stream;
import com.bitmovin.api.encoding.enums.CloudRegion;
import com.bitmovin.api.encoding.enums.StreamSelectionMode;
import com.bitmovin.api.encoding.inputs.HttpsInput;
import com.bitmovin.api.encoding.manifest.enums.PositionMode;
import com.bitmovin.api.encoding.manifest.hls.CustomTag;
import com.bitmovin.api.encoding.manifest.hls.HlsManifest;
import com.bitmovin.api.encoding.manifest.hls.MediaInfo;
import com.bitmovin.api.encoding.manifest.hls.MediaInfoType;
import com.bitmovin.api.encoding.manifest.hls.StreamInfo;
import com.bitmovin.api.encoding.outputs.Output;
import com.bitmovin.api.encoding.outputs.S3Output;
import com.bitmovin.api.encoding.status.Task;
import com.bitmovin.api.enums.Status;
import com.bitmovin.api.examples.util.H264Representation;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.http.RestException;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateHLSEncodingWithSSAIConditioning
{
    private static String API_KEY = "<INSERT_YOUR_APIKEY>";
    private static CloudRegion CLOUD_REGION = CloudRegion.AWS_EU_WEST_1;
    private static String HTTPS_INPUT_HOST = "<INSERT_YOUR_HTTP_HOST>"; // ex.: storage.googleapis.com/
    private static String HTTPS_INPUT_PATH = "<INSERT_YOUR_PATH_TO_INPUT_FILE>";
    private static String S3_OUTPUT_ACCESSKEY = "<INSERT_YOUR_ACCESSKEY>";
    private static String S3_OUTPUT_SECRET_KEY = "<INSERT_YOUR_SECRETKEY>";
    private static String S3_OUTPUT_BUCKET_NAME = "BUCKET_NAME";
    private static String OUTPUT_BASE_PATH = "path/to/your/outputs/" + new Date().getTime();

    private static BitmovinApi bitmovinApi;

    private static List<H264Representation> H264_REPRESENTATIONS = Arrays.asList(
            new H264Representation(null, 240, null, 400000L , ProfileH264.MAIN),
            new H264Representation(null, 360, null, 800000L, ProfileH264.MAIN),
            new H264Representation(null, 480, null, 1200000L, ProfileH264.MAIN),
            new H264Representation(null, 720, null, 2400000L, ProfileH264.MAIN),
            new H264Representation(null, 1080, null, 4800000L, ProfileH264.MAIN)
    );

    private static Long AAC_AUDIO_BITRATE = 128000L;

    /*
        Seconds in which to add a custom HLS tag for ad placement, as well as when to insert a keyframe/split a segment
     */
    private static List<Float> AD_BREAK_PLACEMENTS = Arrays.asList(
            5.0f,
            15.0f
    );

    /*
        Custom HLS tag to insert for each ad break
     */
    private static String HLS_CUSTOM_TAG = "#AD-PLACEMENT-OPPORTUNITY";

    @Test
    public void testHlsWithSsaiConditioning() throws IOException, BitmovinApiException, UnirestException, URISyntaxException, RestException, InterruptedException
    {
        bitmovinApi = new BitmovinApi(API_KEY);

        Encoding encoding = createEncoding("Encoding Java Example - SSAI Conditioned HLS Streams");

        HttpsInput input = new HttpsInput();
        input.setHost(HTTPS_INPUT_HOST);
        input = bitmovinApi.input.https.create(input);

        S3Output output = new S3Output();
        output.setAccessKey(S3_OUTPUT_ACCESSKEY);
        output.setSecretKey(S3_OUTPUT_SECRET_KEY);
        output.setBucketName(S3_OUTPUT_BUCKET_NAME);
        output = bitmovinApi.output.s3.create(output);

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

        Map<H264VideoConfiguration, FMP4Muxing> videoMuxings = createVideoMuxings(encoding, inputStreamVideo, output);
        FMP4Muxing audioMuxing = createAudioMuxing(encoding, inputStreamAudio, output);

        List<Keyframe> keyframes = addKeyframes(encoding, AD_BREAK_PLACEMENTS);

        startAndMonitorEncoding(encoding);

        HlsManifest manifestHls = createHlsMasterManifest("master.m3u8", output, OUTPUT_BASE_PATH);

        // Create EXT-X-MEDIA tags
        MediaInfo audioMediaInfo = createHlsAudioMediaPlaylist(encoding, manifestHls, audioMuxing, keyframes);

        for (Map.Entry<H264VideoConfiguration, FMP4Muxing> videoMuxing: videoMuxings.entrySet())
        {
            // Create EXT-X-STREAM-INF tags
            createHlsVideoStreamPlaylist(encoding, manifestHls, videoMuxing.getKey().getBitrate(), videoMuxing.getValue(), audioMediaInfo, keyframes);
        }

        startAndMonitorManifest(manifestHls);

        System.out.println("Encoding and HLS manifest completed successfully");
    }

    private Encoding createEncoding(String name) throws URISyntaxException, BitmovinApiException, UnirestException, IOException
    {
        System.out.println(String.format("Creating encode \"%s\"", name));
        Encoding encoding = new Encoding();
        encoding.setName(name);
        encoding.setCloudRegion(CLOUD_REGION);
        encoding = bitmovinApi.encoding.create(encoding);

        return encoding;
    }

    private void startAndMonitorEncoding(Encoding encoding)
            throws URISyntaxException, BitmovinApiException, RestException, UnirestException, IOException, InterruptedException
    {
        System.out.println("Starting encode");
        bitmovinApi.encoding.start(encoding);

        Task status = bitmovinApi.encoding.getStatus(encoding);

        while (status.getStatus() != Status.FINISHED && status.getStatus() != Status.ERROR)
        {
            status = bitmovinApi.encoding.getStatus(encoding);
            System.out.println(String.format("Encoding %s at %d%%", status.getStatus().toString(), status.getProgress()));
            Thread.sleep(2500);
        }

        System.out.println(String.format("Encoding finished with status %s", status.getStatus().toString()));

        if (status.getStatus() != Status.FINISHED)
        {
            Assert.fail("Encoding failed. Cannot create HLS manifest");
        }
    }

    private void startAndMonitorManifest(HlsManifest manifestHls)
            throws URISyntaxException, BitmovinApiException, RestException, UnirestException, IOException, InterruptedException
    {
        System.out.println("Starting manifest generation");
        bitmovinApi.manifest.hls.startGeneration(manifestHls);
        Status status = bitmovinApi.manifest.hls.getGenerationStatus(manifestHls);
        while (status != Status.FINISHED && status != Status.ERROR)
        {
            status = bitmovinApi.manifest.hls.getGenerationStatus(manifestHls);
            Thread.sleep(2500);
        }
        if (status != Status.FINISHED)
        {
            System.out.println("Could not create HLS manifest");
            Assert.fail("Could not create HLS manifest");
        }
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

    private AACAudioConfig createAudioConfiguration(Long bitrate)
            throws URISyntaxException, BitmovinApiException, UnirestException, IOException
    {
        AACAudioConfig audioConfig = new AACAudioConfig();
        audioConfig.setBitrate(bitrate);
        audioConfig.setName(String.format("AAC Config - %dkbps", bitrate / 1000));

        audioConfig = bitmovinApi.configuration.audioAAC.create(audioConfig);

        System.out.println(String.format("Creating audio configuration \"%s\"", audioConfig.getName()));

        return audioConfig;
    }

    private H264VideoConfiguration createVideoConfiguration(H264Representation representation)
            throws URISyntaxException, BitmovinApiException, UnirestException, IOException
    {
        H264VideoConfiguration videoConfig = new H264VideoConfiguration();

        videoConfig.setWidth(representation.getWidth());
        videoConfig.setHeight(representation.getHeight());
        videoConfig.setBitrate(representation.getBitrate());
        videoConfig.setRate(representation.getRate());
        videoConfig.setProfile(representation.getProfile());
        videoConfig.setName(String.format("H264 Config - %dp @ %dkbps", videoConfig.getHeight(), videoConfig.getBitrate() / 1000));

        System.out.println(String.format("Creating video configuration \"%s\"", videoConfig.getName()));

        videoConfig = bitmovinApi.configuration.videoH264.create(videoConfig);

        return videoConfig;
    }

    private Stream createAudioStream(Encoding encoding, AudioConfiguration audioConfig, InputStream inputStream)
            throws URISyntaxException, BitmovinApiException, UnirestException, IOException, RestException
    {


        Stream audioStream = new Stream();
        audioStream.setCodecConfigId(audioConfig.getId());
        audioStream.setInputStreams(Collections.singleton(inputStream));

        return bitmovinApi.encoding.stream.addStream(encoding, audioStream);
    }

    private Stream createVideoStream(Encoding encoding, VideoConfiguration videoConfig,
                                     InputStream inputStream)
            throws URISyntaxException, BitmovinApiException, UnirestException, IOException, RestException
    {
        Stream videoStream = new Stream();
        videoStream.setCodecConfigId(videoConfig.getId());
        videoStream.setInputStreams(Collections.singleton(inputStream));

        return bitmovinApi.encoding.stream.addStream(encoding, videoStream);
    }

    private Map<H264VideoConfiguration, FMP4Muxing> createVideoMuxings(Encoding encoding, InputStream inputStreamVideo, Output output)
            throws BitmovinApiException, RestException, UnirestException, IOException, URISyntaxException
    {
        Map<H264VideoConfiguration, FMP4Muxing> muxings = new HashMap<>();

        for (H264Representation representation: H264_REPRESENTATIONS)
        {
            H264VideoConfiguration videoConfig = createVideoConfiguration(representation);
            Stream videoStream = createVideoStream(encoding, videoConfig, inputStreamVideo);
            FMP4Muxing muxing = createFMP4Muxing(encoding, videoStream, output,
                    String.format("%s/video/%dp_%dkbps", OUTPUT_BASE_PATH, representation.getHeight(), representation.getBitrate() / 1000));

            muxings.put(videoConfig, muxing);
        }

        return muxings;
    }

    private FMP4Muxing createAudioMuxing(Encoding encoding, InputStream inputStreamAudio, Output output)
            throws BitmovinApiException, RestException, UnirestException, IOException, URISyntaxException
    {

        AACAudioConfig audioConfig = createAudioConfiguration(AAC_AUDIO_BITRATE);
        Stream audioStream = createAudioStream(encoding, audioConfig, inputStreamAudio);
        FMP4Muxing audioMuxing = createFMP4Muxing(encoding, audioStream, output,
                String.format("%s/audio/%dkbps", OUTPUT_BASE_PATH, AAC_AUDIO_BITRATE / 1000));

        return audioMuxing;
    }

    private FMP4Muxing createFMP4Muxing(Encoding encoding, Stream stream, Output output, String outputPath)
            throws URISyntaxException, BitmovinApiException, RestException, UnirestException, IOException
    {
        EncodingOutput encodingOutput = createEncodingOutput(output, outputPath, AclPermission.PUBLIC_READ);

        FMP4Muxing muxing = new FMP4Muxing();
        muxing.addOutput(encodingOutput);

        MuxingStream muxingStream = new MuxingStream();
        muxingStream.setStreamId(stream.getId());

        muxing.addStream(muxingStream);
        muxing.setSegmentLength(4.0);
        muxing = bitmovinApi.encoding.muxing.addFmp4MuxingToEncoding(encoding, muxing);

        return muxing;
    }

    private List<Keyframe> addKeyframes(Encoding encoding, List<Float> breakPlacements)
            throws URISyntaxException, BitmovinApiException, UnirestException, IOException
    {
        List<Keyframe> keyframes = new ArrayList<>();

        for (Float adBreak: breakPlacements)
        {
            System.out.println(String.format("Adding keyframe to encoding at %.2f(s)", adBreak));
            Keyframe keyframe = bitmovinApi.encoding.keyframes.addKeyframeToEncoding(encoding.getId(), new Keyframe(adBreak, true));
            keyframes.add(keyframe);
        }

        return keyframes;
    }

    private HlsManifest createHlsMasterManifest(String name, Output output, String outputPath)
            throws URISyntaxException, BitmovinApiException, UnirestException, IOException
    {
        System.out.println("Creating HLS Master Playlist (" + name + ")");
        EncodingOutput manifestDestination = createEncodingOutput(output, outputPath, AclPermission.PUBLIC_READ);

        HlsManifest m = new HlsManifest();
        m.setName(name);
        m.addOutput(manifestDestination);

        return bitmovinApi.manifest.hls.create(m);
    }

    private MediaInfo createHlsAudioMediaPlaylist(Encoding encoding, HlsManifest manifest, Muxing audioMuxing,
                                                  List<Keyframe> keyframes)
            throws URISyntaxException, BitmovinApiException, RestException, UnirestException, IOException
    {
        String audioPlaylistName = "audio.m3u8";
        System.out.println("Creating HLS Audio Media Playlist (" + audioPlaylistName + ")");

        MediaInfo audioMediaInfo = new MediaInfo();
        audioMediaInfo.setName(audioPlaylistName);
        audioMediaInfo.setUri(audioPlaylistName);
        audioMediaInfo.setGroupId("audio");
        audioMediaInfo.setType(MediaInfoType.AUDIO);
        audioMediaInfo.setEncodingId(encoding.getId());
        audioMediaInfo.setStreamId(audioMuxing.getStreams().get(0).getStreamId());
        audioMediaInfo.setMuxingId(audioMuxing.getId());
        audioMediaInfo.setLanguage("en");
        audioMediaInfo.setAssocLanguage("en");
        audioMediaInfo.setAutoselect(false);
        audioMediaInfo.setIsDefault(false);
        audioMediaInfo.setForced(false);
        audioMediaInfo.setSegmentPath(audioMuxing.getOutputs().get(0).getOutputPath().replaceAll(OUTPUT_BASE_PATH + "/", ""));

        audioMediaInfo = bitmovinApi.manifest.hls.createMediaInfo(manifest, audioMediaInfo);

        for (Keyframe keyframe: keyframes)
        {
            CustomTag customTag = createHlsCustomTag(keyframe);
            System.out.println(String.format("Adding HLS Custom Tag at %.2f(s) to %s", keyframe.getTime(), audioPlaylistName));
            bitmovinApi.manifest.hls.createCustomTag(manifest, audioMediaInfo, customTag);
        }

        return audioMediaInfo;
    }

    private StreamInfo createHlsVideoStreamPlaylist(Encoding encoding, HlsManifest manifest,
                                                    Long bitrate, Muxing muxing, MediaInfo audioMediaInfo, List<Keyframe> keyframes)
            throws URISyntaxException, BitmovinApiException, RestException, UnirestException, IOException
    {
        String streamInfoName = String.format("video_%dkbps.m3u8", bitrate / 1000);
        System.out.println("Creating HLS Video Stream Playlist (" + streamInfoName + ")");

        StreamInfo streamInfo = new StreamInfo();
        streamInfo.setUri(streamInfoName);
        streamInfo.setEncodingId(encoding.getId());
        streamInfo.setStreamId(muxing.getStreams().get(0).getStreamId());
        streamInfo.setMuxingId(muxing.getId());
        streamInfo.setAudio(audioMediaInfo.getGroupId());
        streamInfo.setSegmentPath(muxing.getOutputs().get(0).getOutputPath().replaceAll(OUTPUT_BASE_PATH + "/", ""));

        streamInfo = bitmovinApi.manifest.hls.createStreamInfo(manifest, streamInfo);

        for (Keyframe keyframe: keyframes)
        {
            CustomTag customTag = createHlsCustomTag(keyframe);
            System.out.println(String.format("Adding HLS Custom Tag at %.2f(s) to %s", keyframe.getTime(), streamInfoName));

            bitmovinApi.manifest.hls.createCustomTag(manifest, streamInfo, customTag);
        }

        return streamInfo;
    }

    private CustomTag createHlsCustomTag(Keyframe keyframe)
    {

        CustomTag customTag = new CustomTag();
        customTag.setKeyframeId(keyframe.getId());
        customTag.setPositionMode(PositionMode.KEYFRAME);
        customTag.setData(HLS_CUSTOM_TAG);

        return customTag;
    }
}
