package com.bitmovin.api.encoding.manifest.hls;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;

/**
 * Created by doweinberger on 8/12/16.
 **/
public enum MediaInfoType
{
    AUDIO("AUDIO"),
    VIDEO("VIDEO"),
    SUBTITLES("SUBTITLES"),
    CLOSED_CAPTIONS("CLOSED_CAPTIONS"),
    VTT("VTT");

    private final String name;
    private static HashMap<String, MediaInfoType> map;

    MediaInfoType(String s)
    {
        this.name = s;
    }

    @JsonCreator
    public static MediaInfoType forValue(String value)
    {
        return map.get(value);
    }

    @JsonValue
    public String toString()
    {
        return this.name;
    }

    static {
        map = new HashMap<>(5);
        map.put("AUDIO", AUDIO);
        map.put("VIDEO", VIDEO);
        map.put("SUBTITLES", SUBTITLES);
        map.put("CLOSED_CAPTIONS", CLOSED_CAPTIONS);
        map.put("VTT", VTT);
    }
}
