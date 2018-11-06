package com.bitmovin.api.encoding.status;

import com.bitmovin.api.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
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

    private Date runningAt;
    private Date updatedAt;
    private Date finishedAt;

    private List<Message> messages;
    private List<Metadata> metadata;

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

    public List<Metadata> getMetadata() { return this.metadata; }

    public void setMetadata(List<Metadata> metadata) { this.metadata = metadata; }

    public Date getRunningAt() { return this.runningAt; }

    public void setRunningAt(Date date) { this.runningAt = date; }

    public Date getUpdatedAt() { return this.updatedAt; }

    public void setUpdatedAt(Date date) { this.updatedAt = date; }

    public Date getFinishedAt() { return this.finishedAt; }

    public void setFinishedAt(Date date) { this.finishedAt = date; }
}
