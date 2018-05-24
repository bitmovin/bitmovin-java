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
import com.bitmovin.api.encoding.encodings.muxing.FMP4Muxing;
import com.bitmovin.api.encoding.encodings.muxing.MuxingStream;
import com.bitmovin.api.encoding.encodings.streams.Stream;
import com.bitmovin.api.encoding.enums.CloudRegion;
import com.bitmovin.api.encoding.enums.DashMuxingType;
import com.bitmovin.api.encoding.enums.StreamSelectionMode;
import com.bitmovin.api.encoding.filters.AudioMixChannel;
import com.bitmovin.api.encoding.filters.AudioMixFilter;
import com.bitmovin.api.encoding.filters.SourceChannel;
import com.bitmovin.api.encoding.filters.enums.AudioMixChannelLayout;
import com.bitmovin.api.encoding.filters.enums.SourceChannelType;
import com.bitmovin.api.encoding.inputs.S3Input;
import com.bitmovin.api.encoding.manifest.dash.*;
import com.bitmovin.api.encoding.outputs.S3Output;
import com.bitmovin.api.encoding.status.Task;
import com.bitmovin.api.enums.Status;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.http.RestException;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class CreateEncodingWithAudioMixFilter
{
    private static String API_KEY = "<INSERT YOUR API KEY>";

    private static CloudRegion CLOUD_REGION = CloudRegion.AWS_EU_WEST_1;

    private static String S3_INPUT_ACCESSKEY = "<INSERT YOUR INPUT ACCESS KEY>";
    private static String S3_INPUT_SECRET_KEY = "<INSERT YOUR INPUT SECRET KEY>";
    private static String S3_INPUT_BUCKET_NAME = "<INSERT YOUR INPUT BUCKET>";
    private static String S3_INPUT_PATH = "path/to/your/input.mkv";

    private static String S3_OUTPUT_ACCESSKEY = "<INSERT YOUR OUTPUT ACCESS KEY>";
    private static String S3_OUTPUT_SECRET_KEY = "<INSERT YOUR OUTPUT SECRET KEY>";
    private static String S3_OUTPUT_BUCKET_NAME = "<INSERT YOUR OUTPUT BUCKET>";
    private static String OUTPUT_BASE_PATH = "/output/bitmovin_java_" + new Date().getTime() + "/";

    private static BitmovinApi bitmovinApi;

    @Test
    public void testCreateEncodingWithAudioMixFilter() throws URISyntaxException, BitmovinApiException, UnirestException, IOException, RestException, InterruptedException
    {
        bitmovinApi = new BitmovinApi(API_KEY);

        Encoding encoding = new Encoding();
        encoding.setName("Audio Mix Filter Example Encoding");
        encoding.setName("Audio Mix Filter Example Encoding");
        encoding.setDescription("Encoding with audio mix filter");
        encoding.setCloudRegion(CLOUD_REGION);
        encoding = bitmovinApi.encoding.create(encoding);

        S3Input input = new S3Input();
        input.setAccessKey(S3_INPUT_ACCESSKEY);
        input.setSecretKey(S3_INPUT_SECRET_KEY);
        input.setBucketName(S3_INPUT_BUCKET_NAME);
        input = bitmovinApi.input.s3.create(input);

        S3Output output = new S3Output();
        output.setAccessKey(S3_OUTPUT_ACCESSKEY);
        output.setSecretKey(S3_OUTPUT_SECRET_KEY);
        output.setBucketName(S3_OUTPUT_BUCKET_NAME);
        output = bitmovinApi.output.s3.create(output);

        InputStream videoInput = new InputStream();
        videoInput.setInputId(input.getId());
        videoInput.setInputPath(S3_INPUT_PATH);
        videoInput.setPosition(0);
        videoInput.setSelectionMode(StreamSelectionMode.AUTO);

        /*
        Video 1080p configuration
         */
        H264VideoConfiguration videoConfig1080p = new H264VideoConfiguration();
        videoConfig1080p.setName("H264 1080p Codec Config");
        videoConfig1080p.setProfile(ProfileH264.HIGH);
        videoConfig1080p.setBitrate(4800000L);
        videoConfig1080p.setHeight(1080);
        videoConfig1080p.setWidth(1920);
        videoConfig1080p = bitmovinApi.configuration.videoH264.create(videoConfig1080p);

        Stream videoStream1080p = new Stream();
        videoStream1080p.setCodecConfigId(videoConfig1080p.getId());
        videoStream1080p.setInputStreams(new HashSet<>(Collections.singletonList(videoInput)));
        videoStream1080p = bitmovinApi.encoding.stream.addStream(encoding, videoStream1080p);

        /*
        Video 720p configuration
         */
        H264VideoConfiguration videoConfig720p = new H264VideoConfiguration();
        videoConfig720p.setName("H264 720p Codec Config");
        videoConfig720p.setProfile(ProfileH264.HIGH);
        videoConfig720p.setBitrate(2400000L);
        videoConfig720p.setHeight(720);
        videoConfig720p.setWidth(1280);
        videoConfig720p = bitmovinApi.configuration.videoH264.create(videoConfig720p);

        Stream videoStream720p = new Stream();
        videoStream720p.setCodecConfigId(videoConfig720p.getId());
        videoStream720p.setInputStreams(new HashSet<>(Collections.singletonList(videoInput)));
        videoStream720p = bitmovinApi.encoding.stream.addStream(encoding, videoStream720p);

        /*
        Audio Configuration
         */
        AACAudioConfig audioConfig = new AACAudioConfig();
        audioConfig.setBitrate(128000L);
        audioConfig = bitmovinApi.configuration.audioAAC.create(audioConfig);

        InputStream audioInputStream = new InputStream();
        audioInputStream.setInputId(input.getId());
        audioInputStream.setInputPath(S3_INPUT_PATH);
        audioInputStream.setPosition(0);
        audioInputStream.setSelectionMode(StreamSelectionMode.AUDIO_RELATIVE);

        Stream audioStream = new Stream();
        audioStream.setInputStreams(new HashSet<>(Collections.singletonList(audioInputStream)));
        audioStream.setCodecConfigId(audioConfig.getId());
        audioStream = bitmovinApi.encoding.stream.addStream(encoding, audioStream);

        /*
        Muxing configuration
         */
        System.out.print("Configuring muxings...");

        HashMap<String, String> videoMuxingIdOutputPathMap = new HashMap<>();
        FMP4Muxing muxingVideo720p = new FMP4Muxing();
        muxingVideo720p.addOutput(new EncodingOutput(
                output.getId(),
                OUTPUT_BASE_PATH + "video/720p"
        ));
        muxingVideo720p.addStream(new MuxingStream(videoStream720p.getId()));
        muxingVideo720p.setSegmentLength(4.0);
        muxingVideo720p = bitmovinApi.encoding.muxing.addFmp4MuxingToEncoding(encoding, muxingVideo720p);
        videoMuxingIdOutputPathMap.put(muxingVideo720p.getId(), "video/720p");

        FMP4Muxing muxingVideo1080p = new FMP4Muxing();
        muxingVideo1080p.addOutput(new EncodingOutput(
                output.getId(),
                OUTPUT_BASE_PATH + "video/1080p"
        ));
        muxingVideo1080p.addStream(new MuxingStream(videoStream1080p.getId()));
        muxingVideo1080p.setSegmentLength(4.0);
        muxingVideo1080p = bitmovinApi.encoding.muxing.addFmp4MuxingToEncoding(encoding, muxingVideo1080p);
        videoMuxingIdOutputPathMap.put(muxingVideo1080p.getId(), "video/1080p");

        HashMap<String, String> audioMuxingIdOutputPathMap = new HashMap<>();
        FMP4Muxing muxingAudio = new FMP4Muxing();
        muxingAudio.addOutput(new EncodingOutput(
                output.getId(),
                OUTPUT_BASE_PATH + "audio"
        ));
        muxingAudio.addStream(new MuxingStream(audioStream.getId()));
        muxingAudio.setSegmentLength(4.0);
        muxingAudio = bitmovinApi.encoding.muxing.addFmp4MuxingToEncoding(encoding, muxingAudio);
        audioMuxingIdOutputPathMap.put(muxingAudio.getId(), "audio");
        System.out.print("[OK]\n");

        /*
        Filter configuration
         */
        System.out.print("Creating audio mix filter...");
        List<AudioMixChannel> audioMixChannels = new ArrayList<>();
        audioMixChannels.add(
                new AudioMixChannel(
                        0,
                        Collections.singletonList(
                                new SourceChannel(
                                        SourceChannelType.CHANNEL_NUMBER,
                                        0
                                )
                        )
                )
        );
        audioMixChannels.add(
                new AudioMixChannel(
                        1,
                        Collections.singletonList(
                                new SourceChannel(
                                        SourceChannelType.CHANNEL_NUMBER,
                                        1
                                )
                        )
                )
        );

        AudioMixFilter audioMixFilter = new AudioMixFilter(
                "Audio Mix Filter",
                "Audio Mix Filter",
                AudioMixChannelLayout.CL_STEREO,
                audioMixChannels
        );

        bitmovinApi.filter.audioMix.create(audioMixFilter);
        System.out.print("[OK]\n");

        System.out.print("Starting encoding...");
        bitmovinApi.encoding.start(encoding);
        System.out.print("[OK]\n");

        System.out.print("Waiting for encoding to be finished...");
        Task status = bitmovinApi.encoding.getStatus(encoding);

        while (status.getStatus() != Status.FINISHED && status.getStatus() != Status.ERROR)
        {
            status = bitmovinApi.encoding.getStatus(encoding);
            Thread.sleep(2500);
        }

        if (status.getStatus() == Status.ERROR)
        {
            System.out.println("\nEncoding finished with status ERROR");
            return;
        }

        System.out.print("[OK]\n");
        this.createDashManifest(output.getId(), encoding.getId(), videoMuxingIdOutputPathMap, audioMuxingIdOutputPathMap);
    }

    private void createDashManifest(String outputId, String encodingId, HashMap<String, String> videoMuxingIdOutputPathMap, HashMap<String, String> audioMuxingIdOutputPathMap) throws URISyntaxException, BitmovinApiException, RestException, UnirestException, IOException, InterruptedException
    {
        System.out.print("Creating DASH manifest...");

        EncodingOutput manifestDestination = new EncodingOutput();
        manifestDestination.setOutputId(outputId);
        manifestDestination.setOutputPath(OUTPUT_BASE_PATH);
        manifestDestination.setAcl(Collections.singletonList(new AclEntry(AclPermission.PUBLIC_READ)));

        DashManifest manifest = new DashManifest();
        manifest.setName("manifest.mpd");
        manifest.addOutput(manifestDestination);
        manifest = bitmovinApi.manifest.dash.create(manifest);

        Period period = new Period();
        period = bitmovinApi.manifest.dash.createPeriod(manifest, period);

        VideoAdaptationSet videoAdaptationSet = new VideoAdaptationSet();
        videoAdaptationSet = bitmovinApi.manifest.dash.addVideoAdaptationSetToPeriod(manifest, period, videoAdaptationSet);

        AudioAdaptationSet audioAdaptationSet = new AudioAdaptationSet();
        audioAdaptationSet.setLang("en");
        audioAdaptationSet = bitmovinApi.manifest.dash.addAudioAdaptationSetToPeriod(manifest, period, audioAdaptationSet);

        for (Map.Entry<String, String> entry : videoMuxingIdOutputPathMap.entrySet())
        {
            this.addDashRepresentationToAdaptationSet(
                    DashMuxingType.TEMPLATE,
                    encodingId,
                    entry.getKey(),
                    entry.getValue(),
                    manifest,
                    period,
                    videoAdaptationSet
            );
        }

        for (Map.Entry<String, String> entry : audioMuxingIdOutputPathMap.entrySet())
        {
            this.addDashRepresentationToAdaptationSet(
                    DashMuxingType.TEMPLATE,
                    encodingId,
                    entry.getKey(),
                    entry.getValue(),
                    manifest,
                    period,
                    audioAdaptationSet
            );
        }

        bitmovinApi.manifest.dash.startGeneration(manifest);
        Status dashStatus = bitmovinApi.manifest.dash.getGenerationStatus(manifest);
        while (dashStatus != Status.FINISHED && dashStatus != Status.ERROR)
        {
            dashStatus = bitmovinApi.manifest.dash.getGenerationStatus(manifest);
            Thread.sleep(2500);
        }
        if (dashStatus == Status.ERROR)
        {
            System.out.println("Could not create DASH manifest");
        }

        System.out.print("[OK]");
    }

    private void addDashRepresentationToAdaptationSet(DashMuxingType type,
                                                      String encodingId,
                                                      String muxingId,
                                                      String segmentPath,
                                                      DashManifest manifest,
                                                      Period period,
                                                      AdaptationSet adaptationSet) throws BitmovinApiException, URISyntaxException, RestException, UnirestException, IOException
    {
        DashFmp4Representation representation = new DashFmp4Representation();
        representation.setType(type);
        representation.setEncodingId(encodingId);
        representation.setMuxingId(muxingId);
        representation.setSegmentPath(segmentPath);
        bitmovinApi.manifest.dash.addRepresentationToAdaptationSet(manifest, period, adaptationSet, representation);
    }
}
