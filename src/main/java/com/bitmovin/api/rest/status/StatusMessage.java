package com.bitmovin.api.rest.status;

import com.bitmovin.api.rest.ServiceMessageType;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 26.08.16.
 */
public class StatusMessage
{
    @JsonIgnore
    private String id;
    private ServiceMessageType type;
    private String text;

    public StatusMessage() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ServiceMessageType getType() {
        return this.type;
    }

    public void setType(ServiceMessageType type) {
        this.type = type;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean equals(Object o) {
        if(this == o) {
            return true;
        } else if(o != null && this.getClass() == o.getClass()) {
            StatusMessage that = (StatusMessage)o;
            if(this.id != null) {
                if(this.id.equals(that.id)) {
                    return this.type == that.type && (this.text != null ? this.text.equals(that.text) : that.text == null);
                }
            } else if(that.id == null) {
                return this.type == that.type && (this.text != null ? this.text.equals(that.text) : that.text == null);
            }

            return false;
        } else {
            return false;
        }
    }

    public int hashCode() {
        int result = this.id != null?this.id.hashCode():0;
        result = 31 * result + (this.type != null?this.type.hashCode():0);
        result = 31 * result + (this.text != null?this.text.hashCode():0);
        return result;
    }
}
