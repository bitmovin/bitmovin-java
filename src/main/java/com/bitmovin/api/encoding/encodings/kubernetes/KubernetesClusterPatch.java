package com.bitmovin.api.encoding.encodings.kubernetes;

import com.bitmovin.api.resource.AbstractResourcePatch;

/**
 * Created by alexanderkopper on 20/01/2017.
 */
public class KubernetesClusterPatch implements AbstractResourcePatch
{

    private Boolean connected;

    public Boolean getConnected()
    {
        return this.connected;
    }

    public void setConnected(Boolean connected)
    {
        this.connected = connected;
    }
}
