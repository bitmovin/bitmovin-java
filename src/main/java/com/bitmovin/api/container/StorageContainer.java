package com.bitmovin.api.container;

import com.bitmovin.api.constants.ApiUrls;
import com.bitmovin.api.resource.StorageResource;
import com.bitmovin.api.resource.StorageStatisticsResource;

import java.util.Map;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 13.09.16.
 */
public class StorageContainer
{
    public StorageResource foldersResource;
    public StorageResource filesResource;
    public StorageStatisticsResource statistics;

    public StorageContainer(Map<String, String> headers)
    {
        this.foldersResource = new StorageResource(headers, ApiUrls.storageFolders);
        this.filesResource = new StorageResource(headers, ApiUrls.storageFiles);
        this.statistics = new StorageStatisticsResource(headers, ApiUrls.storageStatistics);
    }
}
