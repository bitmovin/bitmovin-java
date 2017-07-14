package com.bitmovin.api.encoding.encodings.kubernetes;

import com.bitmovin.api.AbstractApiResponse;

/**
 * Created by alexanderkopper on 20/01/2017.
 */
public class KubernetesCluster extends AbstractApiResponse
{

    private boolean online;
    private boolean connected;

    private String name;
    private String description;
    private String agentDeploymentDownloadUrl;

    public boolean isOnline()
    {
        return this.online;
    }

    public void setOnline(boolean online)
    {
        this.online = online;
    }

    public boolean isConnected()
    {
        return this.connected;
    }

    public void setConnected(boolean connected)
    {
        this.connected = connected;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getAgentDeploymentDownloadUrl()
    {
        return this.agentDeploymentDownloadUrl;
    }

    public void setAgentDeploymentDownloadUrl(String agentDeploymentDownloadUrl)
    {
        this.agentDeploymentDownloadUrl = agentDeploymentDownloadUrl;
    }
}
