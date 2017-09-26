package com.bitmovin.api.encoding.encodings.streams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by arudich on 10.08.17.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Ignoring
{
    private IgnoredBy ignoredBy;
    private String ignoredByDescription;

    public IgnoredBy getIgnoredBy()
    {
        return this.ignoredBy;
    }

    public void setIgnoredBy(IgnoredBy ignoredBy)
    {
        this.ignoredBy = ignoredBy;
    }

    public String getIgnoredByDescription()
    {
        return this.ignoredByDescription;
    }

    public void setIgnoredByDescription(String ignoredByDescription)
    {
        this.ignoredByDescription = ignoredByDescription;
    }
}
