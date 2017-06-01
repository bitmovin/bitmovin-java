package com.bitmovin.api.encoding.manifest.dash;

/**
 * Created by arudich on 09.01.17.
 **/
public class SubtitleAdaptationSet extends AdaptationSet
{
    private String lang;

    public String getLang() { return this.lang; }

    public void setLang(String lang) { this.lang = lang; }
}
