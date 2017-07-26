package com.bitmovin.api.examples;

import com.bitmovin.api.BitmovinApi;
import com.bitmovin.api.encoding.AclEntry;
import com.bitmovin.api.encoding.AclPermission;
import com.bitmovin.api.encoding.EncodingOutput;
import com.bitmovin.api.encoding.InputStream;
import com.bitmovin.api.encoding.codecConfigurations.AACAudioConfig;
import com.bitmovin.api.encoding.codecConfigurations.H265VideoConfiguration;
import com.bitmovin.api.encoding.codecConfigurations.enums.ProfileH265;
import com.bitmovin.api.encoding.encodings.Encoding;
import com.bitmovin.api.encoding.encodings.muxing.FMP4Muxing;
import com.bitmovin.api.encoding.encodings.muxing.MuxingStream;
import com.bitmovin.api.encoding.encodings.muxing.TSMuxing;
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
import com.bitmovin.api.helper.H265CodecConfigHelper;
import com.bitmovin.api.helper.VideoCodecPresets;
import com.bitmovin.api.http.RestException;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * Created by Andreas Rudich on 25.07.17.
 **/
public class CreateHLSEncodingWithHEVC
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
    public void testHlsHevcEncoding() throws IOException, BitmovinApiException, UnirestException, URISyntaxException, RestException, InterruptedException
    {
        bitmovinApi = new BitmovinApi(ApiKey);

        Encoding encoding = new Encoding();
        encoding.setName("Encoding JAVA with HEVC for HLS");
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

        H265VideoConfiguration videoConfiguration240p = this.createH265VideoConfiguration("HEVC_240", ProfileH265.main, 240, 240000L);
        H265VideoConfiguration videoConfiguration360p = this.createH265VideoConfiguration("HEVC_360", ProfileH265.main, 360, 480000L);
        H265VideoConfiguration videoConfiguration480p = this.createH265VideoConfiguration("HEVC_480", ProfileH265.main, 480, 720000L);
        H265VideoConfiguration videoConfiguration720p = this.createH265VideoConfiguration("HEVC_720", ProfileH265.main, 720, 1440000L);
        H265VideoConfiguration videoConfiguration1080p = this.createH265VideoConfiguration("HEVC_1080", ProfileH265.main, 1080, 2880000L);

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

        Stream videoStream240p = new Stream();
        videoStream240p.setCodecConfigId(videoConfiguration240p.getId());
        videoStream240p.setInputStreams(Collections.singleton(inputStreamVideo));
        videoStream240p = bitmovinApi.encoding.stream.addStream(encoding, videoStream240p);

        Stream videoStream360p = new Stream();
        videoStream360p.setCodecConfigId(videoConfiguration360p.getId());
        videoStream360p.setInputStreams(Collections.singleton(inputStreamVideo));
        videoStream360p = bitmovinApi.encoding.stream.addStream(encoding, videoStream360p);

        Stream videoStream480p = new Stream();
        videoStream480p.setCodecConfigId(videoConfiguration480p.getId());
        videoStream480p.setInputStreams(Collections.singleton(inputStreamVideo));
        videoStream480p = bitmovinApi.encoding.stream.addStream(encoding, videoStream480p);

        Stream videoStream720p = new Stream();
        videoStream720p.setCodecConfigId(videoConfiguration720p.getId());
        videoStream720p.setInputStreams(Collections.singleton(inputStreamVideo));
        videoStream720p = bitmovinApi.encoding.stream.addStream(encoding, videoStream720p);

        Stream videoStream1080p = new Stream();
        videoStream1080p.setCodecConfigId(videoConfiguration1080p.getId());
        videoStream1080p.setInputStreams(Collections.singleton(inputStreamVideo));
        videoStream1080p = bitmovinApi.encoding.stream.addStream(encoding, videoStream1080p);

        EncodingOutput encodingOutput = new EncodingOutput();
        encodingOutput.setOutputId(output.getId());
        encodingOutput.setOutputPath(OUTPUT_BASE_PATH);

        FMP4Muxing fmp4Muxing240 = this.createFMP4Muxing(encoding, videoStream240p, output, OUTPUT_BASE_PATH + "/video/240p_hevc", AclPermission.PUBLIC_READ);
        FMP4Muxing fmp4Muxing360 = this.createFMP4Muxing(encoding, videoStream360p, output, OUTPUT_BASE_PATH + "/video/360p_hevc", AclPermission.PUBLIC_READ);
        FMP4Muxing fmp4Muxing480 = this.createFMP4Muxing(encoding, videoStream480p, output, OUTPUT_BASE_PATH + "/video/480p_hevc", AclPermission.PUBLIC_READ);
        FMP4Muxing fmp4Muxing720 = this.createFMP4Muxing(encoding, videoStream720p, output, OUTPUT_BASE_PATH + "/video/720p_hevc", AclPermission.PUBLIC_READ);
        FMP4Muxing fmp4Muxing1080 = this.createFMP4Muxing(encoding, videoStream1080p, output, OUTPUT_BASE_PATH + "/video/1080p_hevc", AclPermission.PUBLIC_READ);
        FMP4Muxing fmp4Audio = this.createFMP4Muxing(encoding, audioStream, output, OUTPUT_BASE_PATH + "/audio/128kbps_hevc", AclPermission.PUBLIC_READ);

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
            Assert.fail("Encoding has status error ... can not create manifest");
        }

        System.out.println("Creating HLS manifest");

        EncodingOutput manifestDestination = new EncodingOutput();
        manifestDestination.setOutputId(output.getId());
        manifestDestination.setOutputPath(OUTPUT_BASE_PATH);
        manifestDestination.setAcl(Collections.singletonList(new AclEntry(AclPermission.PUBLIC_READ)));

        HlsManifest manifestHls = this.createHlsManifest("manifest.m3u8", manifestDestination);

        MediaInfo audioMediaInfo = new MediaInfo();
        audioMediaInfo.setName("audio.m3u8");
        audioMediaInfo.setUri("audio.m3u8");
        audioMediaInfo.setGroupId("audio");
        audioMediaInfo.setType(MediaInfoType.AUDIO);
        audioMediaInfo.setEncodingId(encoding.getId());
        audioMediaInfo.setStreamId(audioStream.getId());
        audioMediaInfo.setMuxingId(fmp4Audio.getId());
        audioMediaInfo.setLanguage("en");
        audioMediaInfo.setAssocLanguage("en");
        audioMediaInfo.setAutoselect(false);
        audioMediaInfo.setDefault(false);
        audioMediaInfo.setForced(false);
        audioMediaInfo.setSegmentPath("audio/128kbps_hevc");
        bitmovinApi.manifest.hls.createMediaInfo(manifestHls, audioMediaInfo);

        this.addStreamInfoToHlsManifest("video_1080p.m3u8", encoding.getId(), videoStream1080p.getId(), fmp4Muxing1080.getId(), "audio","video/1080p_hevc", manifestHls);
        this.addStreamInfoToHlsManifest("video_720p.m3u8", encoding.getId(), videoStream720p.getId(), fmp4Muxing720.getId(), "audio","video/720p_hevc", manifestHls);
        this.addStreamInfoToHlsManifest("video_480p.m3u8", encoding.getId(), videoStream480p.getId(), fmp4Muxing480.getId(), "audio","video/480p_hevc", manifestHls);
        this.addStreamInfoToHlsManifest("video_360p.m3u8", encoding.getId(), videoStream360p.getId(), fmp4Muxing360.getId(), "audio","video/360p_hevc", manifestHls);
        this.addStreamInfoToHlsManifest("video_240p.m3u8", encoding.getId(), videoStream240p.getId(), fmp4Muxing240.getId(), "audio","video/240p_hevc", manifestHls);

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
            Assert.fail("Could not create HLS manifest");
        }
        System.out.println("Encoding completed successfully");
    }

    private StreamInfo addStreamInfoToHlsManifest(String uri, String encodingId, String streamId, String muxingId,
                                                  String audioGroupId, String segmentPath, HlsManifest manifest)
            throws URISyntaxException, BitmovinApiException, RestException, UnirestException, IOException
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


    private HlsManifest createHlsManifest(String name, EncodingOutput output)
            throws URISyntaxException, BitmovinApiException, UnirestException, IOException
    {
        HlsManifest m = new HlsManifest();
        m.setName(name);
        m.addOutput(output);
        return bitmovinApi.manifest.hls.create(m);
    }

    private void addDashRepresentationToAdaptationSet(DashMuxingType type, String encodingId, String muxingId,
                                                      String segmentPath, DashManifest manifest, Period period,
                                                      AdaptationSet adaptationSet)
            throws BitmovinApiException, URISyntaxException, RestException, UnirestException, IOException
    {
        DashFmp4Representation r = new DashFmp4Representation();
        r.setType(type);
        r.setEncodingId(encodingId);
        r.setMuxingId(muxingId);
        r.setSegmentPath(segmentPath);
        bitmovinApi.manifest.dash.addRepresentationToAdaptationSet(manifest, period, adaptationSet, r);
    }

    private AudioAdaptationSet addAudioAdaptationSetToPeriodWithRoles(DashManifest manifest, Period period, String lang)
            throws URISyntaxException, BitmovinApiException, RestException, UnirestException, IOException
    {
        AudioAdaptationSet a = new AudioAdaptationSet();
        a.setLang(lang);
        a = bitmovinApi.manifest.dash.addAudioAdaptationSetToPeriod(manifest, period, a);
        return a;
    }

    private VideoAdaptationSet addVideoAdaptationSetToPeriod(DashManifest manifest, Period period)
            throws URISyntaxException, BitmovinApiException, RestException, UnirestException, IOException
    {
        VideoAdaptationSet adaptationSet = new VideoAdaptationSet();
        adaptationSet = bitmovinApi.manifest.dash.addVideoAdaptationSetToPeriod(manifest, period, adaptationSet);
        return adaptationSet;
    }

    private DashManifest createDashManifest(String name, EncodingOutput output)
            throws URISyntaxException, BitmovinApiException, UnirestException, IOException
    {
        DashManifest manifest = new DashManifest();
        manifest.setName(name);
        manifest.addOutput(output);
        manifest = bitmovinApi.manifest.dash.create(manifest);
        return manifest;
    }

    private Period addPeriodToDashManifest(DashManifest manifest)
            throws URISyntaxException, BitmovinApiException, RestException, UnirestException, IOException
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

    private H265VideoConfiguration createH265VideoConfiguration(String name, ProfileH265 profile,
                                                                Integer height, long bitRate)
            throws URISyntaxException, BitmovinApiException, RestException, UnirestException, IOException
    {
        H265VideoConfiguration h265VideoConfiguration = H265CodecConfigHelper.getConfig(name,
                                                                                        "Medium H265 config for " + name,
                                                                                        profile,
                                                                                        VideoCodecPresets.MEDIUM,
                                                                                        bitRate);
        h265VideoConfiguration.setHeight(height);

        return createH265VideoConfiguration(h265VideoConfiguration);
    }

    private H265VideoConfiguration createH265VideoConfiguration(H265VideoConfiguration h265VideoConfiguration)
            throws URISyntaxException, BitmovinApiException, RestException, UnirestException, IOException
    {
        return bitmovinApi.configuration.videoH265.create(h265VideoConfiguration);
    }
}
