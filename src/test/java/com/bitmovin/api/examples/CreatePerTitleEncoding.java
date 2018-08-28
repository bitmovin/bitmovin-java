package com.bitmovin.api.examples;

import com.bitmovin.api.BitmovinApi;
import com.bitmovin.api.encoding.EncodingOutput;
import com.bitmovin.api.encoding.InputStream;
import com.bitmovin.api.encoding.codecConfigurations.H264VideoConfiguration;
import com.bitmovin.api.encoding.codecConfigurations.enums.ProfileH264;
import com.bitmovin.api.encoding.encodings.AutoRepresentation;
import com.bitmovin.api.encoding.encodings.Encoding;
import com.bitmovin.api.encoding.encodings.EncodingMode;
import com.bitmovin.api.encoding.encodings.StartEncodingRequest;
import com.bitmovin.api.encoding.encodings.muxing.FMP4Muxing;
import com.bitmovin.api.encoding.encodings.muxing.Muxing;
import com.bitmovin.api.encoding.encodings.muxing.MuxingStream;
import com.bitmovin.api.encoding.encodings.pertitle.H264PerTitleConfiguration;
import com.bitmovin.api.encoding.encodings.pertitle.PerTitle;
import com.bitmovin.api.encoding.encodings.streams.Stream;
import com.bitmovin.api.encoding.encodings.streams.StreamMode;
import com.bitmovin.api.encoding.enums.CloudRegion;
import com.bitmovin.api.encoding.enums.DashMuxingType;
import com.bitmovin.api.encoding.enums.StreamSelectionMode;
import com.bitmovin.api.encoding.inputs.HttpsInput;
import com.bitmovin.api.encoding.manifest.dash.DashFmp4Representation;
import com.bitmovin.api.encoding.manifest.dash.DashManifest;
import com.bitmovin.api.encoding.manifest.dash.Period;
import com.bitmovin.api.encoding.manifest.dash.VideoAdaptationSet;
import com.bitmovin.api.encoding.outputs.S3Output;
import com.bitmovin.api.encoding.status.Task;
import com.bitmovin.api.enums.Status;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.http.RestException;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
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

        Encoding encoding = new Encoding();
        encoding.setName("PerTitleExampleEncoding");
        encoding.setCloudRegion(CloudRegion.GOOGLE_EUROPE_WEST_1);

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
        perTitleH264Configuration.setAutoRepresentations(autoRepresentation);

        PerTitle perTitle = new PerTitle();
        perTitle.setH264Configuration(perTitleH264Configuration);

        StartEncodingRequest startEncodingRequest = new StartEncodingRequest();
        startEncodingRequest.setPerTitle(perTitle);
        startEncodingRequest.setEncodingMode(EncodingMode.THREE_PASS);

        bitmovinApi.encoding.start(encoding, startEncodingRequest);

        Task status;
        do {
            Thread.sleep(2500);
            status = bitmovinApi.encoding.getStatus(encoding);
        } while (status.getStatus() != Status.FINISHED && status.getStatus() != Status.ERROR);

        if (status.getStatus() == Status.ERROR)
        {
            System.out.println("Error in encoding. Exiting...");
            return;
        }


        DashManifest dashManifest = new DashManifest();
        dashManifest.setName("stream.mpd");
        dashManifest.setOutputs(Collections.singletonList(
                new EncodingOutput(
                        s3Output.getId(),
                        OUTPUT_BASE_PATH
                )
        ));
        dashManifest = bitmovinApi.manifest.dash.create(dashManifest);

        Period period = new Period();
        period = bitmovinApi.manifest.dash.createPeriod(dashManifest, period);

        VideoAdaptationSet videoAdaptationSet = new VideoAdaptationSet();
        videoAdaptationSet = bitmovinApi.manifest.dash.addVideoAdaptationSetToPeriod(dashManifest, period, videoAdaptationSet);

        List<Muxing> perTitleMuxings = bitmovinApi.encoding.muxing.getMuxings(encoding);
        for (Muxing muxing : perTitleMuxings)
        {
            if (CollectionUtils.isEmpty(muxing.getStreams()))
            {
                System.out.println(
                        String.format("Found muxing with id %s that does not contain a stream...", muxing.getId())
                );
                continue;
            }

            Stream stream = bitmovinApi.encoding.stream.getStream(encoding, muxing.getStreams().get(0).getStreamId());
            if (stream == null)
            {
                System.out.println(
                        String.format("Could not get stream with id %s", muxing.getStreams().get(0).getStreamId())
                );
                continue;
            }

            if (CollectionUtils.isEmpty(muxing.getOutputs()))
            {
                System.out.println(
                        String.format(
                                "Could not get encoding output of muxing with id %s",
                                muxing.getId()
                        )
                );
                continue;
            }

            if (StringUtils.isBlank(muxing.getOutputs().get(0).getOutputPath()))
            {
                System.out.println(
                        String.format(
                                "Could not determine segment path because output path is not set for muxing with id %s",
                                muxing.getId()
                        )
                );
                continue;
            }

            String segmentsPath = StringUtils.removeStart(muxing.getOutputs().get(0).getOutputPath(), OUTPUT_BASE_PATH);
            if (segmentsPath.contains("{bitrate}"))
            {
                continue;
            }
            segmentsPath = StringUtils.removeStart(segmentsPath, "/");

            DashFmp4Representation representation = new DashFmp4Representation();
            representation.setMuxingId(muxing.getId());
            representation.setStreamId(muxing.getStreams().get(0).getStreamId());
            representation.setEncodingId(encoding.getId());
            representation.setSegmentPath(segmentsPath);
            representation.setType(DashMuxingType.TEMPLATE);

            bitmovinApi.manifest.dash.addRepresentationToAdaptationSet(
                    dashManifest,
                    period,
                    videoAdaptationSet,
                    representation
            );
        }

        bitmovinApi.manifest.dash.startGeneration(dashManifest);
        Status manifestStatus;
        do {
            Thread.sleep(2500);
            manifestStatus = bitmovinApi.manifest.dash.getGenerationStatus(dashManifest);
        } while (manifestStatus != Status.FINISHED && manifestStatus != Status.ERROR);

        if (manifestStatus == Status.ERROR)
        {
            System.out.println("Error creating manifest...");
            return;
        }

        System.out.println("Successfully finished encoding and created manifest!");
    }
}
