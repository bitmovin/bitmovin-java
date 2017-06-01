package com.bitmovin.api.encoding.status;

import com.bitmovin.api.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 26.07.16.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Subtask
{
    private Status status;
    private int progress;

    private String name;

    private List<Message> messages;

    public Subtask() {}

    public Status getStatus() { return this.status; }

    public void setStatus(Status status) { this.status = status; }

    public int getProgress() { return this.progress; }

    public void setProgress(int progress) { this.progress = progress; }

    public String getName() { return this.name; }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Message> getMessages() { return this.messages; }

    public void setMessages(List<Message> messages) { this.messages = messages; }
}
