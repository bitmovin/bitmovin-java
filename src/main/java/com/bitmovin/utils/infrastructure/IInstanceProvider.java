package com.bitmovin.utils.infrastructure;

import com.bitmovin.utils.auth.Credentials;

import java.util.List;

/**
 * Created by
 * David Moser [david.moser@bitmovin.com]
 * on 29.02.16
 */
public interface IInstanceProvider
{
    List<?extends AbstractInstance> createInstances(Credentials credentials, AbstractInstanceConfiguration instanceConfiguration, int count);
    List<? extends AbstractInstance> createInstancesAsync(Credentials credentials, AbstractInstanceConfiguration instanceConfiguration, int count);
    boolean deleteInstance(String instanceId);
    boolean deleteInstances(String[] instanceIds);
}
