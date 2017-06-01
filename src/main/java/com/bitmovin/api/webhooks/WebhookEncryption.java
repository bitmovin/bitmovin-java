package com.bitmovin.api.webhooks;

import com.bitmovin.api.webhooks.enums.EncryptionType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by miglar on 12/22/16.
 */

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebhookEncryption
{
    private EncryptionType type;
    private String         key;

    public WebhookEncryption()
    {
    }

    public WebhookEncryption(EncryptionType type, String key)
    {
        this.type = type;
        this.key  = key;
    }

    public EncryptionType getType()
    {
        return this.type;
    }

    public void setType(EncryptionType type)
    {
        this.type = type;
    }

    public String getKey()
    {
        return this.key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }
}
