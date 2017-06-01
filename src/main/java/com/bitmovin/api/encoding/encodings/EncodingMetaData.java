package com.bitmovin.api.encoding.encodings;

import com.bitmovin.api.encoding.outputs.Output;
import com.bitmovin.api.encoding.status.Task;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

/**
 * Created by akopper on 29.08.16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EncodingMetaData
{

    private Date startedAt;

    private Date finishedAt;

    private Task task;

    private boolean allSegementsOk = false;

    private List<Output> outputsUsedInEncoding;

    private String parentPath;

    public EncodingMetaData() {
    }

    public Date getStartedAt()
    {
        return this.startedAt;
    }

    public void setStartedAt(Date startedAt)
    {
        this.startedAt = startedAt;
    }

    public Date getFinishedAt()
    {
        return this.finishedAt;
    }

    public void setFinishedAt(Date finishedAt)
    {
        this.finishedAt = finishedAt;
    }

    public Task getTask()
    {
        return this.task;
    }

    public void setTask(Task task)
    {
        this.task = task;
    }

    public boolean isAllSegementsOk()
    {
        return this.allSegementsOk;
    }

    public void setAllSegementsOk(boolean allSegementsOk)
    {
        this.allSegementsOk = allSegementsOk;
    }

    public List<Output> getOutputsUsedInEncoding()
    {
        return this.outputsUsedInEncoding;
    }

    public void setOutputsUsedForValidation(List<Output> outputsUsedInEncoding)
    {
        this.outputsUsedInEncoding = outputsUsedInEncoding;
    }

    public String getParentPath()
    {
        return this.parentPath;
    }

    public void setParentPath(String parentPath)
    {
        this.parentPath = parentPath;
    }
}
