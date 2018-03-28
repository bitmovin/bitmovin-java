package com.bitmovin.api.encoding.inputs;

import java.util.HashMap;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 25.07.16.
 */
public enum InputType
{
    ASPERA("ASPERA"),
    AZURE("AZURE"),
    FTP("FTP"),
    SFTP("SFTP"),
    GCS("GCS"),
    HTTP("HTTP"),
    HTTPS("HTTPS"),
    RTMP("RTMP"),
    S3("S3"),
    GENERIC_S3("GENERIC_S3"),
    LOCAL("LOCAL"),
    AKAMAI_NETSTORAGE("AKAMAI_NETSTORAGE"),
    ZIXI("ZIXI");

    private final String name;
    private static HashMap<String, InputType> map;

    InputType(String s)
    {
        this.name = s;
    }

    public static InputType forValue(String value)
    {
        return map.get(value);
    }

    public String toString()
    {
        return this.name;
    }

    static
    {
        map = new HashMap<>();
        map.put("ASPERA", ASPERA);
        map.put("AZURE", AZURE);
        map.put("FTP", FTP);
        map.put("SFTP", SFTP);
        map.put("GCS", GCS);
        map.put("HTTP", HTTP);
        map.put("HTTPS", HTTPS);
        map.put("RTMP", RTMP);
        map.put("S3", S3);
        map.put("GENERIC_S3", GENERIC_S3);
        map.put("LOCAL", LOCAL);
        map.put("AKAMAI_NETSTORAGE", AKAMAI_NETSTORAGE);
        map.put("ZIXI", ZIXI);
    }
}
