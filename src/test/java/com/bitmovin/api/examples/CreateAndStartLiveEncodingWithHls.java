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
import com.bitmovin.api.encoding.encodings.live.LiveDetailsResponse;
import com.bitmovin.api.encoding.encodings.live.LiveHlsManifest;
import com.bitmovin.api.encoding.encodings.live.StartLiveEncodingRequest;
import com.bitmovin.api.encoding.encodings.muxing.Muxing;
import com.bitmovin.api.encoding.encodings.muxing.MuxingStream;
import com.bitmovin.api.encoding.encodings.muxing.TSMuxing;
import com.bitmovin.api.encoding.encodings.streams.Stream;
import com.bitmovin.api.encoding.enums.CloudRegion;
import com.bitmovin.api.encoding.enums.StreamSelectionMode;
import com.bitmovin.api.encoding.inputs.RtmpInput;
import com.bitmovin.api.encoding.manifest.hls.AudioMediaInfo;
import com.bitmovin.api.encoding.manifest.hls.HlsManifest;
import com.bitmovin.api.encoding.manifest.hls.StreamInfo;
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
import java.util.List;

public class CreateAndStartLiveEncodingWithHls
{
    private static final int ERROR_CODE_LIVE_STREAM_NOT_READY = 2023;

    private static final String API_KEY = "<INSERT_YOUR_API_KEY>";
    private static final CloudRegion CLOUD_REGION = CloudRegion.AWS_EU_WEST_1;

    // please set here the duration of each segment (audio and video).
    private static final double MUXING_SEGMENT_DURATION = 4.0;

    // please set here your secret stream key.
    private static final String STREAM_KEY = "<INSERT_YOUR_STREAM_KEY>";

    private static final String S3_OUTPUT_ACCESSKEY = "<YOUR_OUTPUT_S3_ACCESSKEY>";
    private static final String S3_OUTPUT_SECRET_KEY = "<YOUR_OUTPUT_S3_SECRET_KEY>";
    private static final String S3_OUTPUT_BUCKET_NAME = "<YOUR_OUTPUT_S3_BUCKET_NAME>";
    private static final String OUTPUT_BASE_PATH = "path/to/output/";

    // please set here the encoding profiles. You can modify height, width, bitrate
    // and fps.
    private static final VideoProfile[] VIDEO_ENCODING_PROFILES = new VideoProfile[]{
            new VideoProfile(1280, 720, 3000, 30.0f),
            new VideoProfile(858, 480, 1200, 30.0f),
            new VideoProfile(640, 360, 800, 30.0f),
            new VideoProfile(426, 240, 400, 30.0f),
    };

    // please set here the encoding profiles. You can modify bitrate and rate.
    private static final AudioProfile AUDIO_ENCODING_PROFILE = new AudioProfile(128, 48000f);

    private static BitmovinApi bitmovinApi;

