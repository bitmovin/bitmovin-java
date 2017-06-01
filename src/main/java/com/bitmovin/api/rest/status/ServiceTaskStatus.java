package com.bitmovin.api.rest.status;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 26.08.16.
 */
public class ServiceTaskStatus
{
    private Double eta;
    private Integer progress;

    private List<StatusMessage> messages;

    private List<SubTask> subTasks;
    private StatusName status;

    public ServiceTaskStatus() {
        this.messages = new ArrayList();
        this.subTasks = new ArrayList();
    }

    public ServiceTaskStatus(StatusName status, Integer progress, Double eta) {
        this();
        this.status = status;
        this.progress = progress;
        this.eta = eta;
    }

    public ServiceTaskStatus(StatusName status, Integer progress, Double eta, ArrayList<StatusMessage> messages) {
        this(status, progress, eta);
        this.messages = messages;
    }

    public ServiceTaskStatus(StatusName status, Integer progress, Double eta, ArrayList<StatusMessage> messages, ArrayList<SubTask> subTasks) {
        this(status, progress, eta, messages);
        this.subTasks = subTasks;
    }

    public Double getEta() {
        return this.eta;
    }

    public void setEta(Double eta) {
        this.eta = eta;
    }

    public Integer getProgress() {
        return this.progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public List<StatusMessage> getMessages() {
        return this.messages;
    }

    public void setMessages(List<StatusMessage> messages) {
        this.messages = messages;
    }

    public List<SubTask> getSubTasks() {
        return this.subTasks;
    }

    public void setSubTasks(List<SubTask> subTasks) {
        this.subTasks = subTasks;
    }

    public StatusName getStatus() {
        return this.status;
    }

    public void setStatus(StatusName status) {
        this.status = status;
    }

}
