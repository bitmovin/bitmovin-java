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
import com.bitmovin.api.encoding.encodings.drms.AesEncryptionDrm;
import com.bitmovin.api.encoding.encodings.drms.enums.AESEncryptionMethod;
import com.bitmovin.api.encoding.encodings.muxing.MuxingStream;
import com.bitmovin.api.encoding.encodings.muxing.TSMuxing;
import com.bitmovin.api.encoding.encodings.streams.Stream;
import com.bitmovin.api.encoding.enums.CloudRegion;
import com.bitmovin.api.encoding.enums.StreamSelectionMode;
import com.bitmovin.api.encoding.inputs.HttpsInput;
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
import java.util.*;

/**
 * Created by Raul Vecchione on 26.07.18.
 */
public class CreateHLSEncodingWithAES128
{
    private static String API_KEY = "<INSERT_YOUR_APIKEY>";

    private static CloudRegion cloudRegion = CloudRegion.AWS_US_WEST_1;

    private static String HTTPS_INPUT_HOST = "<INSERT_YOUR_HTTP_INPUT_HOST>"; // ex.: storage.googleapis.com/
    private static String HTTPS_INPUT_PATH = "<INSERT_YOUR_PATH_TO_INPUT_FILE>"; // ex.: bitmovin-api-us-west1-ci-input/path/myfile.mp4
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
        encoding.setName("JAVA Encoding HLS With AES-128");
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

        // Encoding Configuration - Adding h264 Representations
        List<H264Representation> h264Representations = new ArrayList<>();
        h264Representations.add ( new H264Representation(null, 240, null, 400L, ProfileH264.HIGH));
        h264Representations.add(new H264Representation(null, 360, null, 800L, ProfileH264.HIGH));
        h264Representations.add(new H264Representation(null, 480, null, 1200L, ProfileH264.HIGH));
        h264Representations.add(new H264Representation(null, 720, null, 2400L, ProfileH264.HIGH));
        h264Representations.add(new H264Representation(null, 1080, null, 4800L, ProfileH264.HIGH));

        // Encoding Configuration - Audio
        AACAudioConfig aacConfiguration = new AACAudioConfig();
        aacConfiguration.setBitrate(128000L);
        aacConfiguration.setRate(48000f);
        aacConfiguration = bitmovinApi.configuration.audioAAC.create(aacConfiguration);

        for (H264Representation representation : h264Representations) {
            H264VideoConfiguration videoConfiguration = new H264VideoConfiguration();
            videoConfiguration.setHeight(representation.getHeight());
            videoConfiguration.setBitrate(representation.getBitrate()*1000);
            videoConfiguration.setProfile(ProfileH264.HIGH);
            videoConfiguration = bitmovinApi.configuration.videoH264.create(videoConfiguration);
            representation.setConfiguration(videoConfiguration);

            // Encoding Configuration - Streams
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

            Stream audioStream = new Stream();
            audioStream.setCodecConfigId(aacConfiguration.getId());
            audioStream.setInputStreams(Collections.singleton(inputStreamAudio));
            audioStream = bitmovinApi.encoding.stream.addStream(encoding, audioStream);
            representation.setStream(audioStream);

            Stream videoStream = new Stream();
            videoStream.setCodecConfigId(videoConfiguration.getId());
            videoStream.setInputStreams(Collections.singleton(inputStreamVideo));
            videoStream = bitmovinApi.encoding.stream.addStream(encoding, videoStream);
            representation.setStream(videoStream);

            // AES - Configuration
            AesEncryptionDrm aesEncryptionDrm = new AesEncryptionDrm();
            aesEncryptionDrm.setKey("<SET_YOUR_STRING_KEY>"); // 128 bit (16 bytes)  ex.: cab5b529ae28d5cc5e3e7bc3fd4a544d
            aesEncryptionDrm.setIv("<SET_YOUR_STRING_IV>"); // 128 bit (16 bytes) ex.: 08eecef4b026deec395234d94218273d
            aesEncryptionDrm.setId("DRM_AES_128" + String.format("%sp_%s", representation.getHeight(), representation.getBitrate()));
            aesEncryptionDrm.setMethod(AESEncryptionMethod.AES_128);

            // Muxing Configuration - Creating Muxing configuration
            TSMuxing tsMuxing = this.createTSMuxingNoOutput(encoding, Arrays.asList( videoStream, audioStream));
            System.out.println("Output path: " + OUTPUT_BASE_PATH + "/video/hls/drm/" + String.format("%sp_%s", representation.getHeight(), representation.getBitrate()));
            this.addOutputToDRM(aesEncryptionDrm, output, OUTPUT_BASE_PATH + "/video/hls/drm/" + String.format("%sp_%s", representation.getHeight(), representation.getBitrate()), tsMuxing);
            this.addAesDrmToTssMuxing(encoding, tsMuxing, aesEncryptionDrm);
            representation.setTsMuxing(tsMuxing);
        }

