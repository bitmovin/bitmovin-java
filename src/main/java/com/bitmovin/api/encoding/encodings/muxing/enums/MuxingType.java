package com.bitmovin.api.encoding.encodings.muxing.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 25.07.16.
 */
public enum MuxingType
{
    FMP4,
    MP4,
    TS,
    WEBM,
    MP3,
    PROGRESSIVE_WEBM,
    PROGRESSIVE_MOV,
    PROGRESSIVE_TS,
    BROADCAST_TS
}