package com.bitmovin.api.encoding.manifest.dash;

/**
 * Created by arudich on 09.01.17.
 **/
public class CustomAttribute
{
    private String key;
    private String value;

    public CustomAttribute(String key, String value)
    {
        this.key = key;
        this.value = value;
    }

    public String getKey() { return this.key; }

    public void setKey(String key) { this.key = key; }

    public String getValue() { return this.value; }

    public void setValue(String value) { this.value = value; }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof CustomAttribute)) return false;

        CustomAttribute that = (CustomAttribute) o;

        if (this.key != null ? !this.key.equals(that.key) : that.key != null) return false;
        return this.value != null ? this.value.equals(that.value) : that.value == null;

    }

    @Override
    public int hashCode()
    {
        int result = this.key != null ? this.key.hashCode() : 0;
        result = 31 * result + (this.value != null ? this.value.hashCode() : 0);
        return result;
    }
}
