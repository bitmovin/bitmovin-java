package com.bitmovin.api.examples;

import com.bitmovin.api.BitmovinApi;
import com.bitmovin.api.encoding.AclEntry;
import com.bitmovin.api.encoding.AclPermission;
import com.bitmovin.api.encoding.EncodingOutput;
import com.bitmovin.api.encoding.InputStream;
import com.bitmovin.api.encoding.codecConfigurations.AACAudioConfig;
import com.bitmovin.api.encoding.codecConfigurations.H264VideoConfiguration;
import com.bitmovin.api.encoding.codecConfigurations.enums.ProfileH264;
import com.bitmovin.api.encoding.encodings.AutoRepresentation;
import com.bitmovin.api.encoding.encodings.Encoding;
import com.bitmovin.api.encoding.encodings.EncodingMode;
import com.bitmovin.api.encoding.encodings.StartEncodingRequest;
import com.bitmovin.api.encoding.encodings.muxing.MP4Muxing;
import com.bitmovin.api.encoding.encodings.muxing.MuxingStream;
import com.bitmovin.api.encoding.encodings.pertitle.H264PerTitleConfiguration;
import com.bitmovin.api.encoding.encodings.pertitle.PerTitle;
import com.bitmovin.api.encoding.encodings.streams.Stream;
import com.bitmovin.api.encoding.encodings.streams.StreamMode;
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
import java.util.Arrays;
import java.util.Collections;

public class CreatePerTitleEncodingMp4
{
    private static BitmovinApi bitmovinApi;

    private static final String API_KEY = "<INSERT_YOUR_API_KEY>";

    private static String S3_INPUT_ACCESS_KEY = "<INSERT_YOUR_ACCESS_KEY>";
    private static String S3_INPUT_SECRET_KEY = "<INSERT_YOUR_SECRET_KEY>";
    private static String S3_INPUT_BUCKET_NAME = "<INSERT_YOUR_BUCKET_NAME>";

    private static String INPUT_PATH = "/path/to/your/input/file.mp4";

    private static String S3_OUTPUT_ACCESS_KEY = "<INSERT_YOUR_ACCESS_KEY>";
    private static String S3_OUTPUT_SECRET_KEY = "<INSERT_YOUR_SECRET_KEY>";
    private static String S3_OUTPUT_BUCKET_NAME = "<INSERT_YOUR_BUCKET_NAME>";
    private static String OUTPUT_BASE_PATH = "/your/output/base/path/";

    @Test
    public void testCreatePerTitleEncoding() throws IOException, BitmovinApiException, UnirestException, URISyntaxException, RestException, InterruptedException
    {
        bitmovinApi = new BitmovinApi(API_KEY);

        // Create the input resource to access the input file
        S3Input s3Input = new S3Input();
        s3Input.setBucketName(S3_INPUT_BUCKET_NAME);
        s3Input.setSecretKey(S3_INPUT_SECRET_KEY);
        s3Input.setAccessKey(S3_INPUT_ACCESS_KEY);
        s3Input = bitmovinApi.input.s3.create(s3Input);


        // Create the output resource to write the output files
        S3Output s3Output = new S3Output();
        s3Output.setBucketName(S3_OUTPUT_BUCKET_NAME);
        s3Output.setSecretKey(S3_OUTPUT_SECRET_KEY);
        s3Output.setAccessKey(S3_OUTPUT_ACCESS_KEY);
        s3Output = bitmovinApi.output.s3.create(s3Output);


        // The encoding is created. The cloud region is set to AUTO to use the best cloud region depending on the input
        Encoding encoding = new Encoding();
        encoding.setName("Java Example - Per-Title");
        encoding.setCloudRegion(CloudRegion.AUTO);
        encoding = bitmovinApi.encoding.create(encoding);


        // Select the video and audio input stream that should be encoded
        InputStream videoInputStream = new InputStream();
        videoInputStream.setSelectionMode(StreamSelectionMode.AUTO);
        videoInputStream.setInputPath(INPUT_PATH);
        videoInputStream.setInputId(s3Input.getId());

        InputStream audioInputStream = new InputStream();
        audioInputStream.setSelectionMode(StreamSelectionMode.AUTO);
        audioInputStream.setInputPath(INPUT_PATH);
        audioInputStream.setInputId(s3Input.getId());


        Stream audioStream = createAudioStream(encoding, audioInputStream);
        Stream videoStream = createVideoStream(encoding, videoInputStream);
        createMp4Muxing(encoding, s3Output, videoStream, audioStream);
        startEncoding(encoding);
    }

    /**
     * This will create the audio stream that will be encoded with the given codec configuration.
     *
     * @param encoding         The reference of the encoding
     * @param audioInputStream The input stream that should be encoded
     * @return The created audio stream. This will be used later for the MP4 muxing
     * @throws URISyntaxException
     * @throws BitmovinApiException
     * @throws UnirestException
     * @throws IOException
     * @throws RestException
     */
    private static Stream createAudioStream(Encoding encoding, InputStream audioInputStream)
            throws URISyntaxException, BitmovinApiException, UnirestException, IOException, RestException
    {
        // Create the audio codec configuration that will be used during the encoding. The encoded audio will have a bitrate of 128kbps and sample rate of 48kHz
        AACAudioConfig audioCodecConfiguration = new AACAudioConfig();
        audioCodecConfiguration.setName("audio_codec_configuration");
        audioCodecConfiguration.setBitrate(128000L);
        audioCodecConfiguration.setRate(48000f);
        audioCodecConfiguration = bitmovinApi.configuration.audioAAC.create(audioCodecConfiguration);

        // The encoded audio stream consists of the input stream and the codec configuration that should be used.
        Stream audioStream = new Stream();
        audioStream.setCodecConfigId(audioCodecConfiguration.getId());
        audioStream.setInputStreams(Collections.singleton(audioInputStream));
        audioStream = bitmovinApi.encoding.stream.addStream(encoding, audioStream);
        return audioStream;
    }

