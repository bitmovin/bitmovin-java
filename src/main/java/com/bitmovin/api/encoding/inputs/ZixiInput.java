package com.bitmovin.api.encoding.inputs;

public class ZixiInput extends Input
{
    private String host;
    private Integer port;
    private String stream;
    private String password;
    private Integer latency;
    private Integer minBitrate;
    private String decryptionType;
    private String decryptionKey;

    public ZixiInput()
    {
        this.setType(InputType.ZIXI);
    }

    public String getHost()
    {
        return this.host;
    }

    public void setHost(String host)
    {
        this.host = host;
    }

    public Integer getPort()
    {
        return this.port;
    }

    public void setPort(Integer port)
    {
        this.port = port;
    }

    public String getStream()
    {
        return this.stream;
    }

    public void setStream(String stream)
    {
        this.stream = stream;
    }

    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public Integer getLatency()
    {
        return this.latency;
    }

    public void setLatency(Integer latency)
    {
        this.latency = latency;
    }

    public Integer getMinBitrate()
    {
        return this.minBitrate;
    }

    public void setMinBitrate(Integer minBitrate)
    {
        this.minBitrate = minBitrate;
    }

    public String getDecryptionType()
    {
        return this.decryptionType;
    }

    public void setDecryptionType(String decryptionType)
    {
        this.decryptionType = decryptionType;
    }

    public String getDecryptionKey()
    {
        return this.decryptionKey;
    }

    public void setDecryptionKey(String decryptionKey)
    {
        this.decryptionKey = decryptionKey;
    }
}
