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
import com.bitmovin.api.encoding.encodings.muxing.MuxingStream;
import com.bitmovin.api.encoding.encodings.muxing.TSMuxing;
import com.bitmovin.api.encoding.encodings.streams.Stream;
import com.bitmovin.api.encoding.enums.CloudRegion;
import com.bitmovin.api.encoding.enums.StreamSelectionMode;
import com.bitmovin.api.encoding.inputs.S3Input;
import com.bitmovin.api.encoding.manifest.hls.HlsManifest;
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
import java.util.List;

/**
 * Created by Roland Kersche on 30.05.17.
 */
public class CreateEncodingWithHLSv3
{

    private static String API_KEY = "<INSERT_YOUR_APIKEY>";

    private static CloudRegion CLOUD_REGION = CloudRegion.AWS_EU_WEST_1;

    private static String S3_INPUT_ACCESSKEY = "<INSERT_YOUR_ACCESSKEY>";
    private static String S3_INPUT_SECRET_KEY = "<INSERT_YOUR_SECRETKEY>";
    private static String S3_INPUT_BUCKET_NAME = "BUCKET_NAME";
    private static String S3_INPUT_PATH = "<INSERT_YOUR_PATH_TO_INPUT_FILE>";

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
        encoding.setName("Encoding JAVA with S3 Input and Output");
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

        // Add H264 configuration for encoding
        List<H264Representation> h264Representations = new ArrayList<>();
        h264Representations.add(new H264Representation(null, 240, null, 400L, ProfileH264.HIGH));
        h264Representations.add(new H264Representation(null, 360, null, 800L, ProfileH264.HIGH));
        h264Representations.add(new H264Representation(null, 480, null, 1200L, ProfileH264.HIGH));
        h264Representations.add(new H264Representation(null, 720, null, 2400L, ProfileH264.HIGH));
        h264Representations.add(new H264Representation(null, 1080, null, 4800L, ProfileH264.HIGH));

        AACAudioConfig aacConfiguration = new AACAudioConfig();
        aacConfiguration.setBitrate(128000L);
        aacConfiguration.setRate(48000f);
        aacConfiguration = bitmovinApi.configuration.audioAAC.create(aacConfiguration);

        InputStream inputStreamVideo = new InputStream();
        inputStreamVideo.setInputPath(S3_INPUT_PATH);
        inputStreamVideo.setInputId(input.getId());
        inputStreamVideo.setSelectionMode(StreamSelectionMode.VIDEO_RELATIVE);
        inputStreamVideo.setPosition(0);

        InputStream inputStreamAudio = new InputStream();
        inputStreamAudio.setInputPath(S3_INPUT_PATH);
        inputStreamAudio.setInputId(input.getId());
        inputStreamAudio.setSelectionMode(StreamSelectionMode.AUDIO_RELATIVE);
        inputStreamAudio.setPosition(0);

        Stream audioStream = new Stream();
        audioStream.setCodecConfigId(aacConfiguration.getId());
        audioStream.setInputStreams(Collections.singleton(inputStreamAudio));
        audioStream = bitmovinApi.encoding.stream.addStream(encoding, audioStream);

        for (H264Representation representation : h264Representations)
        {
            H264VideoConfiguration videoConfiguration = new H264VideoConfiguration();
            videoConfiguration.setHeight(representation.getHeight());
            videoConfiguration.setBitrate(representation.getBitrate() * 1000);
            videoConfiguration.setProfile(representation.getProfile());
            videoConfiguration = bitmovinApi.configuration.videoH264.create(videoConfiguration);
            representation.setConfiguration(videoConfiguration);

            Stream videoStream = new Stream();
            videoStream.setCodecConfigId(videoConfiguration.getId());
            videoStream.setInputStreams(Collections.singleton(inputStreamVideo));
            videoStream = bitmovinApi.encoding.stream.addStream(encoding, videoStream);
            representation.setStream(videoStream);

            TSMuxing tsMuxing = this.createTSMuxing(encoding, output,
                    String.format("/video/hls/%sp_%s/", representation.getHeight(), representation.getBitrate()),
                    Arrays.asList(videoStream, audioStream));
            representation.setTsMuxing(tsMuxing);
        }

