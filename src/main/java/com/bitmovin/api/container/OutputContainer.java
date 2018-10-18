package com.bitmovin.api.container;

import com.bitmovin.api.RestClient;
import com.bitmovin.api.constants.ApiUrls;
import com.bitmovin.api.encoding.outputs.*;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.resource.OutputResource;
import com.bitmovin.api.rest.ResponseEnvelope;
import com.bitmovin.api.http.RestException;
import com.bitmovin.api.helper.Tuple;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * Created by rkersche on 9/5/16.
 */
public class OutputContainer
{

    public OutputResource<AkamaiNetStorageOutput> akamaiNetStorage;
    public OutputResource<AzureOutput> azure;
    public OutputResource<BitmovinGcsOutput> bitmovinGcsOutput;
    public OutputResource<BitmovinS3Output> bitmovinS3Output;
    public OutputResource<FtpOutput> ftp;
    public OutputResource<GcsOutput> gcs;
    public OutputResource<LocalOutput> local;
    public OutputResource<S3Output> s3;
    public OutputResource<SftpOutput> sftp;
    public OutputResource<GenericS3Output> genericS3;
    public OutputResource<S3RoleBasedOutput> s3RoleBased;
    public OutputResource<Output> all;
    private Map<String, String> headers;

    public OutputContainer(Map<String, String> headers)
    {
        this.headers = headers;
        this.akamaiNetStorage = new OutputResource<>(headers, ApiUrls.outputAkamaiNetStorage, AkamaiNetStorageOutput.class);
        this.azure = new OutputResource<>(headers, ApiUrls.outputAzure, AzureOutput.class);
        this.bitmovinGcsOutput = new OutputResource<>(headers, ApiUrls.outputBitmovinGcs, BitmovinGcsOutput.class);
        this.bitmovinS3Output = new OutputResource<>(headers, ApiUrls.outputBitmovinS3, BitmovinS3Output.class);
        this.ftp = new OutputResource<>(headers, ApiUrls.outputFtp, FtpOutput.class);
        this.gcs = new OutputResource<>(headers, ApiUrls.outputGcs, GcsOutput.class);
        this.local = new OutputResource<>(headers, ApiUrls.outputLocal, LocalOutput.class);
        this.s3 = new OutputResource<>(headers, ApiUrls.outputS3, S3Output.class);
        this.sftp = new OutputResource<>(headers, ApiUrls.outputSftp, SftpOutput.class);
        this.all = new OutputResource<>(headers, ApiUrls.outputs, Output.class);
        this.genericS3 = new OutputResource<>(headers, ApiUrls.outputGenericS3, GenericS3Output.class);
        this.s3RoleBased = new OutputResource<>(headers, ApiUrls.outputS3RoleBased, S3RoleBasedOutput.class);
    }

    public OutputType getType(String outputId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        ResponseEnvelope responseEnvelope = RestClient.getRaw(ApiUrls.outputs + "/" + outputId + "/type", this.headers, ResponseEnvelope.class);
        JSONObject responseObject = RestClient.convertToJsonObject(responseEnvelope);
        return OutputType.valueOf(responseObject.getJSONObject("data").getJSONObject("result").getString("type"));
    }

    public Tuple<OutputType, Output> get(String outputId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        ResponseEnvelope responseEnvelope = RestClient.getRaw(ApiUrls.outputs + "/" + outputId + "/type", this.headers, ResponseEnvelope.class);
        JSONObject responseObject = RestClient.convertToJsonObject(responseEnvelope);
        OutputType outputType = OutputType.valueOf(responseObject.getJSONObject("data").getJSONObject("result").getString("type"));
        if (outputType == null)
            return null;
        switch (outputType)
        {
            case S3:
                return new Tuple<OutputType, Output>(outputType, this.s3.get(outputId));
            case GCS:
                return new Tuple<OutputType, Output>(outputType, this.gcs.get(outputId));
            case FTP:
                return new Tuple<OutputType, Output>(outputType, this.ftp.get(outputId));
            case SFTP:
                return new Tuple<OutputType, Output>(outputType, this.sftp.get(outputId));
            case LOCAL:
                return new Tuple<OutputType, Output>(outputType, this.local.get(outputId));
            case AKAMAI_NETSTORAGE:
                return new Tuple<OutputType, Output>(outputType, this.akamaiNetStorage.get(outputId));
            case AZURE:
                return new Tuple<OutputType, Output>(outputType, this.azure.get(outputId));
            case GENERIC_S3:
                return new Tuple<OutputType, Output>(outputType, this.genericS3.get(outputId));
            case BITMOVIN_GCS:
                return new Tuple<OutputType, Output>(outputType, this.bitmovinGcsOutput.get(outputId));
            case BITMOVIN_S3:
                return new Tuple<OutputType, Output>(outputType, this.bitmovinS3Output.get(outputId));
            case S3_ROLE_BASED:
                return new Tuple<OutputType, Output>(outputType, this.s3RoleBased.get(outputId));
        }
        return null;
    }

}
