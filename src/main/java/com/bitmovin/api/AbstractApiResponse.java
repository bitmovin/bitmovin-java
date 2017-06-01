package com.bitmovin.api;

import com.bitmovin.api.encoding.status.Message;
import com.bitmovin.api.enums.AnswerStatus;
import com.bitmovin.api.rest.ResponseEnvelope;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 26.07.16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractApiResponse
{
    @JsonIgnore
    private ResponseEnvelope responseEnvelope;
    @JsonIgnore
    private List<Message> messages;
    @JsonIgnore
    private AnswerStatus status;

    private String id;
    private Map<String, Object> customData;

    public AbstractApiResponse()
    {
        this.messages = new ArrayList<>();
    }

    public ResponseEnvelope getResponseEnvelope()
    {
        return this.responseEnvelope;
    }

    public void setResponseEnvelope(ResponseEnvelope responseEnvelope)
    {
        this.responseEnvelope = responseEnvelope;
    }

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public List<Message> getMessages()
    {
        return (List<Message>)((ArrayList) this.messages).clone();
    }

    public void setMessages(List<Message> messages)
    {
        this.messages = messages;
    }

    public AnswerStatus getStatus()
    {
        return this.status;
    }

    public void setStatus(AnswerStatus status)
    {
        this.status = status;
    }

    public Map<String, Object> getCustomData()
    {
        if (this.customData == null)
        {
            this.customData = new HashMap<>();
        }
        return this.customData;
    }

    public void setCustomData(Map<String, Object> customData)
    {
        this.customData = customData;
    }

}
