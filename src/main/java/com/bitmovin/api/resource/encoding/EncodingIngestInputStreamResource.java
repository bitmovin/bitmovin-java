package com.bitmovin.api.resource.encoding;

import com.bitmovin.api.RestClient;
import com.bitmovin.api.constants.ApiUrls;
import com.bitmovin.api.customData.CustomData;
import com.bitmovin.api.encoding.encodings.Encoding;
import com.bitmovin.api.encoding.encodings.streams.IngestInputStream;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.http.RestException;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class EncodingIngestInputStreamResource
{
    private Map<String, String> headers;

    public EncodingIngestInputStreamResource(Map<String, String> headers)
    {
        this.headers = headers;
    }

    public IngestInputStream getIngestInputStream(Encoding encoding, IngestInputStream ingestInputStream) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.ingestInputStreamsWithId.replace("{encoding_id}", encoding.getId()).replace("{ingest_input_stream_id}", ingestInputStream.getId());
        return RestClient.get(newUrl, this.headers, IngestInputStream.class);
    }

    public List<IngestInputStream> getIngestInputStreams(Encoding encoding) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.ingestInputStreams.replace("{encoding_id}", encoding.getId());
        return RestClient.getAllItemsIterative(newUrl, this.headers, IngestInputStream.class);
    }

    public IngestInputStream getIngestInputStream(Encoding encoding, String ingestInputStreamId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.ingestInputStreamsWithId.replace("{encoding_id}", encoding.getId()).replace("{ingest_input_stream_id}", ingestInputStreamId);
        return RestClient.get(newUrl, this.headers, IngestInputStream.class);
    }

    public List<String> getIngestInputStreamIds(Encoding encoding) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.ingestInputStreams.replace("{encoding_id}", encoding.getId());
        return RestClient.getListOfIds(newUrl, this.headers);
    }

    public CustomData getIngestInputStreamCustomData(String encodingId, String ingestInputStreamId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.ingestInputStreams.replace("{encoding_id}", encodingId) + "/" + ingestInputStreamId + ApiUrls.customDataSuffix;
        return RestClient.get(newUrl, this.headers, CustomData.class);
    }

    public IngestInputStream addIngestInputStreamToEncoding(Encoding encoding, IngestInputStream ingestInputStream) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.ingestInputStreams.replace("{encoding_id}", encoding.getId());
        return RestClient.post(this.headers, newUrl, ingestInputStream, IngestInputStream.class);
    }

    public IngestInputStream addIngestInputStream(Encoding encoding, IngestInputStream ingestInputStream) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.ingestInputStreams.replace("{encoding_id}", encoding.getId());
        return RestClient.post(this.headers, newUrl, ingestInputStream, IngestInputStream.class);
    }

    public void deleteIngestInputStream(Encoding encoding, IngestInputStream ingestInputStream) throws BitmovinApiException, URISyntaxException, IOException, RestException, UnirestException
    {
        String newUrl = ApiUrls.ingestInputStreamsWithId.replace("{encoding_id}", encoding.getId());
        newUrl = newUrl.replace("{ingest_input_stream_id}", ingestInputStream.getId());
        RestClient.delete(newUrl, this.headers);
    }

}
