package com.bitmovin.api.container;

import com.bitmovin.api.RestClient;
import com.bitmovin.api.constants.ApiUrls;
import com.bitmovin.api.encoding.analysis.AnalysisDetails;
import com.bitmovin.api.encoding.analysis.AnalysisStartRequest;
import com.bitmovin.api.encoding.inputs.AkamaiNetstorageInput;
import com.bitmovin.api.encoding.inputs.ZixiInput;
import com.bitmovin.api.encoding.status.Task;
import com.bitmovin.api.encoding.inputs.AsperaInput;
import com.bitmovin.api.encoding.inputs.AzureInput;
import com.bitmovin.api.encoding.inputs.FtpInput;
import com.bitmovin.api.encoding.inputs.GcsInput;
import com.bitmovin.api.encoding.inputs.GenericS3Input;
import com.bitmovin.api.encoding.inputs.HttpInput;
import com.bitmovin.api.encoding.inputs.HttpsInput;
import com.bitmovin.api.encoding.inputs.Input;
import com.bitmovin.api.encoding.inputs.InputType;
import com.bitmovin.api.encoding.inputs.LocalInput;
import com.bitmovin.api.encoding.inputs.RtmpInput;
import com.bitmovin.api.encoding.inputs.S3Input;
import com.bitmovin.api.encoding.inputs.SftpInput;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.resource.InputResource;
import com.bitmovin.api.rest.ResponseEnvelope;
import com.bitmovin.api.rest.status.ServiceTaskStatus;
import com.bitmovin.api.http.RestException;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * Created by rkersche on 9/5/16.
 */
public class InputContainer
{
    public InputResource<AsperaInput> aspera;
    public InputResource<AzureInput> azure;
    public InputResource<FtpInput> ftp;
    public InputResource<GcsInput> gcs;
    public InputResource<HttpInput> http;
    public InputResource<HttpsInput> https;
    public InputResource<SftpInput> sftp;
    public InputResource<S3Input> s3;
    public InputResource<RtmpInput> rtmp;
    public InputResource<GenericS3Input> genericS3;
    public InputResource<LocalInput> local;
    public InputResource<AkamaiNetstorageInput> akamaiNetstorage;
    public InputResource<ZixiInput> zixi;
    public InputResource<Input> all;
    private Map<String, String> headers;


    public InputContainer(Map<String, String> headers)
    {
        this.headers = headers;
        this.aspera = new InputResource<>(headers, ApiUrls.inputAspera, AsperaInput.class);
        this.azure = new InputResource<>(headers, ApiUrls.inputAzure, AzureInput.class);
        this.ftp = new InputResource<>(headers, ApiUrls.inputFTP, FtpInput.class);
        this.gcs = new InputResource<>(headers, ApiUrls.inputGcs, GcsInput.class);
        this.http = new InputResource<>(headers, ApiUrls.inputHttp, HttpInput.class);
        this.https = new InputResource<>(headers, ApiUrls.inputHttps, HttpsInput.class);
        this.sftp = new InputResource<>(headers, ApiUrls.inputSFTP, SftpInput.class);
        this.s3 = new InputResource<>(headers, ApiUrls.inputS3, S3Input.class);
        this.rtmp = new InputResource<>(headers, ApiUrls.inputRtmp, RtmpInput.class);
        this.local = new InputResource<>(headers, ApiUrls.inputLocal, LocalInput.class);
        this.all = new InputResource<>(headers, ApiUrls.inputs, Input.class);
        this.genericS3 = new InputResource<>(headers, ApiUrls.inputGenericS3, GenericS3Input.class);
        this.akamaiNetstorage = new InputResource<>(headers, ApiUrls.inputAkamaiNetstorage, AkamaiNetstorageInput.class);
        this.zixi = new InputResource<>(headers, ApiUrls.inputZixi, ZixiInput.class);
    }

    public InputType getType(String inputId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        ResponseEnvelope responseEnvelope = RestClient.getRaw(ApiUrls.inputs + "/" + inputId + "/type", this.headers, ResponseEnvelope.class);
        JSONObject responseObject = RestClient.convertToJsonObject(responseEnvelope);
        String type =  responseObject.getJSONObject("data").getJSONObject("result").getString("type");
        return InputType.valueOf(type);
    }

    public Task getStatusOfInputAnalysis(Input input, String analysisId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.analysisStatus.replace("{inputType}", input.getType().toString().toLowerCase()).replace("{inputId}", input.getId()).replace("{analysisId}", analysisId);
        ResponseEnvelope responseEnvelope = RestClient.getRaw(newUrl, this.headers, ResponseEnvelope.class);
        return RestClient.getAnalysisTaskFromResponse(responseEnvelope);
    }

    public AnalysisDetails getDetailsOfInputAnalysis(Input input, String analysisId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.analysisDetails.replace("{inputType}", input.getType().toString().toLowerCase()).replace("{inputId}", input.getId()).replace("{analysisId}", analysisId);
        ResponseEnvelope responseEnvelope = RestClient.getRaw(newUrl, this.headers, ResponseEnvelope.class);
        return RestClient.getAnalysisDetailsFromResponse(responseEnvelope);
    }

    public String startInputAnalysis(Input input, AnalysisStartRequest analysisStartRequest) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.analysisStart.replace("{inputType}", input.getType().toString().toLowerCase()).replace("{inputId}", input.getId());
        ResponseEnvelope responseEnvelope = RestClient.postRaw(newUrl, this.headers, analysisStartRequest, ResponseEnvelope.class);
        return RestClient.getIdFromResponse(responseEnvelope);
    }

    public ServiceTaskStatus getInputAnalysisStatus(Input input, String analysisId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String url = ApiUrls.analysisStatus.replace("{inputType}", input.getType().toString().toLowerCase())
                                           .replace("{inputId}", input.getId())
                                           .replace("{analysisId}", analysisId);
        return RestClient.get(url, this.headers, ServiceTaskStatus.class);
    }

}
