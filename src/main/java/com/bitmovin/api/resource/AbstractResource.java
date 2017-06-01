package com.bitmovin.api.resource;

import com.bitmovin.api.AbstractApiResponse;
import com.bitmovin.api.RestClient;
import com.bitmovin.api.constants.ApiUrls;
import com.bitmovin.api.customData.CustomData;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.http.RestException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

/**
 * Created by rkersche on 9/2/16.
 **/
public abstract class AbstractResource<T extends AbstractApiResponse>
{

    protected Map<String, String> headers;
    protected String url;
    protected Class<T> type;

    protected AbstractResource(Map<String, String> headers, String url, Class<T> type)
    {
        this.headers = headers;
        this.url = url;
        this.type = type;
    }

    public T create(T item) throws BitmovinApiException, UnirestException, IOException, URISyntaxException
    {
        return RestClient.post(this.headers, this.url, item, this.type);
    }

    public void delete(String id) throws URISyntaxException, BitmovinApiException, RestException, IOException, UnirestException
    {
        RestClient.delete(String.format("%s/%s", this.url, id), this.headers);
    }

    public void deleteStorageOnly(String id) throws URISyntaxException, BitmovinApiException, RestException, IOException, UnirestException
    {
        RestClient.delete(String.format("%s/%s/storage", this.url, id), this.headers);
    }

    public void delete(T item) throws BitmovinApiException, RestException, IOException, URISyntaxException, UnirestException
    {
        this.delete(item.getId());
    }

    public T patch(String id, AbstractResourcePatch patch) throws BitmovinApiException, UnirestException, IOException, URISyntaxException
    {
        return RestClient.patch(this.headers, String.format("%s/%s", this.url, id), patch, this.type);
    }

    public T get(T item) throws URISyntaxException, BitmovinApiException, RestException, UnirestException, IOException
    {
        return this.get(item.getId());
    }

    public T get(String id) throws BitmovinApiException, IOException, RestException, UnirestException, URISyntaxException
    {
        return RestClient.get(String.format("%s/%s", this.url, id), this.headers, this.type);
    }

    public List<T> getAllIterative() throws URISyntaxException, BitmovinApiException, UnirestException, IOException
    {
        return RestClient.getAllItemsIterative(this.url, this.headers, this.type);
    }

    public List<Map<String, Object>> getAllAsHashMap() throws BitmovinApiException, UnirestException, IOException, URISyntaxException
    {
        return RestClient.getItemsAsHashMap(this.url, this.headers);
    }

    public List<T> getAll() throws BitmovinApiException, UnirestException, IOException, URISyntaxException
    {
        return RestClient.getItems(this.url, this.headers, this.type);
    }

    public List<T> getAll(int limit, int offset) throws BitmovinApiException, UnirestException, IOException, URISyntaxException
    {
        return RestClient.getItems(this.url, this.headers, this.type, limit, offset);
    }

    public List<String> getAllIds() throws JsonProcessingException, BitmovinApiException, UnirestException, URISyntaxException
    {
        return RestClient.getListOfIds(this.url, this.headers);
    }

    public Long getTotalCount() throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        return RestClient.getTotalCount(this.url, this.headers);
    }

    public CustomData getCustomData(String id) throws BitmovinApiException, UnirestException, IOException, URISyntaxException
    {
        String newUrl = this.url + "/" + id + ApiUrls.customDataSuffix;
        return RestClient.get(newUrl, this.headers, CustomData.class);
    }

}
