package com.bitmovin.api.resource;

import com.bitmovin.api.encoding.outputs.Output;
import com.bitmovin.api.encoding.outputs.OutputList;
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
public class OutputResource<T extends Output> extends AbstractResource<T>
{

    public OutputResource(Map<String, String> headers, String url, Class<T> type)
    {
        super(headers, url, type);
    }


    public OutputList<T> getAllOutputs() throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        List<T> outputs = this.getAllIterative();
        OutputList<T> outputList = new OutputList<>();
        outputList.setOutputs(outputs);
        outputList.setTotalCount(outputs.size());
        return outputList;
    }

}
