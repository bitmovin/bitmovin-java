package com.bitmovin.api.resource;

import com.bitmovin.api.RestClient;
import com.bitmovin.api.constants.ApiUrls;
import com.bitmovin.api.customData.CustomData;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.http.RestException;
import com.bitmovin.api.webhooks.Webhook;
import com.bitmovin.api.webhooks.enums.WebhookType;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

/**
 * Created by miglar on 12/22/16.
 */
public class WebhookResource<T extends Webhook>
{

    private final String ENCODING_BASE_PATH = "encoding/encodings";
    private final String TRANSFER_BASE_PATH = "encoding/transfers";

    private Map<String, String> headers;
    private String              url;
    private Class<T>            type;
    private String              listName;

    public WebhookResource(Map<String, String> headers, String url, Class<T> type)
    {
        this.headers = headers;
        this.url = url;
        this.type = type;
        this.listName = "items";
    }

    public T create(T item, WebhookType webhookType) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        return this.create(item, webhookType, null);
    }

    public T create(T item, WebhookType webhookType, String resourceId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String resourceUrl = this.getBaseUrl(webhookType, resourceId);
        return RestClient.post(this.headers, resourceUrl, item, this.type);
    }

    public void delete(String id, WebhookType webhookType) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        this.delete(id, webhookType, null);
    }

    public void delete(String id, WebhookType webhookType, String resourceId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String resourceUrl = this.getBaseUrl(webhookType, resourceId);
        resourceUrl = String.format("%s/%s", resourceUrl, id);

        RestClient.delete(resourceUrl, this.headers);
    }

    public T get(String id, WebhookType webhookType) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        return this.get(id, webhookType, null);
    }

    public T get(String id, WebhookType webhookType, String resourceId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String resourceUrl = this.getBaseUrl(webhookType, resourceId);
        resourceUrl = String.format("%s/%s", resourceUrl, id);

        return RestClient.get(resourceUrl, this.headers, this.type);
    }

    public CustomData getCustomData(String id, WebhookType webhookType) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        return this.getCustomData(id, webhookType, null);
    }

    public CustomData getCustomData(String id, WebhookType webhookType, String resourceId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String resourceUrl = this.getBaseUrl(webhookType, resourceId);
        resourceUrl = String.format("%s/%s%s", resourceUrl, id, ApiUrls.customDataSuffix);

        return RestClient.get(resourceUrl, this.headers, CustomData.class);
    }

    public List<T> getAllIterative(WebhookType webhookType) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        return this.getAllIterative(webhookType, null);
    }

    public List<T> getAllIterative(WebhookType webhookType, String resourceId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String resourceUrl = this.getBaseUrl(webhookType, resourceId);
        return RestClient.getAllItemsIterative(resourceUrl, this.headers, this.type);
    }

    public List<T> getAll(WebhookType webhookType) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        return this.getAll(webhookType, null);
    }

    public List<T> getAll(WebhookType webhookType, String resourceId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String resourceUrl = this.getBaseUrl(webhookType, resourceId);
        return RestClient.getItems(resourceUrl, this.headers, this.type);
    }

    public List<T> getAll(int limit, int offset, WebhookType webhookType) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        return this.getAll(limit, offset, webhookType, null);
    }

    public List<T> getAll(int limit, int offset, WebhookType webhookType, String resourceId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String resourceUrl = this.getBaseUrl(webhookType, resourceId);
        return RestClient.getItems(resourceUrl, this.headers, this.type, limit, offset);
    }

    public List<String> getAllIds(WebhookType webhookType) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        return this.getAllIds(webhookType, null);
    }

    public List<String> getAllIds(WebhookType webhookType, String resourceId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String resourceUrl = this.getBaseUrl(webhookType, resourceId);
        return RestClient.getListOfIds(resourceUrl, this.headers);
    }

    public Long getTotalCount(WebhookType webhookType) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        return this.getTotalCount(webhookType, null);
    }

    public Long getTotalCount(WebhookType webhookType, String resourceId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String resourceUrl = this.getBaseUrl(webhookType, resourceId);
        return RestClient.getTotalCount(resourceUrl, this.headers);
    }

    private String getBaseUrl(WebhookType webhookType, String resourceId) throws MalformedURLException, BitmovinApiException
    {
        String resourceUrl;

        switch (webhookType)
        {
            case ENCODING_ERROR:
                resourceUrl = this.getBaseUrlWithAppendix(this.ENCODING_BASE_PATH, resourceId, "error");
                break;
            case ENCODING_FINISHED:
                resourceUrl = this.getBaseUrlWithAppendix(this.ENCODING_BASE_PATH, resourceId, "finished");
                break;
            case TRANSFER_ERROR:
                resourceUrl = this.getBaseUrlWithAppendix(this.TRANSFER_BASE_PATH, resourceId, "error");
                break;
            case TRANSFER_FINISHED:
                resourceUrl = this.getBaseUrlWithAppendix(this.TRANSFER_BASE_PATH, resourceId, "finished");
                break;
            default:
                throw new BitmovinApiException("not implemented");
        }

        return resourceUrl;
    }

    private String getBaseUrlWithAppendix(String basePath, String resourceId, String appendix)
    {
        String resourceUrl;

        if (resourceId == null)
            resourceUrl = String.format("%s/%s/%s",    this.url, basePath, appendix);
        else
            resourceUrl = String.format("%s/%s/%s/%s", this.url, basePath, resourceId, appendix);

        return resourceUrl;
    }
}
