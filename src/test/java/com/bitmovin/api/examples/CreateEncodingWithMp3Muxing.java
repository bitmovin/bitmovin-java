package com.bitmovin.api.examples;

import com.bitmovin.api.BitmovinApi;
import com.bitmovin.api.encoding.AclEntry;
import com.bitmovin.api.encoding.AclPermission;
import com.bitmovin.api.encoding.EncodingOutput;
import com.bitmovin.api.encoding.InputStream;
import com.bitmovin.api.encoding.codecConfigurations.MP3AudioConfig;
import com.bitmovin.api.encoding.encodings.Encoding;
import com.bitmovin.api.encoding.encodings.muxing.MP3Muxing;
import com.bitmovin.api.encoding.encodings.muxing.MuxingStream;
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
import java.util.Collections;
import java.util.Date;

public class CreateEncodingWithMp3Muxing
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
    public void testEncodingWithMP3Muxing() throws IOException, BitmovinApiException, UnirestException, URISyntaxException, RestException, InterruptedException
    {
        bitmovinApi = new BitmovinApi(ApiKey);

        Encoding encoding = new Encoding();
        encoding.setName("Encoding Java MP3 Muxing");
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

        MP3AudioConfig mp3AudioConfig = new MP3AudioConfig();
        mp3AudioConfig.setBitrate(128000L);
        mp3AudioConfig.setRate(48000f);
        mp3AudioConfig = bitmovinApi.configuration.audioMP3.create(mp3AudioConfig);

        InputStream inputStreamAudio = new InputStream();
        inputStreamAudio.setInputPath(HTTPS_INPUT_PATH);
        inputStreamAudio.setInputId(input.getId());
        inputStreamAudio.setSelectionMode(StreamSelectionMode.AUDIO_RELATIVE);
        inputStreamAudio.setPosition(0);

        Stream audioStream = new Stream();
        audioStream.setCodecConfigId(mp3AudioConfig.getId());
        audioStream.setInputStreams(Collections.singleton(inputStreamAudio));
        audioStream = bitmovinApi.encoding.stream.addStream(encoding, audioStream);

        this.createMp3Muxing(encoding, output, audioStream, OUTPUT_BASE_PATH, "myMp3.mp3", AclPermission.PUBLIC_READ);

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

    private MP3Muxing createMp3Muxing(Encoding encoding, Output output, Stream stream, String outputPath, String filename, AclPermission aclPermission) throws URISyntaxException, BitmovinApiException, UnirestException, IOException
    {
        EncodingOutput encodingOutput = this.createEncodingOutput(output, outputPath, aclPermission);

        MP3Muxing muxing = new MP3Muxing();
        muxing.addOutput(encodingOutput);
        muxing.setFilename(filename);

        MuxingStream muxingStream = new MuxingStream();
        muxingStream.setStreamId(stream.getId());

        muxing.addStream(muxingStream);
        muxing = bitmovinApi.encoding.muxing.addMp3MuxingToEncoding(encoding, muxing);
        return muxing;
    }
}
