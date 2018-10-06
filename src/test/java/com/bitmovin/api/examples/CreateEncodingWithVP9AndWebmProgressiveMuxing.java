package com.bitmovin.api.examples;

import com.bitmovin.api.BitmovinApi;
import com.bitmovin.api.encoding.AclEntry;
import com.bitmovin.api.encoding.AclPermission;
import com.bitmovin.api.encoding.EncodingOutput;
import com.bitmovin.api.encoding.InputStream;
import com.bitmovin.api.encoding.codecConfigurations.AACAudioConfig;
import com.bitmovin.api.encoding.codecConfigurations.H264VideoConfiguration;
import com.bitmovin.api.encoding.codecConfigurations.OpusAudioConfig;
import com.bitmovin.api.encoding.codecConfigurations.VP9VideoConfiguration;
import com.bitmovin.api.encoding.codecConfigurations.enums.ProfileH264;
import com.bitmovin.api.encoding.encodings.Encoding;
import com.bitmovin.api.encoding.encodings.muxing.MP4Muxing;
import com.bitmovin.api.encoding.encodings.muxing.MuxingStream;
import com.bitmovin.api.encoding.encodings.muxing.ProgressiveWebmMuxing;
import com.bitmovin.api.encoding.encodings.streams.Stream;
import com.bitmovin.api.encoding.enums.CloudRegion;
import com.bitmovin.api.encoding.enums.StreamSelectionMode;
import com.bitmovin.api.encoding.inputs.HttpsInput;
import com.bitmovin.api.encoding.outputs.Output;
import com.bitmovin.api.encoding.outputs.S3Output;
import com.bitmovin.api.encoding.status.Task;
import com.bitmovin.api.enums.Status;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.http.RestException;
import com.bitmovin.api.webhooks.Webhook;
import com.bitmovin.api.webhooks.enums.WebhookHttpMethod;
import com.bitmovin.api.webhooks.enums.WebhookType;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class CreateEncodingWithVP9AndWebmProgressiveMuxing
{
    private static String API_KEY = "<INSERT_YOUR_APIKEY>";

    private static String HTTPS_INPUT_HOST = "<INSERT_YOUR_HTTP_HOST>"; // ex.: storage.googleapis.com/
    private static String HTTPS_INPUT_PATH = "<INSERT_YOUR_PATH_TO_INPUT_FILE>";
    private static String S3_OUTPUT_ACCESSKEY = "<INSERT_YOUR_ACCESSKEY>";
    private static String S3_OUTPUT_SECRET_KEY = "<INSERT_YOUR_SECRETKEY>";
    private static String S3_OUTPUT_BUCKET_NAME = "BUCKET_NAME";
    private static String OUTPUT_BASE_PATH = "path/to/your/outputs/" + new Date().getTime();

    private static BitmovinApi bitmovinApi;

    @Test
    public void testEncoding() throws IOException, BitmovinApiException, UnirestException, URISyntaxException, RestException, InterruptedException
    {
        bitmovinApi = new BitmovinApi(API_KEY);
        Encoding encoding = new Encoding();
        encoding.setName("Encoding JAVA");
        encoding.setCloudRegion(CloudRegion.AUTO);
        encoding = bitmovinApi.encoding.create(encoding);

        HttpsInput input = new HttpsInput();
        input.setHost(HTTPS_INPUT_HOST);
        input = bitmovinApi.input.https.create(input);

        S3Output output = new S3Output();
        output.setAccessKey(S3_OUTPUT_ACCESSKEY);
        output.setSecretKey(S3_OUTPUT_SECRET_KEY);
        output.setBucketName(S3_OUTPUT_BUCKET_NAME);
        output = bitmovinApi.output.s3.create(output);

        OpusAudioConfig audioConfiguration = new OpusAudioConfig();
        audioConfiguration.setBitrate(128000L);
        audioConfiguration.setRate(48000f);
        audioConfiguration = bitmovinApi.configuration.audioOpus.create(audioConfiguration);

        VP9VideoConfiguration videoConfiguration = new VP9VideoConfiguration();
        videoConfiguration.setWidth(384);
        videoConfiguration.setBitrate(200000L);
        videoConfiguration = bitmovinApi.configuration.videoVP9.create(videoConfiguration);

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

        Stream videoStream = new Stream();
        videoStream.setCodecConfigId(videoConfiguration.getId());
        videoStream.setInputStreams(Collections.singleton(inputStreamVideo));
        videoStream = bitmovinApi.encoding.stream.addStream(encoding, videoStream);

        Stream audioStream = new Stream();
        audioStream.setCodecConfigId(audioConfiguration.getId());
        audioStream.setInputStreams(Collections.singleton(inputStreamAudio));
        audioStream = bitmovinApi.encoding.stream.addStream(encoding, audioStream);

        this.createProgressiveWebmMuxing(encoding, output, videoStream, audioStream, "video_audio.webm");

        bitmovinApi.encoding.start(encoding);

        Task status = bitmovinApi.encoding.getStatus(encoding);

        while (status.getStatus() != Status.FINISHED && status.getStatus() != Status.ERROR)
        {
            status = bitmovinApi.encoding.getStatus(encoding);
            Thread.sleep(2500);
        }

        System.out.println(String.format("Encoding finished with status %s", status.getStatus().toString()));
    }

    private void createProgressiveWebmMuxing(Encoding encoding, Output output, Stream videoStream, Stream audioStream, String filename) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        EncodingOutput encodingOutput = new EncodingOutput();
        encodingOutput.setOutputId(output.getId());
        encodingOutput.setOutputPath(OUTPUT_BASE_PATH);
        encodingOutput.setAcl(new ArrayList<AclEntry>()
        {{
            this.add(new AclEntry(AclPermission.PUBLIC_READ));
        }});
        ProgressiveWebmMuxing muxing = new ProgressiveWebmMuxing();
        muxing.setFilename(filename);
        muxing.setOutputs(Collections.singletonList(encodingOutput));
        List<MuxingStream> muxingStreams = new ArrayList<>();
        MuxingStream muxingStreamVideo = new MuxingStream();
        muxingStreamVideo.setStreamId(videoStream.getId());
        MuxingStream muxingStreamAudio = new MuxingStream();
        muxingStreamAudio.setStreamId(audioStream.getId());
        muxingStreams.add(muxingStreamVideo);
        muxingStreams.add(muxingStreamAudio);
        muxing.setStreams(muxingStreams);
        bitmovinApi.encoding.muxing.addProgressiveWebmMuxingToEncoding(encoding, muxing);
    }
}
