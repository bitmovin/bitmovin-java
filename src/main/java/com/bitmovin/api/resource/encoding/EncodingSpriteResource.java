package com.bitmovin.api.resource.encoding;

import com.bitmovin.api.RestClient;
import com.bitmovin.api.constants.ApiUrls;
import com.bitmovin.api.customData.CustomData;
import com.bitmovin.api.encoding.SimpleApiDTO;
import com.bitmovin.api.encoding.encodings.Encoding;
import com.bitmovin.api.encoding.encodings.streams.Stream;
import com.bitmovin.api.encoding.encodings.thumbnails.Sprite;
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
public class EncodingSpriteResource extends AbstractResource
{
    private Map<String, String> headers;

    public EncodingSpriteResource(Map<String, String> headers)
    {
        super(headers, ApiUrls.sprites, Sprite.class);
        this.headers = headers;
    }

    public Sprite get(Encoding encoding, Stream stream, String spriteId)
            throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        return this.get(encoding.getId(), stream.getId(), spriteId);
    }

    public Sprite get(String encodingId, String streamId, String spriteId)
            throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.sprites
                .replace("{encoding_id}", encodingId)
                .replace("{stream_id}", streamId) + "/" + spriteId;

        return RestClient.get(newUrl, this.headers, Sprite.class);
    }

    public Sprite create(Encoding encoding, Stream stream, Sprite sprite)
            throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        return this.create(encoding.getId(), stream.getId(), sprite);
    }

    public Sprite create(String encodingId, String streamId, Sprite sprite)
            throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.sprites.replace("{encoding_id}", encodingId).replace("{stream_id}", streamId);
        return RestClient.post(this.headers, newUrl, sprite, Sprite.class);
    }

    public void delete(Encoding encoding, Stream stream, Sprite sprite)
            throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        this.delete(encoding.getId(), stream.getId(), sprite.getId());
    }

    public void delete(String encodingId, String streamId, String spriteId)
            throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.sprites
                .replace("{encoding_id}", encodingId)
                .replace("{stream_id}", streamId) + "/" + spriteId;

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
        this.url = ApiUrls.sprites.replace("{encoding_id}", encodingId).replace("{stream_id}", streamId);
        List<SimpleApiDTO> simpleApiDTOs = new ArrayList<>();

        List<String> ids = this.getAllIds();
        for(String id : ids)
        {
            simpleApiDTOs.add(new SimpleApiDTO(id));
        }

        return simpleApiDTOs;
    }

    public CustomData getCustomData(Encoding encoding, Stream stream, String spriteId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        return this.getCustomData(encoding.getId(), stream.getId(), spriteId);
    }

    public CustomData getCustomData(String encodingId, String streamId, String spriteId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.sprites.replace("{encoding_id}", encodingId).replace("{stream_id}", streamId) + "/" + spriteId + ApiUrls.customDataSuffix;
        return RestClient.get(newUrl, this.headers, CustomData.class);
    }
}
