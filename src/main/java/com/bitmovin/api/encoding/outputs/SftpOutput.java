package com.bitmovin.api.encoding.outputs;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 25.07.16.
 */
public class SftpOutput extends Output
{
    private String host;

    private Integer port;

    private String username;

    private String password;

    private boolean passive;

    public SftpOutput()
    {
        super();
        this.setType(OutputType.SFTP);
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

    public String getUsername()
    {
        return this.username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public boolean isPassive()
    {
        return this.passive;
    }

    public void setPassive(boolean passive)
    {
        this.passive = passive;
    }
}