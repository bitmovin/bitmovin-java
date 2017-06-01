package com.bitmovin.api.storage;

import com.bitmovin.api.AbstractApiResponse;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 06.09.16.
 */
public class StorageStatistics
{
    private long bytesStored;
    private long bytesTransferred;
    private String storage;

    public long getBytesStored()
    {
        return this.bytesStored;
    }

    public void setBytesStored(long bytesStored)
    {
        this.bytesStored = bytesStored;
    }

    public String getStorage()
    {
        return this.storage;
    }

    public void setStorage(String storage)
    {
        this.storage = storage;
    }

    public long getBytesTransferred()
    {
        return this.bytesTransferred;
    }

    public void setBytesTransferred(long bytesTransferred)
    {
        this.bytesTransferred = bytesTransferred;
    }
}
