package com.bitmovin.api.storage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 06.09.16.
 */
public class OverallStatistics
{
    private long bytesStoredTotal;
    private long bytesTransferredTotal;

    private List<StorageStatistics> storages;

    public long getBytesStoredTotal()
    {
        return this.bytesStoredTotal;
    }

    public void setBytesStoredTotal(long bytesStoredTotal)
    {
        this.bytesStoredTotal = bytesStoredTotal;
    }

    public List<StorageStatistics> getStorages()
    {
        return this.storages;
    }

    public void setStorages(List<StorageStatistics> storages)
    {
        this.storages = storages;
    }

    public long getBytesTransferredTotal()
    {
        return this.bytesTransferredTotal;
    }

    public void setBytesTransferredTotal(long bytesTransferredTotal)
    {
        this.bytesTransferredTotal = bytesTransferredTotal;
    }

    public void addStorageStatistics(StorageStatistics storageStatistics)
    {
        if(this.storages == null)
            this.storages = new ArrayList<>();
        this.storages.add(storageStatistics);
    }
}
