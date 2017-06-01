package com.bitmovin.api.encoding.enums;

/**
 * Copied from transfer-resource-client and removed database stuff.
 * Replaced JsonProperty with SerializedName (gson) to get it written properly;
 **/
public enum AclPermission
{
    PUBLIC_READ,
    PRIVATE
}
