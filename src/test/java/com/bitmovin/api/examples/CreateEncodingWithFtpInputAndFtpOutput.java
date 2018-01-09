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
import com.bitmovin.api.encoding.encodings.streams.Stream;
import com.bitmovin.api.encoding.enums.CloudRegion;
import com.bitmovin.api.encoding.enums.StreamSelectionMode;
import com.bitmovin.api.encoding.inputs.FtpInput;
import com.bitmovin.api.encoding.outputs.FtpOutput;
import com.bitmovin.api.encoding.outputs.Output;
import com.bitmovin.api.encoding.outputs.TransferVersion;
import com.bitmovin.api.encoding.status.Task;
import com.bitmovin.api.enums.Status;
import com.bitmovin.api.examples.util.H264Representation;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.http.RestException;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by Roland Kersche on 22.06.17.
 */
public class CreateEncodingWithFtpInputAndFtpOutput
{

    private static String API_KEY = "<INSERT_YOUR_APIKEY>";

    private static CloudRegion CLOUD_REGION = CloudRegion.GOOGLE_EUROPE_WEST_1;

    private static String FTP_INPUT_HOST = "<INSERT_YOUR_FTP_HOST>";
    private static String FTP_INPUT_USERNAME = "<INSERT_YOUR_FTP_USERNAME>";
    private static String FTP_INPUT_PASSWORD = "<INSERT_YOUR_FTP_PASSWORD>";
    private static String FTP_INPUT_PATH = "<INSERT_YOUR_PATH_TO_INPUT_FILE>";

    private static String FTP_OUTPUT_HOST = "<INSERT_YOUR_FTP_OUTPUT_HOST>";
    private static String FTP_OUTPUT_USERNAME = "<INSERT_YOUR_FTP_OUTPUT_USERNAME>";
    private static String FTP_OUTPUT_PASSWORD = "<INSERT_YOUR_FTP_OUTPUT_PASSWORD>";
    private static String OUTPUT_BASE_PATH = "path/to/your/outputs/" + new Date().getTime();

    private static BitmovinApi bitmovinApi;

    @Test
    public void testEncoding() throws IOException, BitmovinApiException, UnirestException, URISyntaxException, RestException, InterruptedException
    {
        List<H264Representation> representations = new ArrayList<>();
        representations.add(new H264Representation(null, 240, null, 400000L));
        representations.add(new H264Representation(null, 360, null, 800000L));
        representations.add(new H264Representation(null, 480, null, 1200000L));
        representations.add(new H264Representation(null, 720, null, 2400000L));
        representations.add(new H264Representation(null, 1080, null, 4800000L));

        bitmovinApi = new BitmovinApi(API_KEY);
        Encoding encoding = new Encoding();
        encoding.setName("Encoding JAVA FTP Input and Output");
        encoding.setCloudRegion(CLOUD_REGION);
        encoding = bitmovinApi.encoding.create(encoding);

        FtpInput input = new FtpInput();
        input.setHost(FTP_INPUT_HOST);
        input.setUsername(FTP_INPUT_USERNAME);
        input.setPassword(FTP_INPUT_PASSWORD);
        input = bitmovinApi.input.ftp.create(input);

        FtpOutput output = new FtpOutput();
        output.setHost(FTP_OUTPUT_HOST);
        output.setUsername(FTP_OUTPUT_USERNAME);
        output.setPassword(FTP_OUTPUT_PASSWORD);
        output.setMaxConcurrentConnections(10);
        output.setTransferVersion(TransferVersion.POOL);

        output = bitmovinApi.output.ftp.create(output);

        AACAudioConfig aacConfiguration = new AACAudioConfig();
        aacConfiguration.setBitrate(128000L);
        aacConfiguration.setRate(48000f);
        aacConfiguration = bitmovinApi.configuration.audioAAC.create(aacConfiguration);

        InputStream inputStreamVideo = new InputStream();
        inputStreamVideo.setInputPath(FTP_INPUT_PATH);
        inputStreamVideo.setInputId(input.getId());
        inputStreamVideo.setSelectionMode(StreamSelectionMode.VIDEO_RELATIVE);
        inputStreamVideo.setPosition(0);

        InputStream inputStreamAudio = new InputStream();
        inputStreamAudio.setInputPath(FTP_INPUT_PATH);
        inputStreamAudio.setInputId(input.getId());
        inputStreamAudio.setSelectionMode(StreamSelectionMode.AUDIO_RELATIVE);
        inputStreamAudio.setPosition(0);

        Stream audioStream = new Stream();
        audioStream.setCodecConfigId(aacConfiguration.getId());
        audioStream.setInputStreams(Collections.singleton(inputStreamAudio));
        audioStream = bitmovinApi.encoding.stream.addStream(encoding, audioStream);

        for (H264Representation representation : representations)
        {
            H264VideoConfiguration videoConfiguration = new H264VideoConfiguration();
            videoConfiguration.setHeight(representation.getHeight());
            videoConfiguration.setWidth(representation.getWidth());
            videoConfiguration.setBitrate(representation.getBitrate());
            videoConfiguration.setRate(representation.getRate());
            videoConfiguration.setProfile(ProfileH264.HIGH);
            videoConfiguration = bitmovinApi.configuration.videoH264.create(videoConfiguration);

            Stream videoStream = new Stream();
            videoStream.setCodecConfigId(videoConfiguration.getId());
            videoStream.setInputStreams(Collections.singleton(inputStreamVideo));
            videoStream = bitmovinApi.encoding.stream.addStream(encoding, videoStream);

            this.createMP4Muxing(encoding, output, videoStream, audioStream, String.format("video_audio_%sp_%s.mp4", representation.getHeight(), representation.getBitrate() / 1000));
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

    private void createMP4Muxing(Encoding encoding, Output output, Stream videoStream240p, Stream audioStream, String filename) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
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
        bitmovinApi.encoding.muxing.addMp4MuxingToEncoding(encoding, mp4Muxing);
    }

}
