package com.bitmovin.api.examples;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.bitmovin.api.BitmovinApi;
import com.bitmovin.api.encoding.AclEntry;
import com.bitmovin.api.encoding.AclPermission;
import com.bitmovin.api.encoding.EncodingOutput;
import com.bitmovin.api.encoding.InputStream;
import com.bitmovin.api.encoding.codecConfigurations.AACAudioConfig;
import com.bitmovin.api.encoding.codecConfigurations.VP9VideoConfiguration;
import com.bitmovin.api.encoding.encodings.Encoding;
import com.bitmovin.api.encoding.encodings.live.LiveDashManifest;
import com.bitmovin.api.encoding.encodings.live.LiveDetailsResponse;
import com.bitmovin.api.encoding.encodings.live.StartLiveEncodingRequest;
import com.bitmovin.api.encoding.encodings.muxing.FMP4Muxing;
import com.bitmovin.api.encoding.encodings.muxing.Muxing;
import com.bitmovin.api.encoding.encodings.muxing.MuxingStream;
import com.bitmovin.api.encoding.encodings.muxing.WebmMuxing;
import com.bitmovin.api.encoding.encodings.streams.Stream;
import com.bitmovin.api.encoding.enums.CloudRegion;
import com.bitmovin.api.encoding.enums.DashMuxingType;
import com.bitmovin.api.encoding.enums.StreamSelectionMode;
import com.bitmovin.api.encoding.inputs.RtmpInput;
import com.bitmovin.api.encoding.manifest.dash.AdaptationSet;
import com.bitmovin.api.encoding.manifest.dash.AudioAdaptationSet;
import com.bitmovin.api.encoding.manifest.dash.DashFmp4Representation;
import com.bitmovin.api.encoding.manifest.dash.DashManifest;
import com.bitmovin.api.encoding.manifest.dash.Period;
import com.bitmovin.api.encoding.manifest.dash.VideoAdaptationSet;
import com.bitmovin.api.encoding.outputs.Output;
import com.bitmovin.api.encoding.outputs.S3Output;
import com.bitmovin.api.encoding.status.Task;
import com.bitmovin.api.enums.Status;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.http.RestException;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Created by Germano Fronza on 27.11.17.
 **/
public class CreateAndStartLiveStreamWithVP9 {
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

	// please set here the encoding profiles. You can modify height, width, bitrate and fps.
	private static final VideoProfile[] VIDEO_ENCODING_PROFILES = new VideoProfile[] {
			new VideoProfile(1280, 720, 3000, 30.0f),
			new VideoProfile(858, 480, 1200, 30.0f),
			new VideoProfile(640, 360, 800, 30.0f),
			new VideoProfile(426, 240, 400, 30.0f),
	};

	// please set here the encoding profiles. You can modify bitrate and rate.
	private static final AudioProfile[] AUDIO_ENCODING_PROFILES = new AudioProfile[] {
			new AudioProfile(128, 48000f),
	};

	private static BitmovinApi bitmovinApi;

