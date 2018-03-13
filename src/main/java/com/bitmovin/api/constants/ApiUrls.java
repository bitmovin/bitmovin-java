package com.bitmovin.api.constants;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 25.07.16.
 */
public class ApiUrls
{
    public static final String API_ENDPOINT = "api.bitmovin.com/v1";
    public static final String API_ENDPOINT_WITH_PROTOCOL = "https://" + API_ENDPOINT;

    public static final String inputs = "encoding/inputs";
    public static final String inputsLimitOffset = "encoding/inputs?limit={limit}&offset={offset}";
    public static final String inputHttp = "encoding/inputs/http";
    public static final String inputHttps = "encoding/inputs/https";
    public static final String inputS3 = "encoding/inputs/s3";
    public static final String inputGenericS3 = "encoding/inputs/generic-s3";
    public static final String inputGcs = "encoding/inputs/gcs";
    public static final String inputFTP = "encoding/inputs/ftp";
    public static final String inputSFTP = "encoding/inputs/sftp";
    public static final String inputAzure = "encoding/inputs/azure";
    public static final String inputAspera = "encoding/inputs/aspera";
    public static final String inputRtmp = "encoding/inputs/rtmp";
    public static final String inputLocal = "encoding/inputs/local";

    public static final String analysisStart = "encoding/inputs/{inputType}/{inputId}/analysis";
    public static final String analysisStatus = "encoding/inputs/{inputType}/{inputId}/analysis/{analysisId}/status";
    public static final String analysisDetails = "encoding/inputs/{inputType}/{inputId}/analysis/{analysisId}";

    public static final String outputs = "encoding/outputs";
    public static final String outputsLimitOffset = "encoding/outputs?limit={limit}&offset={offset}";
    public static final String outputGcs = "encoding/outputs/gcs";
    public static final String outputLocal = "encoding/outputs/local";
    public static final String outputBitmovinGcs = "encoding/outputs/bitmovingcs";
    public static final String outputS3 = "encoding/outputs/s3";
    public static final String outputGenericS3 = "encoding/outputs/generic-s3";
    public static final String outputBitmovinS3 = "encoding/outputs/bitmovins3";
    public static final String outputAkamaiNetStorage = "encoding/outputs/akamai-netstorage";
    public static final String outputAzure = "encoding/outputs/azure";
    public static final String outputFtp = "encoding/outputs/ftp";
    public static final String outputSftp = "encoding/outputs/sftp";

    public static final String codecConfig = "encoding/configurations";
    public static final String codecConfigLimitOffset = "encoding/configurations?offset={offset}&limit={limit}";
    public static final String codecConfigH264 = "encoding/configurations/video/h264";
    public static final String codecConfigH265 = "encoding/configurations/video/h265";
    public static final String codecConfigAAc = "encoding/configurations/audio/aac";
    public static final String codecConfigVP9 = "encoding/configurations/video/vp9";
    public static final String codecConfigMjpeg = "encoding/configurations/video/mjpeg";

    public static final String encodings = "encoding/encodings/";
    public static final String encodingInformation = "encoding/encodings/{encoding_id}/information";
    public static final String streams = "encoding/encodings/{encoding_id}/streams";
    public static final String streamsWithId = "encoding/encodings/{encoding_id}/streams/{stream_id}";
    public static final String streamsInputDetails = "encoding/encodings/{encoding_id}/streams/{stream_id}/inputs";
    public static final String encodingReport = "encoding/encodings/{encoding_id}/report";

    public static final String addFilterToStream = "encoding/encodings/{encoding_id}/streams/{stream_id}/filters";

    public static final String fmp4muxings = "encoding/encodings/{encoding_id}/muxings/fmp4";
    public static final String progressivetsmuxings = "encoding/encodings/{encoding_id}/muxings/progressive-ts";
    public static final String tsmuxings = "encoding/encodings/{encoding_id}/muxings/ts";
    public static final String mp4muxings = "encoding/encodings/{encoding_id}/muxings/mp4";
    public static final String webmmuxings = "encoding/encodings/{encoding_id}/muxings/webm";
    public static final String progressiveMovMuxings = "encoding/encodings/{encoding_id}/muxings/progressive-mov";

    public static final String widevineDrms = "encoding/encodings/{encoding_id}/muxings/fmp4/{muxing_id}/drm/widevine";
    public static final String playReadyDrms = "encoding/encodings/{encoding_id}/muxings/fmp4/{muxing_id}/drm/playready";
    public static final String primeTimeDrms = "encoding/encodings/{encoding_id}/muxings/fmp4/{muxing_id}/drm/primetime";
    public static final String fairPlayFmp4Drms = "encoding/encodings/{encoding_id}/muxings/fmp4/{muxing_id}/drm/fairplay";
    public static final String marlinDrms = "encoding/encodings/{encoding_id}/muxings/fmp4/{muxing_id}/drm/marlin";
    public static final String clearKeyDrms = "encoding/encodings/{encoding_id}/muxings/fmp4/{muxing_id}/drm/clearkey";
    public static final String cencDrms = "encoding/encodings/{encoding_id}/muxings/fmp4/{muxing_id}/drm/cenc";

