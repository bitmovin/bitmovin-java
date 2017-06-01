package com.bitmovin.api.resource;

import com.bitmovin.api.encoding.inputs.Input;
import com.bitmovin.api.encoding.inputs.InputList;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.http.RestException;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

/**
 * Created by rkersche on 9/5/16.
 */
public class InputResource<T extends Input> extends AbstractResource<T>
{

    public InputResource(Map<String, String> headers, String url, Class<T> type)
    {
        super(headers, url, type);
    }

    public InputList<T> getAllInputs() throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        List<T> inputs = this.getAllIterative();
        InputList<T> inputList = new InputList<>();
        inputList.setInputs(inputs);
        inputList.setTotalCount(inputs.size());
        return inputList;
    }

}
