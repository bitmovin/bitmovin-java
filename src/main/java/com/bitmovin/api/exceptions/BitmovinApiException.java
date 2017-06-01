package com.bitmovin.api.exceptions;

import com.bitmovin.api.rest.ResponseEnvelope;

import java.util.Map;

public class BitmovinApiException extends Exception
{

    private int status;
    private ResponseEnvelope responseEnvelope;
    private int code;
    private String message;
    private String developerMessage;

    public BitmovinApiException(int status)
    {
        this.status = status;
    }

    public BitmovinApiException(String message)
    {
        this.message = message;
    }

    public BitmovinApiException(int status, ResponseEnvelope responseEnvelope)
    {
        this.status = status;
        this.responseEnvelope = responseEnvelope;
        try
        {
            Map<String, Object> data = (Map<String, Object>) responseEnvelope.getData();
            this.code = Integer.valueOf(data.get("code").toString());
            this.message = data.get("message").toString();
            this.developerMessage = data.get("developerMessage").toString();
        }
        catch (Exception ignore)
        {
        }
    }

    public int getStatus()
    {
        return this.status;
    }

    public int getCode()
    {
        return this.code;
    }

    @Override
    public String getMessage()
    {
        return this.message;
    }

    public String getDeveloperMessage()
    {
        return this.developerMessage;
    }

    @Override
    public String toString()
    {
        return String.format("Error Code: %d; Error message: %s; Developer Message: %s", this.code, this.message, this.developerMessage);
    }
}