    public static final String fairPlayTsDrms = "encoding/encodings/{encoding_id}/muxings/ts/{muxing_id}/drm/fairplay";
    public static final String aesEncryptionDrms = "encoding/encodings/{encoding_id}/muxings/ts/{muxing_id}/drm/aes";

    public static final String allDrmsFromFmp4Muxing = "encoding/encodings/{encoding_id}/muxings/fmp4/{muxing_id}/drm";
    public static final String addWidevineDrmToFmp4Muxing = "encoding/encodings/{encoding_id}/muxings/fmp4/{muxing_id}/drm/widevine";
    public static final String addPlayReadyDrmToFmp4Muxing = "encoding/encodings/{encoding_id}/muxings/fmp4/{muxing_id}/drm/playready";
    public static final String addPrimeTimeDrmToFmp4Muxing = "encoding/encodings/{encoding_id}/muxings/fmp4/{muxing_id}/drm/primetime";
    public static final String addFairPlayDrmToFmp4Muxing = "encoding/encodings/{encoding_id}/muxings/fmp4/{muxing_id}/drm/fairplay";
    public static final String addMarlinDrmToFmp4Muxing = "encoding/encodings/{encoding_id}/muxings/fmp4/{muxing_id}/drm/marlin";
    public static final String addClearKeyDrmToFmp4Muxing = "encoding/encodings/{encoding_id}/muxings/fmp4/{muxing_id}/drm/clearkey";
    public static final String addCencDrmToFmp4Muxing = "encoding/encodings/{encoding_id}/muxings/fmp4/{muxing_id}/drm/cenc";
    public static final String getCencDrmToFmp4Muxing = "encoding/encodings/{encoding_id}/streams/{stream_id}/muxings/fmp4/{muxing_id}/drm/cenc/{cencDrmId}";

    public static final String allDrmsFromTsMuxing = "encoding/encodings/{encoding_id}/muxings/ts/{muxing_id}/drm";
    public static final String addFairPlayDrmToTssMuxing = "encoding/encodings/{encoding_id}/muxings/ts/{muxing_id}/drm/fairplay";
    public static final String addAESEncryptionToTssMuxing = "encoding/encodings/{encoding_id}/muxings/ts/{muxing_id}/drm/aes";

    public static final String allDrmsFromMp4Muxing = "encoding/encodings/{encoding_id}/muxings/mp4/{muxing_id}/drm";
    public static final String addPlayReadyDrmToMP4Muxing = "encoding/encodings/{encoding_id}/muxings/mp4/{muxing_id}/drm/playready";
    public static final String addClearKeyDrmToMP4Muxing = "encoding/encodings/{encoding_id}/muxings/mp4/{muxing_id}/drm/clearkey";

    public static final String encodingsLimitOffset = "encoding/encodings?limit={limit}&offset={offset}";
    public static final String encodingStart = "encoding/encodings/{encoding_id}/start/";
    public static final String encodingDetailsLive = "encoding/encodings/{encoding_id}/live";
    public static final String encodingStartLive = "encoding/encodings/{encoding_id}/live/start";
    public static final String encodingStopLive = "encoding/encodings/{encoding_id}/live/stop";
    public static final String encodingStartRest = "encoding/encodings/{encoding_id}/startrest";
    public static final String encodingStop = "encoding/encodings/{encoding_id}/stop";
    public static final String encodingRestart = "encoding/encodings/{encoding_id}/restart";
    public static final String encodingStatus = "encoding/encodings/{encoding_id}/status";
    public static final String encodingDelete = "encoding/encodings/{encoding_id}";

    public static final String manifests = "encoding/manifests";
    public static final String manifestsLimitOffset = "encoding/manifests?limit={limit}&offset={offset}";