        bitmovinApi.encoding.start(encoding);

        Task status = bitmovinApi.encoding.getStatus(encoding);
        while (status.getStatus() != Status.FINISHED && status.getStatus() != Status.ERROR)
        {
            status = bitmovinApi.encoding.getStatus(encoding);
            Thread.sleep(2500);
        }

        System.out.println(String.format("Encoding finished with status %s", status.getStatus().toString()));

        Assert.assertEquals(Status.FINISHED, status.getStatus());
        EncodingOutput manifestOutput = new EncodingOutput();
        manifestOutput.setOutputId(output.getId());
        manifestOutput.setOutputPath(OUTPUT_BASE_PATH);
        manifestOutput.setAcl(new ArrayList<AclEntry>()
        {{
            this.add(new AclEntry(AclPermission.PUBLIC_READ));
        }});

        // Create HLS Manifest
        HlsManifest hlsManifest = new HlsManifest();
        hlsManifest.setName("stream.m3u8");
        hlsManifest.setOutputs(Collections.singletonList(manifestOutput));
        hlsManifest = bitmovinApi.manifest.hls.create(hlsManifest);

        for (H264Representation representation : h264Representations)
        {
            this.addStreamInfo(String.format("video_%sp_%s.m3u8", representation.getHeight(), representation.getBitrate()),
                    encoding.getId(), representation.getStream().getId(), representation.getTsMuxing().getId(),
                    String.format("video/hls/%sp_%s/", representation.getHeight(), representation.getBitrate()),
                    hlsManifest);
        }

        bitmovinApi.manifest.hls.startGeneration(hlsManifest);

        Status hlsStatus = bitmovinApi.manifest.hls.getGenerationStatus(hlsManifest);
        while (hlsStatus != Status.FINISHED && hlsStatus != Status.ERROR)
        {
            hlsStatus = bitmovinApi.manifest.hls.getGenerationStatus(hlsManifest);
            Thread.sleep(2500);
        }

        System.out.println(String.format("HLS Manifest generation finished with status %s", hlsStatus.toString()));
        Assert.assertEquals(Status.FINISHED, hlsStatus);

    }

    private void addStreamInfo(String uri, String encodingId, String streamId, String muxingId, String segmentPath, HlsManifest manifest)
            throws URISyntaxException, BitmovinApiException, RestException, UnirestException, IOException
    {
        StreamInfo s = new StreamInfo();
        s.setUri(uri);
        s.setEncodingId(encodingId);
        s.setStreamId(streamId);
        s.setMuxingId(muxingId);
        s.setSegmentPath(segmentPath);
        bitmovinApi.manifest.hls.createStreamInfo(manifest, s);
    }

    private TSMuxing createTSMuxing(Encoding encoding, Output output, String path, List<Stream> streams) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        EncodingOutput encodingOutput = new EncodingOutput();
        encodingOutput.setOutputId(output.getId());
        encodingOutput.setOutputPath(OUTPUT_BASE_PATH + path);
        encodingOutput.setAcl(new ArrayList<AclEntry>()
        {{
            this.add(new AclEntry(AclPermission.PUBLIC_READ));
        }});
        TSMuxing tsMuxing = new TSMuxing();
        tsMuxing.setSegmentLength(4.0);
        tsMuxing.setOutputs(Collections.singletonList(encodingOutput));
        List<MuxingStream> muxingStreams = new ArrayList<>();
        for (Stream stream : streams)
        {
            MuxingStream muxingStreamVideo = new MuxingStream();
            muxingStreamVideo.setStreamId(stream.getId());
            muxingStreams.add(muxingStreamVideo);
        }
        tsMuxing.setStreams(muxingStreams);
        return bitmovinApi.encoding.muxing.addTSMuxingToEncoding(encoding, tsMuxing);
    }

}