    @Test
    public void testCreateAndStartLiveStreamWithVP9() throws IOException, BitmovinApiException, UnirestException,
            URISyntaxException, RestException, InterruptedException
    {
        bitmovinApi = new BitmovinApi(API_KEY);

        Encoding encoding = new Encoding();
        encoding.setName("Java Client HLS live stream");
        encoding.setCloudRegion(CLOUD_REGION);
        encoding = bitmovinApi.encoding.create(encoding);

        RtmpInput input = bitmovinApi.input.rtmp.getAll().get(0);

        S3Output output = new S3Output();
        output.setAccessKey(S3_OUTPUT_ACCESSKEY);
        output.setSecretKey(S3_OUTPUT_SECRET_KEY);
        output.setBucketName(S3_OUTPUT_BUCKET_NAME);
        output = bitmovinApi.output.s3.create(output);

        InputStream videoInputStream = new InputStream();
        videoInputStream.setInputPath("live");
        videoInputStream.setInputId(input.getId());
        videoInputStream.setSelectionMode(StreamSelectionMode.AUTO);
        videoInputStream.setPosition(0);

        InputStream audioInputStream = new InputStream();
        audioInputStream.setInputPath("live");
        audioInputStream.setInputId(input.getId());
        audioInputStream.setSelectionMode(StreamSelectionMode.AUTO);
        audioInputStream.setPosition(1);

        for (VideoProfile videoProfile : VIDEO_ENCODING_PROFILES)
        {
            H264VideoConfiguration videoConfig = createH264VideoConfiguration(videoProfile);
            Stream videoStream = createStream(encoding, videoInputStream, videoConfig.getId());
            Muxing muxing = this.createTsMuxing(encoding, output,
                    String.format("video/%dp_%d_ts", videoProfile.height, videoProfile.bitrate), videoStream);

            videoProfile.stream = videoStream;
            videoProfile.muxing = muxing;
        }


        AACAudioConfig audioConfig = createAACAudioConfig(AUDIO_ENCODING_PROFILE);
        Stream audioStream = createStream(encoding, audioInputStream, audioConfig.getId());
        Muxing muxing = this.createTsMuxing(encoding, output,
                String.format("audio/%d_ts", AUDIO_ENCODING_PROFILE.bitrate), audioStream);

        AUDIO_ENCODING_PROFILE.stream = audioStream;
        AUDIO_ENCODING_PROFILE.muxing = muxing;

        // Create HLS manifest
        EncodingOutput manifestOutput = new EncodingOutput();
        manifestOutput.setOutputId(output.getId());
        manifestOutput.setOutputPath(OUTPUT_BASE_PATH);
        manifestOutput.setAcl(new ArrayList<AclEntry>()
        {
            {
                this.add(new AclEntry(AclPermission.PUBLIC_READ));
            }
        });

        HlsManifest hlsManifest = new HlsManifest();
        hlsManifest.setName("stream.m3u8");
        hlsManifest.setOutputs(Collections.singletonList(manifestOutput));
        hlsManifest = bitmovinApi.manifest.hls.create(hlsManifest);

        AudioMediaInfo audioMediaInfo = new AudioMediaInfo();
        audioMediaInfo.setMuxingId(AUDIO_ENCODING_PROFILE.muxing.getId());
        audioMediaInfo.setStreamId(AUDIO_ENCODING_PROFILE.stream.getId());
        audioMediaInfo.setSegmentPath(String.format("audio/%d_ts", AUDIO_ENCODING_PROFILE.bitrate));
        audioMediaInfo.setName("audio.m3u8");
        audioMediaInfo.setUri("audio.m3u8");
        audioMediaInfo.setGroupId("audio");
        audioMediaInfo.setEncodingId(encoding.getId());
        audioMediaInfo = bitmovinApi.manifest.hls.createAudioMediaInfo(hlsManifest, audioMediaInfo);

        for (VideoProfile videoProfile : VIDEO_ENCODING_PROFILES)
        {
            StreamInfo videoStreamInfo = new StreamInfo();
            videoStreamInfo.setUri(String.format("%dp_%d.m3u8", videoProfile.height, videoProfile.bitrate));
            videoStreamInfo.setEncodingId(encoding.getId());
            videoStreamInfo.setStreamId(videoProfile.stream.getId());
            videoStreamInfo.setMuxingId(videoProfile.muxing.getId());
            videoStreamInfo.setAudio(audioMediaInfo.getGroupId());
            videoStreamInfo.setSegmentPath(String.format("video/%dp_%d_ts", videoProfile.height, videoProfile.bitrate));
            bitmovinApi.manifest.hls.createStreamInfo(hlsManifest, videoStreamInfo);
        }

        LiveHlsManifest liveHlsManifest = new LiveHlsManifest();
        liveHlsManifest.setManifestId(hlsManifest.getId());

        StartLiveEncodingRequest liveEncodingRequest = new StartLiveEncodingRequest();
        liveEncodingRequest.setStreamKey(STREAM_KEY);
        liveEncodingRequest.setHlsManifests(Collections.singletonList(liveHlsManifest));

        // start live encoding with dash manifest.
        bitmovinApi.encoding.startLive(encoding, liveEncodingRequest);

        // wait until live encoding is running
        waitUntilRunning(encoding);

        // retrieve live encoding details.
        LiveDetailsResponse liveDetails = getLiveDetails(encoding);

        System.out.println("-----------------------------------------------------");
        System.out.println("Live Stream set up successfully");
        System.out.println(String.format("RTMP Url: %s", liveDetails.getEncoderIp()));
        System.out.println(String.format("Stream key: %s", liveDetails.getStreamKey()));
        System.out.println(String.format("Encoding ID: %s", encoding.getId()));
        System.out.println("-----------------------------------------------------");
    }

    private void waitUntilRunning(Encoding encoding) throws BitmovinApiException, IOException, RestException,
            URISyntaxException, UnirestException, InterruptedException
    {
        Task status = bitmovinApi.encoding.getStatus(encoding);

        while (status.getStatus() != Status.RUNNING && status.getStatus() != Status.ERROR)
        {
            status = bitmovinApi.encoding.getStatus(encoding);
            Thread.sleep(2500);

            System.out.println(String.format("Encoding configuration status: %s", status.getStatus().toString()));
        }
    }