    /**
     * This will create the Per-Title template video stream. This stream will be used as a template for the Per-Title
     * encoding. The Codec Configuration, Muxings, DRMs and Filters applied to the generated Per-Title profile will be
     * based on the same, or closest matching resolutions defined in the template.
     * Please note, that template streams are not necessarily used for the encoding -
     * they are just used as template.
     *
     * @param encoding         The reference of the encoding
     * @param videoInputStream The input stream that should be encoded
     * @return The created Per-Title template video stream. This will be used later for the MP4 muxing
     * @throws URISyntaxException
     * @throws BitmovinApiException
     * @throws UnirestException
     * @throws IOException
     * @throws RestException
     */
    private static Stream createVideoStream(Encoding encoding, InputStream videoInputStream)
            throws URISyntaxException, BitmovinApiException, UnirestException, IOException, RestException
    {
        // Create the Per-Title template video configuration. All per title streams will be encoded with profile HIGH
        H264VideoConfiguration videoCodecConfiguration = new H264VideoConfiguration();
        videoCodecConfiguration.setName("H264 Configuration");
        videoCodecConfiguration.setProfile(ProfileH264.HIGH);
        videoCodecConfiguration = bitmovinApi.configuration.videoH264.create(videoCodecConfiguration);

        Stream videoStream = new Stream();
        videoStream.setCodecConfigId(videoCodecConfiguration.getId());
        videoStream.setInputStreams(Collections.singleton(videoInputStream));
        videoStream.setMode(StreamMode.PER_TITLE_TEMPLATE);
        videoStream = bitmovinApi.encoding.stream.addStream(encoding, videoStream);
        return videoStream;
    }

    /**
     * An MP4 muxing will be created for with the Per-Title video stream template and the audio stream.
     * This muxing must define either {uuid} or {bitrate} in the output path.  These placeholders will be replaced during
     * the generation of the Per-Title.
     *
     * @param encoding    The reference of the encoding
     * @param s3Output    The output the files should be written to
     * @param videoStream The Per-Title template video stream
     * @param audioStream The audio stream
     * @throws URISyntaxException
     * @throws BitmovinApiException
     * @throws RestException
     * @throws UnirestException
     * @throws IOException
     */
    private static void createMp4Muxing(Encoding encoding, S3Output s3Output, Stream videoStream, Stream audioStream)
            throws URISyntaxException, BitmovinApiException, RestException, UnirestException, IOException
    {
        AclEntry aclEntry = new AclEntry();
        aclEntry.setPermission(AclPermission.PUBLIC_READ);

        EncodingOutput mp4MuxingOutput = new EncodingOutput();
        mp4MuxingOutput.setAcl(Collections.singletonList(aclEntry));
        mp4MuxingOutput.setOutputId(s3Output.getId());
        mp4MuxingOutput.setOutputPath(String.format("%s{width}_{bitrate}_{uuid}/", OUTPUT_BASE_PATH));

        MP4Muxing mp4Muxing = new MP4Muxing();
        mp4Muxing.setStreams(Arrays.asList(new MuxingStream(videoStream.getId()), new MuxingStream(audioStream.getId())));
        mp4Muxing.setFilename("per_title_mp4.mp4");
        mp4Muxing.setOutputs(Collections.singletonList(mp4MuxingOutput));
        bitmovinApi.encoding.muxing.addMp4MuxingToEncoding(encoding, mp4Muxing);
    }

    /**
     * The encoding will be started with the per title object and the auto representations set. If the auto
     * representation is set, stream configurations will be automatically added to the Per-Title profile. In that case
     * at least one PER_TITLE_TEMPLATE stream configuration must be available. All other configurations will be
     * automatically chosen by the Per-Title algorithm. All relevant settings for streams and muxings will be taken from
     * the closest PER_TITLE_TEMPLATE stream defined. The closest stream will be chosen based on the resolution
     * specified in the codec configuration.
     *
     * @param encoding The reference of the encoding
     * @throws URISyntaxException
     * @throws BitmovinApiException
     * @throws RestException
     * @throws UnirestException
     * @throws IOException
     * @throws InterruptedException
     */
    private static void startEncoding(Encoding encoding)
            throws URISyntaxException, BitmovinApiException, RestException, UnirestException, IOException, InterruptedException
    {
        AutoRepresentation autoRepresentation = new AutoRepresentation();

        H264PerTitleConfiguration h264PerTitleConfiguration = new H264PerTitleConfiguration();
        h264PerTitleConfiguration.setAutoRepresentations(autoRepresentation);

        PerTitle perTitle = new PerTitle();
        perTitle.setH264Configuration(h264PerTitleConfiguration);

        StartEncodingRequest startEncodingRequest = new StartEncodingRequest();
        startEncodingRequest.setPerTitle(perTitle);
        startEncodingRequest.setEncodingMode(EncodingMode.THREE_PASS);

        bitmovinApi.encoding.start(encoding, startEncodingRequest);

        Task status;
        do
        {
            Thread.sleep(2500);
            status = bitmovinApi.encoding.getStatus(encoding);
        } while (status.getStatus() != Status.FINISHED && status.getStatus() != Status.ERROR);

        if (status.getStatus() == Status.ERROR)
        {
            System.out.println("An error has occurred");
            return;
        }

        System.out.println("Encoding has been finished successfully.");

    }

}
