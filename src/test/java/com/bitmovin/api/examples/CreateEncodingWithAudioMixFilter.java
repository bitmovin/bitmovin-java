package com.bitmovin.api.examples;

import com.bitmovin.api.BitmovinApi;
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
import com.bitmovin.api.encoding.enums.StreamSelectionMode;
import com.bitmovin.api.encoding.filters.AudioMixChannel;
import com.bitmovin.api.encoding.filters.AudioMixFilter;
import com.bitmovin.api.encoding.filters.SourceChannel;
import com.bitmovin.api.encoding.filters.enums.AudioMixChannelLayout;
import com.bitmovin.api.encoding.filters.enums.SourceChannelType;
import com.bitmovin.api.encoding.inputs.S3Input;
import com.bitmovin.api.encoding.outputs.S3Output;
import com.bitmovin.api.encoding.status.Task;
import com.bitmovin.api.enums.Status;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.http.RestException;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

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
    public void testCreateEncodingWithAudioMuxFilter() throws URISyntaxException, BitmovinApiException, UnirestException, IOException, RestException, InterruptedException
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
        FMP4Muxing muxingVideo720p = new FMP4Muxing();
        muxingVideo720p.addOutput(new EncodingOutput(
                output.getId(),
                OUTPUT_BASE_PATH + "video/720p"
        ));
        muxingVideo720p.addStream(new MuxingStream(videoStream720p.getId()));
        muxingVideo720p.setSegmentLength(4.0);
        bitmovinApi.encoding.muxing.addFmp4MuxingToEncoding(encoding, muxingVideo720p);

        FMP4Muxing muxingVideo1080p = new FMP4Muxing();
        muxingVideo1080p.addOutput(new EncodingOutput(
                output.getId(),
                OUTPUT_BASE_PATH + "video/1080p"
        ));
        muxingVideo1080p.addStream(new MuxingStream(videoStream1080p.getId()));
        muxingVideo1080p.setSegmentLength(4.0);
        bitmovinApi.encoding.muxing.addFmp4MuxingToEncoding(encoding, muxingVideo1080p);

        FMP4Muxing muxingAudio = new FMP4Muxing();
        muxingAudio.addOutput(new EncodingOutput(
                output.getId(),
                OUTPUT_BASE_PATH + "audio"
        ));
        muxingAudio.addStream(new MuxingStream(audioStream.getId()));
        muxingAudio.setSegmentLength(4.0);
        bitmovinApi.encoding.muxing.addFmp4MuxingToEncoding(encoding, muxingAudio);
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

        System.out.println("Waiting for encoding to be finished...");
        Task status = bitmovinApi.encoding.getStatus(encoding);

        while (status.getStatus() != Status.FINISHED && status.getStatus() != Status.ERROR)
        {
            status = bitmovinApi.encoding.getStatus(encoding);
            Thread.sleep(2500);
        }

        System.out.println(String.format("Encoding finished with status %s", status.getStatus().toString()));

        if (status.getStatus() == Status.ERROR)
        {
            System.out.println("Encoding has status ERROR");
        }

        System.out.println("Encoding finished successfully!");
    }
}