        // Start Encoding
        this.bitmovinApi.encoding.start(encoding);

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
                    String.format("video/hls/drm/%sp_%s/", representation.getHeight(), representation.getBitrate()),
                    hlsManifest, representation.getTsMuxing().getDrmConfigs().get(0).getId());
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

    private void addStreamInfo(String uri, String encodingId, String streamId, String muxingId, String segmentPath, HlsManifest manifest, String aesEncryptionDrmId)
            throws URISyntaxException, BitmovinApiException, RestException, UnirestException, IOException
    {
        StreamInfo s = new StreamInfo();
        s.setUri(uri);
        s.setEncodingId(encodingId);
        s.setStreamId(streamId);
        s.setMuxingId(muxingId);
        s.setSegmentPath(segmentPath);
        s.setDrmId(aesEncryptionDrmId);
        bitmovinApi.manifest.hls.createStreamInfo(manifest, s);
    }

    private TSMuxing createTSMuxingNoOutput(Encoding encoding, List<Stream> streams)
            throws URISyntaxException, BitmovinApiException, RestException, UnirestException, IOException
    {
        TSMuxing muxing = new TSMuxing();
        MuxingStream list = new MuxingStream();
        List<MuxingStream> muxingStreams = new ArrayList<>();
        for (Stream stream : streams)
        {
            MuxingStream muxingStreamVideo = new MuxingStream();
            muxingStreamVideo.setStreamId(stream.getId());
            muxingStreams.add(muxingStreamVideo);
        }
        muxing.setStreams(muxingStreams);
        muxing.setSegmentLength(4.0);
        muxing = bitmovinApi.encoding.muxing.addTSMuxingToEncoding(encoding, muxing);
        return muxing;
    }

    private void addOutputToDRM(AesEncryptionDrm aesEncryptionDrm, Output output, String outputPath, TSMuxing tsMuxing)
    {
        List<EncodingOutput> drmOutputs = aesEncryptionDrm.getOutputs();

        if (drmOutputs == null)
        {
            drmOutputs = new ArrayList<>();
            aesEncryptionDrm.setOutputs(drmOutputs);
        }

        EncodingOutput drmOutput = new EncodingOutput();
        drmOutput.setOutputId(output.getId());
        drmOutput.setOutputPath(outputPath);
        drmOutputs.add(drmOutput);
        tsMuxing.setOutputs(Collections.singletonList(drmOutput));
    }

    private AesEncryptionDrm addAesDrmToTssMuxing(Encoding encoding, TSMuxing tsMuxing, AesEncryptionDrm aesEncryptionDrm)
            throws BitmovinApiException, IOException, RestException, UnirestException, URISyntaxException
    {
        AesEncryptionDrm result = bitmovinApi.encoding.muxing.addAESEncryptionToTssMuxing(encoding, tsMuxing, aesEncryptionDrm);
        Assert.assertNotNull(result.getId());
        tsMuxing.getDrmConfigs().add(result);
        return result;
    }
}
