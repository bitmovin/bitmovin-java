package com.bitmovin.api.encoding.status;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 26.07.16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Message
{
    private MessageType type;
    private String text;

    private List<Link> links;

    private String field;

    private String more;

    public Message()
    {
    }

    public MessageType getType() { return this.type; }

    public void setType(MessageType type) { this.type = type; }

    public String getText() { return this.text; }

    public void setText(String text) { this.text = text; }

    public List<Link> getLinks() { return this.links; }

    public void setLinks(List<Link> links) { this.links = links; }

    public String getField() { return this.field; }

    public void setField(String field) { this.field = field; }

    public String getMore() { return this.more; }

    public void setMore(String more) { this.more = more; }
}
