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
import com.bitmovin.api.encoding.encodings.muxing.MP4Muxing;
import com.bitmovin.api.encoding.encodings.muxing.MuxingStream;
import com.bitmovin.api.encoding.encodings.muxing.TimeCode;
import com.bitmovin.api.encoding.encodings.streams.Stream;
import com.bitmovin.api.encoding.enums.CloudRegion;
import com.bitmovin.api.encoding.enums.StreamSelectionMode;
import com.bitmovin.api.encoding.inputs.HttpsInput;
import com.bitmovin.api.encoding.outputs.GcsOutput;
import com.bitmovin.api.encoding.outputs.Output;
import com.bitmovin.api.encoding.outputs.S3Output;
import com.bitmovin.api.encoding.status.Task;
import com.bitmovin.api.enums.Status;
import com.bitmovin.api.examples.util.H264Representation;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.http.RestException;
import com.bitmovin.api.webhooks.Webhook;
import com.bitmovin.api.webhooks.enums.WebhookHttpMethod;
import com.bitmovin.api.webhooks.enums.WebhookType;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

/**
 * Created by Roland Kersche on 30.05.17.
 */
public class CreateEncodingWithTimecode
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

    private static List<H264Representation> h264Representations = Arrays.asList(
            new H264Representation(null, 240, null, 400000L , ProfileH264.MAIN),
            new H264Representation(null, 360, null, 800000L, ProfileH264.MAIN),
            new H264Representation(null, 480, null, 1200000L, ProfileH264.MAIN),
            new H264Representation(null, 720, null, 2400000L, ProfileH264.MAIN),
            new H264Representation(null, 1080, null, 4800000L, ProfileH264.MAIN)
    );

    @Test
    public void testEncoding() throws IOException, BitmovinApiException, UnirestException, URISyntaxException, RestException, InterruptedException
    {
        bitmovinApi = new BitmovinApi(API_KEY);
        Encoding encoding = new Encoding();
        encoding.setName("Encoding Java Example - Add TimeCode to MP4Muxing");
        encoding.setCloudRegion(CLOUD_REGION);
        encoding = bitmovinApi.encoding.create(encoding);

        HttpsInput input = new HttpsInput();
        input.setHost(HTTPS_INPUT_HOST);
        input = bitmovinApi.input.https.create(input);

        S3Output output = new S3Output();
        output.setAccessKey(S3_OUTPUT_ACCESSKEY);
        output.setSecretKey(S3_OUTPUT_SECRET_KEY);
        output.setBucketName(S3_OUTPUT_BUCKET_NAME);
        output = bitmovinApi.output.s3.create(output);

        InputStream inputStreamVideo = new InputStream();
        inputStreamVideo.setInputPath(HTTPS_INPUT_PATH);
        inputStreamVideo.setInputId(input.getId());
        inputStreamVideo.setSelectionMode(StreamSelectionMode.VIDEO_RELATIVE);
        inputStreamVideo.setPosition(0);

        InputStream inputStreamAudio = new InputStream();
        inputStreamAudio.setInputPath(HTTPS_INPUT_PATH);
        inputStreamAudio.setInputId(input.getId());
        inputStreamAudio.setSelectionMode(StreamSelectionMode.AUDIO_RELATIVE);
        inputStreamAudio.setPosition(0);

        AACAudioConfig aacConfiguration = new AACAudioConfig();
        aacConfiguration.setBitrate(96000L);
        aacConfiguration.setRate(48000f);
        aacConfiguration = bitmovinApi.configuration.audioAAC.create(aacConfiguration);

        Stream audioStream = new Stream();
        audioStream.setCodecConfigId(aacConfiguration.getId());
        audioStream.setInputStreams(Collections.singleton(inputStreamAudio));
        audioStream = bitmovinApi.encoding.stream.addStream(encoding, audioStream);

        String startTimeCode = "01:00:00:00";
        TimeCode timeCode = new TimeCode();
        timeCode.setTimeCodeStart(startTimeCode);

        for (H264Representation representation: h264Representations)
        {
            H264VideoConfiguration videoConfig = new H264VideoConfiguration();
            videoConfig.setHeight(representation.getHeight());
            videoConfig.setBitrate(representation.getBitrate());
            videoConfig.setProfile(representation.getProfile());

            videoConfig = bitmovinApi.configuration.videoH264.create(videoConfig);

            Stream videoStream = new Stream();
            videoStream.setCodecConfigId(videoConfig.getId());
            videoStream.setInputStreams(Collections.singleton(inputStreamVideo));
            videoStream = bitmovinApi.encoding.stream.addStream(encoding, videoStream);

            this.createMP4Muxing(encoding, output, videoStream, audioStream, String.format("video_audio_%sp.mp4", videoConfig.getHeight()), timeCode);
        }

        bitmovinApi.encoding.start(encoding);

        Task status = bitmovinApi.encoding.getStatus(encoding);

        while (status.getStatus() != Status.FINISHED && status.getStatus() != Status.ERROR)
        {
            status = bitmovinApi.encoding.getStatus(encoding);
            Thread.sleep(2500);
        }

        System.out.println(String.format("Encoding finished with status %s", status.getStatus().toString()));

    }

    private void createMP4Muxing(Encoding encoding, Output output, Stream videoStream240p, Stream audioStream, String filename, TimeCode timeCode) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        EncodingOutput encodingOutput = new EncodingOutput();
        encodingOutput.setOutputId(output.getId());
        encodingOutput.setOutputPath(OUTPUT_BASE_PATH);
        encodingOutput.setAcl(new ArrayList<AclEntry>()
        {{
            this.add(new AclEntry(AclPermission.PUBLIC_READ));
        }});
        MP4Muxing mp4Muxing = new MP4Muxing();
        mp4Muxing.setFilename(filename);
        mp4Muxing.setOutputs(Collections.singletonList(encodingOutput));
        List<MuxingStream> muxingStreams = new ArrayList<>();
        MuxingStream muxingStreamVideo = new MuxingStream();
        muxingStreamVideo.setStreamId(videoStream240p.getId());
        MuxingStream muxingStreamAudio = new MuxingStream();
        muxingStreamAudio.setStreamId(audioStream.getId());
        muxingStreams.add(muxingStreamVideo);
        muxingStreams.add(muxingStreamAudio);
        mp4Muxing.setStreams(muxingStreams);
        mp4Muxing.setTimeCode(timeCode);
        bitmovinApi.encoding.muxing.addMp4MuxingToEncoding(encoding, mp4Muxing);
    }

}
