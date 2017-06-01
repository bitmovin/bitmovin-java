package com.bitmovin.api.rest.enums;

import java.util.HashMap;

/**
 * Created by
 * David Moser [david.moser@bitmovin.com]
 * on 7/12/16
 **/
public enum ResponseErrorCode
{
    GENERAL_MISSING_ATTRIBUTE_OR_FIELD(1000),
    GENERAL_PARAMETER_NOT_VALID(1001),
    GENERAL_INVALID_CREDENTIALS(1002),
    GENERAL_UNAUTHORIZED(1003),
    GENERAL_UNDEFINED_ERROR(1004),
    GENERAL_REQUEST_URL_NOT_VALID(1005),

    ENCODING_GENERAL_ENCODING_RESOURCE_ERROR(2000),
    ENCODING_GENERAL_INPUT_NOT_VALID(2001),
    ENCODING_GENERAL_OUTPUT_NOT_VALID(2002),
    ENCODING_GENERAL_MUXING_ERROR(2003),
    ENCODING_GENERAL_ENCRYPTION_ERROR(2004),
    ENCODING_GENERAL_FILTER_ERROR(2005),
    ENCODING_GENERAL_CAPTIONS_ERROR(2006),
    ENCODING_GENERAL_SUBTITLE_ERROR(2007),
    ENCODING_GENERAL_CODEC_CONFIGURATION_ERROR(2008),
    ENCODING_GENERAL_THUMBNAIL_ERROR(2009),
    ENCODING_GENERAL_SPRITE_ERROR(2010),
    ENCODING_GENERAL_LIVE_ERROR(2011),
    ENCODING_GENERAL_DEMUXING_ERROR(2014),
    ENCODING_GENERAL_DECODING_ERROR(2015),
    ENCODING_GENERAL_ENCODING_ERROR(2016),
    ENCODING_GENERAL_UPLOAD_ERROR(2017),
    ENCODING_GENERAL_INTERNAL_ERROR(2018),
    ENCODING_GENERAL_INFRASTRUCTURE_ERROR(2019),
    ENCODING_GENERAL_INVALID_ENCODER_VERSION(2020),
    ENCODING_GENERAL_DELETE_NOT_ALLOWED(2021),
    ENCODING_GENERAL_COULD_NOT_STOP_LIVE_ENCODING(2022),
    ENCODING_GENERAL_LIVE_ENCODING_NOT_READY(2023),
    ENCODING_GENERAL_STREAM_INPUT_DETAILS_NOT_AVAILABLE(2024),
    ENCODING_GENERAL_ENCODING_CONFIGURATION_NOT_VALID(2025),
    ENCODING_GENERAL_ON_PREMISE_NOT_ALLOWED(2026),

    ENCODING_INPUT_INPUT_FILE_NOT_FOUND(2100),
    ENCODING_INPUT_BUCKET_NOT_FOUND(2101),
    ENCODING_INPUT_INVALID_FILE_PATH(2102),
    ENCODING_INPUT_DOWNLOAD_ACCESS_DENIED(2103),
    ENCODING_INPUT_DOWNLOAD_TIMEOUT(2104),
    ENCODING_INPUT_DOWNLOAD_FAILURE(2105),
    ENCODING_INPUT_REMOTE_SERVER_PROBLEM(2106),
    ENCODING_INPUT_INPUT_FILE_IS_NOT_A_VALID_MEDIA_FILE(2107),

    ENCODING_OUTPUT_BUCKET_NOT_FOUND(2200),
    ENCODING_OUTPUT_INVALID_FILE_PATH(2201),
    ENCODING_OUTPUT_UPLOAD_ACCESS_DENIED(2202),
    ENCODING_OUTPUT_UPLOAD_TIMEOUT(2203),
    ENCODING_OUTPUT_UPLOAD_FAILURE(2204),
    ENCODING_OUTPUT_REMOTE_SERVER_PROBLEM(2205),

