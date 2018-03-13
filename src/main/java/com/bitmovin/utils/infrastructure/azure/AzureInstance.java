package com.bitmovin.utils.infrastructure.azure;

import com.bitmovin.utils.infrastructure.AbstractInstance;
import com.bitmovin.utils.infrastructure.InstanceStatus;
import com.bitmovin.utils.infrastructure.Provider;
import com.bitmovin.utils.infrastructure.UsageState;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.UUID;

/**
 * This class represents the instance.
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AzureInstance extends AbstractInstance
{
    private String azureId;
    private AzureCredentials credentials;
    private AzureInstanceConfiguration configuration;

    public AzureInstance()
    {
        super();
        this.setProvider(Provider.AZURE);
        this.setUsageState(UsageState.NEW);
        this.setStatus(InstanceStatus.STARTING);
        this.setId(UUID.randomUUID().toString().replaceAll("-", ""));
    }

    public AzureInstance(AzureInstanceConfiguration config, AzureCredentials credentials)
    {
        this();
        this.configuration = config;
        this.credentials = credentials;
    }

    public String getAzureId()
    {
        return this.azureId;
    }

    public void setAzureId(String azureId)
    {
        this.azureId = azureId;
    }

    public AzureCredentials getCredentials()
    {
        return this.credentials;
    }

    public void setCredentials(AzureCredentials credentials)
    {
        this.credentials = credentials;
    }

    @Override
    public AzureInstanceConfiguration getConfiguration()
    {
        return this.configuration;
    }

    public void setConfiguration(AzureInstanceConfiguration configuration)
    {
        this.configuration = configuration;
    }

    @Override
    public String getRegion()
    {
        return this.getConfiguration().getRegion();
    }
}
