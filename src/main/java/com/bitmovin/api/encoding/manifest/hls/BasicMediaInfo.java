package com.bitmovin.api.encoding.manifest.hls;

import java.util.ArrayList;

/**
 * Copied from MediaInfo and adapted to spec
 **/
public abstract class BasicMediaInfo
{
    private String id;
    private String groupId;
    private String language;
    private String assocLanguage;
    private String name;
    private Boolean isDefault;
    private Boolean autoselect;
    private ArrayList<String> characteristics;

    public BasicMediaInfo()
    {
        this.characteristics = new ArrayList<>();
    }


    public String getId() { return this.id; }

    public void setId(String id) { this.id = id; }

    public String getGroupId()
    {
        return this.groupId;
    }

    public void setGroupId(String groupId)
    {
        this.groupId = groupId;
    }

    public String getLanguage()
    {
        return this.language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public String getAssocLanguage()
    {
        return this.assocLanguage;
    }

    public void setAssocLanguage(String assocLanguage)
    {
        this.assocLanguage = assocLanguage;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Boolean getDefault()
    {
        return this.isDefault;
    }

    public void setDefault(Boolean aDefault)
    {
        this.isDefault = aDefault;
    }

    public Boolean getAutoselect()
    {
        return this.autoselect;
    }

    public void setAutoselect(Boolean autoselect)
    {
        this.autoselect = autoselect;
    }

    public ArrayList<String> getCharacteristics()
    {
        return this.characteristics;
    }

    public void setCharacteristics(ArrayList<String> characteristics)
    {
        this.characteristics = characteristics;
    }

    public void addCharasteristic(String characteristic)
    {
        this.characteristics.add(characteristic);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof BasicMediaInfo)) return false;

        BasicMediaInfo that = (BasicMediaInfo) o;

        if (this.id != null ? !this.id.equals(that.id) : that.id != null) return false;
        if (this.groupId != null ? !this.groupId.equals(that.groupId) : that.groupId != null) return false;
        if (this.language != null ? !this.language.equals(that.language) : that.language != null) return false;
        if (this.assocLanguage != null ? !this.assocLanguage.equals(that.assocLanguage) : that.assocLanguage != null)
            return false;
        if (this.name != null ? !this.name.equals(that.name) : that.name != null) return false;
        if (this.isDefault != null ? !this.isDefault.equals(that.isDefault) : that.isDefault != null) return false;
        if (this.autoselect != null ? !this.autoselect.equals(that.autoselect) : that.autoselect != null) return false;
        return this.characteristics != null ? this.characteristics.equals(that.characteristics) : that.characteristics == null;

    }

    @Override
    public int hashCode()
    {
        int result = this.id != null ? this.id.hashCode() : 0;
        result = 31 * result + (this.groupId != null ? this.groupId.hashCode() : 0);
        result = 31 * result + (this.language != null ? this.language.hashCode() : 0);
        result = 31 * result + (this.assocLanguage != null ? this.assocLanguage.hashCode() : 0);
        result = 31 * result + (this.name != null ? this.name.hashCode() : 0);
        result = 31 * result + (this.isDefault != null ? this.isDefault.hashCode() : 0);
        result = 31 * result + (this.autoselect != null ? this.autoselect.hashCode() : 0);
        result = 31 * result + (this.characteristics != null ? this.characteristics.hashCode() : 0);
        return result;
    }
}