	@Test
	public void testCreateAndStartLiveStreamWithVP9() throws IOException, BitmovinApiException, UnirestException, URISyntaxException,
			RestException, InterruptedException {
		bitmovinApi = new BitmovinApi(API_KEY);

		Encoding encoding = new Encoding();
		encoding.setName("JAVA live stream with VP9");
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

		for (VideoProfile videoProfile : VIDEO_ENCODING_PROFILES) {
			VP9VideoConfiguration videoConfig = createVP9VideoConfiguration(videoProfile);
			Stream videoStream = createStream(encoding, videoInputStream, videoConfig.getId());
			Muxing muxing = this.createWebmMuxing(encoding, output,
					String.format("video/%dp_%d_dash", videoProfile.height, videoProfile.bitrate), videoStream);

			videoProfile.stream = videoStream;
			videoProfile.muxing = muxing;
		}

		for (AudioProfile audioProfile : AUDIO_ENCODING_PROFILES) {
			AACAudioConfig audioConfig = createAACAudioConfig(audioProfile);
			Stream audioStream = createStream(encoding, audioInputStream, audioConfig.getId());
			Muxing muxing = this.createFMP4Muxing(encoding, output,
					String.format("audio/%d_dash", audioProfile.bitrate), audioStream);

			audioProfile.stream = audioStream;
			audioProfile.muxing = muxing;
		}

		// Create DASH manifest
		EncodingOutput manifestOutput = new EncodingOutput();
		manifestOutput.setOutputId(output.getId());
		manifestOutput.setOutputPath(OUTPUT_BASE_PATH);
		manifestOutput.setAcl(new ArrayList<AclEntry>() {
			{
				this.add(new AclEntry(AclPermission.PUBLIC_READ));
			}
		});

		DashManifest dashManifest = new DashManifest();
		dashManifest.setName("stream.mpd");
		dashManifest.setOutputs(Collections.singletonList(manifestOutput));
		dashManifest = bitmovinApi.manifest.dash.create(dashManifest);

		Period period = bitmovinApi.manifest.dash.createPeriod(dashManifest, new Period());

		VideoAdaptationSet videoAdaptationSet = bitmovinApi.manifest.dash.addVideoAdaptationSetToPeriod(dashManifest,
				period, new VideoAdaptationSet());

		for (VideoProfile videoProfile : VIDEO_ENCODING_PROFILES) {
			this.addDashRepresentationToAdaptationSet(DashMuxingType.TEMPLATE, encoding.getId(),
					videoProfile.stream.getId(), videoProfile.muxing.getId(),
					String.format("video/%dp_%d_dash", videoProfile.height, videoProfile.bitrate), dashManifest, period,
					videoAdaptationSet);
		}

		AudioAdaptationSet audioAdaptationSet = bitmovinApi.manifest.dash.addAudioAdaptationSetToPeriod(dashManifest, period,
				new AudioAdaptationSet());

		for (AudioProfile audioProfile : AUDIO_ENCODING_PROFILES) {
			this.addDashRepresentationToAdaptationSet(DashMuxingType.TEMPLATE, encoding.getId(),
					audioProfile.stream.getId(), audioProfile.muxing.getId(),
					String.format("audio/%d_dash", audioProfile.bitrate), dashManifest, period, audioAdaptationSet);
		}

		LiveDashManifest liveDashManifest = new LiveDashManifest();
		liveDashManifest.setManifestId(dashManifest.getId());
		
		StartLiveEncodingRequest liveEncodingRequest = new StartLiveEncodingRequest();
		liveEncodingRequest.setStreamKey(STREAM_KEY);
		liveEncodingRequest.setDashManifests(Collections.singletonList(liveDashManifest));
		
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
			URISyntaxException, UnirestException, InterruptedException {
		Task status = bitmovinApi.encoding.getStatus(encoding);

		while (status.getStatus() != Status.RUNNING && status.getStatus() != Status.ERROR) {
			status = bitmovinApi.encoding.getStatus(encoding);
			Thread.sleep(2500);
			
			System.out.println(String.format("Encoding configuration status: %s", status.getStatus().toString()));
		}
	}

	private LiveDetailsResponse getLiveDetails(Encoding encoding) throws IOException, RestException, URISyntaxException,
			UnirestException, BitmovinApiException, InterruptedException {
		LiveDetailsResponse liveDetails = null;
		
		while (liveDetails == null) {
			try {
				liveDetails = bitmovinApi.encoding.getLiveDetails(encoding.getId());
			} catch (BitmovinApiException e) {
				if (e.getCode() == ERROR_CODE_LIVE_STREAM_NOT_READY) {
					System.out.println(String.format("Live encoding details are not available yet."));
				} else {
					System.out.println(String.format("Got unexpected exception with code %d", e.getCode()));
					throw e;
				}
				
				Thread.sleep(2500);
			}
		}
		return liveDetails;
	}

	private AACAudioConfig createAACAudioConfig(AudioProfile audioProfile)
			throws BitmovinApiException, UnirestException, IOException, URISyntaxException {
		AACAudioConfig audioConfig = new AACAudioConfig();
		audioConfig.setBitrate(audioProfile.bitrate * 1000);
		audioConfig.setRate(audioProfile.rate);
		audioConfig = bitmovinApi.configuration.audioAAC.create(audioConfig);
		return audioConfig;
	}

	private Stream createStream(Encoding encoding, InputStream inputStream, String codecConfigId)
			throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException {
		Stream stream = new Stream();
		stream.setCodecConfigId(codecConfigId);
		stream.setInputStreams(Collections.singleton(inputStream));
		stream = bitmovinApi.encoding.stream.addStream(encoding, stream);
		return stream;
	}

	private VP9VideoConfiguration createVP9VideoConfiguration(VideoProfile videoProfile)
			throws BitmovinApiException, UnirestException, IOException, URISyntaxException {
		VP9VideoConfiguration videoConfig = new VP9VideoConfiguration();
		videoConfig.setName(String.format("StreamDemoVP9%dp", videoProfile.height));
		videoConfig.setBitrate(videoProfile.bitrate * 1000);
		videoConfig.setRate(videoProfile.fps);
		videoConfig.setWidth(videoProfile.width);
		videoConfig.setHeight(videoProfile.height);
		videoConfig.setId(String.format("vp9_%dp", videoProfile.height));
		videoConfig = bitmovinApi.configuration.videoVP9.create(videoConfig);
		return videoConfig;
	}

	private FMP4Muxing createFMP4Muxing(Encoding encoding, Output output, String path, Stream videoStream)
			throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException {
		EncodingOutput encodingOutput = new EncodingOutput();
		encodingOutput.setOutputId(output.getId());
		encodingOutput.setOutputPath(OUTPUT_BASE_PATH + path);
		encodingOutput.setAcl(new ArrayList<AclEntry>() {
			{
				this.add(new AclEntry(AclPermission.PUBLIC_READ));
			}
		});

		FMP4Muxing fmp4Muxing = new FMP4Muxing();
		fmp4Muxing.setInitSegmentName("init.mp4");
		fmp4Muxing.setSegmentNaming("segment_%number%.m4s");
		fmp4Muxing.setSegmentLength(MUXING_SEGMENT_DURATION);
		fmp4Muxing.setOutputs(Collections.singletonList(encodingOutput));

		MuxingStream muxingStreamVideo = new MuxingStream();
		muxingStreamVideo.setStreamId(videoStream.getId());

		List<MuxingStream> muxingStreams = new ArrayList<>();
		muxingStreams.add(muxingStreamVideo);

		fmp4Muxing.setStreams(muxingStreams);

		return bitmovinApi.encoding.muxing.addFmp4MuxingToEncoding(encoding, fmp4Muxing);
	}

	private WebmMuxing createWebmMuxing(Encoding encoding, Output output, String path, Stream videoStream)
			throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException {
		EncodingOutput encodingOutput = new EncodingOutput();
		encodingOutput.setOutputId(output.getId());
		encodingOutput.setOutputPath(OUTPUT_BASE_PATH + path);
		encodingOutput.setAcl(new ArrayList<AclEntry>() {
			{
				this.add(new AclEntry(AclPermission.PUBLIC_READ));
			}
		});

		WebmMuxing webmMuxing = new WebmMuxing();
		webmMuxing.setInitSegmentName("init.hdr");
		webmMuxing.setSegmentNaming("segment_%number%.chk");
		webmMuxing.setSegmentLength(MUXING_SEGMENT_DURATION);
		webmMuxing.setOutputs(Collections.singletonList(encodingOutput));

		MuxingStream muxingStreamVideo = new MuxingStream();
		muxingStreamVideo.setStreamId(videoStream.getId());

		List<MuxingStream> muxingStreams = new ArrayList<>();
		muxingStreams.add(muxingStreamVideo);

		webmMuxing.setStreams(muxingStreams);

		return bitmovinApi.encoding.muxing.addWebmMuxingToEncoding(encoding, webmMuxing);
	}

	private void addDashRepresentationToAdaptationSet(DashMuxingType type, String encodingId, String streamId,
			String muxingId, String segmentPath, DashManifest manifest, Period period, AdaptationSet adaptationSet)
			throws BitmovinApiException, URISyntaxException, RestException, UnirestException, IOException {
		DashFmp4Representation r = new DashFmp4Representation();
		r.setType(type);
		r.setEncodingId(encodingId);
		r.setStreamId(streamId);
		r.setMuxingId(muxingId);
		r.setSegmentPath(segmentPath);
		bitmovinApi.manifest.dash.addRepresentationToAdaptationSet(manifest, period, adaptationSet, r);
	}

	private static class MediaProfile {
		protected Stream stream;
		protected Muxing muxing;
	}

	private static class VideoProfile extends MediaProfile {
		private int width;
		private int height;
		private long bitrate;
		private float fps;

		public VideoProfile(int width, int height, long bitrate, float fps) {
			super();
			this.width = width;
			this.height = height;
			this.bitrate = bitrate;
			this.fps = fps;
		}
	}

	private static class AudioProfile extends MediaProfile {
		private long bitrate;
		private float rate;

		public AudioProfile(long bitrate, float rate) {
			super();
			this.bitrate = bitrate;
			this.rate = rate;
		}
	}
}
