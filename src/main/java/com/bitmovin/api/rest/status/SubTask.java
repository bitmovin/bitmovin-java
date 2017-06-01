package com.bitmovin.api.rest.status;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 26.08.16.
 */
public class SubTask
{
    @JsonIgnore
    private String id;
    private String name;
    private Integer progress;
    private StatusName status;

    public SubTask() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProgress() {
        return this.progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public StatusName getStatus() {
        return this.status;
    }

    public void setStatus(StatusName status) {
        this.status = status;
    }

    public boolean equals(Object o) {
        if(this == o) {
            return true;
        } else if(o != null && this.getClass() == o.getClass()) {
            SubTask subTask = (SubTask)o;
            if(this.id != null) {
                if(!this.id.equals(subTask.id)) {
                    return false;
                }
            } else if(subTask.id != null) {
                return false;
            }

            label43: {
                if(this.name != null) {
                    if(this.name.equals(subTask.name)) {
                        break label43;
                    }
                } else if(subTask.name == null) {
                    break label43;
                }

                return false;
            }

            if(this.progress != null) {
                if(!this.progress.equals(subTask.progress)) {
                    return false;
                }
            } else if(subTask.progress != null) {
                return false;
            }

            return this.status == subTask.status;
        } else {
            return false;
        }
    }

    public int hashCode() {
        int result = this.id != null?this.id.hashCode():0;
        result = 31 * result + (this.name != null?this.name.hashCode():0);
        result = 31 * result + (this.progress != null?this.progress.hashCode():0);
        result = 31 * result + (this.status != null?this.status.hashCode():0);
        return result;
    }
}
