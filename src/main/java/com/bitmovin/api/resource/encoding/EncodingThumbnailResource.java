package com.bitmovin.api.resource.encoding;

import com.bitmovin.api.RestClient;
import com.bitmovin.api.constants.ApiUrls;
import com.bitmovin.api.customData.CustomData;
import com.bitmovin.api.encoding.SimpleApiDTO;
import com.bitmovin.api.encoding.encodings.Encoding;
import com.bitmovin.api.encoding.encodings.streams.Stream;
import com.bitmovin.api.encoding.encodings.thumbnails.Thumbnail;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.resource.AbstractResource;
import com.bitmovin.api.http.RestException;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Dominic Miglar [dominic.miglar@bitmovin.com] on 9/9/16 at 1:25 PM.
 */
public class EncodingThumbnailResource extends AbstractResource
{
    private Map<String, String> headers;

    public EncodingThumbnailResource(Map<String, String> headers)
    {
        super(headers, ApiUrls.thumbnails, Thumbnail.class);
        this.headers = headers;
    }

    public Thumbnail get(Encoding encoding, Stream stream, String thumbnailId)
            throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        return this.get(encoding.getId(), stream.getId(), thumbnailId);
    }

    public Thumbnail get(String encodingId, String streamId, String thumbnailId)
            throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.thumbnails
                .replace("{encoding_id}", encodingId)
                .replace("{stream_id}", streamId) + "/" + thumbnailId;

        return RestClient.get(newUrl, this.headers, Thumbnail.class);
    }

    public Thumbnail create(Encoding encoding, Stream stream, Thumbnail thumbnail)
            throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        return this.create(encoding.getId(), stream.getId(), thumbnail);
    }

    public Thumbnail create(String encodingId, String streamId, Thumbnail thumbnail)
            throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.thumbnails.replace("{encoding_id}", encodingId).replace("{stream_id}", streamId);
        return RestClient.post(this.headers, newUrl, thumbnail, Thumbnail.class);
    }

    public void delete(Encoding encoding, Stream stream, Thumbnail thumbnail)
            throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        this.delete(encoding.getId(), stream.getId(), thumbnail.getId());
    }

    public void delete(String encodingId, String streamId, String thumbnailId)
            throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.thumbnails
                .replace("{encoding_id}", encodingId)
                .replace("{stream_id}", streamId) + "/" + thumbnailId;

        RestClient.delete(newUrl, this.headers);
    }

    public List<SimpleApiDTO> listSimpleApiDTOs(Encoding encoding, Stream stream)
            throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        return this.listSimpleApiDTOs(encoding.getId(), stream.getId());
    }


    public List<SimpleApiDTO> listSimpleApiDTOs(String encodingId, String streamId)
            throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        this.url = ApiUrls.thumbnails.replace("{encoding_id}", encodingId).replace("{stream_id}", streamId);
        List<SimpleApiDTO> simpleApiDTOs = new ArrayList<>();

        List<String> ids = this.getAllIds();
        for(String id : ids)
        {
            simpleApiDTOs.add(new SimpleApiDTO(id));
        }

        return simpleApiDTOs;
    }

    public CustomData getCustomData(Encoding encoding, Stream stream, String thumbnailId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        return this.getCustomData(encoding.getId(), stream.getId(), thumbnailId);
    }

    public CustomData getCustomData(String encodingId, String streamId, String thumbnailId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.thumbnails.replace("{encoding_id}", encodingId).replace("{stream_id}", streamId) + "/" + thumbnailId + ApiUrls.customDataSuffix;
        return RestClient.get(newUrl, this.headers, CustomData.class);
    }
}
