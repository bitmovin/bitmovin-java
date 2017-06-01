package com.bitmovin.api;

import java.util.Date;

/**
 * Created by Dominic Miglar [dominic.miglar@bitmovin.com] on 8/26/16 at 12:11 PM.
 */
public abstract class AbstractApiResource extends AbstractApiResponse
{
    private String userId;
    private String orgId;
    private Date   createdAt;
    private Date   modifiedAt;

    public AbstractApiResource()
    {
        super();
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getOrgId()
    {
        return this.orgId;
    }

    public void setOrgId(String orgId)
    {
        this.orgId = orgId;
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
