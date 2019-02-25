package com.bitmovin.api.encoding;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.inputs.InputsApi;
import com.bitmovin.api.encoding.outputs.OutputsApi;
import com.bitmovin.api.encoding.configurations.ConfigurationsApi;
import com.bitmovin.api.encoding.filters.FiltersApi;
import com.bitmovin.api.encoding.encodings.EncodingsApi;
import com.bitmovin.api.encoding.manifests.ManifestsApi;
import com.bitmovin.api.encoding.infrastructure.InfrastructureApi;
import com.bitmovin.api.encoding.statistics.StatisticsApi;


public class EncodingApi
{
    public InputsApi inputs;
    public OutputsApi outputs;
    public ConfigurationsApi configurations;
    public FiltersApi filters;
    public EncodingsApi encodings;
    public ManifestsApi manifests;
    public InfrastructureApi infrastructure;
    public StatisticsApi statistics;

    public EncodingApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public EncodingApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public EncodingApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        inputs = new InputsApi(clientFactory);
        outputs = new OutputsApi(clientFactory);
        configurations = new ConfigurationsApi(clientFactory);
        filters = new FiltersApi(clientFactory);
        encodings = new EncodingsApi(clientFactory);
        manifests = new ManifestsApi(clientFactory);
        infrastructure = new InfrastructureApi(clientFactory);
        statistics = new StatisticsApi(clientFactory);
    }

}
