package com.bitmovin.api.helper;

import com.bitmovin.api.encoding.codecConfigurations.H265VideoConfiguration;
import com.bitmovin.api.encoding.codecConfigurations.enums.BAdapt;
import com.bitmovin.api.encoding.codecConfigurations.enums.MaxCTUSize;
import com.bitmovin.api.encoding.codecConfigurations.enums.MotionSearch;
import com.bitmovin.api.encoding.codecConfigurations.enums.ProfileH265;
import com.bitmovin.api.encoding.codecConfigurations.enums.TuInterDepth;
import com.bitmovin.api.encoding.codecConfigurations.enums.TuIntraDepth;

public class H265CodecConfigHelper
{

    public static H265VideoConfiguration getConfig(String name, String description, ProfileH265 profile, VideoCodecPresets preset, long bitRate)
    {
        return getConfig(name, description, profile, preset, bitRate, null);
    }

    public static H265VideoConfiguration getConfig(String name, String description, ProfileH265 profile, VideoCodecPresets preset, long bitRate, Float frameRate)
    {
        return getConfig(name, description, profile, preset, null, null, bitRate, frameRate);
    }

    public static H265VideoConfiguration getConfig(String name, String description, ProfileH265 profile, VideoCodecPresets preset,
                                                   Integer width, Integer height, long bitRate, Float frameRate)
    {
        H265VideoConfiguration config = new H265VideoConfiguration();
        config.setName(name);
        config.setDescription(description);
        config.setProfile(profile);
        config.setBitrate(bitRate);

        if (width != null)
            config.setWidth(width);
        if (height != null)
            config.setHeight(height);
        if (frameRate != null)
            config.setRate(frameRate);

        config.setMaxCTUSize(MaxCTUSize.S64);
        config.setBframes(4);
        config.setMotionSearchRange(57);
        config.setTuInterDepth(TuInterDepth.D1);
        config.setTuIntraDepth(TuIntraDepth.D1);
        config.setSao(true);
        config.setWeightPredictionOnPSlice(true);
        config.setWeightPredictionOnBSlice(false);

        if      (preset == VideoCodecPresets.FAST)
            setFastPresetSettings(config);
        else if (preset == VideoCodecPresets.MEDIUM)
            setMediumPresetSettings(config);
        else if (preset == VideoCodecPresets.SLOW)
            setSlowPresetSettings(config);
        else if (preset == VideoCodecPresets.VERYSLOW)
            setVerySlowPresetSettings(config);

        return config;
    }

    private static void setVerySlowPresetSettings(H265VideoConfiguration config)
    {
        config.setbAdapt(BAdapt.FULL);
        config.setRcLookahead(40);
        config.setRefFrames(5);
        config.setMotionSearch(MotionSearch.STAR);
        config.setSubMe(4);
        config.setTuInterDepth(TuInterDepth.D3);
        config.setTuIntraDepth(TuIntraDepth.D3);
    }

    private static void setSlowPresetSettings(H265VideoConfiguration config)
    {
        config.setbAdapt(BAdapt.FULL);
        config.setRcLookahead(25);
        config.setRefFrames(4);
        config.setMotionSearch(MotionSearch.STAR);
        config.setSubMe(3);
    }

    private static void setMediumPresetSettings(H265VideoConfiguration config)
    {
        config.setbAdapt(BAdapt.FULL);
        config.setRcLookahead(20);
        config.setRefFrames(3);
        config.setMotionSearch(MotionSearch.HEX);
        config.setSubMe(2);

    }

    private static void setFastPresetSettings(H265VideoConfiguration config)
    {
        config.setbAdapt(BAdapt.NONE);
        config.setRcLookahead(15);
        config.setRefFrames(3);
        config.setMotionSearch(MotionSearch.HEX);
        config.setSubMe(2);
    }
}
