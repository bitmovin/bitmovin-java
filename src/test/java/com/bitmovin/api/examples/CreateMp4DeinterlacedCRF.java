package com.bitmovin.api.examples;

import com.bitmovin.api.BitmovinApi;
import com.bitmovin.api.encoding.AclEntry;
import com.bitmovin.api.encoding.AclPermission;
import com.bitmovin.api.encoding.EncodingOutput;
import com.bitmovin.api.encoding.InputStream;
import com.bitmovin.api.encoding.StreamFilter;
import com.bitmovin.api.encoding.StreamFilterList;
import com.bitmovin.api.encoding.codecConfigurations.AACAudioConfig;
import com.bitmovin.api.encoding.codecConfigurations.H264VideoConfiguration;
import com.bitmovin.api.encoding.codecConfigurations.enums.ProfileH264;
import com.bitmovin.api.encoding.encodings.Encoding;
import com.bitmovin.api.encoding.encodings.muxing.MP4Muxing;
import com.bitmovin.api.encoding.encodings.muxing.MuxingStream;
import com.bitmovin.api.encoding.encodings.streams.Stream;
import com.bitmovin.api.encoding.enums.CloudRegion;
import com.bitmovin.api.encoding.enums.StreamSelectionMode;
import com.bitmovin.api.encoding.filters.DeinterlaceFilter;
import com.bitmovin.api.encoding.filters.enums.DeinterlaceMode;
import com.bitmovin.api.encoding.filters.enums.PictureFieldParity;
import com.bitmovin.api.encoding.inputs.HttpInput;
import com.bitmovin.api.encoding.outputs.S3Output;
import com.bitmovin.api.encoding.status.Task;
import com.bitmovin.api.enums.Status;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.helper.H264CodecConfigHelper;
import com.bitmovin.api.helper.VideoCodecPresets;
import com.bitmovin.api.http.RestException;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CreateMp4DeinterlacedCRF
{
    private static String API_KEY = "<INSERT_YOUR_APIKEY>";

    private static CloudRegion CLOUD_REGION = CloudRegion.AWS_EU_WEST_1;
    private static String HTTPS_INPUT_HOST = "<INSERT_YOUR_HTTP_HOST>"; // ex.: storage.googleapis.com/
    private static String S3_OUTPUT_ACCESSKEY = "<INSERT_YOUR_ACCESSKEY>";
    private static String S3_OUTPUT_SECRET_KEY = "<INSERT_YOUR_SECRETKEY>";
    private static String S3_OUTPUT_BUCKET_NAME = "<INSERT_YOUR_BUCKET_NAME>";
    private static String RELATIVE_INPUT_FILE_URL = "path/to/your/file.mkv";
    private static String OUTPUT_BASE_PATH = "path/to/your/outputs/" + new Date().getTime() + "/";
    private static String OUTPUT_FILENAME = "muxed_file_deinterlaced.mp4";

    private static BitmovinApi bitmovinApi;

    @Test
    public void testCreateMp4DeinterlacedCRF() throws URISyntaxException, BitmovinApiException, UnirestException, IOException, RestException, InterruptedException
    {
        bitmovinApi = new BitmovinApi(API_KEY);

        Encoding encoding = new Encoding();
        encoding.setName("MP4 Encoding");
        encoding.setDescription("MP4 Encoding with deinterlaced filter");
        encoding.setCloudRegion(CLOUD_REGION);
        encoding = bitmovinApi.encoding.create(encoding);

        HttpInput input = new HttpInput();
        input.setHost(HTTPS_INPUT_HOST);
        input = bitmovinApi.input.http.create(input);

        S3Output output = new S3Output();
        output.setAccessKey(S3_OUTPUT_ACCESSKEY);
        output.setSecretKey(S3_OUTPUT_SECRET_KEY);
        output.setBucketName(S3_OUTPUT_BUCKET_NAME);
        output = bitmovinApi.output.s3.create(output);

        H264VideoConfiguration videoConfig = H264CodecConfigHelper.getConfig(
                "H264 Codec Config",
                "H264 Codec Config",
                ProfileH264.HIGH,
                VideoCodecPresets.VERYSLOW,
                1920,
                1080,
                12000000,
                29.97f
        );
        videoConfig.setBitrate(null);
        videoConfig.setCrf(25.0f);
        videoConfig = bitmovinApi.configuration.videoH264.create(videoConfig);

        InputStream videoInput = new InputStream();
        videoInput.setInputId(input.getId());
        videoInput.setInputPath(RELATIVE_INPUT_FILE_URL);
        videoInput.setPosition(0);
        videoInput.setSelectionMode(StreamSelectionMode.AUTO);

        DeinterlaceFilter deinterlaceFilter = new DeinterlaceFilter();
        deinterlaceFilter.setParity(PictureFieldParity.AUTO);
        deinterlaceFilter.setMode(DeinterlaceMode.FRAME);
        deinterlaceFilter = bitmovinApi.filter.deinterlace.create(deinterlaceFilter);

        List<StreamFilter> streamFilters = new ArrayList<>();
        StreamFilter streamFilter = new StreamFilter();
        streamFilter.setFilter(deinterlaceFilter);
        streamFilters.add(streamFilter);

        StreamFilterList streamFilterList = new StreamFilterList();
        streamFilterList.setFilters(streamFilters);

        Stream videoStream = new Stream();
        videoStream.setCodecConfigId(videoConfig.getId());
        videoStream.setInputStreams(new HashSet<>(Arrays.asList(videoInput)));
        videoStream.setFilters(streamFilters);
        videoStream = bitmovinApi.encoding.stream.addStream(encoding, videoStream);

        AACAudioConfig audioConfig = new AACAudioConfig();
        audioConfig.setBitrate(256000L);
        audioConfig.setRate(48000F);
        audioConfig = bitmovinApi.configuration.audioAAC.create(audioConfig);

        Set<InputStream> audioInputStreams = new HashSet<>();
        InputStream inputStream1 = new InputStream();
        inputStream1.setInputId(input.getId());
        inputStream1.setInputPath(RELATIVE_INPUT_FILE_URL);
        inputStream1.setPosition(0);
        inputStream1.setSelectionMode(StreamSelectionMode.AUDIO_RELATIVE);
        audioInputStreams.add(inputStream1);

        InputStream inputStream2 = new InputStream();
        inputStream2.setInputId(input.getId());
        inputStream2.setInputPath(RELATIVE_INPUT_FILE_URL);
        inputStream2.setPosition(1);
        inputStream2.setSelectionMode(StreamSelectionMode.AUDIO_RELATIVE);
        audioInputStreams.add(inputStream2);

        Stream audioStream = new Stream();
        audioStream.setInputStreams(audioInputStreams);
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
        encodingOutput.setAcl(Arrays.asList(aclEntry));

        mp4Muxing.setOutputs(Arrays.asList(encodingOutput));
        mp4Muxing.setFilename(OUTPUT_FILENAME);
        mp4Muxing.setName("My MP4 Muxing");

        bitmovinApi.encoding.muxing.addMp4MuxingToEncoding(encoding, mp4Muxing);

        bitmovinApi.encoding.start(encoding);

        Task status = bitmovinApi.encoding.getStatus(encoding);

        while (status.getStatus() != Status.FINISHED && status.getStatus() != Status.ERROR)
        {
            status = bitmovinApi.encoding.getStatus(encoding);
            Thread.sleep(2500);
        }

        System.out.println(String.format("Encoding finished with status %s", status.getStatus().toString()));

        if (status.getStatus() != Status.FINISHED)
        {
            System.out.println("Encoding has status error");
        }

        System.out.println("Encoding finished successfully!");
    }
}

