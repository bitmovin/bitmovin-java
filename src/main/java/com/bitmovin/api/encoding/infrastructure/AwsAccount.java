package com.bitmovin.api.encoding.infrastructure;

import com.bitmovin.api.AbstractApiResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by arudich on 23.11.17.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class AwsAccount extends AbstractApiResponse
{
    private String name;
    private String description;
    private String accessKey;
    private String secretKey;
    private String accountNumber;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getAccessKey()
    {
        return accessKey;
    }

    public void setAccessKey(String accessKey)
    {
        this.accessKey = accessKey;
    }

    public String getSecretKey()
    {
        return secretKey;
    }

    public void setSecretKey(String secretKey)
    {
        this.secretKey = secretKey;
    }

    public String getAccountNumber()
    {
        return this.accountNumber;
    }

    public void setAccountNumber(String accountNumber)
    {
        this.accountNumber = accountNumber;
    }
}
