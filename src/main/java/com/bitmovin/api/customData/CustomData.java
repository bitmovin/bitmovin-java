package com.bitmovin.api.customData;

import com.bitmovin.api.AbstractApiResponse;

import java.util.Date;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 01.09.16.
 */
public class CustomData extends AbstractApiResponse
{
    private Date createdAt;

    public Date getCreatedAt()
    {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }
}
