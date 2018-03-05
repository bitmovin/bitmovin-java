package com.bitmovin.api.resource;

import com.bitmovin.api.encoding.SimpleApiDTO;
import com.bitmovin.api.encoding.filters.Filter;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.http.RestException;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by rkersche on 9/5/16.
 */
public class FilterResource<T extends Filter> extends AbstractResource<T>
{

    public FilterResource(Map<String, String> headers, String url, Class<T> type)
    {
        super(headers, url, type);
    }

    public List<SimpleApiDTO> getSimpleApiDTOs() throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        List<SimpleApiDTO> simpleApiDTOs = new ArrayList<>();

        List<String> ids = this.getAllIds();
        for (String id : ids)
        {
            SimpleApiDTO dto = new SimpleApiDTO();
            dto.setId(id);
            simpleApiDTOs.add(dto);
        }

        return simpleApiDTOs;
    }


}
