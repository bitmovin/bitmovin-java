package com.bitmovin.api.encoding.outputs;

import java.util.HashMap;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 18.08.16.
 */
public enum OutputType
{
    S3("S3"),
    GCS("GCS"),
    AZURE("AZURE"),
    FTP("FTP"),
    SFTP("SFTP"),
    BITMOVIN_S3("BITMOVIN_S3"),
    BITMOVIN_GCS("BITMOVIN_GCS"),
    LOCAL("LOCAL"),
    GENERIC_S3("GENERIC_S3");

    private final String name;
    private static HashMap<String, OutputType> map;

    OutputType(String s)
    {
        this.name = s;
    }

    public static OutputType forValue(String value)
    {
        return map.get(value);
    }

    public String toString()
    {
        return this.name;
    }

    static
    {
        map = new HashMap<String, OutputType>(7);
        map.put("S3", S3);
        map.put("GCS", GCS);
        map.put("AZURE", AZURE);
        map.put("FTP", FTP);
        map.put("SFTP", SFTP);
        map.put("BITMOVIN_S3", BITMOVIN_S3);
        map.put("BITMOVIN_GCS", BITMOVIN_GCS);
        map.put("LOCAL", LOCAL);
        map.put("GENERIC_S3", GENERIC_S3);
    }

}
