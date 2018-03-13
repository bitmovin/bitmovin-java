package com.bitmovin.api.encoding.filters.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;

public enum AudioMixChannelLayout
{
    NONE("NONE"),
    CL_MONO("MONO"),
    CL_STEREO("STEREO"),
    CL_SURROUND("SURROUND"),
    CL_QUAD("QUAD"),
    CL_OCTAGONAL("OCTAGONAL"),
    CL_HEXAGONAL("HEXAGONAL"),
    CL_STEREO_DOWNMIX("STEREO_DOWNMIX"),
    CL_2_1("2.1"),
    CL_2_2("2.2"),
    CL_3_1("3.1"),
    CL_4_0("4.0"),
    CL_4_1("4.1"),
    CL_5_0("5.0"),
    CL_5_1("5.1"),
    CL_5_0_BACK("5.0_BACK"),
    CL_5_1_BACK("5.1_BACK"),
    CL_6_0("6.0_BACK"),
    CL_6_0_FRONT("6.0_FRONT"),
    CL_6_1("6.1"),
    CL_6_1_BACK("6.1_BACK"),
    CL_6_1_FRONT("6.1_FRONT"),
    CL_7_0("7.0"),
    CL_7_0_FRONT("7.0_FRONT"),
    CL_7_1("7.1"),
    CL_7_1_WIDE("7.1_WIDE"),
    CL_7_1_WIDE_BACK("7.1_WIDE_BACK");

    private final String name;
    private static HashMap<String, AudioMixChannelLayout> map;

    AudioMixChannelLayout(String s)
    {
        this.name = s;
    }

    @JsonCreator
    public static AudioMixChannelLayout forValue(String value)
    {
        return map.get(value);
    }

    @JsonValue
    public String toString()
    {
        return this.name;
    }

    static
    {
        map = new HashMap<>(27);
        map.put("NONE", NONE);
        map.put("MONO", CL_MONO);
        map.put("STEREO", CL_STEREO);
        map.put("SURROUND", CL_SURROUND);
        map.put("QUAD", CL_QUAD);
        map.put("OCTAGONAL", CL_OCTAGONAL);
        map.put("HEXAGONAL", CL_HEXAGONAL);
        map.put("STEREO_DOWNMIX", CL_STEREO_DOWNMIX);
        map.put("2.1", CL_2_1);
        map.put("2.2", CL_2_2);
        map.put("3.1", CL_3_1);
        map.put("4.0", CL_4_0);
        map.put("4.1", CL_4_1);
        map.put("5.0", CL_5_0);
        map.put("5.1", CL_5_1);
        map.put("5.0_BACK", CL_5_0_BACK);
        map.put("5.1_BACK", CL_5_1_BACK);
        map.put("6.0", CL_6_0);
        map.put("6.0_FRONT", CL_6_0_FRONT);
        map.put("6.1", CL_6_1);
        map.put("6.1_BACK", CL_6_1_BACK);
        map.put("6.1_FRONT", CL_6_1_FRONT);
        map.put("7.0", CL_7_0);
        map.put("7.0_FRONT", CL_7_0_FRONT);
        map.put("7.1", CL_7_1);
        map.put("7.1_WIDE", CL_7_1_WIDE);
        map.put("7.1_WIDE_BACK", CL_7_1_WIDE_BACK);
    }
}