    ENCODING_CODEC_CONFIGURATION_H264_CONFIGURATION_ERROR(2300),
    ENCODING_CODEC_CONFIGURATION_H265_CONFIGURATION_ERROR(2301),
    ENCODING_CODEC_CONFIGURATION_AAC_CONFIGURATION_ERROR(2302),

    ENCODING_FILTER_WATERMARK_CONFIGURATION_NOT_VALID(2400),
    ENCODING_FILTER_WATERMARK_ENCODING_ERROR(2401),
    ENCODING_FILTER_CROP_CONFIGURATION_NOT_VALID(2402),
    ENCODING_FILTER_CROP_ENCODING_ERROR(2403),
    ENCODING_FILTER_ROTATE_CONFIGURATION_NOT_VALID(2404),
    ENCODING_FILTER_ROTATE_ENCODING_ERROR(2405),

    ENCODING_MANIFEST_DASH_MANIFEST_CONFIGURATION_NOT_VALID(2500),
    ENCODING_MANIFEST_HLS_MANIFEST_CONFIGURATION_NOT_VALID(2501),

    ENCODING_TRANSFER_CONFIGURATION_NOT_VALID(2600),

    STORAGE_GENERAL_ERROR(3000),
    STORAGE_NOT_ACCESSABLE(3001),

    PLAYER_GENERAL_ERROR(4000),
    PLAYER_DOMAIN_NOT_VALID(4001),

    ANALYTICS_GENERAL_ERROR(5000),
    ANALYTICS_INFRASTRUCTURE_ERROR(5001),

    ACCOUNT_GENERAL_ERROR(6000),
    ACCOUNT_UNKNOWN_ORGANIZATION(6001),
    ACCOUNT_UNKNOWN_TENANT(6002),

    ACCOUNT_INTERNAL_COULD_NOT_CREATE_USER_ON_GATEWAY(6100),
    ACCOUNT_INTERNAL_COULD_NOT_CREATE_APIKEY_ON_GATEWAY(6101),
    ACCOUNT_INTERNAL_COULD_NOT_DELETE_USER_ON_GATEWAY(6102),
    ACCOUNT_INTERNAL_COULD_NOT_DELETE_API_KEY_ON_GATEWAY(6103),
    ACCOUNT_INTERNAL_API_GATEWAY_COMMUNICATION_FAILURE(6104),

    NOTIFCATION_GENERAL_ERROR(7000);

    private final Integer code;
    private static HashMap<Integer, ResponseErrorCode> errorCodeMap;
    private static HashMap<Integer, String> errorMessageMap;


    ResponseErrorCode(Integer code)
    {
        this.code = code;
    }

    public static ResponseErrorCode forValue(Integer value)
    {
        return errorCodeMap.get(value);
    }

    public Integer getCode()
    {
        return this.code;
    }

    public String getMessage() { return errorMessageMap.get(this.code); }

    static
    {
        setUpErrorCodeMap();
        setUpErrorMessageMap();
    }

