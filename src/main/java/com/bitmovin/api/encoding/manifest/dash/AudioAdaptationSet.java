package com.bitmovin.api.encoding.manifest.dash;

/**
 * Created by doweinberger on 8/10/16.
 */
public class AudioAdaptationSet extends AdaptationSet
{
    private String lang;

    public String getLang()
    {
        return this.lang;
    }

    public void setLang(String lang)
    {
        this.lang = lang;
    }
}
