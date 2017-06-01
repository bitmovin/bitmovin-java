package com.bitmovin.api.resource;

import com.bitmovin.api.RestClient;
import com.bitmovin.api.constants.ApiUrls;
import com.bitmovin.api.encoding.status.Task;
import com.bitmovin.api.encoding.encodings.transfer.EncodingTransfer;
import com.bitmovin.api.encoding.encodings.transfer.ManifestTransfer;
import com.bitmovin.api.encoding.encodings.transfer.Transfer;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.rest.ResponseEnvelope;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * Created by arudich on 15.09.16.
 **/
public class TransferResource<T extends Transfer> extends AbstractResource<T>
{

    public TransferResource(Map<String, String> headers, String url, Class<T> type)
    {
        super(headers, url, type);
    }

    public Task getStatus(EncodingTransfer encodingTransfer) throws BitmovinApiException, UnirestException, URISyntaxException, IOException
    {
        String newUrl = ApiUrls.transferEncodingStatus.replace("{transfer_id}", encodingTransfer.getId());
        ResponseEnvelope responseEnvelope = RestClient.getRaw(newUrl, this.headers, ResponseEnvelope.class);
        return RestClient.getAnalysisTaskFromResponse(responseEnvelope);
    }

    public EncodingTransfer startEncodingTransfer(EncodingTransfer encodingTransfer) throws BitmovinApiException, UnirestException, IOException, URISyntaxException
    {
        String newUrl = ApiUrls.transferEncoding;
        return RestClient.post(this.headers, newUrl, encodingTransfer, EncodingTransfer.class);
    }

    public Task getStatus(ManifestTransfer manifestTransfer) throws BitmovinApiException, UnirestException, URISyntaxException, IOException
    {
        String newUrl = ApiUrls.transferManifestStatus.replace("{transfer_id}", manifestTransfer.getId());
        ResponseEnvelope responseEnvelope = RestClient.getRaw(newUrl, this.headers, ResponseEnvelope.class);

        return RestClient.getAnalysisTaskFromResponse(responseEnvelope);
    }

    public ManifestTransfer startManifestTransfer(ManifestTransfer manifestTransfer) throws BitmovinApiException, UnirestException, IOException, URISyntaxException
    {
        String newUrl = ApiUrls.transferManifest;
        ManifestTransfer createdTransfer = RestClient.post(this.headers, newUrl, manifestTransfer, ManifestTransfer.class);
        return createdTransfer;
    }

}
