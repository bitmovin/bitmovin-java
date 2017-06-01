package com.bitmovin.api.webhooks;

import com.bitmovin.api.webhooks.enums.SignatureType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by miglar on 12/22/16.
 */

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebhookSignature
{
    private SignatureType type;
    private String        key;

    public WebhookSignature()
    {
    }

    public WebhookSignature(SignatureType type, String key)
    {
        this.type = type;
        this.key  = key;
    }

    public SignatureType getType()
    {
        return this.type;
    }

    public void setType(SignatureType type)
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
