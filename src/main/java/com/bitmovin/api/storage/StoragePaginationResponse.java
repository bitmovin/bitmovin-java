package com.bitmovin.api.storage;

import com.bitmovin.api.rest.pagination.PaginationResponse;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 13.09.16.
 */
public class StoragePaginationResponse extends PaginationResponse
{
    private String rootPath;

    public String getRootPath()
    {
        return this.rootPath;
    }

    public void setRootPath(String rootPath)
    {
        this.rootPath = rootPath;
    }
}