    private static void setUpErrorCodeMap()
    {
        errorCodeMap = new HashMap<>();

        errorCodeMap.put(1000, GENERAL_MISSING_ATTRIBUTE_OR_FIELD);
        errorCodeMap.put(1001, GENERAL_PARAMETER_NOT_VALID);
        errorCodeMap.put(1002, GENERAL_INVALID_CREDENTIALS);
        errorCodeMap.put(1003, GENERAL_UNAUTHORIZED);
        errorCodeMap.put(1004, GENERAL_UNDEFINED_ERROR);
        errorCodeMap.put(1005, GENERAL_REQUEST_URL_NOT_VALID);

        errorCodeMap.put(2000, ENCODING_GENERAL_ENCODING_RESOURCE_ERROR);
        errorCodeMap.put(2001, ENCODING_GENERAL_INPUT_NOT_VALID);
        errorCodeMap.put(2002, ENCODING_GENERAL_OUTPUT_NOT_VALID);
        errorCodeMap.put(2003, ENCODING_GENERAL_MUXING_ERROR);
        errorCodeMap.put(2004, ENCODING_GENERAL_ENCRYPTION_ERROR);
        errorCodeMap.put(2005, ENCODING_GENERAL_FILTER_ERROR);
        errorCodeMap.put(2006, ENCODING_GENERAL_CAPTIONS_ERROR);
        errorCodeMap.put(2007, ENCODING_GENERAL_SUBTITLE_ERROR);
        errorCodeMap.put(2008, ENCODING_GENERAL_CODEC_CONFIGURATION_ERROR);
        errorCodeMap.put(2009, ENCODING_GENERAL_THUMBNAIL_ERROR);
        errorCodeMap.put(2010, ENCODING_GENERAL_SPRITE_ERROR);
        errorCodeMap.put(2011, ENCODING_GENERAL_LIVE_ERROR);
        errorCodeMap.put(2014, ENCODING_GENERAL_DEMUXING_ERROR);
        errorCodeMap.put(2015, ENCODING_GENERAL_DECODING_ERROR);
        errorCodeMap.put(2016, ENCODING_GENERAL_ENCODING_ERROR);
        errorCodeMap.put(2017, ENCODING_GENERAL_UPLOAD_ERROR);
        errorCodeMap.put(2018, ENCODING_GENERAL_INTERNAL_ERROR);
        errorCodeMap.put(2019, ENCODING_GENERAL_INFRASTRUCTURE_ERROR);
        errorCodeMap.put(2020, ENCODING_GENERAL_INVALID_ENCODER_VERSION);
        errorCodeMap.put(2021, ENCODING_GENERAL_DELETE_NOT_ALLOWED);

        errorCodeMap.put(2100, ENCODING_INPUT_INPUT_FILE_NOT_FOUND);
        errorCodeMap.put(2101, ENCODING_INPUT_BUCKET_NOT_FOUND);
        errorCodeMap.put(2102, ENCODING_INPUT_INVALID_FILE_PATH);
        errorCodeMap.put(2103, ENCODING_INPUT_DOWNLOAD_ACCESS_DENIED);
        errorCodeMap.put(2104, ENCODING_INPUT_DOWNLOAD_TIMEOUT);
        errorCodeMap.put(2105, ENCODING_INPUT_DOWNLOAD_FAILURE);
        errorCodeMap.put(2106, ENCODING_INPUT_REMOTE_SERVER_PROBLEM);
        errorCodeMap.put(2107, ENCODING_INPUT_INPUT_FILE_IS_NOT_A_VALID_MEDIA_FILE);

        errorCodeMap.put(2200, ENCODING_OUTPUT_BUCKET_NOT_FOUND);
        errorCodeMap.put(2201, ENCODING_OUTPUT_INVALID_FILE_PATH);
        errorCodeMap.put(2202, ENCODING_OUTPUT_UPLOAD_ACCESS_DENIED);
        errorCodeMap.put(2203, ENCODING_OUTPUT_UPLOAD_TIMEOUT);
        errorCodeMap.put(2204, ENCODING_OUTPUT_UPLOAD_FAILURE);
        errorCodeMap.put(2205, ENCODING_OUTPUT_REMOTE_SERVER_PROBLEM);

        errorCodeMap.put(2300, ENCODING_CODEC_CONFIGURATION_H264_CONFIGURATION_ERROR);
        errorCodeMap.put(2301, ENCODING_CODEC_CONFIGURATION_H265_CONFIGURATION_ERROR);
        errorCodeMap.put(2302, ENCODING_CODEC_CONFIGURATION_AAC_CONFIGURATION_ERROR);

        errorCodeMap.put(2400, ENCODING_FILTER_WATERMARK_CONFIGURATION_NOT_VALID);
        errorCodeMap.put(2401, ENCODING_FILTER_WATERMARK_ENCODING_ERROR);
        errorCodeMap.put(2402, ENCODING_FILTER_CROP_CONFIGURATION_NOT_VALID);
        errorCodeMap.put(2403, ENCODING_FILTER_CROP_ENCODING_ERROR);
        errorCodeMap.put(2404, ENCODING_FILTER_ROTATE_CONFIGURATION_NOT_VALID);
        errorCodeMap.put(2405, ENCODING_FILTER_ROTATE_ENCODING_ERROR);

        errorCodeMap.put(2500, ENCODING_MANIFEST_DASH_MANIFEST_CONFIGURATION_NOT_VALID);
        errorCodeMap.put(2501, ENCODING_MANIFEST_HLS_MANIFEST_CONFIGURATION_NOT_VALID);

        errorCodeMap.put(2600, ENCODING_TRANSFER_CONFIGURATION_NOT_VALID);

        errorCodeMap.put(3000, STORAGE_GENERAL_ERROR);
        errorCodeMap.put(3001, STORAGE_NOT_ACCESSABLE);

        errorCodeMap.put(4000, PLAYER_GENERAL_ERROR);
        errorCodeMap.put(4001, PLAYER_DOMAIN_NOT_VALID);

        errorCodeMap.put(5000, ANALYTICS_GENERAL_ERROR);
        errorCodeMap.put(5001, ANALYTICS_INFRASTRUCTURE_ERROR);

        errorCodeMap.put(6000, ACCOUNT_GENERAL_ERROR);
        errorCodeMap.put(6001, ACCOUNT_UNKNOWN_ORGANIZATION);
        errorCodeMap.put(6002, ACCOUNT_UNKNOWN_TENANT);

        errorCodeMap.put(6100, ACCOUNT_INTERNAL_COULD_NOT_CREATE_USER_ON_GATEWAY);
        errorCodeMap.put(6101, ACCOUNT_INTERNAL_COULD_NOT_CREATE_APIKEY_ON_GATEWAY);
        errorCodeMap.put(6102, ACCOUNT_INTERNAL_COULD_NOT_DELETE_USER_ON_GATEWAY);
        errorCodeMap.put(6103, ACCOUNT_INTERNAL_COULD_NOT_DELETE_API_KEY_ON_GATEWAY);
        errorCodeMap.put(6104, ACCOUNT_INTERNAL_API_GATEWAY_COMMUNICATION_FAILURE);

        errorCodeMap.put(7000, NOTIFCATION_GENERAL_ERROR);
    }