    private LiveDetailsResponse getLiveDetails(Encoding encoding) throws IOException, RestException, URISyntaxException,
            UnirestException, BitmovinApiException, InterruptedException
    {
        LiveDetailsResponse liveDetails = null;

        while (liveDetails == null)
        {
            try
            {
                liveDetails = bitmovinApi.encoding.getLiveDetails(encoding.getId());
            }
            catch (BitmovinApiException e)
            {
                if (e.getCode() == ERROR_CODE_LIVE_STREAM_NOT_READY)
                {
                    System.out.println(String.format("Live encoding details are not available yet."));
                }
                else
                {
                    System.out.println(String.format("Got unexpected exception with code %d", e.getCode()));
                    throw e;
                }

                Thread.sleep(2500);
            }
        }
        return liveDetails;
    }

    private AACAudioConfig createAACAudioConfig(AudioProfile audioProfile)
            throws BitmovinApiException, UnirestException, IOException, URISyntaxException
    {
        AACAudioConfig audioConfig = new AACAudioConfig();
        audioConfig.setBitrate(audioProfile.bitrate * 1000);
        audioConfig.setRate(audioProfile.rate);
        audioConfig = bitmovinApi.configuration.audioAAC.create(audioConfig);
        return audioConfig;
    }

    private Stream createStream(Encoding encoding, InputStream inputStream, String codecConfigId)
            throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        Stream stream = new Stream();
        stream.setCodecConfigId(codecConfigId);
        stream.setInputStreams(Collections.singleton(inputStream));
        stream = bitmovinApi.encoding.stream.addStream(encoding, stream);
        return stream;
    }

    private H264VideoConfiguration createH264VideoConfiguration(VideoProfile videoProfile)
            throws BitmovinApiException, UnirestException, IOException, URISyntaxException
    {
        H264VideoConfiguration videoConfig = new H264VideoConfiguration();
        videoConfig.setName(String.format("H264 video configuration %dp", videoProfile.height));
        videoConfig.setBitrate(videoProfile.bitrate * 1000);
        videoConfig.setRate(videoProfile.fps);
        videoConfig.setWidth(videoProfile.width);
        videoConfig.setHeight(videoProfile.height);
        videoConfig.setProfile(ProfileH264.HIGH);
        videoConfig = bitmovinApi.configuration.videoH264.create(videoConfig);
        return videoConfig;
    }

    private TSMuxing createTsMuxing(Encoding encoding, Output output, String path, Stream videoStream)
            throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        EncodingOutput encodingOutput = new EncodingOutput();
        encodingOutput.setOutputId(output.getId());
        encodingOutput.setOutputPath(OUTPUT_BASE_PATH + path);
        encodingOutput.setAcl(new ArrayList<AclEntry>()
        {
            {
                this.add(new AclEntry(AclPermission.PUBLIC_READ));
            }
        });

        TSMuxing tsMuxing = new TSMuxing();
        tsMuxing.setSegmentNaming("segment_%number%.ts");
        tsMuxing.setSegmentLength(MUXING_SEGMENT_DURATION);
        tsMuxing.setOutputs(Collections.singletonList(encodingOutput));

        MuxingStream muxingStreamVideo = new MuxingStream();
        muxingStreamVideo.setStreamId(videoStream.getId());

        List<MuxingStream> muxingStreams = new ArrayList<>();
        muxingStreams.add(muxingStreamVideo);

        tsMuxing.setStreams(muxingStreams);

        return bitmovinApi.encoding.muxing.addTSMuxingToEncoding(encoding, tsMuxing);
    }

    private static class MediaProfile
    {
        protected Stream stream;
        protected Muxing muxing;
    }

    private static class VideoProfile extends MediaProfile
    {
        private int width;
        private int height;
        private long bitrate;
        private float fps;

        public VideoProfile(int width, int height, long bitrate, float fps)
        {
            super();
            this.width = width;
            this.height = height;
            this.bitrate = bitrate;
            this.fps = fps;
        }
    }

    private static class AudioProfile extends MediaProfile
    {
        private long bitrate;
        private float rate;

        public AudioProfile(long bitrate, float rate)
        {
            super();
            this.bitrate = bitrate;
            this.rate = rate;
        }

    }
}
