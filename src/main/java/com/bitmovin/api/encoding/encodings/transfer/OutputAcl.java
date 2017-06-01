package com.bitmovin.api.encoding.encodings.transfer;

import com.bitmovin.api.encoding.enums.AclPermission;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Copied from transfer-resource-client and removed database stuff.
 **/
public class OutputAcl
{
    @JsonIgnore
    private String id;

    private String scope;

    private AclPermission permission;

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
