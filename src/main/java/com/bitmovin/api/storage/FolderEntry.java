package com.bitmovin.api.storage;


import com.bitmovin.api.storage.enums.FolderEntryType;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 05.09.16.
 */
public class FolderEntry
{
    private FolderEntryType type;
    private String path;

    public FolderEntry()
    {

    }

    public FolderEntry(FolderEntryType type, String path)
    {
        this.type = type;
        this.path = path;
    }

    public FolderEntryType getType()
    {
        return this.type;
    }

    public void setType(FolderEntryType type)
    {
        this.type = type;
    }

    public String getPath()
    {
        return this.path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }
}
