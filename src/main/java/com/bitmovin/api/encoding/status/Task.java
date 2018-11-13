package com.bitmovin.api.encoding.status;

import com.bitmovin.api.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
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

    private Date createdAt;
    private Date queuedAt;
    private Date runningAt;
    private Date finishedAt;

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

    public Date getCreatedAt()
    {
        return this.createdAt;
    }

    public void setCreatedAt(Date date)
    {
        this.createdAt = date;
    }

    public Date getQueuedAt()
    {
        return this.queuedAt;
    }

    public void setQueuedAt(Date date)
    {
        this.queuedAt = date;
    }

    public Date getRunningAt()
    {
        return this.runningAt;
    }

    public void setRunningAt(Date date)
    {
        this.runningAt = date;
    }

    public Date getFinishedAt()
    {
        return this.finishedAt;
    }

    public void setFinishedAt(Date date)
    {
        this.finishedAt = date;
    }
}
