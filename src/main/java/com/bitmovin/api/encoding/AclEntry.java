package com.bitmovin.api.encoding;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by atrattnig on 9/12/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AclEntry
{
    private String scope;
    private AclPermission permission;

    public AclEntry()
    {

    }

    public AclEntry(AclPermission permission)
    {
        this.permission = permission;
    }

    public AclEntry(String scope, AclPermission permission)
    {
        this.scope = scope;
        this.permission = permission;
    }

    public String getScope()
    {
        return this.scope;
    }
    public void setScope(String scope)
    {
        this.scope = scope;
    }
    public AclPermission getPermission()
    {
        return this.permission;
    }
    public void setPermission(AclPermission permission)
    {
        this.permission = permission;
    }
}
