package com.bitmovin.api;

import com.bitmovin.api.encoding.inputs.S3Input;
import com.bitmovin.api.rest.Link;
import com.bitmovin.api.rest.ResponseEnvelope;
import com.bitmovin.api.rest.ResponseErrorData;
import com.bitmovin.api.rest.ResponseStatus;
import com.bitmovin.api.rest.ServiceMessage;
import com.bitmovin.api.rest.ServiceMessageType;

import java.util.ArrayList;
import java.util.UUID;

public class SampleProvider
{
    public static ResponseEnvelope sampleBadRequestResponse()
    {
        ResponseEnvelope responseEnvelope = new ResponseEnvelope(UUID.randomUUID().toString());
        responseEnvelope.setStatus(ResponseStatus.ERROR);
        ResponseErrorData responseErrorData = new ResponseErrorData();
        responseErrorData.setCode(1000);
        responseErrorData.setMessage("One or more required fields are not valid or not present");
        responseErrorData.setDeveloperMessage("Exception while parsing input fields");
        responseErrorData.setLinks(
                new ArrayList<Link>() {{
                    add(new Link("https://bitmovin.com/encoding-documentation/", "Encoding Documentation"));
                }}
        );
        responseErrorData.setDetails(
                new ArrayList<ServiceMessage>(){{
                    add(new ServiceMessage(ServiceMessageType.ERROR, "Exception while parsing field 'name': field is empty"));
                }}
        );
        responseEnvelope.setData(responseErrorData);
        return responseEnvelope;
    }

    public static ResponseEnvelope sampleSuccessResponse()
    {
        ResponseEnvelope responseEnvelope = new ResponseEnvelope(UUID.randomUUID().toString());
        responseEnvelope.setStatus(ResponseStatus.SUCCESS);
        S3Input s3Input = new S3Input();
        s3Input.setAccessKey(UUID.randomUUID().toString());
        s3Input.setSecretKey(UUID.randomUUID().toString());
        s3Input.setBucketName("myBucket");
        s3Input.setId(UUID.randomUUID().toString());
        responseEnvelope.setData(s3Input);
        return responseEnvelope;
    }
}
