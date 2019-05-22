package com.bitmovin.api.helper;

import com.bitmovin.api.encoding.codecConfigurations.H264VideoConfiguration;
import com.bitmovin.api.encoding.codecConfigurations.enums.BAdapt;
import com.bitmovin.api.encoding.codecConfigurations.enums.H264MotionEstimationMethod;
import com.bitmovin.api.encoding.codecConfigurations.enums.H264Partition;
import com.bitmovin.api.encoding.codecConfigurations.enums.H264SubMe;
import com.bitmovin.api.encoding.codecConfigurations.enums.H264Trellis;
import com.bitmovin.api.encoding.codecConfigurations.enums.MVPredictionMode;
import com.bitmovin.api.encoding.codecConfigurations.enums.ProfileH264;

import java.util.ArrayList;

public class H264CodecConfigHelper
{
    public static H264VideoConfiguration getConfig(String name, String description, ProfileH264 profile, VideoCodecPresets preset, long bitRate)
    {
        return getConfig(name, description, profile, preset, bitRate, null);
    }

    public static H264VideoConfiguration getConfig(String name, String description, ProfileH264 profile, VideoCodecPresets preset, long bitRate, Float frameRate)
    {
        return getConfig(name, description, profile, preset, null, null, bitRate, frameRate);
    }

    public static H264VideoConfiguration getConfig(String name, String description, ProfileH264 profile, VideoCodecPresets preset,
                                                   Integer width, Integer height, long bitRate, Float frameRate)
    {
        H264VideoConfiguration config = new H264VideoConfiguration();
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

        config.setBframes(3);
        config.setCabac(true);
        config.setMvSearchRangeMax(16);

        if (preset == VideoCodecPresets.ULTRAFAST)
            setUltraFastPresetSettings(config);
        else if (preset == VideoCodecPresets.VERYFAST)
            setVeryFastPresetSettings(config);
        else if (preset == VideoCodecPresets.FAST)
            setFastPresetSettings(config);
        else if (preset == VideoCodecPresets.MEDIUM)
            setMediumPresetSettings(config);
        else if (preset == VideoCodecPresets.SLOW)
            setSlowPresetSettings(config);
        else if (preset == VideoCodecPresets.VERYSLOW)
            setVerySlowPresetSettings(config);

        return config;
    }

    private static void setUltraFastPresetSettings(H264VideoConfiguration config)
    {
        config.setbAdaptiveStrategy(BAdapt.NONE);
        config.setBframes(0);
        config.setMvSearchRangeMax(16);
        config.setMvPredictionMode(MVPredictionMode.SPATIAL);
        config.setMotionEstimationMethod(H264MotionEstimationMethod.DIA);
        config.setCabac(false);
        config.setRcLookahead(0);
        config.setRefFrames(1);
        config.setSubMe(H264SubMe.FULLPEL);
        config.setTrellis(H264Trellis.DISABLED);
        config.setPartitions(new ArrayList<H264Partition>()
        {{
            add(H264Partition.NONE);
        }});
    }

    private static void setVeryFastPresetSettings(H264VideoConfiguration config)
    {
        config.setbAdaptiveStrategy(BAdapt.FAST);
        config.setBframes(3);
        config.setMvSearchRangeMax(16);
        config.setMvPredictionMode(MVPredictionMode.SPATIAL);
        config.setMotionEstimationMethod(H264MotionEstimationMethod.HEX);
        config.setCabac(true);
        config.setRcLookahead(10);
        config.setRefFrames(1);
        config.setSubMe(H264SubMe.SATD);
        config.setTrellis(H264Trellis.ENABLED_FINAL_MB);
        config.setPartitions(new ArrayList<H264Partition>()
        {{
            add(H264Partition.I4X4);
            add(H264Partition.I8X8);
            add(H264Partition.P8X8);
            add(H264Partition.B8X8);
        }});
    }

    private static void setFastPresetSettings(H264VideoConfiguration config)
    {
        config.setbAdaptiveStrategy(BAdapt.FAST);
        config.setBframes(3);
        config.setMvSearchRangeMax(16);
        config.setMvPredictionMode(MVPredictionMode.SPATIAL);
        config.setMotionEstimationMethod(H264MotionEstimationMethod.HEX);
        config.setCabac(true);
        config.setRcLookahead(20);
        config.setRefFrames(2);
        config.setSubMe(H264SubMe.QPEL4);
        config.setTrellis(H264Trellis.ENABLED_FINAL_MB);
        config.setPartitions(new ArrayList<H264Partition>()
        {{
            add(H264Partition.I4X4);
            add(H264Partition.I8X8);
            add(H264Partition.P8X8);
            add(H264Partition.B8X8);
        }});
    }

    private static void setMediumPresetSettings(H264VideoConfiguration config)
    {
        config.setbAdaptiveStrategy(BAdapt.FAST);
        config.setBframes(3);
        config.setMvSearchRangeMax(16);
        config.setMvPredictionMode(MVPredictionMode.SPATIAL);
        config.setMotionEstimationMethod(H264MotionEstimationMethod.HEX);
        config.setCabac(true);
        config.setRcLookahead(40);
        config.setRefFrames(3);
        config.setSubMe(H264SubMe.RD_ALL);
        config.setTrellis(H264Trellis.ENABLED_ALL);
        config.setPartitions(new ArrayList<H264Partition>()
        {{
            add(H264Partition.I4X4);
            add(H264Partition.I8X8);
            add(H264Partition.P8X8);
            add(H264Partition.B8X8);
        }});
    }

    private static void setSlowPresetSettings(H264VideoConfiguration config)
    {
        config.setbAdaptiveStrategy(BAdapt.FULL);
        config.setBframes(3);
        config.setMvSearchRangeMax(16);
        config.setMvPredictionMode(MVPredictionMode.AUTO);
        config.setMotionEstimationMethod(H264MotionEstimationMethod.UMH);
        config.setCabac(true);
        config.setRcLookahead(50);
        config.setRefFrames(5);
        config.setSubMe(H264SubMe.RD_REF_IP);
        config.setTrellis(H264Trellis.ENABLED_ALL);
        config.setPartitions(new ArrayList<H264Partition>()
        {{
            add(H264Partition.ALL);
        }});
    }

    private static void setVerySlowPresetSettings(H264VideoConfiguration config)
    {
        config.setbAdaptiveStrategy(BAdapt.FULL);
        config.setBframes(8);
        config.setMvSearchRangeMax(24);
        config.setMvPredictionMode(MVPredictionMode.AUTO);
        config.setMotionEstimationMethod(H264MotionEstimationMethod.UMH);
        config.setCabac(true);
        config.setRcLookahead(60);
        config.setRefFrames(16);
        config.setSubMe(H264SubMe.RD_REF_ALL);
        config.setTrellis(H264Trellis.ENABLED_ALL);
        config.setPartitions(new ArrayList<H264Partition>()
        {{
            add(H264Partition.ALL);
        }});
    }

}
