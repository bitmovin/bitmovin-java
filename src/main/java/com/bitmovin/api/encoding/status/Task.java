package com.bitmovin.api.encoding.status;

import com.bitmovin.api.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 26.07.16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Task
{
    private Status status;
    private int eta;
    private int progress;

    private Set<Subtask> subtasks;
    private Set<Message> messages;

    public Task()
    {
    }

    public Status getStatus()
    {
        return this.status;
    }

    public void setStatus(Status status)
    {
        this.status = status;
    }

    public int getEta()
    {
        return this.eta;
    }

    public void setEta(int eta)
    {
        this.eta = eta;
    }

    public int getProgress()
    {
        return this.progress;
    }

    public void setProgress(int progress)
    {
        this.progress = progress;
    }

    public Set<Subtask> getSubtasks()
    {
        return this.subtasks;
    }

    public void setSubtasks(Set<Subtask> subTasks)
    {
        this.subtasks = subTasks;
    }

    public Set<Message> getMessages()
    {
        return this.messages;
    }

    public void setMessages(Set<Message> messages)
    {
        this.messages = messages;
    }
}
