package com.bitmovin.api.webhooks;

import com.bitmovin.api.AbstractApiResponse;
import com.bitmovin.api.webhooks.enums.WebhookHttpMethod;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by miglar on 12/22/16.
 */

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Webhook extends AbstractApiResponse
{
    private String            url;
    private WebhookHttpMethod method;
    private Boolean           insecureSsl;
    private WebhookEncryption encryption;
    private WebhookSignature  signature;

    public String getUrl()
    {
        return this.url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public WebhookHttpMethod getMethod()
    {
        return this.method;
    }

    public void setMethod(WebhookHttpMethod method)
    {
        this.method = method;
    }

    public Boolean getInsecureSsl()
    {
        return this.insecureSsl;
    }

    public void setInsecureSsl(Boolean insecureSsl)
    {
        this.insecureSsl = insecureSsl;
    }

    public WebhookEncryption getEncryption()
    {
        return this.encryption;
    }

    public void setEncryption(WebhookEncryption encryption)
    {
        this.encryption = encryption;
    }

    public WebhookSignature getSignature()
    {
        return this.signature;
    }

    public void setSignature(WebhookSignature signature)
    {
        this.signature = signature;
    }
}
