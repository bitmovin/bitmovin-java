package com.bitmovin.api.encoding.encodings.drms;

import com.bitmovin.api.encoding.encodings.drms.enums.DrmType;

import java.util.Date;

/**
 * Created by dmoser on 20.12.16.
 */
public class TypeDrm
{
    private String id;
    private DrmType type;
    private Date createdAt;
    private Date modifiedAt;

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public DrmType getType()
    {
        return this.type;
    }

    public void setType(DrmType type)
    {
        this.type = type;
    }

    public Date getCreatedAt()
    {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt()
    {
        return this.modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt)
    {
        this.modifiedAt = modifiedAt;
    }
}
