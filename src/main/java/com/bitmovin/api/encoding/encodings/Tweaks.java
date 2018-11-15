package com.bitmovin.api.encoding.encodings;

import com.bitmovin.api.encoding.enums.AudioVideoSyncMode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by jyeh on 11/14/18.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tweaks {
    private AudioVideoSyncMode audioVideoSyncMode;

    public AudioVideoSyncMode getAudioVideoSyncMode()
    {
        return this.audioVideoSyncMode;
    }

    public void setAudioVideoSyncMode(AudioVideoSyncMode audioVideoSyncMode)
    {
        this.audioVideoSyncMode = audioVideoSyncMode;
    }
}
