package com.bitmovin.api.examples;

import com.bitmovin.api.BitmovinApi;
import com.bitmovin.api.encoding.AclEntry;
import com.bitmovin.api.encoding.AclPermission;
import com.bitmovin.api.encoding.EncodingOutput;
import com.bitmovin.api.encoding.InputStream;
import com.bitmovin.api.encoding.codecConfigurations.AACAudioConfig;
import com.bitmovin.api.encoding.codecConfigurations.H264VideoConfiguration;
import com.bitmovin.api.encoding.codecConfigurations.MJPEGCodecConfiguration;
import com.bitmovin.api.encoding.codecConfigurations.enums.PixelFormat;
import com.bitmovin.api.encoding.codecConfigurations.enums.ProfileH264;
import com.bitmovin.api.encoding.encodings.Encoding;
import com.bitmovin.api.encoding.encodings.muxing.MP4Muxing;
import com.bitmovin.api.encoding.encodings.muxing.MuxingStream;
import com.bitmovin.api.encoding.encodings.muxing.ProgressiveMOVMuxing;
import com.bitmovin.api.encoding.encodings.streams.Stream;
import com.bitmovin.api.encoding.enums.CloudRegion;
import com.bitmovin.api.encoding.enums.StreamSelectionMode;
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
import java.util.Collections;
import java.util.HashSet;

public class CreateMp4EncodingAndKeyframeArchive
{
    private static String API_KEY = "<YOUR BITMOVIN API KEY>";

    private static CloudRegion CLOUD_REGION = CloudRegion.AWS_EU_WEST_1;

    private static String S3_INPUT_ACCESSKEY = "<YOUR S3 INPUT ACCESS KEY>";
    private static String S3_INPUT_SECRET_KEY = "<YOUR S3 INPUT SECRET KEY>";
    private static String S3_INPUT_BUCKET_NAME = "<YOUR S3 INPUT BUCKET NAME>";
    private static String S3_INPUT_PATH = "path/to/your/input/file.mkv";

    private static String S3_OUTPUT_ACCESSKEY = "<YOUR S3 OUTPUT ACCESS KEY>";
    private static String S3_OUTPUT_SECRET_KEY = "<YOUR S3 OUTPUT SECRET KEY>";
    private static String S3_OUTPUT_BUCKET_NAME = "<YOUR S3 OUTPUT BUCKET NAME>";
    private static String OUTPUT_BASE_PATH = "/your/output/base/path/";

    private static String MP4_OUTPUT_FILE_NAME = "myMp4Output.mp4";
    private static String MOV_OUTPUT_FILE_NAME = "myMovOutput.mov";

    private static BitmovinApi bitmovinApi;

    @Test
    public void testCreateMp4AndMovEncoding() throws URISyntaxException, BitmovinApiException, UnirestException, IOException, RestException, InterruptedException
    {
        bitmovinApi = new BitmovinApi(API_KEY);

        Encoding encoding = new Encoding();
        encoding.setName("MP4 and MOV Encoding");
        encoding.setDescription("MP4 and MOV Encoding ");
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

        H264VideoConfiguration mp4VideoConfig = new H264VideoConfiguration();
        mp4VideoConfig.setName("H264 Codec Config");
        mp4VideoConfig.setProfile(ProfileH264.HIGH);
        mp4VideoConfig.setMinBitrate(800000L);
        mp4VideoConfig.setMaxBitrate(1500000L);
        mp4VideoConfig.setBufsize(1835000L);
        mp4VideoConfig.setBitrate(1000000L);
        mp4VideoConfig.setHeight(360);
        mp4VideoConfig.setWidth(640);
        mp4VideoConfig.setPixelFormat(PixelFormat.YUV420P);
        mp4VideoConfig = bitmovinApi.configuration.videoH264.create(mp4VideoConfig);

        InputStream videoInput = new InputStream();
        videoInput.setInputId(input.getId());
        videoInput.setInputPath(S3_INPUT_PATH);
        videoInput.setPosition(0);
        videoInput.setSelectionMode(StreamSelectionMode.AUTO);

        Stream videoStream = new Stream();
        videoStream.setCodecConfigId(mp4VideoConfig.getId());
        videoStream.setInputStreams(new HashSet<>(Collections.singletonList(videoInput)));
        videoStream = bitmovinApi.encoding.stream.addStream(encoding, videoStream);

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

        MuxingStream videoMuxingStream = new MuxingStream();
        videoMuxingStream.setStreamId(videoStream.getId());

        MuxingStream audioMuxingStream = new MuxingStream();
        audioMuxingStream.setStreamId(audioStream.getId());

        MP4Muxing mp4Muxing = new MP4Muxing();
        mp4Muxing.addStream(videoMuxingStream);
        mp4Muxing.addStream(audioMuxingStream);

        EncodingOutput encodingOutput = new EncodingOutput();
        encodingOutput.setOutputId(output.getId());
        encodingOutput.setOutputPath(OUTPUT_BASE_PATH);
        AclEntry aclEntry = new AclEntry(AclPermission.PUBLIC_READ);
        encodingOutput.setAcl(Collections.singletonList(aclEntry));

        mp4Muxing.setOutputs(Collections.singletonList(encodingOutput));
        mp4Muxing.setFilename(MP4_OUTPUT_FILE_NAME);
        mp4Muxing.setName("My MP4 Muxing");

        bitmovinApi.encoding.muxing.addMp4MuxingToEncoding(encoding, mp4Muxing);

        MJPEGCodecConfiguration mjpegVideoConfiguration = new MJPEGCodecConfiguration();
        mjpegVideoConfiguration.setName("MJPEG Codec Config");
        mjpegVideoConfiguration.setPixelFormat(PixelFormat.YUV420P);
        mjpegVideoConfiguration.setRate(1.0F);
        mjpegVideoConfiguration.setqScale(1);
        mjpegVideoConfiguration = bitmovinApi.configuration.mjpeg.create(mjpegVideoConfiguration);

        Stream mjpegVideoStream = new Stream();
        mjpegVideoStream.setCodecConfigId(mjpegVideoConfiguration.getId());
        mjpegVideoStream.setInputStreams(new HashSet<>(Collections.singletonList(videoInput)));
        mjpegVideoStream = bitmovinApi.encoding.stream.addStream(encoding, mjpegVideoStream);

        MuxingStream movStream = new MuxingStream();
        movStream.setStreamId(mjpegVideoStream.getId());

        ProgressiveMOVMuxing movMuxing = new ProgressiveMOVMuxing();
        movMuxing.setName("My MOV Muxing");
        movMuxing.setFilename(MOV_OUTPUT_FILE_NAME);
        movMuxing.addStream(movStream);
        movMuxing.setOutputs(Collections.singletonList(encodingOutput));

        bitmovinApi.encoding.muxing.addProgressiveMOVMuxingToEncoding(encoding, movMuxing);

        bitmovinApi.encoding.start(encoding);

        Task status = bitmovinApi.encoding.getStatus(encoding);

        while (status.getStatus() != Status.FINISHED && status.getStatus() != Status.ERROR)
        {
            status = bitmovinApi.encoding.getStatus(encoding);
            Thread.sleep(2500);
        }

        System.out.println(String.format("Encoding finished with status %s", status.getStatus().toString()));

        if (status.getStatus() == Status.ERROR)
        {
            System.out.println("Encoding has status error");
            return;
        }

        System.out.println("Encoding finished successfully!");
    }
}
