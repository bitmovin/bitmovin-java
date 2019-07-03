package com.bitmovin.api.examples;

import com.bitmovin.api.BitmovinApi;
import com.bitmovin.api.encoding.AclEntry;
import com.bitmovin.api.encoding.AclPermission;
import com.bitmovin.api.encoding.EncodingOutput;
import com.bitmovin.api.encoding.InputStream;
import com.bitmovin.api.encoding.codecConfigurations.AACAudioConfig;
import com.bitmovin.api.encoding.codecConfigurations.H264VideoConfiguration;
import com.bitmovin.api.encoding.codecConfigurations.WebVttConfiguration;
import com.bitmovin.api.encoding.codecConfigurations.enums.ProfileH264;
import com.bitmovin.api.encoding.encodings.Encoding;
import com.bitmovin.api.encoding.encodings.muxing.MuxingStream;
import com.bitmovin.api.encoding.encodings.muxing.TSMuxing;
import com.bitmovin.api.encoding.encodings.muxing.TextMuxing;
import com.bitmovin.api.encoding.encodings.streams.Cea608CaptionInputStream;
import com.bitmovin.api.encoding.encodings.streams.Cea608ChannelType;
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
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by gfronza on 7/3/19.
 */
public class CreateEncodingThatConvertsCea608CaptionToWebVtt
{
    private static String ApiKey = "<INSERT_YOUR_APIKEY>";

    private static CloudRegion cloudRegion = CloudRegion.AWS_EU_WEST_1;
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
        bitmovinApi = new BitmovinApi(ApiKey);

        Encoding encoding = new Encoding();
        encoding.setName("Encoding JAVA");
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

        H264VideoConfiguration videoConfiguration = new H264VideoConfiguration();
        videoConfiguration.setHeight(480);
        videoConfiguration.setBitrate(1200000L);
        videoConfiguration.setProfile(ProfileH264.HIGH);
        videoConfiguration = bitmovinApi.configuration.videoH264.create(videoConfiguration);

        WebVttConfiguration webVttConfiguration = new WebVttConfiguration();
        webVttConfiguration = bitmovinApi.configuration.webVtt.create(webVttConfiguration);

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

        Cea608CaptionInputStream cea608CaptionInputStream = new Cea608CaptionInputStream();
        cea608CaptionInputStream.setInputId(input.getId());
        cea608CaptionInputStream.setInputPath(HTTPS_INPUT_PATH);
        cea608CaptionInputStream.setChannel(Cea608ChannelType.CC1);
        cea608CaptionInputStream = bitmovinApi.encoding.cea608CaptionInputStreamResource.addCea608CaptionInputStreamToEncoding(encoding, cea608CaptionInputStream);

        Stream audioStream = new Stream();
        audioStream.setCodecConfigId(aacConfiguration.getId());
        audioStream.setInputStreams(Collections.singleton(inputStreamAudio));
        audioStream = bitmovinApi.encoding.stream.addStream(encoding, audioStream);

        Stream videoStream = new Stream();
        videoStream.setCodecConfigId(videoConfiguration.getId());
        videoStream.setInputStreams(Collections.singleton(inputStreamVideo));
        videoStream = bitmovinApi.encoding.stream.addStream(encoding, videoStream);

        InputStream inputStream = new InputStream();
        inputStream.setInputStreamId(cea608CaptionInputStream.getId());

        Stream subtitleStream = new Stream();
        subtitleStream.setInputStreams(Collections.singleton(inputStream));
        subtitleStream.setCodecConfigId(webVttConfiguration.getId());
        subtitleStream = bitmovinApi.encoding.stream.addStream(encoding, subtitleStream);

        this.createTSMuxing(encoding, Arrays.asList(videoStream, audioStream), output, OUTPUT_BASE_PATH + "/video", AclPermission.PUBLIC_READ);
        this.createTextMuxing(encoding, subtitleStream, output, OUTPUT_BASE_PATH + "/subtitles", AclPermission.PUBLIC_READ);

        bitmovinApi.encoding.start(encoding);

        Task status = bitmovinApi.encoding.getStatus(encoding);

        while (status.getStatus() != Status.FINISHED && status.getStatus() != Status.ERROR)
        {
            status = bitmovinApi.encoding.getStatus(encoding);
            Thread.sleep(2500);
        }

        System.out.println(String.format("Encoding finished with status %s", status.getStatus().toString()));
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

    private TSMuxing createTSMuxing(Encoding encoding, List<Stream> streams, Output output, String outputPath, AclPermission defaultAclPermission)
            throws URISyntaxException, BitmovinApiException, RestException, UnirestException, IOException
    {
        EncodingOutput encodingOutput = this.createEncodingOutput(output, outputPath, defaultAclPermission);
        TSMuxing muxing = new TSMuxing();
        muxing.addOutput(encodingOutput);

        for (Stream stream : streams)
        {
            MuxingStream muxingStream = new MuxingStream();
            muxingStream.setStreamId(stream.getId());
            muxing.getStreams().add(muxingStream);
        }

        muxing.setSegmentLength(4.0);
        muxing = bitmovinApi.encoding.muxing.addTSMuxingToEncoding(encoding, muxing);
        return muxing;
    }

    private TextMuxing createTextMuxing(Encoding encoding, Stream stream, Output output, String outputPath, AclPermission defaultAclPermission)
            throws URISyntaxException, BitmovinApiException, RestException, UnirestException, IOException
    {
        EncodingOutput encodingOutput = this.createEncodingOutput(output, outputPath, defaultAclPermission);
        TextMuxing muxing = new TextMuxing();
        muxing.setFilename("test.vtt");
        muxing.addOutput(encodingOutput);

        MuxingStream muxingStream = new MuxingStream();
        muxingStream.setStreamId(stream.getId());
        muxing.getStreams().add(muxingStream);

        muxing = bitmovinApi.encoding.muxing.addTextMuxingToEncoding(encoding, muxing);
        return muxing;
    }

}
