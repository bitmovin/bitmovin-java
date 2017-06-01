package com.bitmovin.api.rest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmoser on 22.12.16.
 */
public class ResponseErrorData
{
    private Integer code;
    private String message;
    private String developerMessage;
    private List<Link> links = new ArrayList();

    private List<ServiceMessage> details = new ArrayList();

    public Integer getCode()
    {
        return this.code;
    }

    public void setCode(Integer code)
    {
        this.code = code;
    }

    public String getMessage()
    {
        return this.message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String getDeveloperMessage()
    {
        return this.developerMessage;
    }

    public void setDeveloperMessage(String developerMessage)
    {
        this.developerMessage = developerMessage;
    }

    public List<Link> getLinks()
    {
        return this.links;
    }

    public void setLinks(List<Link> links)
    {
        this.links = links;
    }

    public List<ServiceMessage> getDetails()
    {
        return this.details;
    }

    public void setDetails(List<ServiceMessage> details)
    {
        this.details = details;
    }
}