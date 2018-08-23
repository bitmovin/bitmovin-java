package com.bitmovin.api.examples;

import com.bitmovin.api.BitmovinApi;
import com.bitmovin.api.encoding.EncodingOutput;
import com.bitmovin.api.encoding.InputStream;
import com.bitmovin.api.encoding.codecConfigurations.H264VideoConfiguration;
import com.bitmovin.api.encoding.codecConfigurations.enums.ProfileH264;
import com.bitmovin.api.encoding.encodings.AutoRepresentation;
import com.bitmovin.api.encoding.encodings.Encoding;
import com.bitmovin.api.encoding.encodings.StartEncodingRequest;
import com.bitmovin.api.encoding.encodings.muxing.FMP4Muxing;
import com.bitmovin.api.encoding.encodings.muxing.MuxingStream;
import com.bitmovin.api.encoding.encodings.pertitle.H264PerTitleConfiguration;
import com.bitmovin.api.encoding.encodings.pertitle.PerTitle;
import com.bitmovin.api.encoding.encodings.streams.Stream;
import com.bitmovin.api.encoding.encodings.streams.StreamMode;
import com.bitmovin.api.encoding.enums.CloudRegion;
import com.bitmovin.api.encoding.enums.StreamSelectionMode;
import com.bitmovin.api.encoding.inputs.HttpsInput;
import com.bitmovin.api.encoding.outputs.S3Output;
import com.bitmovin.api.encoding.status.Task;
import com.bitmovin.api.enums.Status;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.http.RestException;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

public class CreatePerTitleEncoding
{
    private static BitmovinApi bitmovinApi;
    private static final String API_KEY = "<INSERT_YOUR_API_KEY>";

    private static final String HTTPS_INPUT_HOST = "your.host.com";
    private static final String INPUT_PATH = "/path/to/your/input.mp4";

    private static String S3_OUTPUT_ACCESS_KEY = "<INSERT_YOUR_ACCESS_KEY>";
    private static String S3_OUTPUT_SECRET_KEY = "<INSERT_YOUR_SECRET_KEY>";
    private static String S3_OUTPUT_BUCKET_NAME = "<INSERT_YOUR_BUCKET_NAME>";
    private static String OUTPUT_BASE_PATH = "path/to/output";

    @Test
    public void testCreatePerTitleEncoding() throws IOException, BitmovinApiException, UnirestException, URISyntaxException, RestException, InterruptedException
    {
        bitmovinApi = new BitmovinApi(API_KEY);
        bitmovinApi.setDebug(true);

        Encoding encoding = new Encoding();
        encoding.setName("PerTitleExampleEncoding");
        encoding.setCloudRegion(CloudRegion.GOOGLE_EUROPE_WEST_1);
        encoding.setEncoderVersion("BETA");

        encoding = bitmovinApi.encoding.create(encoding);

        HttpsInput httpsInput = new HttpsInput();
        httpsInput.setHost(HTTPS_INPUT_HOST);
        httpsInput = bitmovinApi.input.https.create(httpsInput);

        S3Output s3Output = new S3Output();
        s3Output.setBucketName(S3_OUTPUT_BUCKET_NAME);
        s3Output.setSecretKey(S3_OUTPUT_SECRET_KEY);
        s3Output.setAccessKey(S3_OUTPUT_ACCESS_KEY);
        s3Output = bitmovinApi.output.s3.create(s3Output);

        H264VideoConfiguration videoConfiguration = new H264VideoConfiguration();
        videoConfiguration.setProfile(ProfileH264.HIGH);
        videoConfiguration = bitmovinApi.configuration.videoH264.create(videoConfiguration);

        Stream videoStream = new Stream();
        videoStream.setCodecConfigId(videoConfiguration.getId());
        videoStream.setMode(StreamMode.PER_TITLE_TEMPLATE);

        InputStream inputStream = new InputStream();
        inputStream.setSelectionMode(StreamSelectionMode.AUTO);
        inputStream.setPosition(0);
        inputStream.setInputPath(INPUT_PATH);
        inputStream.setInputId(httpsInput.getId());
        videoStream.setInputStreams(Collections.singleton(
                inputStream
        ));

        videoStream = bitmovinApi.encoding.stream.addStream(encoding, videoStream);

        FMP4Muxing fmp4Muxing = new FMP4Muxing();
        fmp4Muxing.setOutputs(
                Collections.singletonList(
                        new EncodingOutput(
                                s3Output.getId(),
                                OUTPUT_BASE_PATH + "/video/{bitrate}/"
                        )
                )
        );
        fmp4Muxing.setStreams(
                Collections.singletonList(
                        new MuxingStream(
                                videoStream.getId()
                        )
                )
        );
        fmp4Muxing.setSegmentLength(4.0);
        bitmovinApi.encoding.muxing.addFmp4MuxingToEncoding(encoding, fmp4Muxing);

        H264PerTitleConfiguration perTitleH264Configuration = new H264PerTitleConfiguration();

        AutoRepresentation autoRepresentation = new AutoRepresentation();
        autoRepresentation.setAdoptConfigurationThreshold(0.3);
        perTitleH264Configuration.setAutoRepresentations(autoRepresentation);

        PerTitle perTitle = new PerTitle();
        perTitle.setH264Configuration(perTitleH264Configuration);

        StartEncodingRequest startEncodingRequest = new StartEncodingRequest();
        startEncodingRequest.setPerTitle(perTitle);

        bitmovinApi.encoding.start(encoding, startEncodingRequest);

        Task status;
        do {
            Thread.sleep(2500);
            status = bitmovinApi.encoding.getStatus(encoding);
        } while (status.getStatus() != Status.FINISHED && status.getStatus() != Status.ERROR);
    }
}