    private static void setUpErrorMessageMap()
    {
        errorMessageMap = new HashMap<>();

        errorMessageMap.put(1000, "General error: Required attribute/field not valid or not present");
        errorMessageMap.put(1001, "General error: One or more parameters are not valid");
        errorMessageMap.put(1002, "General error: API key is not valid");
        errorMessageMap.put(1003, "General error: Unauthorized");
        errorMessageMap.put(1004, "General error: Undefined error occurred");
        errorMessageMap.put(1005, "General error: Request URL is not valid");

        errorMessageMap.put(2000, "Encoding error: General encoding resource error");
        errorMessageMap.put(2001, "Encoding error: Input not valid");
        errorMessageMap.put(2002, "Encoding error: Output not valid");
        errorMessageMap.put(2003, "Encoding error: Error during muxing");
        errorMessageMap.put(2004, "Encoding error: Error during encryption");
        errorMessageMap.put(2005, "Encoding error: Error while applying filter");
        errorMessageMap.put(2006, "Encoding error: Error with specified captions");
        errorMessageMap.put(2007, "Encoding error: Error with specified subtitles");
        errorMessageMap.put(2008, "Encoding error: Error with specified codec configuration");
        errorMessageMap.put(2009, "Encoding error: Error while generating thumbnails");
        errorMessageMap.put(2010, "Encoding error: Error while generating sprites");
        errorMessageMap.put(2011, "Encoding error: Error during live streaming");
        errorMessageMap.put(2014, "Encoding error: Error while demuxing file");
        errorMessageMap.put(2015, "Encoding error: Error while decoding file");
        errorMessageMap.put(2016, "Encoding error: Error during encoding");
        errorMessageMap.put(2017, "Encoding error: Error while uploading files");
        errorMessageMap.put(2018, "Encoding error: Internal encoding error");
        errorMessageMap.put(2019, "Encoding error: Error on the encoding infrastructure");
        errorMessageMap.put(2020, "Encoding error: The given encoder version is not available");
        errorMessageMap.put(2021, "Encoding error: Deletion of encoding not allowed when status equals RUNNING or QUEUED");

        errorMessageMap.put(2100, "Encoding input error: Could not find input file");
        errorMessageMap.put(2101, "Encoding input error: Could not find input bucket");
        errorMessageMap.put(2102, "Encoding input error: File path not valid");
        errorMessageMap.put(2103, "Encoding input error: File was not accessable");
        errorMessageMap.put(2104, "Encoding input error: File download timed out");
        errorMessageMap.put(2105, "Encoding input error: File download failed");
        errorMessageMap.put(2106, "Encoding input error: Remote server was not reachable");
        errorMessageMap.put(2107, "Encoding input error: Encoder was not able to parse input file");

        errorMessageMap.put(2200, "Encoding output error: Could not find output bucket");
        errorMessageMap.put(2201, "Encoding output error: File path not valid");
        errorMessageMap.put(2202, "Encoding output error: Access denied during upload");
        errorMessageMap.put(2203, "Encoding output error: File upload timed out");
        errorMessageMap.put(2204, "Encoding output error: File upload failed");
        errorMessageMap.put(2205, "Encoding output error: Remote server was not reachable");

        errorMessageMap.put(2300, "Encoding codec error: H264 configuration is not valid");
        errorMessageMap.put(2301, "Encoding codec error: H265 configuration is not valid");
        errorMessageMap.put(2302, "Encoding codec error: AAC configuration is not valid");

        errorMessageMap.put(2400, "Encoding filter error: Watermark configuration not valid");
        errorMessageMap.put(2401, "Encoding filter error: Error while applying watermark");
        errorMessageMap.put(2402, "Encoding filter error: Crop configuration not valid");
        errorMessageMap.put(2403, "Encoding filter error: Error while cropping");
        errorMessageMap.put(2404, "Encoding filter error: Rotate configuration not valid");
        errorMessageMap.put(2405, "Encoding filter error: Error while rotating frame");

        errorMessageMap.put(2500, "Encoding manifest error: DASH manifest configuration not valid");
        errorMessageMap.put(2501, "Encoding manifest error: HLS manifest configuration not valid");

        errorMessageMap.put(2600, "Encoding transfer error: Transfer configuration not valid");

        errorMessageMap.put(3000, "Storage error: General storage error");
        errorMessageMap.put(3001, "Storage error: Storage is currently not accessable");

        errorMessageMap.put(4000, "Player error: General player error");
        errorMessageMap.put(4001, "Player error: Domain was not valid");

        errorMessageMap.put(5000, "Analytics error: General analytics error");
        errorMessageMap.put(5001, "Analytics error: Analytics infrastructure error");

        errorMessageMap.put(6000, "Account error: General account error");
        errorMessageMap.put(6001, "Account error: Organization not found");
        errorMessageMap.put(6002, "Account error: Tenant not found");

        errorMessageMap.put(6100, "Internal account error: Could not create user on gateway");
        errorMessageMap.put(6101, "Internal account error: Could not create API key on gateway");
        errorMessageMap.put(6102, "Internal account error: Could not delete user on gateway");
        errorMessageMap.put(6103, "Internal account error: Could not delete API key on gateway");
        errorMessageMap.put(6104, "Internal account error: API gateway communication failure");

        errorMessageMap.put(7000, "Notifcation error: General notification error");
    }
}