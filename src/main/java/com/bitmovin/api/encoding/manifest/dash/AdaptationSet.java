package com.bitmovin.api.encoding.manifest.dash;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Set;

/**
 * Created by msmole on 13.10.16.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdaptationSet
{
    private String               id;
    private Set<CustomAttribute> customAttributes;
    private List<Role>           roles;

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public Set<CustomAttribute> getCustomAttributes() { return this.customAttributes; }

    public void setCustomAttributes(Set<CustomAttribute> customAttributes)
    {
        this.customAttributes = customAttributes;
    }

    public List<Role> getRoles() { return this.roles; }

    public void setRoles(List<Role> roles) { this.roles = roles; }
}
