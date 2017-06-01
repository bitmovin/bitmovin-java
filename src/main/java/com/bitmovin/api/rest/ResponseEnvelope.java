package com.bitmovin.api.rest;

/**
 * Created by
 * David Moser [david.moser@bitmovin.com]
 * on 7/13/16
 */
public class ResponseEnvelope
{
    private String requestId;
    private ResponseStatus status;

    private Object data;
    private Object more;

    public ResponseEnvelope()
    {
    }

    public ResponseEnvelope(String requestId)
    {
        this.requestId = requestId;
    }

    public String getRequestId()
    {
        return this.requestId;
    }

    public void setRequestId(String requestId)
    {
        this.requestId = requestId;
    }

    public ResponseStatus getStatus()
    {
        return this.status;
    }

    public void setStatus(ResponseStatus status)
    {
        this.status = status;
    }

    public Object getData()
    {
        return this.data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }

    public Object getMore()
    {
        return this.more;
    }

    public void setMore(Object more)
    {
        this.more = more;
    }

}
