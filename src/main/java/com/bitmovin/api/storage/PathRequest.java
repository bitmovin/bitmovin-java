package com.bitmovin.api.storage;

import com.bitmovin.api.encoding.enums.CloudRegion;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 05.09.16.
 */
public class PathRequest
{
    private String path;

    private boolean recursive = true;

    private CloudRegion cloudRegion;

    public PathRequest()
    {
    }

    public String getPath()
    {
        return this.path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public boolean isRecursive()
    {
        return this.recursive;
    }

    public void setRecursive(boolean recursive)
    {
        this.recursive = recursive;
    }

    public CloudRegion getCloudRegion()
    {
        return this.cloudRegion;
    }

    public void setCloudRegion(CloudRegion cloudRegion)
    {
        this.cloudRegion = cloudRegion;
    }
}
