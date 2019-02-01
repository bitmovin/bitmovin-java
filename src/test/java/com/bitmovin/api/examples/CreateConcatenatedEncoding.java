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
import com.bitmovin.api.encoding.encodings.muxing.FMP4Muxing;
import com.bitmovin.api.encoding.encodings.muxing.MuxingStream;
import com.bitmovin.api.encoding.encodings.muxing.TSMuxing;
import com.bitmovin.api.encoding.encodings.streams.ConcatenationConfiguration;
import com.bitmovin.api.encoding.encodings.streams.ConcatenationInputStream;
import com.bitmovin.api.encoding.encodings.streams.IngestInputStream;
import com.bitmovin.api.encoding.encodings.streams.Stream;
import com.bitmovin.api.encoding.enums.CloudRegion;
import com.bitmovin.api.encoding.enums.DashMuxingType;
import com.bitmovin.api.encoding.enums.StreamSelectionMode;
import com.bitmovin.api.encoding.inputs.HttpsInput;
import com.bitmovin.api.encoding.manifest.dash.AdaptationSet;
import com.bitmovin.api.encoding.manifest.dash.AudioAdaptationSet;
import com.bitmovin.api.encoding.manifest.dash.DashFmp4Representation;
import com.bitmovin.api.encoding.manifest.dash.DashManifest;
import com.bitmovin.api.encoding.manifest.dash.Period;
import com.bitmovin.api.encoding.manifest.dash.VideoAdaptationSet;
import com.bitmovin.api.encoding.manifest.hls.HlsManifest;
import com.bitmovin.api.encoding.manifest.hls.MediaInfo;
import com.bitmovin.api.encoding.manifest.hls.MediaInfoType;
import com.bitmovin.api.encoding.manifest.hls.StreamInfo;
import com.bitmovin.api.encoding.outputs.Output;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class CreateConcatenatedEncoding
{
    private static String ApiKey = "<INSERT_YOUR_APIKEY>";

    private static CloudRegion cloudRegion = CloudRegion.AWS_EU_WEST_1;
    private static String HTTPS_INPUT_HOST = "<INSERT_YOUR_HTTP_HOST>"; // ex.: storage.googleapis.com/
    private static String HTTPS_BUMPER_INPUT_PATH = "<INSERT_YOUR_PATH_TO_BUMPER_VIDEO>";
    private static String HTTPS_MAIN_INPUT_PATH = "<INSERT_YOUR_PATH_TO_MAIN_VIDEO>";
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
        encoding.setEncoderVersion("2.7.0");
        encoding = bitmovinApi.encoding.create(encoding);

        HttpsInput input = new HttpsInput();
        input.setHost(HTTPS_INPUT_HOST);
        input = bitmovinApi.input.https.create(input);

        S3Output output = new S3Output();
        output.setAccessKey(S3_OUTPUT_ACCESSKEY);
        output.setSecretKey(S3_OUTPUT_SECRET_KEY);
        output.setBucketName(S3_OUTPUT_BUCKET_NAME);
        output = bitmovinApi.output.s3.create(output);

        IngestInputStream bumperIngestStream = new IngestInputStream();
        bumperIngestStream.setInputId(input.getId());
        bumperIngestStream.setInputPath(HTTPS_BUMPER_INPUT_PATH);
        bumperIngestStream.setPosition(0);
        bumperIngestStream.setSelectionMode(StreamSelectionMode.AUTO);

        bumperIngestStream = bitmovinApi.encoding.ingestInputStream.addIngestInputStream(encoding, bumperIngestStream);

        IngestInputStream mainIngestStream = new IngestInputStream();
        mainIngestStream.setInputId(input.getId());
        mainIngestStream.setInputPath(HTTPS_MAIN_INPUT_PATH);
        mainIngestStream.setPosition(0);
        mainIngestStream.setSelectionMode(StreamSelectionMode.AUTO);

        mainIngestStream = bitmovinApi.encoding.ingestInputStream.addIngestInputStream(encoding, mainIngestStream);

        ConcatenationInputStream concatenationInputStream = new ConcatenationInputStream();

        ConcatenationConfiguration bumperConfig = new ConcatenationConfiguration();
        bumperConfig.setInputStreamId(bumperIngestStream.getId());
        bumperConfig.setPosition(0);
        bumperConfig.setIsMain(false);

        ConcatenationConfiguration mainConfig = new ConcatenationConfiguration();
        mainConfig.setInputStreamId(mainIngestStream.getId());
        mainConfig.setPosition(1);
        mainConfig.setIsMain(true);

        concatenationInputStream.getConcatenation().add(bumperConfig);
        concatenationInputStream.getConcatenation().add(mainConfig);

        concatenationInputStream = bitmovinApi.encoding.concatenationInputStream.addConcatenationInputStream(encoding, concatenationInputStream);

        InputStream inputStream = new InputStream();
        inputStream.setInputStreamId(concatenationInputStream.getId());

        AACAudioConfig aacConfiguration = new AACAudioConfig();
        aacConfiguration.setBitrate(128000L);
        aacConfiguration.setRate(48000f);
        aacConfiguration = bitmovinApi.configuration.audioAAC.create(aacConfiguration);

        H264VideoConfiguration videoConfiguration720p = new H264VideoConfiguration();
        videoConfiguration720p.setHeight(720);
        videoConfiguration720p.setBitrate(2400000L);
        videoConfiguration720p.setProfile(ProfileH264.HIGH);
        videoConfiguration720p = bitmovinApi.configuration.videoH264.create(videoConfiguration720p);

        H264VideoConfiguration videoConfiguration1080p = new H264VideoConfiguration();
        videoConfiguration1080p.setHeight(1080);
        videoConfiguration1080p.setBitrate(4800000L);
        videoConfiguration1080p.setProfile(ProfileH264.HIGH);
        videoConfiguration1080p = bitmovinApi.configuration.videoH264.create(videoConfiguration1080p);

        Stream audioStream = new Stream();
        audioStream.setCodecConfigId(aacConfiguration.getId());
        audioStream.setInputStreams(Collections.singleton(inputStream));
        audioStream = bitmovinApi.encoding.stream.addStream(encoding, audioStream);

        Stream videoStream720p = new Stream();
        videoStream720p.setCodecConfigId(videoConfiguration720p.getId());
        videoStream720p.setInputStreams(Collections.singleton(inputStream));
        videoStream720p = bitmovinApi.encoding.stream.addStream(encoding, videoStream720p);

        Stream videoStream1080p = new Stream();
        videoStream1080p.setCodecConfigId(videoConfiguration1080p.getId());
        videoStream1080p.setInputStreams(Collections.singleton(inputStream));
        videoStream1080p = bitmovinApi.encoding.stream.addStream(encoding, videoStream1080p);

        EncodingOutput encodingOutput = new EncodingOutput();
        encodingOutput.setOutputId(output.getId());
        encodingOutput.setOutputPath(OUTPUT_BASE_PATH);

        FMP4Muxing fmp4Muxing720 = this.createFMP4Muxing(encoding, videoStream720p, output, OUTPUT_BASE_PATH + "/video/720p_dash", AclPermission.PUBLIC_READ);
        FMP4Muxing fmp4Muxing1080 = this.createFMP4Muxing(encoding, videoStream1080p, output, OUTPUT_BASE_PATH + "/video/1080p_dash", AclPermission.PUBLIC_READ);
        FMP4Muxing fmp4Audio = this.createFMP4Muxing(encoding, audioStream, output, OUTPUT_BASE_PATH + "/audio/128kbps_dash", AclPermission.PUBLIC_READ);

        TSMuxing tsMuxing720 = this.createTSMuxing(encoding, videoStream720p, output, OUTPUT_BASE_PATH + "/video/720p_hls", AclPermission.PUBLIC_READ);
        TSMuxing tsMuxing1080 = this.createTSMuxing(encoding, videoStream1080p, output, OUTPUT_BASE_PATH + "/video/1080p_hls", AclPermission.PUBLIC_READ);
        TSMuxing tsAudio = this.createTSMuxing(encoding, audioStream, output, OUTPUT_BASE_PATH + "/audio/128kbps_hls", AclPermission.PUBLIC_READ);

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
            System.out.println("Encoding has status error ... can not create manifest");
            return;
        }

        System.out.println("Creating DASH manifest");

        EncodingOutput manifestDestination = new EncodingOutput();
        manifestDestination.setOutputId(output.getId());
        manifestDestination.setOutputPath(OUTPUT_BASE_PATH);
        manifestDestination.setAcl(Collections.singletonList(new AclEntry(AclPermission.PUBLIC_READ)));

        DashManifest manifest = this.createDashManifest("manifest.mpd", manifestDestination);
        Period period = this.addPeriodToDashManifest(manifest);
        VideoAdaptationSet videoAdaptationSet = this.addVideoAdaptationSetToPeriod(manifest, period);
        AudioAdaptationSet audioAdaptationSet = this.addAudioAdaptationSetToPeriodWithRoles(manifest, period, "en");

        this.addDashRepresentationToAdaptationSet(DashMuxingType.TEMPLATE, encoding.getId(), fmp4Muxing1080.getId(), "video/1080p_dash", manifest, period, videoAdaptationSet);
        this.addDashRepresentationToAdaptationSet(DashMuxingType.TEMPLATE, encoding.getId(), fmp4Muxing720.getId(), "video/720p_dash", manifest, period, videoAdaptationSet);

        this.addDashRepresentationToAdaptationSet(DashMuxingType.TEMPLATE, encoding.getId(), fmp4Audio.getId(), "audio/128kbps_dash", manifest, period, audioAdaptationSet);

        bitmovinApi.manifest.dash.startGeneration(manifest);
        Status dashStatus = bitmovinApi.manifest.dash.getGenerationStatus(manifest);
        while (dashStatus != Status.FINISHED && dashStatus != Status.ERROR)
        {
            dashStatus = bitmovinApi.manifest.dash.getGenerationStatus(manifest);
            Thread.sleep(2500);
        }
        if (dashStatus != Status.FINISHED)
        {
            System.out.println("Could not create DASH manifest");
            return;
        }
        System.out.println("Creating HLS manifest");

        HlsManifest manifestHls = this.createHlsManifest("manifest.m3u8", manifestDestination);

        MediaInfo audioMediaInfo = new MediaInfo();
        audioMediaInfo.setName("audio.m3u8");
        audioMediaInfo.setUri("audio.m3u8");
        audioMediaInfo.setGroupId("audio");
        audioMediaInfo.setType(MediaInfoType.AUDIO);
        audioMediaInfo.setEncodingId(encoding.getId());
        audioMediaInfo.setStreamId(audioStream.getId());
        audioMediaInfo.setMuxingId(tsAudio.getId());
        audioMediaInfo.setLanguage("en");
        audioMediaInfo.setAssocLanguage("en");
        audioMediaInfo.setAutoselect(false);
        audioMediaInfo.setIsDefault(false);
        audioMediaInfo.setForced(false);
        audioMediaInfo.setSegmentPath("audio/128kbps_hls");
        bitmovinApi.manifest.hls.createMediaInfo(manifestHls, audioMediaInfo);

        this.addStreamInfoToHlsManifest("video_1080p.m3u8", encoding.getId(), videoStream1080p.getId(), tsMuxing1080.getId(), "audio","video/1080p_hls", manifestHls);
        this.addStreamInfoToHlsManifest("video_720p.m3u8", encoding.getId(), videoStream720p.getId(), tsMuxing720.getId(), "audio","video/720p_hls", manifestHls);

        bitmovinApi.manifest.hls.startGeneration(manifestHls);
        Status hlsStatus = bitmovinApi.manifest.hls.getGenerationStatus(manifestHls);
        while (hlsStatus != Status.FINISHED && hlsStatus != Status.ERROR)
        {
            hlsStatus = bitmovinApi.manifest.hls.getGenerationStatus(manifestHls);
            Thread.sleep(2500);
        }
        if (hlsStatus != Status.FINISHED)
        {
            System.out.println("Could not create HLS manifest");
            return;
        }
        System.out.println("Encoding completed successfully");

    }

    private StreamInfo addStreamInfoToHlsManifest(String uri, String encodingId, String streamId, String muxingId,
                                                  String audioGroupId, String segmentPath, HlsManifest manifest) throws URISyntaxException, BitmovinApiException, RestException, UnirestException, IOException
    {
        StreamInfo s = new StreamInfo();
        s.setUri(uri);
        s.setEncodingId(encodingId);
        s.setStreamId(streamId);
        s.setMuxingId(muxingId);
        s.setAudio(audioGroupId);
        s.setSegmentPath(segmentPath);
        s = bitmovinApi.manifest.hls.createStreamInfo(manifest, s);
        return s;
    }


    private HlsManifest createHlsManifest(String name, EncodingOutput output) throws URISyntaxException, BitmovinApiException, UnirestException, IOException
    {
        HlsManifest m = new HlsManifest();
        m.setName(name);
        m.addOutput(output);
        return bitmovinApi.manifest.hls.create(m);
    }

    private void addDashRepresentationToAdaptationSet(DashMuxingType type, String encodingId, String muxingId,
                                                      String segmentPath, DashManifest manifest, Period period,
                                                      AdaptationSet adaptationSet) throws BitmovinApiException, URISyntaxException, RestException, UnirestException, IOException
    {
        DashFmp4Representation r = new DashFmp4Representation();
        r.setType(type);
        r.setEncodingId(encodingId);
        r.setMuxingId(muxingId);
        r.setSegmentPath(segmentPath);
        bitmovinApi.manifest.dash.addRepresentationToAdaptationSet(manifest, period, adaptationSet, r);
    }

    private AudioAdaptationSet addAudioAdaptationSetToPeriodWithRoles(DashManifest manifest, Period period, String lang) throws URISyntaxException, BitmovinApiException, RestException, UnirestException, IOException
    {
        AudioAdaptationSet a = new AudioAdaptationSet();
        a.setLang(lang);
        a = bitmovinApi.manifest.dash.addAudioAdaptationSetToPeriod(manifest, period, a);
        return a;
    }

    private AudioAdaptationSet addAudioAdaptationSet(DashManifest manifest, Period period, AudioAdaptationSet audioAdaptationSet)
    {
        try
        {
        }
        catch (Exception e)
        {
            Assert.fail(e.getMessage());
        }

        Assert.assertNotNull("Null audio adaptation set created", audioAdaptationSet);
        Assert.assertNotNull("Null audio adaptation set ID created", audioAdaptationSet.getId());
        return audioAdaptationSet;
    }

    private VideoAdaptationSet addVideoAdaptationSetToPeriod(DashManifest manifest, Period period) throws URISyntaxException, BitmovinApiException, RestException, UnirestException, IOException
    {
        VideoAdaptationSet adaptationSet = new VideoAdaptationSet();
        adaptationSet = bitmovinApi.manifest.dash.addVideoAdaptationSetToPeriod(manifest, period, adaptationSet);
        return adaptationSet;
    }

    private DashManifest createDashManifest(String name, EncodingOutput output) throws URISyntaxException, BitmovinApiException, UnirestException, IOException
    {
        DashManifest manifest = new DashManifest();
        manifest.setName(name);
        manifest.addOutput(output);
        manifest = bitmovinApi.manifest.dash.create(manifest);
        return manifest;
    }

    private Period addPeriodToDashManifest(DashManifest manifest) throws URISyntaxException, BitmovinApiException, RestException, UnirestException, IOException
    {
        Period period = new Period();
        period = bitmovinApi.manifest.dash.createPeriod(manifest, period);
        return period;
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

    private FMP4Muxing createFMP4Muxing(Encoding encoding, Stream stream, Output output, String outputPath, AclPermission defaultAclPermission)
            throws URISyntaxException, BitmovinApiException, RestException, UnirestException, IOException
    {
        EncodingOutput encodingOutput = this.createEncodingOutput(output, outputPath, defaultAclPermission);
        FMP4Muxing muxing = new FMP4Muxing();
        muxing.addOutput(encodingOutput);
        MuxingStream list = new MuxingStream();
        list.setStreamId(stream.getId());
        muxing.addStream(list);
        muxing.setSegmentLength(4.0);
        muxing = bitmovinApi.encoding.muxing.addFmp4MuxingToEncoding(encoding, muxing);
        return muxing;
    }

    private TSMuxing createTSMuxing(Encoding encoding, Stream stream, Output output, String outputPath, AclPermission defaultAclPermission)
            throws URISyntaxException, BitmovinApiException, RestException, UnirestException, IOException
    {
        EncodingOutput encodingOutput = this.createEncodingOutput(output, outputPath, defaultAclPermission);
        TSMuxing muxing = new TSMuxing();
        muxing.addOutput(encodingOutput);
        MuxingStream list = new MuxingStream();
        list.setStreamId(stream.getId());
        muxing.addStream(list);
        muxing.setSegmentLength(4.0);
        muxing = bitmovinApi.encoding.muxing.addTSMuxingToEncoding(encoding, muxing);
        return muxing;
    }

}
