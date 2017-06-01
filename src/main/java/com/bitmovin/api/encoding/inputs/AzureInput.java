package com.bitmovin.api.encoding.inputs;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 25.07.16.
 */
public class AzureInput extends Input
{
    private String accountName;

    private String accountKey;

    private String container;

    public AzureInput()
    {
        this.setType(InputType.AZURE);
    }

    public String getAccountName()
    {
        return this.accountName;
    }

    public void setAccountName(String accountName)
    {
        this.accountName = accountName;
    }

    public String getAccountKey()
    {
        return this.accountKey;
    }

    public void setAccountKey(String accountKey)
    {
        this.accountKey = accountKey;
    }

    public String getContainer()
    {
        return this.container;
    }

    public void setContainer(String container)
    {
        this.container = container;
    }
}