    public static final String manifestDash = "encoding/manifests/dash";
    public static final String manifestDashAddPeriod = "encoding/manifests/dash/{manifestId}/periods";
    public static final String manifestDashAddVideoAdaptionSet = "encoding/manifests/dash/{manifestId}/periods/{periodId}/adaptationsets/video";
    public static final String manifestDashAddAudioAdaptionSet = "encoding/manifests/dash/{manifestId}/periods/{periodId}/adaptationsets/audio";
    public static final String manifestDashAddSubtitleAdaptionSet = "encoding/manifests/dash/{manifestId}/periods/{periodId}/adaptationsets/subtitle";
    public static final String manifestDashAddFmp4Representation = "encoding/manifests/dash/{manifestId}/periods/{periodId}/adaptationsets/{adaptionsetId}/representations/fmp4";
    public static final String manifestDashAddVttRepresentation = "encoding/manifests/dash/{manifestId}/periods/{periodId}/adaptationsets/{adaptionsetId}/representations/vtt";
    public static final String manifestDashAddContentProtectionToAdaptationSet = "encoding/manifests/dash/{manifestId}/periods/{periodId}/adaptationsets/{adaptionsetId}/contentprotection";
    public static final String manifestDashAddContentProtectionTofMP4Representation = "encoding/manifests/dash/{manifestId}/periods/{periodId}/adaptationsets/{adaptionsetId}/representations/fmp4/{representationId}/contentprotection";
    public static final String manifestDashAddContentProtectionToDRMfMP4Representation = "encoding/manifests/dash/{manifestId}/periods/{periodId}/adaptationsets/{adaptionsetId}/representations/fmp4/drm/{representationId}/contentprotection";
    public static final String manifestDashAddWebmRepresentation = "encoding/manifests/dash/{manifestId}/periods/{periodId}/adaptationsets/{adaptionsetId}/representations/webm";
    public static final String manifestDashStart = "encoding/manifests/dash/{manifestId}/start";
    public static final String manifestDashStatus = "encoding/manifests/dash/{manifestId}/status";

    public static final String manifestHls = "encoding/manifests/hls";
    public static final String manifestHlsMediaInfo = "encoding/manifests/hls/{manifestId}/media";
    public static final String manifestHlsVideoMediaInfo = "encoding/manifests/hls/{manifestId}/media/video";
    public static final String manifestHlsAudioMediaInfo = "encoding/manifests/hls/{manifestId}/media/audio";
    public static final String manifestHlsSubtitlesMediaInfo = "encoding/manifests/hls/{manifestId}/media/subtitles";
    public static final String manifestHlsClosedCaptionsMediaInfo = "encoding/manifests/hls/{manifestId}/media/closed-captions";
    public static final String manifestHlsVttMediaInfo = "encoding/manifests/hls/{manifestId}/media/vtt";
    public static final String manifestHlsStreamInfo = "encoding/manifests/hls/{manifestId}/streams";
    public static final String manifestHlsStart = "encoding/manifests/hls/{manifestId}/start";
    public static final String manifestHlsStatus = "encoding/manifests/hls/{manifestId}/status";

    public static final String manifestSmooth = "encoding/manifests/smooth";
    public static final String manifestSmoothStart = "encoding/manifests/smooth/{manifestId}/start";
    public static final String manifestSmoothStatus = "encoding/manifests/smooth/{manifestId}/status";
    public static final String manifestSmoothRepresentation = "encoding/manifests/smooth/{manifestId}/representations/mp4";
    public static final String manifestSmoothContentProtection = "encoding/manifests/smooth/{manifestId}/contentprotection";

    public static final String notificationWebhooks = "notifications/webhooks";

    public static final String filtersLimitOffset = "encoding/filters?offset={offset}&limit={limit}";
    public static final String filters = "encoding/filters";
    public static final String filterCrop = "encoding/filters/crop";
    public static final String filterRotate = "encoding/filters/rotate";
    public static final String filterWatermark = "encoding/filters/watermark";
    public static final String filterDeinterlace = "encoding/filters/deinterlace";
    public static final String filterAudioMix = "encoding/filters/audio-mix";

    public static final String customDataSuffix = "/customData";

    public static final String thumbnails = "encoding/encodings/{encoding_id}/streams/{stream_id}/thumbnails";
    public static final String sprites = "encoding/encodings/{encoding_id}/streams/{stream_id}/sprites";

    public static final String transferEncoding = "encoding/transfers/encoding";
    public static final String transferEncodingStatus = "encoding/transfers/encoding/{transfer_id}/status";
    public static final String transferEncodingDetails = "encoding/transfers/encoding/{transfer_id}";

    public static final String transferManifest = "encoding/transfers/manifest";
    public static final String transferManifestStatus = "encoding/transfers/manifest/{transfer_id}/status";
    public static final String transferManifestDetails = "encoding/transfers/manifest/{transfer_id}";

    public static final String storageUrl = "storage";
    public static final String storageFolders = "storage/folders";
    public static final String storageFiles = "storage/files";
    public static final String storageStatistics = "storage/statistics";

    public static final String kubernetesUrl = "encoding/infrastructure/kubernetes";

}
