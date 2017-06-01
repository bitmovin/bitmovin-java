package com.bitmovin.api.encoding.manifest.dash;

/**
 * Created by arudich on 19.12.16.
 **/
public enum Role
{
    ALTERNATE,
    CAPTION,
    COMMENTARY,
    DUB,
    MAIN,
    SUBTITLE,
    SUPPLEMENTARY;

    @Override
    public String toString()
    {
        return super.toString().toLowerCase();
    }
}
